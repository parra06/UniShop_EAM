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
import co.edu.eam.unishop_eam.modelo.Comentario
import co.edu.eam.unishop_eam.modelo.Producto
import co.edu.eam.unishop_eam.util.utilidades


class ComentarioAdapter(var lista:ArrayList<Comentario>): RecyclerView.Adapter<ComentarioAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComentarioAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_comentario,parent,false)
        return ComentarioAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ComentarioAdapter.ViewHolder, position: Int) {
        holder.bindComentario(lista[position])
    }

    override fun getItemCount(): Int = lista.size

    class ViewHolder(var itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{

        val nombreUser: TextView = itemView.findViewById(R.id.nombre_usuario_comentario)
        val mensaje: TextView = itemView.findViewById(R.id.txt_mensaje)
        val calificacion: TextView = itemView.findViewById(R.id.txt_calificacion)

        init{
            itemView.setOnClickListener(this)
        }




        fun bindComentario(comentario: Comentario){
            nombreUser.text = comentario.correoUsuario
            mensaje.text = comentario.mensaje
            calificacion.text = comentario.calificacion.toString() + " Estrellas"

        }

        override fun onClick(p0: View?) {
            /*itemView.context.startActivity(Intent(itemView.context, DetalleProductoActivity::class.java))*/

        }
    }


}
