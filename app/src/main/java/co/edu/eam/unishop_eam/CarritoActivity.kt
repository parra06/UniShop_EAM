package co.edu.eam.unishop_eam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.edu.eam.unishop_eam.databinding.ActivityCarritoBinding

class CarritoActivity : AppCompatActivity() {
    lateinit var binding:ActivityCarritoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCarritoBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}