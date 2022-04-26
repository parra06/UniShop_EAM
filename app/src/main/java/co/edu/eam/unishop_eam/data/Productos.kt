package co.edu.eam.unishop_eam.data

import android.util.Log
import co.edu.eam.unishop_eam.modelo.Producto

object Productos {
    private var listaProductos:ArrayList<Producto> = ArrayList()

    init{

        var categorias:ArrayList<Int> = ArrayList()
        categorias.add(3)

        val p1 = Producto("123", 40000f, "Memoria USB 8 GB", "Une espectacular memoria usb marca gato", ArrayList(), categorias)
        listaProductos.add(p1)

        categorias = ArrayList()
        categorias.add(5)

        val p2 = Producto("126", 90000f, "Camiseta Levis", "Camiseta colección 2022", ArrayList(), categorias)
        listaProductos.add(p2)

        categorias = ArrayList()
        categorias.add(3)

        val p3 = Producto("125", 160000f, "Nintendo Switch", "Nintendo 2021", ArrayList(), categorias)
        listaProductos.add(p3)

        categorias = ArrayList()
        categorias.add(3)

        val p4 = Producto("124", 90000f, "Computador ASUS", "Computador con xyz características", ArrayList(), categorias)
        listaProductos.add(p4)

        categorias = ArrayList()
        categorias.add(1)

        val p5 = Producto("127", 160000f, "Guitarra Acustica", "2022", ArrayList(), categorias)
        p5.descuento = 30f
        listaProductos.add(p5)

        categorias = ArrayList()
        categorias.add(2)

        val p6 = Producto("128", 160000f, "Bajo la misma estrella", "Emotivo", ArrayList(), categorias)
        listaProductos.add(p6)

        categorias = ArrayList()
        categorias.add(4)

        val p7 = Producto("129", 180000f, "Balon Champions", "2022", ArrayList(), categorias)
        listaProductos.add(p7)

        categorias = ArrayList()
        categorias.add(6)
        categorias.add(3)

        val p8 = Producto("130", 200000f, "Licuadora", "OSTER", ArrayList(), categorias)
        p8.descuento = 50F
        listaProductos.add(p8)

    }

    fun getLista():ArrayList<Producto>{
        return listaProductos
    }

    fun agregar(producto: Producto){
        listaProductos.add(producto)
    }

    fun obtener(productoID:String):Producto?{
        return listaProductos.find{ p -> p.codigo == productoID }
    }

    fun eliminar(codigo:String){
        listaProductos.removeIf{ it.codigo == codigo }
    }

    fun buscar(nombre:String):ArrayList<Producto>{
        return listaProductos.filter { p -> p.nombre!!.lowercase().contains(nombre.lowercase()) }.toCollection(ArrayList())
    }

    fun listar(categoria: Int): ArrayList<Producto>{
        Log.v("LISTA", listaProductos.toString())
        return listaProductos.filter { p -> p.categorias.contains(categoria) }.toCollection(ArrayList())
    }

    fun editar(producto: Producto){

    }

    fun listarOfertas():ArrayList<Producto>{
        return ArrayList()
    }
}