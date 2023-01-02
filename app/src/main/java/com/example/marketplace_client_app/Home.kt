package com.example.marketplace_client_app

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marketplace_client_app.activities.ProductDetailsActivity
import com.example.marketplace_client_app.adapters.ProduitCardAdapter
import com.example.marketplace_client_app.listeners.ProductCardClickListener
import com.example.marketplace_client_app.listeners.SearchBarChangeListener
import com.example.marketplace_client_app.model.GroupProduit
import com.example.marketplace_client_app.model.PRODUCT_ID_EXTRA
import com.example.marketplace_client_app.model.Produit

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Home.newInstance] factory method to
 * create an instance of this fragment.
 */
class Home : Fragment(), ProductCardClickListener, SearchBarChangeListener {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ProduitCardAdapter
    private lateinit var searchView: SearchView
    private var productsCopy = products.toMutableList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "Product's List"

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.setHasFixedSize(true)
        adapter = ProduitCardAdapter(productsCopy, this)
        recyclerView.adapter = adapter

        searchView = view.findViewById(R.id.searchView)

        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query == null) return false

                if (query.isEmpty())
                    productsCopy = products.toMutableList()
                else
                    onSearchBarChange(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }

        })
    }

    override fun onProductCardClick(product: Produit) {
        val intent = Intent(context, ProductDetailsActivity::class.java)
        intent.putExtra(PRODUCT_ID_EXTRA, product.numeroSerie)
        startActivity(intent)
    }

    override fun onSearchBarChange(productName: String) {
        val index = removeAndGetIndex(productName)

        if (index == -1) return
    }

    private fun removeAndGetIndex(productName: String): Int {
        var j = 0

        while (j < productsCopy.size) {
            if (productName != productsCopy[j].nom) {
                productGroups.removeAt(j)
                adapter.notifyItemRemoved(j)
            }
            j++
        }

        return j
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Home.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Home().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}