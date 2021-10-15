package com.nemo.androiduitraining.viewModel.favorite

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class FavoriteItemViewModel @Inject constructor(): ViewModel() {
    fun fetchDisplayClothsList(): List<DisplayClothsData> {
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

        return displayList
    }

    private val fullData = DisplayClothsData(
        itemImage = "",
        discountPercent = 50,
        couponPrice = 300,
        itemName = "アディパン",
        itemGenre = "いかつい",
        itemPrice = 3000
    )

    private val missPercentData = DisplayClothsData(
        itemImage = "",
        discountPercent = null,
        couponPrice = 300,
        itemName = "アディパン",
        itemGenre = "いかつい",
        itemPrice = 3000
    )

    private val missCouponData = DisplayClothsData(
        itemImage = "",
        discountPercent = 50,
        couponPrice = null,
        itemName = "アディパン",
        itemGenre = "いかつい",
        itemPrice = 3000
    )

    private val missBothData = DisplayClothsData(
        itemImage = "",
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
    )
}