package com.nemo.androiduitraining.view.fragment.home

import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.PromotionViewPagerBinding
import com.nemo.androiduitraining.entity.Promotion
import com.nemo.androiduitraining.view.fragment.home.adapter.HomePromotionPageAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.viewbinding.BindableItem

class HomePromotion(
    private val homePromotionPageAdapter: HomePromotionPageAdapter,
    private val promotionList: List<Promotion>,
    private val promotionIndex: Int,
    private val homePromotionListener: HomePromotionListener
) : BindableItem<PromotionViewPagerBinding>() {
    override fun bind(viewBinding: PromotionViewPagerBinding, position: Int) {
        viewBinding.promotionViewPager.adapter = homePromotionPageAdapter
        viewBinding.promotionViewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        viewBinding.promotionViewPager.setCurrentItem(promotionIndex, true)
        viewBinding.promotionTabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    homePromotionListener.onTabSelected(it.position)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // do nothing
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // do nothing
            }
        })
        homePromotionPageAdapter.update(promotionList)
        TabLayoutMediator(
            viewBinding.promotionTabLayout,
            viewBinding.promotionViewPager,
            false,
            true
        ) { _, _ -> }.attach()
        viewBinding.executePendingBindings()
    }

    override fun getLayout(): Int = R.layout.promotion_view_pager

    override fun initializeViewBinding(view: View): PromotionViewPagerBinding =
        PromotionViewPagerBinding.bind(view)

    override fun hasSameContentAs(other: Item<*>): Boolean =
        (other as? HomePromotion)?.promotionList == promotionList
            && (other as? HomePromotion)?.promotionIndex == promotionIndex

    override fun isSameAs(other: Item<*>): Boolean = other is HomePromotion


    interface HomePromotionListener {
        fun onTabSelected(index:Int)
    }
}
