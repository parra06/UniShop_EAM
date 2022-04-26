package co.edu.eam.unishop_eam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView

class activity_recuperarContra : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recuperar_contra)
        getSupportActionBar()?.hide()
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);

        val crearCuenta=findViewById<TextView>(R.id.msj3)
        crearCuenta.setOnClickListener { startActivity(Intent(this, activity_registrar::class.java)) }

        val login=findViewById<Button>(R.id.btn_iniciar_sesion)
        login.setOnClickListener { startActivity(Intent(this, activity_login::class.java)) }
    }
}