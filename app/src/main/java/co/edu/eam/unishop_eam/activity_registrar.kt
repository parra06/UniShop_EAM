package co.edu.eam.unishop_eam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import co.edu.eam.unishop_eam.data.Usuarios
import co.edu.eam.unishop_eam.databinding.ActivityCompraBinding
import co.edu.eam.unishop_eam.databinding.ActivityRegistrarBinding
import co.edu.eam.unishop_eam.modelo.Usuario
import co.edu.eam.unishop_eam.util.utilidades

class activity_registrar : AppCompatActivity() {
    lateinit var binding: ActivityRegistrarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegistrarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtCorreoLayout.isErrorEnabled = true
        binding.txtNombreLayout.isErrorEnabled = true
        binding.txtTelefonoLayout.isErrorEnabled = true
        binding.txtPasswordLayout.isErrorEnabled = true
        binding.txtUbicacionLayout.isErrorEnabled = true
        binding.txtConfirmarPasswordLayout.isErrorEnabled = true

        binding.btnRegistrar.setOnClickListener{





                val correo = binding.textCorreo.text.toString()
                val nombre = binding.textNombre.text.toString()
                val telefono = binding.textTelefono.text.toString()
                val password = binding.textPassword.text.toString()
                val password2 = binding.textConfirmarPassword.text.toString()
                val ubicacion = binding.textUbicacion.text.toString()
                var valido = true

                if(correo.isEmpty()){
                    valido = false
                    binding.txtCorreoLayout.error = "Es un campo obligatorio"
                }else{
                    binding.txtCorreoLayout.error = null
                }

                if(nombre.isEmpty()){
                    valido = false
                    binding.txtNombreLayout.error = "Es un campo obligatorio"
                }else{
                    binding.txtNombreLayout.error = null
                }

                if(telefono.isEmpty()){
                    valido = false
                    binding.txtTelefonoLayout.error = "Es un campo obligatorio"
                }else{
                    binding.txtTelefonoLayout.error = null
                }

                if(password.isEmpty()){
                    valido = false
                    binding.txtPasswordLayout.error = "Es un campo obligatorio"
                }else{
                    binding.txtPasswordLayout.error = null
                }
                if(password2.isEmpty()){
                    valido = false
                    binding.txtConfirmarPasswordLayout.error = "Es un campo obligatorio"
                }else{
                    binding.txtConfirmarPasswordLayout.error = null
                }
                if(ubicacion.isEmpty()){
                    valido = false
                    binding.txtUbicacionLayout.error = "Es un campo obligatorio"
                }else{
                    binding.txtUbicacionLayout.error = null
                }

                if(valido){
                    val usuario = Usuario(correo, nombre, telefono, ubicacion, password)
                    Usuarios.registro(usuario)


                    var usuarios:ArrayList<Usuario> = Usuarios.getLista()




                        utilidades.setCorreoLoggeado(correo)
                        limpiar()
                        startActivity(Intent(this, MainActivity::class.java))


                }


        }









        binding.iniciaSesion.setOnClickListener {
            startActivity(Intent(this,activity_login::class.java))
        }
        getSupportActionBar()?.hide()
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);





        /*val login=findViewById<TextView>(R.id.iniciaSesion)
        login.setOnClickListener { startActivity(Intent(this, activity_login::class.java)) }*/


    }
    fun limpiar(){
        binding.textCorreo.setText("")
        binding.textNombre.setText("")
        binding.textTelefono.setText("")
        binding.textUbicacion.setText("")
        binding.textPassword.setText("")
        binding.textConfirmarPassword.setText("")

    }
}