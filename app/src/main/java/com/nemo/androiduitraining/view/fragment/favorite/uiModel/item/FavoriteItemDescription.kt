package com.nemo.androiduitraining.view.fragment.favorite.uiModel.item

import android.view.View
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FavoriteItemDescriptionBinding
import com.nemo.androiduitraining.viewModel.favorite.FavoriteItemViewModel
import com.xwray.groupie.Item
import com.xwray.groupie.viewbinding.BindableItem

class FavoriteItemDescription(
    val displayData: FavoriteItemViewModel.DisplayClothsData
) : BindableItem<FavoriteItemDescriptionBinding>(), HasSpanSizeItem {
    override val spanSize = 1
    override fun bind(viewBinding: FavoriteItemDescriptionBinding, position: Int) {
        viewBinding.displayClothsData = displayData
    }

    override fun getLayout() = R.layout.favorite_item_description

    override fun initializeViewBinding(view: View): FavoriteItemDescriptionBinding {
        return FavoriteItemDescriptionBinding.bind(view)
    }

    override fun isSameAs(other: Item<*>): Boolean {
        return (other as? FavoriteItemDescription)?.displayData == this.displayData
    }

    override fun hasSameContentAs(other: Item<*>): Boolean {
        return (other as? FavoriteItemDescription)?.displayData?.id == this.displayData.id
    }
}
