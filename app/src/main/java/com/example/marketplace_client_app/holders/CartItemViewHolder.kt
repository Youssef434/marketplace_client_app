package com.example.marketplace_client_app.holders

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.marketplace_client_app.databinding.CartItemCardBinding
import com.example.marketplace_client_app.listeners.CartItemClickListener
import com.example.marketplace_client_app.model.GroupProduit

class CartItemViewHolder(
    private val cartItemCardBinding: CartItemCardBinding,
    private val clickListener: CartItemClickListener
): RecyclerView.ViewHolder(cartItemCardBinding.root) {
    private lateinit var productGroupAdapter: ArrayAdapter<GroupProduit>

    fun bindCartItem(cartItem: GroupProduit) {
        cartItemCardBinding.productImageView.setImageResource(cartItem.produit.image)
        cartItemCardBinding.productNameTextView.text = cartItem.produit.nom
        cartItemCardBinding.quantitySpinner.setSelection(cartItem.nombreProduit - 1)
        ((cartItem.nombreProduit * cartItem.produit.prix).toString() + " DH").also { cartItemCardBinding.productTotalPriceTextView.text = it }

        cartItemCardBinding.quantitySpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View?, position: Int, id: Long) {
                cartItem.nombreProduit = position + 1
                ((cartItem.nombreProduit * cartItem.produit.prix).toString() + " DH").also { cartItemCardBinding.productTotalPriceTextView.text = it }
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {}
        }

        cartItemCardBinding.deleteProductButton.setOnClickListener {
            clickListener.onCartItemDelete(cartItem)
        }
    }
}