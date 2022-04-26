package co.edu.eam.unishop_eam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import co.edu.eam.unishop_eam.adapter.ProductoAdapter
import co.edu.eam.unishop_eam.data.Productos
import co.edu.eam.unishop_eam.databinding.ActivityMainBinding
import co.edu.eam.unishop_eam.modelo.Producto
import co.edu.eam.unishop_eam.util.utilidades

class MainActivity : AppCompatActivity() , View.OnClickListener {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)


        getSupportActionBar()?.hide()
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);




        setContentView(binding.root)

        binding.btnInstru.setOnClickListener(this)
        binding.btnLibros.setOnClickListener(this)
        binding.btnTec.setOnClickListener(this)
        binding.btnDeportes.setOnClickListener(this)
        binding.btnRopa.setOnClickListener(this)
        binding.btnOtros.setOnClickListener(this)
        binding.btnPrueba.setOnClickListener(this)


        /*val bundle = intent.extras
        val dato = bundle?.getString("correo")
        Toast.makeText(this,dato, Toast.LENGTH_LONG).show()*/

        val listaProductos:ArrayList<Producto> = Productos.getLista()
        val listaAux:ArrayList<Producto> = ArrayList()
        for (producto in listaProductos){
            if (producto.descuento!=0f){
                listaAux.add(producto)
            }
        }




        val adapter = ProductoAdapter(listaAux)
        binding.listaProductos.adapter = adapter
        binding.listaProductos.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,false)





    }

    override fun onClick(p0: View?) {

        when(p0?.id){
            binding.btnInstru.id ->    mostrarLista(1)
            binding.btnLibros.id ->    mostrarLista(2)
            binding.btnTec.id ->   mostrarLista(3)
            binding.btnDeportes.id ->    mostrarLista(4)
            binding.btnRopa.id ->    mostrarLista(5)
            binding.btnOtros.id ->    mostrarLista(6)
            binding.btnPrueba.id -> {
                startActivity(Intent(this,CompraActivity::class.java))
            }

        }
    }

    fun mostrarLista(codigo:Int){
        val intent = Intent(this, ListaProductosActivity::class.java)
        intent.putExtra("categoria",codigo)
        startActivity(intent)
    }
    fun irABusqueda(){

    }


}