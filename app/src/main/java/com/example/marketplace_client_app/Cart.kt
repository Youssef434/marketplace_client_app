package com.example.marketplace_client_app

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marketplace_client_app.adapters.CartItemAdapter
import com.example.marketplace_client_app.adapters.ProduitCardAdapter
import com.example.marketplace_client_app.listeners.CartItemClickListener
import com.example.marketplace_client_app.listeners.ProductCardClickListener
import com.example.marketplace_client_app.model.Categorie
import com.example.marketplace_client_app.model.GroupProduit
import com.example.marketplace_client_app.model.Produit

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Cart.newInstance] factory method to
 * create an instance of this fragment.
 */

var productGroups = mutableListOf(
    GroupProduit(2, products[0]),
    GroupProduit(3, products[1]))

class Cart : Fragment(), CartItemClickListener {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CartItemAdapter

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
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "Cart"

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        adapter = CartItemAdapter(productGroups, this)
        recyclerView.adapter = adapter
    }

    override fun onCartItemDelete(cartItem: GroupProduit) {
        val index = removeAndGetIndex(cartItem)
        if (index == -1) return

        adapter.notifyItemRemoved(index)
    }

    private fun removeAndGetIndex(cardItem: GroupProduit): Int {
        for (i in productGroups.indices) {
            if (cardItem == productGroups[i]) {
                productGroups.remove(cardItem)
                return i
            }
        }

        return -1
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Cart.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Cart().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}