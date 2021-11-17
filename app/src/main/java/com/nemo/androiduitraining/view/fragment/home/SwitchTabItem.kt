package com.nemo.androiduitraining.view.fragment.home

import android.view.View
import androidx.databinding.BindingAdapter
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.PersonSwitchTabBinding
import com.xwray.groupie.Item
import com.xwray.groupie.viewbinding.BindableItem

class SwitchTabItem(private val selectedGender: Gender, private val listener: OnClickListener) : BindableItem<PersonSwitchTabBinding>() {
    override fun bind(viewBinding: PersonSwitchTabBinding, position: Int) {
        viewBinding.listener = listener
        viewBinding.selectedGender = selectedGender
        viewBinding.executePendingBindings()

    }

    override fun getLayout(): Int = R.layout.person_switch_tab

    override fun initializeViewBinding(view: View): PersonSwitchTabBinding = PersonSwitchTabBinding.bind(view)
    override fun isSameAs(other: Item<*>): Boolean = other is SwitchTabItem
    override fun hasSameContentAs(other: Item<*>): Boolean = (other as? SwitchTabItem)?.selectedGender == selectedGender

    interface OnClickListener {
        fun onGenderClick(gender: Gender)
    }
}

