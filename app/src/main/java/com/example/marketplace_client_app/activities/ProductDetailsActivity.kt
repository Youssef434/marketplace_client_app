package com.example.marketplace_client_app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.marketplace_client_app.R
import com.example.marketplace_client_app.databinding.ProductDetailsBinding
import com.example.marketplace_client_app.model.PRODUCT_ID_EXTRA
import com.example.marketplace_client_app.products

class ProductDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ProductDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val productId = intent.getIntExtra(PRODUCT_ID_EXTRA, -1)
        val product = products
            .find { produit -> produit.numeroSerie == productId }

        if (product != null) {
            supportActionBar?.title = product.nom

            binding.productImage.setImageResource(product.image)
            binding.productTitle.text = product.nom
            binding.productPrice.text = product.prix.toString() + " DH"
            binding.productInfo.text = product.description
        }
    }
}