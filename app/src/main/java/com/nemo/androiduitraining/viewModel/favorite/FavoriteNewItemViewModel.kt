package com.nemo.androiduitraining.viewModel.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteNewItemViewModel @Inject constructor() : ViewModel() {
    private val _brandsLD = MutableLiveData<List<BrandItem>>()
    val brandLD: LiveData<List<BrandItem>>
        get() = _brandsLD

    fun fetchBrandItems() {
        val brandsList = mutableListOf<BrandItem>()
        for (i in 0..29) {
            brandsList.add(
                BrandItem("ほげほげ", "フガフガ")
            )
        }
        _brandsLD.postValue(brandsList)
    }

    data class BrandItem(
        val name: String,
        val nameJapanese: String
    )
}
