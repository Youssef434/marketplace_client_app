package com.example.marketplace_client_app.holder

import androidx.recyclerview.widget.RecyclerView
import com.example.marketplace_client_app.databinding.ProductCardBinding
import com.example.marketplace_client_app.model.Produit

class ProduitCardViewHolder(private val productCardBinding: ProductCardBinding): RecyclerView.ViewHolder(productCardBinding.root) {
    fun bindProduct(product: Produit) {
        productCardBinding.productImage.setImageResource(product.image)
        productCardBinding.productTitle.text = product.nom
        (product.prix.toString() + " DH").also { productCardBinding.productPrice.text = it }
        productCardBinding.productInfo.text = product.description
    }
}