package com.nemo.androiduitraining.view.fragment.home.adapter

import com.nemo.androiduitraining.entity.Promotion
import com.nemo.androiduitraining.view.fragment.home.HomePromotionItem
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder

class HomePromotionPageAdapter : GroupAdapter<GroupieViewHolder>() {
    fun update(promotionList: List<Promotion>) {
        val group = promotionList.map { HomePromotionItem(it) }
        updateAsync(group)
    }
}
