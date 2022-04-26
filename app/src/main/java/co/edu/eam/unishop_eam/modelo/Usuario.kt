package co.edu.eam.unishop_eam.modelo

class Usuario(var correo:String, var nombre:String, var telefono:String, var ubicacion:String,var password:String) {
    override fun toString(): String {
        return "Usuario(cedula='$correo', nombre='$nombre', correo='$telefono', ubicacion='$ubicacion',password='$password')"
    }

}