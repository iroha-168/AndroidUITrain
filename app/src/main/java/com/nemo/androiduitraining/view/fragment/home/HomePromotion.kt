package com.nemo.androiduitraining.view.fragment.home

import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.PromotionViewPagerBinding
import com.nemo.androiduitraining.entity.Promotion
import com.nemo.androiduitraining.view.fragment.home.adapter.HomePromotionPageAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.viewbinding.BindableItem

class HomePromotion(
    private val homePromotionPageAdapter: HomePromotionPageAdapter,
    private val promotionList: List<Promotion>
) :
    BindableItem<PromotionViewPagerBinding>() {
    override fun bind(viewBinding: PromotionViewPagerBinding, position: Int) {
        viewBinding.promotionViewPager.adapter = homePromotionPageAdapter
        viewBinding.promotionViewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }

    override fun getLayout(): Int = R.layout.promotion_view_pager

    override fun initializeViewBinding(view: View): PromotionViewPagerBinding =
        PromotionViewPagerBinding.bind(view)

    override fun hasSameContentAs(other: Item<*>): Boolean {
        return super.hasSameContentAs(other)
    }

    override fun isSameAs(other: Item<*>): Boolean {
        return super.isSameAs(other)
    }
}
