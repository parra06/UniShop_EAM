package co.edu.eam.unishop_eam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import co.edu.eam.unishop_eam.data.Categorias
import co.edu.eam.unishop_eam.databinding.ActivityCrearProductoBinding
import co.edu.eam.unishop_eam.modelo.Categoria
import co.edu.eam.unishop_eam.util.utilidades

class CrearProductoActivity : AppCompatActivity() {
    lateinit var binding: ActivityCrearProductoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCrearProductoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getSupportActionBar()?.hide()
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);

        val aux:ArrayList<Categoria> = Categorias.getLista()
        val opciones:ArrayList<String> = ArrayList()
        for (cat in aux){
            opciones.add(cat.nombre)
        }

        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,opciones)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.seleccionDescuento.adapter = adapter

        binding.seleccionDescuento.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, pos: Int, p3: Long) {
               Log.e("Crear","Elemento: $pos")
            }

            override fun onNothingSelected(p0: AdapterView<*>?) { }
        }

        binding.btnInfoDescuento.setOnClickListener{
            binding.txtDescuentoProducto.isEnabled = binding.btnInfoDescuento.isChecked
        }

        }

        }



