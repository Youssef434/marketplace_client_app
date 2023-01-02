package com.example.marketplace_client_app.holders

import androidx.recyclerview.widget.RecyclerView
import com.example.marketplace_client_app.databinding.ProductCardBinding
import com.example.marketplace_client_app.listeners.ProductCardClickListener
import com.example.marketplace_client_app.model.Produit

class ProduitCardViewHolder(
    private val productCardBinding: ProductCardBinding,
    private val clickListener: ProductCardClickListener
    ): RecyclerView.ViewHolder(productCardBinding.root) {

    fun bindProduct(product: Produit) {
        productCardBinding.productImage.setImageResource(product.image)
        productCardBinding.productTitle.text = product.nom
        (product.prix.toString() + " DH").also { productCardBinding.productPrice.text = it }

        productCardBinding.productCard.setOnClickListener {
            clickListener.onProductCardClick(product)
        }
    }
}