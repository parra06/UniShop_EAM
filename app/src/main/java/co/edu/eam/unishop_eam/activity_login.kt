package co.edu.eam.unishop_eam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import co.edu.eam.unishop_eam.data.Usuarios
import co.edu.eam.unishop_eam.databinding.ActivityLoginBinding
import co.edu.eam.unishop_eam.util.utilidades

class activity_login : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textCorreoLayout.isErrorEnabled = true
        binding.textPasswordLayout.isErrorEnabled = true
        utilidades.imprimir(this,Usuarios.getLista().toString())


        getSupportActionBar()?.hide()
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);

        binding.txtOlvidePassword.setOnClickListener { startActivity(Intent(this, activity_recuperarContra::class.java)) }


        binding.txtRegistrate.setOnClickListener { startActivity(Intent(this, activity_registrar::class.java)) }






        binding.btnIniciarSesion.setOnClickListener {

            val correo = binding.textCorreo.text.toString()
            val password = binding.textPassword.text.toString()

            var valido = true

            if(correo.isEmpty()){
                valido = false
                binding.textCorreoLayout.error = "Es un campo obligatorio"
            }else{
                binding.textCorreoLayout.error = null
            }

            if(password.isEmpty()){
                valido = false
                binding.textPasswordLayout.error = "Es un campo obligatorio"
            }else{
                binding.textPasswordLayout.error = null
            }
            if(valido){


                var aux = false
                for (usuario in Usuarios.getLista()){
                    if (usuario.correo == correo && usuario.password == password){
                        utilidades.setCorreoLoggeado(correo)

                        binding.textPassword.setText("")
                        binding.textCorreo.setText("")

                        startActivity(Intent(this, MainActivity::class.java))
                        aux = true
                        break

                    }else{


                    }
                }
                if(!aux){
                    utilidades.imprimir(this,"El correo o la contraseña son incorrectos")
                }








            }






        }

    }

    override fun onRestart() {
        super.onRestart()
        binding.textCorreo.requestFocus()
    }

}