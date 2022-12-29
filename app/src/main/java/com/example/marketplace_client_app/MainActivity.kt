package com.example.marketplace_client_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.marketplace_client_app.model.Categorie
import com.example.marketplace_client_app.model.Produit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val products: List<Produit> = initProducts()
    }

    private fun initProducts(): List<Produit> {
        return listOf(
            Produit(
                R.drawable.book,
                1,
                "Book1",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                50,
                listOf(Categorie(1, "book"))
            ),
            Produit(
                R.drawable.book,
                2,
                "Book2",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                150,
                listOf(Categorie(1, "book"))
            ),
            Produit(
                R.drawable.book,
                3,
                "Book3",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                80,
                listOf(Categorie(1, "book"))
            )
        )
    }
}