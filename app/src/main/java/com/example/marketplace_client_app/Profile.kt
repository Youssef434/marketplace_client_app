package com.example.marketplace_client_app

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.marketplace_client_app.databinding.FragmentProfileBinding
import com.example.marketplace_client_app.databinding.ProductDetailsBinding
import com.example.marketplace_client_app.model.Client
import com.example.marketplace_client_app.model.GroupProduit
import com.example.marketplace_client_app.model.Panier
import java.time.LocalDate

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Profile.newInstance] factory method to
 * create an instance of this fragment.
 */
private var productGroups = mutableListOf(
GroupProduit(1, products[0]),
GroupProduit(3, products[1]))

@RequiresApi(Build.VERSION_CODES.O)
val currentClient = Client(
    "Youssef",
    "FATMI",
    LocalDate.of(2001, 1, 7),
    "+212670339442",
    "fatmi2019py@gmail.com",
    Panier(0, productGroups)
)

class Profile : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentProfileBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(layoutInflater)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "Profile"

        (currentClient.prenom + " " + currentClient.nom).also {
            binding.fullName.text = it
        }

        binding.phoneNumber.text = currentClient.numeroTelephone
        binding.email.text = currentClient.email
        binding.dateNaissance.text = currentClient.dateNaissance.toString()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Profile.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic fun newInstance(param1: String, param2: String) =
                Profile().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}