package com.nemo.androiduitraining.viewModel.favorite

import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.nemo.androiduitraining.view.fragment.favorite.entity.FavoriteItemCell
import com.nemo.androiduitraining.view.fragment.favorite.entity.FavoriteNoBrandRegistered
import com.nemo.androiduitraining.view.fragment.favorite.entity.FavoriteNowPopular
import com.xwray.groupie.viewbinding.BindableItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteNewItemViewModel @Inject constructor() : ViewModel() {
    private val _defaultViewList = mutableListOf(
        FavoriteNoBrandRegistered(),
        FavoriteNowPopular()
    )
    val defaultViewList: List<BindableItem<out ViewBinding>>
        get() = _defaultViewList

    fun createItemCells() {
        for (i in 0..29) {
            _defaultViewList.add(FavoriteItemCell(
                "ほげほげ", "ふがふが"
            ))
        }
    }
}