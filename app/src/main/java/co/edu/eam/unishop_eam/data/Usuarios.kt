package co.edu.eam.unishop_eam.data

import co.edu.eam.unishop_eam.modelo.Usuario

object Usuarios {
    private var usuarios:ArrayList<Usuario> = ArrayList()

    init{
        usuarios.add( Usuario("santi@mail.com", "Santiago", "21321312312", "Armenia","1234") )

        usuarios.add( Usuario("lucas@lucas.com", "Lucas", "234", "Calarca","4321") )

    }

    fun getLista():ArrayList<Usuario>{
        return usuarios
    }

    fun registro(usuario: Usuario){
        usuarios.add(usuario)
    }

    fun validarSesion(email:String, password:String):Usuario?{
        val usuario = usuarios.find { u -> u.correo == email && u.password == password }
        return usuario
    }
}