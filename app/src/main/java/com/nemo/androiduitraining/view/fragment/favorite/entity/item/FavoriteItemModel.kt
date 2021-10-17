package com.nemo.androiduitraining.view.fragment.favorite.entity.item

import androidx.viewbinding.ViewBinding
import com.xwray.groupie.viewbinding.BindableItem

abstract class FavoriteItemModel<VB: ViewBinding> : BindableItem<VB>() {
    abstract val spanSize: Int
}