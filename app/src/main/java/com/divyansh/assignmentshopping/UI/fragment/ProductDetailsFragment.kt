package com.divyansh.assignmentshopping.UI.fragment

import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.divyansh.assignmentshopping.DATA.Adapters.ImageCarouselAdapter
import com.divyansh.assignmentshopping.R
import com.divyansh.assignmentshopping.databinding.FragmentProductDetailsBinding
import com.google.android.material.carousel.CarouselLayoutManager
import com.google.android.material.carousel.CarouselSnapHelper


class ProductDetailsFragment : Fragment() {
    private lateinit var binding: FragmentProductDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductDetailsBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.productDetailsMrp.paintFlags = binding.productDetailsMrp.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG

        binding.backButtonProductDetails.setOnClickListener {
            replaceFragment(ProductsFragment())
        }

        binding.productDetailsColor1.setOnClickListener {
            resetAllChoosenColor()
            changeChooseColor(1)
        }
        binding.productDetailsColor2.setOnClickListener {
            resetAllChoosenColor()
            changeChooseColor(2)
        }
        binding.productDetailsColor3.setOnClickListener {
            resetAllChoosenColor()
            changeChooseColor(3)
        }
        binding.productDetailsColor1.setImageResource(R.drawable.check)
        binding.productDetailsChooseColor.text = "black"

        binding.imageProductDetails.setHasFixedSize(true)
        binding.imageProductDetails.layoutManager = CarouselLayoutManager()
        CarouselSnapHelper().attachToRecyclerView(binding.imageProductDetails)

        val imageList = mutableListOf<String>()
        imageList.add("https://chronexttime.imgix.net/V/0/V00201415/V00201415_2.jpg")
        imageList.add("https://petermachlup.com/cdn/shop/products/rx14950_3_800x.jpg")
        imageList.add("https://dillibazar.co.in/wp-content/uploads/90.jpg")

        val adapter = ImageCarouselAdapter(imageList)
        binding.imageProductDetails.adapter = adapter
    }
    private fun changeChooseColor(colorId:Int){
        when(colorId){
            1 -> {
                binding.productDetailsColor1.setImageResource(R.drawable.check)
                binding.productDetailsChooseColor.text = "black"
            }
            2 -> {
                binding.productDetailsColor2.setImageResource(R.drawable.check)
                binding.productDetailsChooseColor.text = "blue"
            }
            3 -> {
                binding.productDetailsColor3.setImageResource(R.drawable.check)
                binding.productDetailsChooseColor.text = "grey"
            }
        }
    }
    private fun resetAllChoosenColor(){
        binding.productDetailsColor1.setImageResource(0)
        binding.productDetailsColor2.setImageResource(0)
        binding.productDetailsColor3.setImageResource(0)
    }
    private fun replaceFragment(fragment: Fragment){
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameLayout,fragment)
            .commit()
    }
}