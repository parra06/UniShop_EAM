package co.edu.eam.unishop_eam

import android.graphics.Canvas
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import  co.edu.eam.unishop_eam.R
import co.edu.eam.unishop_eam.adapter.ProductoAdapter
import co.edu.eam.unishop_eam.data.Categorias
import co.edu.eam.unishop_eam.data.Productos
import co.edu.eam.unishop_eam.databinding.ActivityListaProductosBinding
import co.edu.eam.unishop_eam.modelo.Producto
import co.edu.eam.unishop_eam.util.utilidades
import com.google.android.material.snackbar.Snackbar
import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator

class ListaProductosActivity : AppCompatActivity() {
    lateinit var binding: ActivityListaProductosBinding
    lateinit var adapterProductos: ProductoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = ActivityListaProductosBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val codigoCategoria = intent.extras?.getInt("categoria")
        val productoBuscado = intent.extras?.getString("criterio")

        val listaProductos:ArrayList<Producto> = Productos.getLista()
        var listaAux:ArrayList<Producto> = ArrayList()
        if (productoBuscado != null) {
            listaAux = Productos.buscar(productoBuscado)




            /*for (producto in listaProductos){
                if (producto.nombre == productoBuscado.toString()){
                    binding.txtCategoria.text = productoBuscado.toString()
                    listaAux.add(producto)
                }
            }*/
        }else{
            for (cat in Categorias.getLista()){
                if (cat.codigo == codigoCategoria){
                    binding.txtCategoria.text = cat.nombre
                    break
                }
            }




            for (producto in listaProductos){
                for (cat in producto.categorias){
                    if (cat == codigoCategoria){
                        listaAux.add(producto)
                        break
                    }
                }
            }
        }






        adapterProductos = ProductoAdapter(listaAux)
        binding.listaProductos.adapter = adapterProductos
        binding.listaProductos.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        val simpleCallback:ItemTouchHelper.SimpleCallback = object : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
               return false
            }



            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val pos = viewHolder.adapterPosition

                when(direction){
                    ItemTouchHelper.LEFT ->{
                        val producto = listaAux[pos]
                        listaAux.removeAt(pos)
                        Productos.eliminar(producto.codigo.toString())
                        adapterProductos.notifyItemRemoved(pos)


                        Snackbar.make(binding.listaProductos,"${producto.nombre} se ha eliminado!",Snackbar.LENGTH_SHORT)
                                .setAction("Deshacer",View.OnClickListener {
                                    listaAux.add(pos, producto)
                                    adapterProductos.notifyItemInserted(pos)
                                }).show()

                    }
                    ItemTouchHelper.RIGHT->{
                        Log.e("Listaaaaaa","Swipe Derecha")
                    }
                }
            }

            override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
                super.onSelectedChanged(viewHolder, actionState)
                val pos = viewHolder?.adapterPosition
                val producto = listaAux[pos!!]
                utilidades.setProducto(producto)
            }

            override fun onChildDraw(
                c: Canvas,
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                dX: Float,
                dY: Float,
                actionState: Int,
                isCurrentlyActive: Boolean
            ) {
                RecyclerViewSwipeDecorator.Builder(c, recyclerView,viewHolder,dX,dY,actionState,isCurrentlyActive)
                    .addSwipeLeftBackgroundColor(ContextCompat.getColor(baseContext,R.color.red))
                    .addSwipeLeftActionIcon(android.R.drawable.ic_menu_delete)
                    .addSwipeRightBackgroundColor(ContextCompat.getColor(baseContext,R.color.verde))
                    .addSwipeRightActionIcon(android.R.drawable.ic_menu_add)
                    .create()
                    .decorate()


                super.onChildDraw(
                    c,
                    recyclerView,
                    viewHolder,
                    dX,
                    dY,
                    actionState,
                    isCurrentlyActive
                )
            }


        }

        val itemTouchHelper = ItemTouchHelper(simpleCallback)
        itemTouchHelper.attachToRecyclerView(binding.listaProductos)


    }
}