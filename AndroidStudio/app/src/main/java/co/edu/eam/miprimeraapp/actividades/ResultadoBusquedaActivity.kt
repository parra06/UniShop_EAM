package co.edu.eam.miprimeraapp.actividades

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.edu.eam.miprimeraapp.databinding.ActivityResultadoBusquedaBinding

class ResultadoBusquedaActivity : AppCompatActivity() {

    lateinit var binding:ActivityResultadoBusquedaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultadoBusquedaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val texto = intent.extras?.getString("criterio")

        binding.criterioTxt.text = texto

    }
}