package com.example.marketplace_client_app.holders

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.marketplace_client_app.currentClient
import com.example.marketplace_client_app.databinding.ProductCardBinding
import com.example.marketplace_client_app.listeners.ProductCardClickListener
import com.example.marketplace_client_app.model.GroupProduit
import com.example.marketplace_client_app.model.Produit

class ProduitCardViewHolder(
    private val productCardBinding: ProductCardBinding,
    private val clickListener: ProductCardClickListener
    ): RecyclerView.ViewHolder(productCardBinding.root) {

    @RequiresApi(Build.VERSION_CODES.O)
    private var productGroups = currentClient.panier.items

    @RequiresApi(Build.VERSION_CODES.O)
    fun bindProduct(product: Produit) {
        productCardBinding.productImage.setImageResource(product.image)
        productCardBinding.productTitle.text = product.nom
        (product.prix.toString() + " DH").also { productCardBinding.productPrice.text = it }

        productCardBinding.productCard.setOnClickListener {
            clickListener.onProductCardClick(product)
        }

        productCardBinding.addCart.setOnClickListener {
            for (group in productGroups) {
                if (group.produit.numeroSerie == product.numeroSerie) {
                    group.nombreProduit += 1
                    return@setOnClickListener
                }
            }

            productGroups.add(GroupProduit(1, product))
        }
    }
}