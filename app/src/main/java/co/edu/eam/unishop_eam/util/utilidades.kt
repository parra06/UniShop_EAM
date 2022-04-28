package co.edu.eam.unishop_eam.util

import android.content.Context
import android.widget.AdapterView
import android.widget.Toast
import co.edu.eam.unishop_eam.modelo.Producto

var correoLoggeado: String = ""
var producto: Producto = Producto("",0f,"","", ArrayList(),ArrayList())

object utilidades {

    fun imprimir(context: Context, texto:String){
        Toast.makeText(context,texto, Toast.LENGTH_SHORT).show()
    }
    fun setCorreoLoggeado(correo:String){
        correoLoggeado = correo
    }
    fun getCorreoLoggeado():String{
        return correoLoggeado
    }

    fun setProducto(p:Producto){
        producto = p
    }
    fun getProducto():Producto{
        return producto
    }


}