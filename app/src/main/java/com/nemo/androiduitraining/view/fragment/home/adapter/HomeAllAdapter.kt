package com.nemo.androiduitraining.view.fragment.home.adapter

import androidx.viewbinding.ViewBinding
import com.nemo.androiduitraining.view.fragment.home.HomePromotion
import com.nemo.androiduitraining.view.fragment.home.viewModel.HomeAllViewModel
import com.nemo.androiduitraining.view.fragment.home.SwitchTabItem
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.viewbinding.BindableItem

class HomeAllAdapter : GroupAdapter<GroupieViewHolder>() {
    fun update(
        renderData: HomeAllViewModel.RenderData,
        listener: SwitchTabItem.OnClickListener,
        homePromotionPageAdapter: HomePromotionPageAdapter,
        homePromotionListener: HomePromotion.HomePromotionListener
    ) {
        val group = mutableListOf<BindableItem<out ViewBinding>>()
        group.add(SwitchTabItem(renderData.selectedGender, listener))
        group.add(HomePromotion(homePromotionPageAdapter, renderData.promotionList, renderData.promotionIndex, homePromotionListener))

        updateAsync(group)
    }
}
