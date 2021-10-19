package com.nemo.androiduitraining.view.fragment.favorite.entity.item

import android.view.View
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FavoriteItemNowPopularBinding
import com.xwray.groupie.Item
import com.xwray.groupie.viewbinding.BindableItem

class FavoriteItemNowPopular : BindableItem<FavoriteItemNowPopularBinding>(), HasSpanSizeItem {
    override val spanSize = 3
    override fun bind(viewBinding: FavoriteItemNowPopularBinding, position: Int) {

    }

    override fun getLayout() = R.layout.favorite_item_now_popular

    override fun initializeViewBinding(view: View): FavoriteItemNowPopularBinding {
        return FavoriteItemNowPopularBinding.bind(view)
    }

    override fun isSameAs(other: Item<*>): Boolean {
        return other is FavoriteItemNowPopular
    }

    override fun hasSameContentAs(other: Item<*>): Boolean {
        return isSameAs(other)
    }
}
