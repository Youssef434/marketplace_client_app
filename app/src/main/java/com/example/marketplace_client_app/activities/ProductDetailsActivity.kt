package com.example.marketplace_client_app.activities

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.marketplace_client_app.R
import com.example.marketplace_client_app.currentClient
import com.example.marketplace_client_app.databinding.ProductDetailsBinding
import com.example.marketplace_client_app.model.GroupProduit
import com.example.marketplace_client_app.model.PRODUCT_ID_EXTRA
import com.example.marketplace_client_app.products

class ProductDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ProductDetailsBinding

    @RequiresApi(Build.VERSION_CODES.O)
    private var productGroups = currentClient.panier.items

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val productId = intent.getIntExtra(PRODUCT_ID_EXTRA, -1)
        val product = products
            .find { produit -> produit.numeroSerie == productId } ?: return

        supportActionBar?.title = product.nom

        binding.productImage.setImageResource(product.detailImage!!)
        binding.productTitle.text = product.nom
        (product.prix.toString() + " DH").also { binding.productPrice.text = it }
        binding.productInfo.text = product.description

        binding.outlinedButton.setOnClickListener {
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