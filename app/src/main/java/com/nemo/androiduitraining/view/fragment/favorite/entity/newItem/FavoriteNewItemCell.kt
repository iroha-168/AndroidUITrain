package com.nemo.androiduitraining.view.fragment.favorite.entity.newItem

import android.content.res.Resources
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FavoriteNewItemItemCellBinding
import com.xwray.groupie.viewbinding.BindableItem

class FavoriteNewItemCell(
    private val brandName: String,
    private val brandNameJapanese: String,
    private val res: Resources
) : BindableItem<FavoriteNewItemItemCellBinding>() {
    override fun bind(viewBinding: FavoriteNewItemItemCellBinding, position: Int) {
        viewBinding.itemNameTv.text = brandName
        viewBinding.brandTv.text = brandNameJapanese

        val layoutParams = ViewGroup.MarginLayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
            this.marginStart = res.getDimension(R.dimen.side_margin_16).toInt()
            this.marginEnd = res.getDimension(R.dimen.side_margin_16).toInt()
        }
        viewBinding.root.layoutParams = layoutParams
    }

    override fun getLayout() = R.layout.favorite_new_item_item_cell

    override fun initializeViewBinding(view: View): FavoriteNewItemItemCellBinding {
        return FavoriteNewItemItemCellBinding.bind(view)
    }
}