package com.nemo.androiduitraining.view.fragment.favorite.entity.item

import android.view.View
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FavoriteItemNowPopularBinding

class FavoriteItemNowPopular : FavoriteItemModel<FavoriteItemNowPopularBinding>() {
    override val spanSize = 3
    override fun bind(viewBinding: FavoriteItemNowPopularBinding, position: Int) {

    }

    override fun getLayout() = R.layout.favorite_item_now_popular

    override fun initializeViewBinding(view: View): FavoriteItemNowPopularBinding {
        return FavoriteItemNowPopularBinding.bind(view)
    }
}