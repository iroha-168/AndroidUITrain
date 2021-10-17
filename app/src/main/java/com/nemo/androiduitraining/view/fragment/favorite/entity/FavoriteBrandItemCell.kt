package com.nemo.androiduitraining.view.fragment.favorite.entity

import android.view.View
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FavoriteBrandItemCellBinding
import com.xwray.groupie.viewbinding.BindableItem

class FavoriteBrandItemCell : BindableItem<FavoriteBrandItemCellBinding>() {
    override fun bind(viewBinding: FavoriteBrandItemCellBinding, position: Int) {

    }

    override fun getLayout() = R.layout.favorite_brand_item_cell

    override fun initializeViewBinding(view: View): FavoriteBrandItemCellBinding {
        return FavoriteBrandItemCellBinding.bind(view)
    }
}