package com.nemo.androiduitraining.view.fragment.favorite.uiModel.newItem

import android.view.View
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FavoriteNewItemItemCellBinding
import com.xwray.groupie.viewbinding.BindableItem

class FavoriteNewItemCell(
    private val brandName: String,
    private val brandNameJapanese: String
) : BindableItem<FavoriteNewItemItemCellBinding>() {
    override fun bind(viewBinding: FavoriteNewItemItemCellBinding, position: Int) {
        viewBinding.itemNameTv.text = brandName
        viewBinding.brandTv.text = brandNameJapanese
    }

    override fun getLayout() = R.layout.favorite_new_item_item_cell

    override fun initializeViewBinding(view: View): FavoriteNewItemItemCellBinding {
        return FavoriteNewItemItemCellBinding.bind(view)
    }
}
