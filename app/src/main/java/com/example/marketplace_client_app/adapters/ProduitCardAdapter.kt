package com.example.marketplace_client_app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marketplace_client_app.R
import com.example.marketplace_client_app.databinding.ProductCardBinding
import com.example.marketplace_client_app.holders.ProduitCardViewHolder
import com.example.marketplace_client_app.model.Categorie
import com.example.marketplace_client_app.model.Produit

class ProduitCardAdapter: RecyclerView.Adapter<ProduitCardViewHolder>()  {
    private val products = listOf(
        Produit(
            R.drawable.book,
            1,
            "Book 1",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
            50,
            listOf(Categorie(1, "book"))
        ),
        Produit(
            R.drawable.book,
            2,
            "Book 2",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
            150,
            listOf(Categorie(1, "book"))
        ),
        Produit(
            R.drawable.book,
            3,
            "Book 3",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
            80,
            listOf(Categorie(1, "book"))
        ),
        Produit(
            R.drawable.book,
            4,
            "Book 4",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
            75,
            listOf(Categorie(1, "book"))
        ),
        Produit(
            R.drawable.book,
            5,
            "Book 5",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
            280,
            listOf(Categorie(1, "book"))
        ),
        Produit(
            R.drawable.book,
            6,
            "Book 6",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
            80,
            listOf(Categorie(1, "book"))
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProduitCardViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = ProductCardBinding.inflate(from, parent, false)
        return ProduitCardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProduitCardViewHolder, position: Int) {
        holder.bindProduct(products[position])
    }

    override fun getItemCount() = products.size
}