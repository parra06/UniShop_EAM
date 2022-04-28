package co.edu.eam.unishop_eam.data

import co.edu.eam.unishop_eam.modelo.Producto

object Carrito {

    private var listaCarrito:ArrayList<Producto> = ArrayList()
    init {
        var categorias:ArrayList<Int> = ArrayList()
        categorias.add(3)

        val p1 = Producto("123", 40000f, "Memoria USB 8 GB", "Une espectacular memoria usb marca gato", ArrayList(), categorias)
        listaCarrito.add(p1)



        categorias = ArrayList()
        categorias.add(5)

        val p2 = Producto("126", 90000f, "Camiseta Levis", "Camiseta colección 2022", ArrayList(), categorias)
        listaCarrito.add(p2)



        categorias = ArrayList()
        categorias.add(3)

        val p3 = Producto("125", 160000f, "Nintendo Switch", "Nintendo 2021", ArrayList(), categorias)
        listaCarrito.add(p3)


    }
    fun obtener():ArrayList<Producto>{
        return listaCarrito
    }

    fun agregar(producto: Producto){
        listaCarrito.add(producto)
    }

    fun limpiar(){
        listaCarrito.clear()
    }

}