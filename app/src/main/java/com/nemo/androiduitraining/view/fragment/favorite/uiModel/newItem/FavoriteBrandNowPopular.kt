package com.nemo.androiduitraining.view.fragment.favorite.entity

import android.view.View
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FavoriteBrandItemCellBinding
import com.nemo.androiduitraining.databinding.FavoriteBrandNowPopularBinding
import com.xwray.groupie.viewbinding.BindableItem

class FavoriteBrandNowPopular : BindableItem<FavoriteBrandNowPopularBinding>() {
    override fun bind(viewBinding: FavoriteBrandNowPopularBinding, position: Int) {

    }

    override fun getLayout() = R.layout.favorite_brand_now_popular

    override fun initializeViewBinding(view: View): FavoriteBrandNowPopularBinding {
        return FavoriteBrandNowPopularBinding.bind(view)
    }
}