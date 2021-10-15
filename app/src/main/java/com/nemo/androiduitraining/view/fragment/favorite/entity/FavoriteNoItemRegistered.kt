package com.nemo.androiduitraining.view.fragment.favorite.entity

import android.view.View
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FavoriteItemNoItemRegisteredBinding
import com.nemo.androiduitraining.databinding.FavoriteNewItemNoBrandRegisteredBinding
import com.xwray.groupie.viewbinding.BindableItem

class FavoriteNoItemRegistered : BindableItem<FavoriteItemNoItemRegisteredBinding>() {
    override fun bind(viewBinding: FavoriteItemNoItemRegisteredBinding, position: Int) {

    }

    override fun getLayout() = R.layout.favorite_item_no_item_registered

    override fun initializeViewBinding(view: View): FavoriteItemNoItemRegisteredBinding {
        return FavoriteItemNoItemRegisteredBinding.bind(view)
    }
}