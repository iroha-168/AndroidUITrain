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
        viewBinding.clothsNameTv.text = displayData.itemName
        viewBinding.clothsGenreTv.text = displayData.itemGenre
        viewBinding.clothsPriceTv.text = displayData.itemPrice.toString()

        viewBinding.mainImage.load(displayData.itemImage) {
            this.error(R.drawable.ic_android_black_24dp)
        }

        when (val percent = displayData.discountPercent) {
            null -> viewBinding.discountPercentTv.visibility = View.GONE
            else -> {
                viewBinding.discountPercentTv.visibility = View.VISIBLE
                viewBinding.discountPercentTv.text = percent.toString()
            }
        }

        when (val price = displayData.couponPrice) {
            null -> viewBinding.couponPriceTv.visibility = View.GONE
            else -> {
                viewBinding.couponPriceTv.visibility = View.VISIBLE
                viewBinding.couponPriceTv.text = price.toString()
            }
        }
    }

    override fun getLayout() = R.layout.favorite_item_description

    override fun initializeViewBinding(view: View): FavoriteItemDescriptionBinding {
        return FavoriteItemDescriptionBinding.bind(view)
    }
}