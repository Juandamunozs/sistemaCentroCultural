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
import com.example.sistemacentrocultural.databinding.ActivityObraFamosaBinding

class ObraFamosa : AppCompatActivity() {
    lateinit var enviarnombre: EditText
    lateinit var nombre: EditText
    lateinit var partitura: EditText
    lateinit var creacion: EditText
    lateinit var foto: EditText
    lateinit var musico: EditText
    lateinit var genero: EditText
    lateinit var nombreBorrarActualizar: EditText
    var IP_SERVIDOR: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityObraFamosaBinding.inflate(layoutInflater)
        enviarnombre = binding.txtMensaje
        nombre = binding.txtNombreObra
        partitura = binding.txtpartitura
        creacion = binding.txtcreacion
        musico=binding.txtcantante
        genero=binding.txtgenero
        foto=binding.txtFoto
        nombreBorrarActualizar = binding.txtObraUd
        val intencion:Intent=intent
        IP_SERVIDOR=intencion.getStringExtra("IP_SERVIDOR")
        setContentView(binding.root)
    }
    fun guardar(view: View){
        //ruta de envío de mensaje
        var url="http://$IP_SERVIDOR/android/insertarObras.php?nombre_obra="+nombre.text.toString()+"&partitura="+partitura.text.toString()+"&ano_creacion="+creacion.text.toString()+"&musico="+musico.text.toString()+"&genero="+genero.text.toString()+"&foto="+foto.text.toString()
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
        var url="http://$IP_SERVIDOR/android/actualizarObras.php?nombre_obra="+nombre.text.toString()+"&partitura="+partitura.text.toString()+"&ano_creacion="+creacion.text.toString()+"&musico="+musico.text.toString()+"&genero="+genero.text.toString() +"&foto="+foto.text.toString()+"&nombreBorrarActualizar="+nombreBorrarActualizar.text.toString()
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
        var url="http://$IP_SERVIDOR/android/borrarObras.php?nombre_obra="+nombre.text.toString()+"&partitura="+partitura.text.toString()+"&ano_creacion="+creacion.text.toString()+"&nombreBorrarActualizar="+nombreBorrarActualizar.text.toString()
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
