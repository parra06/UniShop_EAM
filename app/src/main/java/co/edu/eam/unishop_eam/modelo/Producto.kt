package co.edu.eam.unishop_eam.modelo

class Producto (var codigo:String?, var precio:Float, var nombre:String?, var descripcion:String?, var imagenes:ArrayList<String>?, var categorias:List<Int>) {

    var descuento: Float = 0f
    var vendedor: String = ""
    var unidades: Int = 0

    override fun toString(): String {
        return "Producto(codigo=$codigo, precio=$precio, nombre=$nombre, descripcion=$descripcion, imagenes=$imagenes, descuento=$descuento, categorias=$categorias, vendedor='$vendedor', unidades=$unidades)"
    }
}