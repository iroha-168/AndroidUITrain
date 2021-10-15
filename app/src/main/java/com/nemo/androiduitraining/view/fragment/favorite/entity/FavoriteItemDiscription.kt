package com.nemo.androiduitraining.view.fragment.favorite.entity

import android.view.View
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FavoriteItemDescriptionBinding
import com.xwray.groupie.viewbinding.BindableItem

class FavoriteItemDescription : BindableItem<FavoriteItemDescriptionBinding>() {
    override fun bind(viewBinding: FavoriteItemDescriptionBinding, position: Int) {

    }

    override fun getLayout() = R.layout.favorite_item_description

    override fun initializeViewBinding(view: View): FavoriteItemDescriptionBinding {
        return FavoriteItemDescriptionBinding.bind(view)
    }
}