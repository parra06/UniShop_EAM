package co.edu.eam.unishop_eam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.edu.eam.unishop_eam.databinding.ActivityCompraBinding
import co.edu.eam.unishop_eam.util.utilidades

class CompraActivity : AppCompatActivity() {

    lateinit var binding: ActivityCompraBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCompraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNotificaciones.setOnClickListener{
            if (binding.btnNotificaciones.isChecked){
                utilidades.imprimir(this,"Boton encendido")
            }else{
                utilidades.imprimir(this,"Boton apagado")
            }
        }
        binding.btnInfoCompra.setOnClickListener{
            if (binding.btnInfoCompra.isChecked){
                utilidades.imprimir(this,"Boton encendido")
            }else{
                utilidades.imprimir(this,"Boton apagado")
            }
        }
    }

}