package co.edu.eam.unishop_eam.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.edu.eam.unishop_eam.DetalleProductoActivity
import co.edu.eam.unishop_eam.R
import co.edu.eam.unishop_eam.databinding.ItemProductoBinding
import co.edu.eam.unishop_eam.modelo.Producto
import co.edu.eam.unishop_eam.util.utilidades


class ProductoAdapter(var lista:ArrayList<Producto>): RecyclerView.Adapter<ProductoAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemProductoBinding.inflate( LayoutInflater.from(parent.context), parent, false )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bindProducto(lista[position])
    }

    override fun getItemCount(): Int = lista.size

    inner class ViewHolder(private var view: ItemProductoBinding):RecyclerView.ViewHolder(view.root){

        fun bindProducto(producto:Producto){
            view.tituloProducto.text = producto.nombre
            view.precioProducto.text = producto.precio.toString()
            view.root.setOnClickListener {
                val intent = Intent( itemView.context, DetalleProductoActivity::class.java )
                intent.putExtra("producto-id", producto.codigo)
                itemView.context.startActivity( intent )
            }
        }

    }

    /*class ViewHolder(var itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val imagen:ImageView = itemView.findViewById(R.id.img_producto)
        val titulo:TextView = itemView.findViewById(R.id.titulo_producto)
        val precio:TextView = itemView.findViewById(R.id.precio_producto)

        init{
            itemView.setOnClickListener(this)
        }

        fun bindProducto(producto:Producto){
            titulo.text = producto.nombre
            precio.text = producto.precio.toString()
        }

        override fun onClick(p0: View?) {
            val pos = adapterPosition
            itemView.context.startActivity(Intent(itemView.context, DetalleProductoActivity::class.java))
        }
    }*/

}