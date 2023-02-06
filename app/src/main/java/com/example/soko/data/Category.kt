package com.example.soko.data

enum class Category(val s: String) {
    //this class holds the constant variables

    Electronics("electronics"),
    Jewelery("jewelery"),
    MenSClothing("men's clothing"),
    WomenSClothing("women's clothing");

    companion object {
        public fun fromValue(s: String): Category = when (s) {
            "electronics"      -> Electronics
            "jewelery"         -> Jewelery
            "men's clothing"   -> MenSClothing
            "women's clothing" -> WomenSClothing
            else               -> throw IllegalArgumentException()
        }
    }



}