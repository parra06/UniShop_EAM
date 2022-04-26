package co.edu.eam.unishop_eam.modelo

class Categoria(var codigo:Int, var nombre:String, var icono: Char, var color:String) {

    override fun toString(): String {
        return "Categoria(nombre='$nombre', icono='$icono', color='$color')"
    }
}