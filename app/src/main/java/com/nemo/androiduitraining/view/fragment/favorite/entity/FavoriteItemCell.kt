package com.nemo.androiduitraining.view.fragment.favorite.entity

import android.view.View
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FavoriteNewItemItemCellBinding
import com.xwray.groupie.viewbinding.BindableItem

class FavoriteItemCell(
    private val itemName: String,
    private val brandName: String
) : BindableItem<FavoriteNewItemItemCellBinding>() {
    override fun bind(viewBinding: FavoriteNewItemItemCellBinding, position: Int) {
        viewBinding.itemNameTv.text = itemName
        viewBinding.brandTv.text = brandName
    }

    override fun getLayout() = R.layout.favorite_new_item_item_cell

    override fun initializeViewBinding(view: View): FavoriteNewItemItemCellBinding {
        return FavoriteNewItemItemCellBinding.bind(view)
    }
}