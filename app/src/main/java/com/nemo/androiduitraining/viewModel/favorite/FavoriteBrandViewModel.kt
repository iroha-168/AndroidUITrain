package com.nemo.androiduitraining.viewModel.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteBrandViewModel @Inject constructor(): ViewModel() {
    private val _brandsLD = MutableLiveData<List<BrandTabBrandItem>>()
    val brandLD: LiveData<List<BrandTabBrandItem>>
        get() = _brandsLD

    fun fetchBrandItems() {
        val brandsList = mutableListOf<BrandTabBrandItem>()
        for (i in 0..29) {
            brandsList.add(
                BrandTabBrandItem("uniqlo", "ユニクロ")
            )
        }
        _brandsLD.postValue(brandsList)
    }

    data class BrandTabBrandItem(
        val name: String,
        val nameJapanese: String
    )
}