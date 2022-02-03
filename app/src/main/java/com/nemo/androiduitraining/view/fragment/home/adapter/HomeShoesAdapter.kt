package com.nemo.androiduitraining.view.fragment.home.adapter

import androidx.viewbinding.ViewBinding
import com.nemo.androiduitraining.view.fragment.home.viewModel.HomeShoesViewModel
import com.nemo.androiduitraining.view.fragment.home.SwitchTabItem
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.viewbinding.BindableItem

class HomeShoesAdapter : GroupAdapter<GroupieViewHolder>() {
    fun update(renderData: HomeShoesViewModel.RenderData, listener: SwitchTabItem.OnClickListener) {
        val group = mutableListOf<BindableItem<out ViewBinding>>()
        group.add(SwitchTabItem(renderData.selectedGender, listener))

        updateAsync(group)
    }
}
