package com.nemo.androiduitraining.view.fragment.favorite.uiModel.item

import android.view.View
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FavoriteItemDescriptionBinding
import com.nemo.androiduitraining.viewModel.favorite.FavoriteItemViewModel
import com.xwray.groupie.Item
import com.xwray.groupie.viewbinding.BindableItem

data class FavoriteItemDescriptionViewModel(
    val id: String,
    val displayData: FavoriteItemViewModel.DisplayClothsData
)

class FavoriteItemDescription(
    val model: FavoriteItemDescriptionViewModel
) : BindableItem<FavoriteItemDescriptionBinding>(), HasSpanSizeItem {
    override val spanSize = 1
    override fun bind(viewBinding: FavoriteItemDescriptionBinding, position: Int) {
        viewBinding.displayClothsData = model.displayData
    }

    override fun getLayout() = R.layout.favorite_item_description

    override fun initializeViewBinding(view: View): FavoriteItemDescriptionBinding {
        return FavoriteItemDescriptionBinding.bind(view)
    }

    override fun isSameAs(other: Item<*>): Boolean {
        return (other as? FavoriteItemDescription)?.model == this.model
    }

    override fun hasSameContentAs(other: Item<*>): Boolean {
        return (other as? FavoriteItemDescription)?.model?.id == this.model.id
    }
}
