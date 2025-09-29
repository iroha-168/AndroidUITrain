package com.nemo.androiduitraining.view.fragment.home

import android.view.View
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.HomePromotionItemBinding
import com.xwray.groupie.Item
import com.xwray.groupie.viewbinding.BindableItem

class HomePromotionItem(
    private val promotion: Promotion,
) : BindableItem<HomePromotionItemBinding>() {
    override fun bind(viewBinding: HomePromotionItemBinding, position: Int) {
        viewBinding.promotion = promotion
        viewBinding.executePendingBindings()
    }

    override fun getLayout(): Int = R.layout.home_promotion_item

    override fun isSameAs(other: Item<*>): Boolean = (other as? HomePromotionItem)?.promotion == promotion

    override fun hasSameContentAs(other: Item<*>): Boolean = (other as? HomePromotionItem)?.promotion?.id == promotion.id

    override fun initializeViewBinding(view: View): HomePromotionItemBinding = HomePromotionItemBinding.bind(view)
}
