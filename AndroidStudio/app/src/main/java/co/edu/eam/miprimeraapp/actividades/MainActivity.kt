 package co.edu.eam.miprimeraapp.actividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import co.edu.eam.miprimeraapp.R
import co.edu.eam.miprimeraapp.modelo.Producto

 class MainActivity : AppCompatActivity() {

    lateinit var resultLauncher: ActivityResultLauncher<Intent>
     lateinit var binding:ActivityMainBinding

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)

         binding = ActivityMainBinding.inflate(layoutInflater)
         setContentView(binding.root)

         binding.btnTec.setOnClickListener(this)
         binding.btnAseo.setOnClickListener(this)
         binding.btnHogar.setOnClickListener(this)
         binding.btnElec.setOnClickListener(this)
         binding.btnRopa.setOnClickListener(this)
         binding.btnOtros.setOnClickListener(this)
         binding.barraS.btnBuscar.setOnClickListener(this)
         binding.btnRegistro.setOnClickListener(this)

        resultLauncher= registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            Log.i("MainActivity","Llego Informacion")
            if (it.data!=null){
                Log.i("MainActivity", "${it.data?.extras?.getString("FOTO")}")
            }

        }

    }
     fun mostrarDetalle(view:View){
         val intent = Intent(this, DetalleProductoActivity::class.java)

         val imagenes = ArrayList<String>()
         imagenes.add("image1.jpg")
         imagenes.add("image2.jpg")
         val p = Producto("123", 40000F, "Memoria USB", "La mejor memoria", imagenes)
         p.descuento = 5

         intent.putExtra("PRODUCTO", p)
         startActivity(intent)
     }

     override fun onClick(p0: View?) {
         when(p0?.id){
             binding.btnTec.id ->  mostrarLista(1)
             binding.btnHogar.id -> mostrarLista(2)
             binding.btnRopa.id ->  mostrarLista(3)
             binding.btnAseo.id ->  mostrarLista(4)
             binding.btnElec.id ->  mostrarLista(5)
             binding.btnOtros.id ->  mostrarLista(6)
             binding.barraS.btnBuscar.id -> irABusqueda()
             binding.btnRegistro.id -> irARegistro()
         }
     }

     fun mostrarLista(codigo:Int){
         val intent = Intent(this, ListaProductosActivity::class.java)
         intent.putExtra("categoria", codigo)
         startActivity(intent)
     }

     fun irARegistro(){
         startActivity( Intent(this, RegistroActivity::class.java) )
     }

     fun irABusqueda(){
         val criterio = binding.barraS.textoBusqueda.text.toString()

         if(criterio.isNotEmpty()){
             val intent = Intent(this, ResultadoBusquedaActivity::class.java)
             intent.putExtra("criterio", criterio)
             startActivity(intent)
         }


     }

     /*fun navegarFoto(view:View){
         val intent = Intent(this, PhotoActivity::class.java)
         resultLauncher.launch(intent)
     }*/
 }