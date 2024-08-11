package com.example.sistemacentrocultural

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView
import com.android.volley.Request.Method
import com.android.volley.toolbox.StringRequest
import com.android.volley.Response
import com.android.volley.toolbox.Volley
import com.android.volley.Request
import com.example.sistemacentrocultural.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
       lateinit var IP_SERVIDOR:EditText
       lateinit var mensaje:TextView
       lateinit var codigo:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityMainBinding.inflate(layoutInflater)
        IP_SERVIDOR=binding.txtip
        mensaje=binding.mensaje
        codigo=binding.Codigo
        setContentView(binding.root)
    }

    fun llamarVentanaEpoca(view: View){
        val Epoca = Intent(this,Epoca::class.java)
        val IP_SERVIDOR = leerDatos(view)
        Epoca.putExtra("IP_SERVIDOR",IP_SERVIDOR)
        startActivity(Epoca)
    }
    fun llamarVentanaGenero(view: View){
        val Genero= Intent(this,Genero::class.java)
        val IP_SERVIDOR = leerDatos(view)
        Genero.putExtra("IP_SERVIDOR",IP_SERVIDOR)
        startActivity(Genero)
    }
    fun llamarVentanaInstrumento(view: View){
        val Instrumento= Intent(this,Instrumento::class.java)
        val IP_SERVIDOR = leerDatos(view)
        Instrumento.putExtra("IP_SERVIDOR",IP_SERVIDOR)
        startActivity(Instrumento)
    }
    fun llamarVentanaMusico(view: View){
        val Musico= Intent(this,Musico::class.java)
        val IP_SERVIDOR = leerDatos(view)
        Musico.putExtra("IP_SERVIDOR",IP_SERVIDOR)
        startActivity(Musico)
    }
    fun llamarVentanaObraFamosa(view: View){
        val ObraFamosa= Intent(this,ObraFamosa::class.java)
        val IP_SERVIDOR = leerDatos(view)
        ObraFamosa.putExtra("IP_SERVIDOR",IP_SERVIDOR)
        startActivity(ObraFamosa)
    }
    fun crearDatos(view:View){
        if(IP_SERVIDOR.text.toString().length>0){
            var ip= IP(IP_SERVIDOR.text.toString())
            var Db= BaseDeDatos(this)
            mensaje.setText(Db.insertarDatos(ip))
        }
    }
    fun leerDatos(view:View): String{
        var IPencontrada = ""
        var db= BaseDeDatos(this)
        var datos=db.traerDatos()
        mensaje.text=""
        for(i in 0..datos.size-1){
            val ip =datos.get(i)
            mensaje.append("ID:"+ip.id + " IP: "+ ip.IP + "\n" )
            IPencontrada=ip.IP
        }
        db.close()
        return IPencontrada
    }
    fun borrarDatos(view: View){
        var db=BaseDeDatos(this)
        db.borrar(codigo.text.toString())
    }
    fun actualizar(view: View){
        var db=BaseDeDatos(this)
        var ip= IP(codigo.text.toString().toInt(),IP_SERVIDOR.text.toString())
        mensaje.setText(db.actualizar(ip))
    }
}