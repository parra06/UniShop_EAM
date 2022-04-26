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
import co.edu.eam.unishop_eam.modelo.Producto


class ProductoAdapter(var lista:ArrayList<Producto>): RecyclerView.Adapter<ProductoAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_producto,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bindProducto(lista[position])
    }

    override fun getItemCount(): Int = lista.size



    class ViewHolder(var itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{
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
            itemView.context.startActivity(Intent(itemView.context, DetalleProductoActivity::class.java))
        }
    }

}