package com.nemo.androiduitraining.view.fragment.home

import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.HomePromotionBinding
import com.nemo.androiduitraining.view.fragment.home.adapter.HomePromotionPageAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.viewbinding.BindableItem

interface HomePromotionListener {
    fun onTabSelected(index: Int)
}

class HomePromotion(
    private val adapter: HomePromotionPageAdapter,
    private val promotionIndex: Int,
    private val homePromotionListener: HomePromotionListener,
    private val promotionList: List<Promotion>,
) : BindableItem<HomePromotionBinding>() {
    override fun bind(viewBinding: HomePromotionBinding, position: Int) {
        viewBinding.promotionViewPager.adapter = adapter
        viewBinding.promotionViewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        viewBinding.promotionViewPager.setCurrentItem(promotionIndex, true)
        viewBinding.promotionTabLayout.addOnTabSelectedListener(object :
            TabLayout.OnTabSelectedListener {
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
        adapter.update(promotionList)
        TabLayoutMediator(
            viewBinding.promotionTabLayout,
            viewBinding.promotionViewPager,
            false,
            true
        ) { _, _ -> }.attach()
    }

    override fun getLayout(): Int = R.layout.home_promotion

    override fun initializeViewBinding(view: View): HomePromotionBinding =
        HomePromotionBinding.bind(view)

    override fun isSameAs(other: Item<*>): Boolean = other is HomePromotion

    override fun hasSameContentAs(other: Item<*>): Boolean =
        (other as? HomePromotion)?.promotionList == promotionList &&
            (other as? HomePromotion)?.promotionIndex == promotionIndex
}
