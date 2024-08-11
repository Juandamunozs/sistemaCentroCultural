package com.example.sistemacentrocultural

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.sistemacentrocultural.databinding.ActivityGeneroBinding

class Genero : AppCompatActivity() {
    lateinit var enviarnombre: EditText
    lateinit var nombre: EditText
    lateinit var caracteristica: EditText
    lateinit var origen: EditText
    lateinit var instrumento: EditText
    lateinit var foto: EditText
    lateinit var nombreBorrarActualizar: EditText
    var IP_SERVIDOR: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityGeneroBinding.inflate(layoutInflater)
        enviarnombre=binding.txtMensaje
        nombre=binding.TxtNombreGenero
        caracteristica=binding.txtcaracteristica
        origen=binding.txtorigen
        instrumento= binding.txtinstrumento
        foto=binding.txtFoto
        nombreBorrarActualizar=binding.txtGeneroUd
        val intencion:Intent=intent
        IP_SERVIDOR=intencion.getStringExtra("IP_SERVIDOR")
        setContentView(binding.root)
    }
    fun guardar(view: View){
        //ruta de envío de mensaje
        var url="http://$IP_SERVIDOR/android/insertarGeneros.php?nombre_genero="+nombre.text.toString()+"&caracteristica_g="+caracteristica.text.toString()+"&origen="+origen.text.toString()+"&instrumento="+instrumento.text.toString()+"&foto="+foto.text.toString()
        //se crea la cola
        val cola= Volley.newRequestQueue(this);
        //se manda la petición por Get
        val cadenaConexion= StringRequest(
            Request.Method.GET,url,
            Response.Listener { response ->
                //se recibe la respuestas
                enviarnombre.setText(""+response.toString())
            },
            Response.ErrorListener { response ->
                //en caso de error
                enviarnombre.setText("error*"+response.toString())})
        //se encola el mensaje
        cola.add(cadenaConexion)
    }
    fun actualizar(view: View){
        //ruta de envío de mensaje
        var url="http://$IP_SERVIDOR/android/actualizarGeneros.php?nombre_genero="+nombre.text.toString()+"&caracteristica_g="+caracteristica.text.toString()+"&origen="+origen.text.toString()+"&instrumento="+instrumento.text.toString()+"&foto="+foto.text.toString()+"&nombreBorrarActualizar="+nombreBorrarActualizar.text.toString()
        //se crea la cola
        val cola= Volley.newRequestQueue(this);
        //se manda la petición por Get
        val cadenaConexion= StringRequest(
            Request.Method.GET,url,
            Response.Listener { response ->
                //se recibe la respuestas
                enviarnombre.setText(""+response.toString())
            },
            Response.ErrorListener { response ->
                //en caso de error
                enviarnombre.setText("error*"+response.toString())})
        //se encola el mensaje
        cola.add(cadenaConexion)
    }
    fun borrar(view: View){
        //ruta de envío de mensaje
        var url="http://$IP_SERVIDOR/android/borrarGeneros.php?nombre_genero="+nombre.text.toString()+"&caracteristica_g="+caracteristica.text.toString()+"&origen="+origen.text.toString()+"&nombreBorrarActualizar="+nombreBorrarActualizar.text.toString()
        //se crea la cola
        val cola= Volley.newRequestQueue(this);
        //se manda la petición por Get
        val cadenaConexion= StringRequest(
            Request.Method.GET,url,
            Response.Listener { response ->
                //se recibe la respuestas
                enviarnombre.setText(""+response.toString())
            },
            Response.ErrorListener { response ->
                //en caso de error
                enviarnombre.setText("error*"+response.toString())})
        //se encola el mensaje
        cola.add(cadenaConexion)
    }

    fun Regresar(view: View){
        val Epoca = Intent(this,MainActivity::class.java)
        startActivity(Epoca)
    }
}