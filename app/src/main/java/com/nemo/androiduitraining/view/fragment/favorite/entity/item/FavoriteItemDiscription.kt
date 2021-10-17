package com.nemo.androiduitraining.view.fragment.favorite.entity.item

import android.view.View
import coil.load
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FavoriteItemDescriptionBinding
import com.nemo.androiduitraining.viewModel.favorite.FavoriteItemViewModel

class FavoriteItemDescription(
    private val displayData: FavoriteItemViewModel.DisplayClothsData
) : FavoriteItemModel<FavoriteItemDescriptionBinding>() {
    override val spanSize = 1
    override fun bind(viewBinding: FavoriteItemDescriptionBinding, position: Int) {
        viewBinding.displayClothsData = displayData
    }

    override fun getLayout() = R.layout.favorite_item_description

    override fun initializeViewBinding(view: View): FavoriteItemDescriptionBinding {
        return FavoriteItemDescriptionBinding.bind(view)
    }
}