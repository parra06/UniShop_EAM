package co.edu.eam.unishop_eam.fragmentos

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import co.edu.eam.unishop_eam.*
import co.edu.eam.unishop_eam.databinding.FragmentBarraSuperiorBinding


class BarraSuperiorFragment : Fragment() {

    lateinit var binding: FragmentBarraSuperiorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v("BarraSuperiorFragment", "onCreate()")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBarraSuperiorBinding.inflate(inflater, container, false)

        Log.v("BarraSuperiorFragment", "onCreateView()")

        binding.textoBusqueda.setOnEditorActionListener { textView, i, keyEvent ->
            if( i == EditorInfo.IME_ACTION_SEARCH ){
                irABusqueda()
            }
            true
        }

        binding.btnCarrito.setOnClickListener {
            val intent = Intent(context, CarritoActivity2::class.java)
            startActivity(intent)
        }

        return binding.root
    }

    fun irABusqueda(){
        val criterio = binding.textoBusqueda.text.toString()

        if(criterio.isNotEmpty()){
            val intent = Intent(context, ListaProductosActivity::class.java)
            intent.putExtra("criterio", criterio)
            startActivity(intent)
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.v("BarraSuperiorFragment", "onAttach()")
    }

    override fun onDetach() {
        super.onDetach()
        Log.v("BarraSuperiorFragment", "onDetach()")
    }

}