package co.edu.eam.miprimeraapp.actividades

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import co.edu.eam.miprimeraapp.R

class PhotoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)
    }

    fun tomarFoto(view: View){
        val foto = "Esta es la foto que se tomo"
        intent.putExtra("FOTO",foto)
        setResult(RESULT_OK,intent)
        finish()
    }
}