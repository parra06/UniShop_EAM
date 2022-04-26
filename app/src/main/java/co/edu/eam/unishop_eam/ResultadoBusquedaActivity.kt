package co.edu.eam.unishop_eam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.edu.eam.unishop_eam.databinding.ActivityResultadoBusquedaBinding

class ResultadoBusquedaActivity : AppCompatActivity() {
    lateinit var binding:ActivityResultadoBusquedaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultadoBusquedaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val texto = intent.extras?.getString("criterio")

        /*if(texto!=null){

            supportFragmentManager.beginTransaction()
                .replace(binding.resultadoBusqueda.id, ListaProductosFragment.newInstance(busqueda = texto))
                .commit()
        }*/

    }
}