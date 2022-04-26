package co.edu.eam.unishop_eam.data

import co.edu.eam.unishop_eam.modelo.Categoria

object Categorias {

    private var categorias:ArrayList<Categoria> = ArrayList()

    init {
        categorias.add( Categoria(1,"Instrumentos", '\uf236', "") )
        categorias.add( Categoria(2,"Libros", '\uf1e6', "") )
        categorias.add( Categoria(3,"Tecnología", '\uf390', "") )
        categorias.add( Categoria(4,"Deportes", '\uf6e3', "") )
        categorias.add( Categoria(5,"Ropa", '\uf553', "") )
        categorias.add( Categoria(6,"Otros", '\uf1b9', "") )
    }

    fun getLista():ArrayList<Categoria>{
        return categorias
    }

    fun agregar(categoria: Categoria){
        categorias.add(categoria)
    }

    fun obtener(codigo:Int):Categoria?{
        return categorias.find { c -> c.codigo == codigo }
    }

}