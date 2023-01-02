package com.example.marketplace_client_app

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.marketplace_client_app.databinding.ActivityMainBinding
import com.example.marketplace_client_app.model.Categorie
import com.example.marketplace_client_app.model.Produit

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#4E4F55")))

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.homeItem -> replaceFragment(Home())
                R.id.cartItem -> replaceFragment(Cart())
                R.id.profileItem -> replaceFragment(Profile())
                else -> {}
            }

            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }
}

val products: List<Produit> = listOf(
    Produit(
        R.drawable.img_1,
        1,
        "Sierra",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
        5000,
        listOf(Categorie(1, "book")),
        R.drawable.img_3_detail
    ),
    Produit(
        R.drawable.img_2,
        2,
        "Adidas Core",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
        550,
        listOf(Categorie(1, "book")),
        R.drawable.img_3_detail
    ),
    Produit(
        R.drawable.img_3,
        3,
        "PlayStation 5",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
        80,
        listOf(Categorie(1, "book")),
        R.drawable.img_3_detail
    ),
    Produit(
        R.drawable.book,
        4,
        "Book",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
        75,
        listOf(Categorie(1, "book")),
        R.drawable.img_3_detail
    ),
    Produit(
        R.drawable.img_1,
        5,
        "Book 5",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
        280,
        listOf(Categorie(1, "book")),
        R.drawable.img_3_detail
    ),
    Produit(
        R.drawable.img_1,
        6,
        "Book 6",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
        80,
        listOf(Categorie(1, "book")),
        R.drawable.img_3_detail
    ))