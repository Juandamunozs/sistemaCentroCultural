package com.example.sistemacentrocultural

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.CalendarContract.CalendarCache.URI
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.sistemacentrocultural.databinding.ActivityInstrumentoBinding

class Instrumento : AppCompatActivity() {
    lateinit var enviarnombre: EditText
    lateinit var nombre: EditText
    lateinit var creador: EditText
    lateinit var lugar_creacion: EditText
    lateinit var tipo: EditText
    lateinit var material: EditText
    lateinit var genero: EditText
    lateinit var foto: EditText
    lateinit var nombreBorrarActualizar: EditText
    var IP_SERVIDOR: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityInstrumentoBinding.inflate(layoutInflater)
        enviarnombre=binding.txtMensaje
        nombre=binding.TxtNombreInstrumento
        creador=binding.txtCreador
        lugar_creacion=binding.txtLugarDeCreacion
        material=binding.txtMaterial
        foto=binding.txtFoto
        nombreBorrarActualizar=binding.txtInstrumentoUd
        tipo= binding.txtTipo
        genero= binding.TxtGenero
        val intencion:Intent=intent
        IP_SERVIDOR=intencion.getStringExtra("IP_SERVIDOR")
        setContentView(binding.root)
    }
    fun guardar(view: View){
        //ruta de envío de mensaje
        var url="http://$IP_SERVIDOR/android/insertarInstrumentos.php?nombre_instrumento="+nombre.text.toString()+"&creador="+creador.text.toString()+"&lugar_creacion="+lugar_creacion.text.toString()+"&tipo="+tipo.text.toString()+"&material="+material.text.toString()+"&foto="+foto.text.toString()+"&genero="+genero.text.toString()
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

    fun actualizar(view:View){
        //ruta de envío de mensaje
        var url="http://$IP_SERVIDOR/android/actualizarInstrumentos.php?nombre_instrumento="+nombre.text.toString()+"&creador="+creador.text.toString()+"&lugar_creacion="+lugar_creacion.text.toString()+"&tipo="+tipo.text.toString()+"&material="+material.text.toString()+"&foto="+foto.text.toString()+"&genero="+genero.text.toString()+"&nombreBorrarActualizar="+nombreBorrarActualizar.text.toString()
        //se crea la cola
        val cola= Volley.newRequestQueue(this);
        //se manda la petición por Get
        val cadenaConexion= StringRequest(Request.Method.GET,url,
            Response.Listener {response ->
                //se recibe la respuestas
                enviarnombre.setText(""+response.toString())
            },
            Response.ErrorListener { response ->
                //en caso de error
                enviarnombre.setText("error*"+response.toString())})
        //se encola el mensaje
        cola.add(cadenaConexion)
    }
    fun borrar(view:View){
        //ruta de envío de mensaje
        var url="http://$IP_SERVIDOR/android/borrarInstrumentos.php?nombre_instrumento="+nombre.text.toString()+"&creador="+creador.text.toString()+"&lugar_creacion="+lugar_creacion.text.toString()+"&tipo="+tipo.text.toString()+"&material="+material.text.toString()+"&foto="+foto.text.toString()+"&nombreBorrarActualizar="+nombreBorrarActualizar.text.toString()
        //se crea la cola
        val cola= Volley.newRequestQueue(this);
        //se manda la petición por Get
        val cadenaConexion= StringRequest(Request.Method.GET,url,
            Response.Listener {response ->
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