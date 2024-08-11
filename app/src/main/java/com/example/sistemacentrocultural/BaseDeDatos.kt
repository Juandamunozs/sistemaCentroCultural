package com.example.sistemacentrocultural

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

val Basedatosfinal="Dasedatosfinal"
class BaseDeDatos(contexto: Context) :SQLiteOpenHelper(contexto, Basedatosfinal, null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val crearTabla="CREATE TABLE " + "IP (id INTEGER PRIMARY KEY AUTOINCREMENT, IP VARCHAR(256))";
        db?.execSQL(crearTabla);
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
    fun insertarDatos(ip: IP):String{
        val db = this.writableDatabase
        var contenedordeValores = ContentValues();
        contenedordeValores.put("IP", ip.IP)
        var resultado=db.insert("IP ", null, contenedordeValores)
        if(resultado==-1.toLong()) {
            return "fallas en la inserción";
        }else{
            return "Datos insertados (ok)"
        }
    }//insertarDatos


    fun traerDatos():MutableList<IP>{
        var lista:MutableList<IP> = ArrayList()
        val db =this.readableDatabase
        //val sql="select * from Usuario where id=10"
        val sql="select * from IP"
        val resultado= db.rawQuery(sql,null)
        if(resultado.moveToFirst()){
            do {
                var ip=IP()
                ip.id= resultado.getString(0).toInt()
                ip.IP=resultado.getString(resultado.getColumnIndex("IP").toInt())
                lista.add(ip)
            }while (resultado.moveToNext())
        }//if
        resultado.close()
        db.close()
        return lista
    }//listar
    fun borrar(codigo:String){
        if(codigo.length>0){
            val db =this.writableDatabase
            db.delete("IP","id=?",arrayOf(codigo))
            //para borar todos
            //db.delete("Usuario",null,null)
            db.close()
        }
    }//borrar
    fun actualizar(ip: IP):String{
        val db = this.writableDatabase
        var contenedordeValores = ContentValues();
        contenedordeValores.put("IP", ip.IP)
        var resultado=db.update("IP", contenedordeValores,
            "id=?", arrayOf(ip.id.toString()))
        if(resultado>0){
            return "Actualización exitosa"
        }else{
            return "no re actualizó la ip "+ip.IP
        }
    }//actualizar
}//clase
