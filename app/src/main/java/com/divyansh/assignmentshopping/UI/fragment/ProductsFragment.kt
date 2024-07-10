package com.divyansh.assignmentshopping.UI.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.divyansh.assignmentshopping.DATA.Adapters.productsAdapter
import com.divyansh.assignmentshopping.DATA.Models.Products
import com.divyansh.assignmentshopping.R
import com.divyansh.assignmentshopping.databinding.FragmentProductsBinding

class ProductsFragment : Fragment() , productsAdapter.onProductClick {
    private lateinit var binding:FragmentProductsBinding
    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductsBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.productRecyclerview

        val productsData = listOf(
            Products("Titan Watch", "This is a Titan watch", 20000, 1050, listOf("#F5F5F5", "#FFFFFF", "#F0F0F0"), "https://www.titan.co.in/dw/image/v2/BKDD_PRD/on/demandware.static/-/Sites-titan-master-catalog/default/dw0814ec34/images/Titan/Catalog/1805QM04_1.jpg"),
            Products("Apple Watch", "Latest model of Apple watch", 20999, 1089, listOf("#F5F5F5", "#000000", "#FF0000"), "https://m.media-amazon.com/images/I/71CrNuzQaHL._AC_UF894,1000_QL80_.jpg"),
            Products("Mens blue suit", "buy mens blue suit and trouser", 1799, 1699, listOf("#F5F5F5", "#00FF00", "#0000FF"), "https://m.media-amazon.com/images/I/61LXuN3rZbL._AC_UY1100_.jpg"),
            Products("Black Sports Shoes for Men by NIKE", "Buy Black Sports Shoes for Men by NIKE", 7020, 1090, listOf("#F5F5F5", "#FFFF00", "#FF00FF"), "https://assets.ajio.com/medias/sys_master/root/20221025/ex6J/6357f5c5f997ddfdbd3e830e/-1117Wx1400H-469258173-black-MODEL.jpg"),
            Products("Nike Air Force", "Nike Air Force 1 Mid By You. Men's Custom Shoes", 30050, 13000, listOf("#F5F5F5", "#000000", "#808080"), "https://static.nike.com/a/images/t_PDP_1280_v1/f_auto,q_auto:eco/fdded470-0ac5-4bd7-b41b-1bb63e161438/custom-nike-air-force-1-mid-by-you-shoes.png"),
            Products("Shirt Men Fashion Slim Fit ", "New Shirt Men Fashion Slim Fit Long Sleeve Mens Shirt Solid Color Henley Collar Casual Shirts Men Cotton", 1500, 1350, listOf("#F5F5F5", "#FFFFFF", "#333333"), "https://img.fruugo.com/product/4/85/614718854_max.jpg"),
            Products("Ticwatch E3 Smart Watch Wear OS", "Ticwatch E3 Smart Watch Wear OS by Google Watch for Men and Women Qualcomm Snapdragon Wear", 30899, 30500, listOf("#F5F5F5", "#212121", "#BDBDBD"), "https://m.media-amazon.com/images/I/61k3TgTZfVL.jpg"),
            Products("Titan Watch", "This is a Titan watch", 20000, 1050, listOf("#F5F5F5", "#FFFFFF", "#F0F0F0"), "https://www.titan.co.in/dw/image/v2/BKDD_PRD/on/demandware.static/-/Sites-titan-master-catalog/default/dw0814ec34/images/Titan/Catalog/1805QM04_1.jpg"),
            Products("Apple Watch", "Latest model of Apple watch", 20999, 1089, listOf("#F5F5F5", "#000000", "#FF0000"), "https://m.media-amazon.com/images/I/71CrNuzQaHL._AC_UF894,1000_QL80_.jpg"),
            Products("Mens blue suit", "buy mens blue suit and trouser", 1799, 1699, listOf("#F5F5F5", "#00FF00", "#0000FF"), "https://m.media-amazon.com/images/I/61LXuN3rZbL._AC_UY1100_.jpg"),
            Products("Black Sports Shoes for Men by NIKE", "Buy Black Sports Shoes for Men by NIKE", 7020, 1090, listOf("#F5F5F5", "#FFFF00", "#FF00FF"), "https://assets.ajio.com/medias/sys_master/root/20221025/ex6J/6357f5c5f997ddfdbd3e830e/-1117Wx1400H-469258173-black-MODEL.jpg"),
            Products("Nike Air Force", "Nike Air Force 1 Mid By You. Men's Custom Shoes", 30050, 13000, listOf("#F5F5F5", "#000000", "#808080"), "https://static.nike.com/a/images/t_PDP_1280_v1/f_auto,q_auto:eco/fdded470-0ac5-4bd7-b41b-1bb63e161438/custom-nike-air-force-1-mid-by-you-shoes.png"),
            Products("Shirt Men Fashion Slim Fit ", "New Shirt Men Fashion Slim Fit Long Sleeve Mens Shirt Solid Color Henley Collar Casual Shirts Men Cotton", 1500, 1350, listOf("#F5F5F5", "#FFFFFF", "#333333"), "https://img.fruugo.com/product/4/85/614718854_max.jpg"),
            Products("Titan Watch", "This is a Titan watch", 20000, 1050, listOf("#F5F5F5", "#FFFFFF", "#F0F0F0"), "https://www.titan.co.in/dw/image/v2/BKDD_PRD/on/demandware.static/-/Sites-titan-master-catalog/default/dw0814ec34/images/Titan/Catalog/1805QM04_1.jpg"),
            Products("Apple Watch", "Latest model of Apple watch", 20999, 1089, listOf("#F5F5F5", "#000000", "#FF0000"), "https://m.media-amazon.com/images/I/71CrNuzQaHL._AC_UF894,1000_QL80_.jpg"),
            Products("Mens blue suit", "buy mens blue suit and trouser", 1799, 1699, listOf("#F5F5F5", "#00FF00", "#0000FF"), "https://m.media-amazon.com/images/I/61LXuN3rZbL._AC_UY1100_.jpg"),
            Products("Black Sports Shoes for Men by NIKE", "Buy Black Sports Shoes for Men by NIKE", 7020, 1090, listOf("#F5F5F5", "#FFFF00", "#FF00FF"), "https://assets.ajio.com/medias/sys_master/root/20221025/ex6J/6357f5c5f997ddfdbd3e830e/-1117Wx1400H-469258173-black-MODEL.jpg"),
            Products("Nike Air Force", "Nike Air Force 1 Mid By You. Men's Custom Shoes", 30050, 13000, listOf("#F5F5F5", "#000000", "#808080"), "https://static.nike.com/a/images/t_PDP_1280_v1/f_auto,q_auto:eco/fdded470-0ac5-4bd7-b41b-1bb63e161438/custom-nike-air-force-1-mid-by-you-shoes.png"),
            Products("Shirt Men Fashion Slim Fit ", "New Shirt Men Fashion Slim Fit Long Sleeve Mens Shirt Solid Color Henley Collar Casual Shirts Men Cotton", 1500, 1350, listOf("#F5F5F5", "#FFFFFF", "#333333"), "https://img.fruugo.com/product/4/85/614718854_max.jpg"),
            Products("Titan Watch", "This is a Titan watch", 20000, 1050, listOf("#F5F5F5", "#FFFFFF", "#F0F0F0"), "https://www.titan.co.in/dw/image/v2/BKDD_PRD/on/demandware.static/-/Sites-titan-master-catalog/default/dw0814ec34/images/Titan/Catalog/1805QM04_1.jpg"),
            Products("Apple Watch", "Latest model of Apple watch", 20999, 1089, listOf("#F5F5F5", "#000000", "#FF0000"), "https://m.media-amazon.com/images/I/71CrNuzQaHL._AC_UF894,1000_QL80_.jpg"),
            Products("Mens blue suit", "buy mens blue suit and trouser", 1799, 1699, listOf("#F5F5F5", "#00FF00", "#0000FF"), "https://m.media-amazon.com/images/I/61LXuN3rZbL._AC_UY1100_.jpg"),
            Products("Black Sports Shoes for Men by NIKE", "Buy Black Sports Shoes for Men by NIKE", 7020, 1090, listOf("#F5F5F5", "#FFFF00", "#FF00FF"), "https://assets.ajio.com/medias/sys_master/root/20221025/ex6J/6357f5c5f997ddfdbd3e830e/-1117Wx1400H-469258173-black-MODEL.jpg"),
            Products("Nike Air Force", "Nike Air Force 1 Mid By You. Men's Custom Shoes", 30050, 13000, listOf("#F5F5F5", "#000000", "#808080"), "https://static.nike.com/a/images/t_PDP_1280_v1/f_auto,q_auto:eco/fdded470-0ac5-4bd7-b41b-1bb63e161438/custom-nike-air-force-1-mid-by-you-shoes.png"),
            Products("Shirt Men Fashion Slim Fit ", "New Shirt Men Fashion Slim Fit Long Sleeve Mens Shirt Solid Color Henley Collar Casual Shirts Men Cotton", 1500, 1350, listOf("#F5F5F5", "#FFFFFF", "#333333"), "https://img.fruugo.com/product/4/85/614718854_max.jpg")

        )


        val linearLayout = LinearLayoutManager(requireContext(),RecyclerView.VERTICAL,false)
        recyclerView.layoutManager = linearLayout

        val adapter = productsAdapter(requireContext(),productsData , this)
        recyclerView.adapter = adapter
    }

    override fun onItemClick(products: Products?) {
        // here we could pass the data through bundle,focusing on UI so skipping that part
        // as a result it would show the same product on any product click; we can pass the entire product
        // or best would be to pass  the product Id and fetch the product data using that
        replaceFragment(ProductDetailsFragment())
    }
    private fun replaceFragment(fragment: Fragment){
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameLayout,fragment)
            .commit()
    }
}