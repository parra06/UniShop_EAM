package co.edu.eam.unishop_eam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import co.edu.eam.unishop_eam.adapter.ComentarioAdapter
import co.edu.eam.unishop_eam.adapter.ProductoAdapter
import co.edu.eam.unishop_eam.data.Comentarios
import co.edu.eam.unishop_eam.data.Productos
import co.edu.eam.unishop_eam.databinding.ActivityDetalleProductoBinding
import co.edu.eam.unishop_eam.databinding.ActivityListaProductosBinding
import co.edu.eam.unishop_eam.modelo.Comentario
import co.edu.eam.unishop_eam.modelo.Producto
import co.edu.eam.unishop_eam.util.utilidades

class DetalleProductoActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetalleProductoBinding
    lateinit var adapterComentarios: ComentarioAdapter
    var productoCodigo:String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleProductoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        productoCodigo = intent.extras?.getString("producto-id")



        val p1: Producto? = Productos.obtener(productoCodigo.toString())
        if (p1 != null) {
            binding.nombreProductoDetalle.text = p1.nombre
            binding.precioProductoDetalle.text = p1.precio.toString()
            if(p1.descuento == 0f){
                binding.descuentoProductoDetalle.text = ""
            }else{
                binding.descuentoProductoDetalle.text = p1.descuento.toString()+"%"
            }
            binding.txtDescripcionDetalle.text = p1.descripcion
            val listaComentarios:ArrayList<Comentario> = Comentarios.getLista()
            var listaAux:ArrayList<Comentario> = ArrayList()
            for (coment in listaComentarios){
                if (coment.productoID == p1.codigo){
                    listaAux.add(coment)
                }
            }
            adapterComentarios = ComentarioAdapter(listaAux)
            binding.listaComentarios.adapter = adapterComentarios
            binding.listaComentarios.layoutManager = LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,false)

            binding.btnAgregarACarrito.setOnClickListener{
                val intent = Intent(this, CarritoActivity2::class.java)
                startActivity(intent)
            }


        }

    }
}