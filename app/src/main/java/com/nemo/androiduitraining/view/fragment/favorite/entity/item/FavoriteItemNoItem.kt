package com.nemo.androiduitraining.view.fragment.favorite.entity.item

import android.view.View
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FavoriteItemNoItemRegisteredBinding
import com.xwray.groupie.viewbinding.BindableItem

class FavoriteItemNoItem : BindableItem<FavoriteItemNoItemRegisteredBinding>(), SpanSizeInterface {
    override val spanSize = 3
    override fun bind(viewBinding: FavoriteItemNoItemRegisteredBinding, position: Int) {

    }

    override fun getLayout() = R.layout.favorite_item_no_item_registered

    override fun initializeViewBinding(view: View): FavoriteItemNoItemRegisteredBinding {
        return FavoriteItemNoItemRegisteredBinding.bind(view)
    }
}