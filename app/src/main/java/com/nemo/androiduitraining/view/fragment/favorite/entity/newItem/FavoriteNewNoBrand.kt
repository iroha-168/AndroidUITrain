package com.nemo.androiduitraining.view.fragment.favorite.entity.newItem

import android.view.View
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FavoriteNewItemNoBrandRegisteredBinding
import com.xwray.groupie.viewbinding.BindableItem

class FavoriteNewNoBrand : BindableItem<FavoriteNewItemNoBrandRegisteredBinding>() {
    override fun bind(viewBinding: FavoriteNewItemNoBrandRegisteredBinding, position: Int) {
    }

    override fun getLayout() = R.layout.favorite_new_item_no_brand_registered

    override fun initializeViewBinding(view: View): FavoriteNewItemNoBrandRegisteredBinding {
        return FavoriteNewItemNoBrandRegisteredBinding.bind(view)
    }
}
