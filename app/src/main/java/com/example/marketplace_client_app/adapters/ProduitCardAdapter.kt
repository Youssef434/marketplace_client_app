package com.example.marketplace_client_app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marketplace_client_app.R
import com.example.marketplace_client_app.databinding.ProductCardBinding
import com.example.marketplace_client_app.holders.ProduitCardViewHolder
import com.example.marketplace_client_app.listeners.ProductCardClickListener
import com.example.marketplace_client_app.model.Categorie
import com.example.marketplace_client_app.model.Produit

class ProduitCardAdapter(
    private val products: List<Produit>,
    private val clickListener: ProductCardClickListener
): RecyclerView.Adapter<ProduitCardViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProduitCardViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = ProductCardBinding.inflate(from, parent, false)
        return ProduitCardViewHolder(binding, clickListener)
    }

    override fun onBindViewHolder(holder: ProduitCardViewHolder, position: Int) {
        holder.bindProduct(products[position])
    }

    override fun getItemCount() = products.size
}