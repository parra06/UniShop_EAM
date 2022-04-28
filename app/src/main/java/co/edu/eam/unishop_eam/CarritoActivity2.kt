package co.edu.eam.unishop_eam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import co.edu.eam.unishop_eam.adapter.ProductoAdapter
import co.edu.eam.unishop_eam.data.Carrito
import co.edu.eam.unishop_eam.databinding.ActivityCarrito2Binding
import co.edu.eam.unishop_eam.databinding.ActivityCarritoBinding
import co.edu.eam.unishop_eam.modelo.Producto

class CarritoActivity2 : AppCompatActivity() {
    lateinit var adapterProductos: ProductoAdapter
    lateinit var binding: ActivityCarrito2Binding
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityCarrito2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val listaProductos:ArrayList<Producto> = Carrito.obtener()
        adapterProductos = ProductoAdapter(listaProductos)
        binding.listaProductos.adapter = adapterProductos
        binding.listaProductos.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,false)
    }
}