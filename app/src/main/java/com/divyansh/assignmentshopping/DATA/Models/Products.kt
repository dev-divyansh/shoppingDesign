package com.divyansh.assignmentshopping.DATA.Models

data class Products(
    val productName:String ="",
    val productDescription:String="",
    val productMRP:Int = 0,
    val discountPrice:Int = 0,
    val colors:List<String> = listOf(),
    val productImage:String = ""
)