package com.divyansh.assignmentshopping.UI.Activity

import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import com.divyansh.assignmentshopping.R
import com.divyansh.assignmentshopping.UI.fragment.CartFragment
import com.divyansh.assignmentshopping.UI.fragment.FavouriteFragment
import com.divyansh.assignmentshopping.UI.fragment.ProductDetailsFragment
import com.divyansh.assignmentshopping.UI.fragment.ProductsFragment
import com.divyansh.assignmentshopping.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private  lateinit var binding:ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(ProductsFragment())

        binding.bottomNavigationView.setOnItemSelectedListener { itemView ->
            when(itemView.itemId){
                R.id.home_bv_icon -> {
                    replaceFragment(ProductsFragment())
                    true
                }

                R.id.cart_bv_icon -> {
                    replaceFragment(CartFragment())
                    true
                }

                R.id.more_bv_icon -> {
                    replaceFragment(ProductsFragment())
                    true
                }

                R.id.favourite_bv_icon -> {
                    replaceFragment(FavouriteFragment())
                    true
                }

                else -> false
            }
        }
    }
    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameLayout,fragment)
            .commit()
    }
}