package co.edu.eam.unishop_eam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import co.edu.eam.unishop_eam.adapter.ProductoAdapter
import co.edu.eam.unishop_eam.data.Productos
import co.edu.eam.unishop_eam.databinding.ActivityMainBinding
import co.edu.eam.unishop_eam.fragmentos.BarraSuperiorFragment
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



        /*val bundle = intent.extras
        val dato = bundle?.getString("correo")
        Toast.makeText(this,dato, Toast.LENGTH_LONG).show()*/
        binding.barraInferior.menu.get(1).isChecked = true

        binding.barraInferior.setOnItemReselectedListener { item ->
            when(item.itemId){
                R.id.menu_favs -> startActivity(Intent(this, ProductosFavoritosActivity::class.java))
                R.id.menu_home -> startActivity(Intent(this, MainActivity::class.java))
                /*R.id.menu_user -> startActivity(Intent(this, UsuarioActivity::class.java))*/
            }
        }





    }

    override fun onResume() {
        super.onResume()
        val adapter = ProductoAdapter(Productos.listarOfertas())
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


        }
    }

    fun mostrarLista(codigo:Int){
        val intent = Intent(this, ListaProductosActivity::class.java)
        intent.putExtra("categoria",codigo)
        startActivity(intent)
    }
    fun mostrarListaFavs(){
        startActivity(Intent(this, ListaProductosActivity::class.java))
    }





}