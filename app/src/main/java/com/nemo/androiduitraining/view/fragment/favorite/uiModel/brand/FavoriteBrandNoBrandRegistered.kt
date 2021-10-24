package com.nemo.androiduitraining.view.fragment.favorite.uiModel.brand

import android.view.View
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FavoriteBrandNoBrandRegisteredBinding
import com.xwray.groupie.viewbinding.BindableItem

class FavoriteBrandNoBrandRegistered : BindableItem<FavoriteBrandNoBrandRegisteredBinding>() {
    override fun bind(viewBinding: FavoriteBrandNoBrandRegisteredBinding, position: Int) {

    }

    override fun getLayout() = R.layout.favorite_brand_no_brand_registered

    override fun initializeViewBinding(view: View): FavoriteBrandNoBrandRegisteredBinding {
        return FavoriteBrandNoBrandRegisteredBinding.bind(view)
    }
}
