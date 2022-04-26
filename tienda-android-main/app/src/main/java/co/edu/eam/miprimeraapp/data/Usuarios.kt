package co.edu.eam.miprimeraapp.data

import co.edu.eam.miprimeraapp.modelo.Usuario

object Usuarios {

    private var usuarios:ArrayList<Usuario> = ArrayList()

    init{

    }

    fun getLista():ArrayList<Usuario>{
        return usuarios
    }

}