package com.nemo.androiduitraining.viewModel.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class FavoriteItemViewModel @Inject constructor(): ViewModel() {
    private val _clothsLD = MutableLiveData<List<DisplayClothsData>>()
    val clothsLD: LiveData<List<DisplayClothsData>>
        get() = _clothsLD

    fun fetchDisplayClothsList() {
        val displayList = mutableListOf<DisplayClothsData>()

        for(i in 0..29) {
            val data = when (Random.nextInt(3)) {
                0 -> fullData
                1 -> missPercentData
                2 -> missCouponData
                else -> missBothData
            }
            displayList.add(data)
        }

        _clothsLD.postValue(displayList)
    }

    private val fullData = DisplayClothsData(
        itemImage = "https://shop.adidas.jp/photo/GN/GN3458/z-GN3458-on_model-standard_view.jpg",
        discountPercent = 50,
        couponPrice = 300,
        itemName = "アディパン",
        itemGenre = "いかつい",
        itemPrice = 3000
    )

    private val missPercentData = DisplayClothsData(
        itemImage = "https://shop.adidas.jp/photo/GN/GN3458/z-GN3458-on_model-standard_view.jpg",
        discountPercent = null,
        couponPrice = 300,
        itemName = "アディパン",
        itemGenre = "いかつい",
        itemPrice = 3000
    )

    private val missCouponData = DisplayClothsData(
        itemImage = "https://shop.adidas.jp/photo/GN/GN3458/z-GN3458-on_model-standard_view.jpg",
        discountPercent = 50,
        couponPrice = null,
        itemName = "アディパン",
        itemGenre = "いかつい",
        itemPrice = 3000
    )

    private val missBothData = DisplayClothsData(
        itemImage = "https://shop.adidas.jp/photo/GN/GN3458/z-GN3458-on_model-standard_view.jpg",
        discountPercent = null,
        couponPrice = null,
        itemName = "アディパン",
        itemGenre = "いかつい",
        itemPrice = 3000
    )

    data class DisplayClothsData(
        val itemImage: String,
        val discountPercent: Int?,
        val couponPrice: Int?,
        val itemName: String,
        val itemGenre: String,
        val itemPrice: Int
    ) {
        fun hasDiscountPercent() = discountPercent != null
        fun hasCouponPrice() = couponPrice != null
    }
}