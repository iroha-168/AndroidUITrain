package com.nemo.androiduitraining.view.fragment.home.adapter

import androidx.viewbinding.ViewBinding
import com.nemo.androiduitraining.view.fragment.home.SwitchTabItem
import com.nemo.androiduitraining.view.fragment.home.viewModel.HomeCosmeViewModel
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.viewbinding.BindableItem

class HomeCosmeAdapter : GroupAdapter<GroupieViewHolder>() {
    fun update(renderData: HomeCosmeViewModel.RenderData, listener: SwitchTabItem.OnClickListener) {
        val group = mutableListOf<BindableItem<out ViewBinding>>()
        group.add(SwitchTabItem(renderData.selectedGender, listener))

        updateAsync(group)
    }
}

