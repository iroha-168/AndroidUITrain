package com.nemo.androiduitraining.view.fragment.home.adapter

import com.nemo.androiduitraining.view.fragment.home.HomePromotionItem
import com.nemo.androiduitraining.view.fragment.home.Promotion
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder

class HomePromotionPageAdapter : GroupAdapter<GroupieViewHolder>() {
    fun update(promotionList: List<Promotion>) {
        val group = promotionList.map { HomePromotionItem(it) }
        update(group)
    }
}
