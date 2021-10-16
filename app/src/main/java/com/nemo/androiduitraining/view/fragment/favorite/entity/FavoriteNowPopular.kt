package com.nemo.androiduitraining.view.fragment.favorite.entity

import android.view.View
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FavoriteNewItemNowPopularBinding
import com.xwray.groupie.viewbinding.BindableItem

class FavoriteNowPopular : BindableItem<FavoriteNewItemNowPopularBinding>() {
    override fun bind(viewBinding: FavoriteNewItemNowPopularBinding, position: Int) {

    }

    override fun getLayout() = R.layout.favorite_new_item_now_popular

    override fun initializeViewBinding(view: View): FavoriteNewItemNowPopularBinding {
        return FavoriteNewItemNowPopularBinding.bind(view)
    }
}