package com.nemo.androiduitraining.view.fragment.home

import android.view.View
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.PersonSwitchTabBinding
import com.xwray.groupie.viewbinding.BindableItem

class SwitchTabItem(private val selectedGender: Gender, private val listener: OnClickListener) : BindableItem<PersonSwitchTabBinding>() {
    override fun bind(viewBinding: PersonSwitchTabBinding, position: Int) {
        viewBinding.listener = listener
        viewBinding.executePendingBindings()

    }

    override fun getLayout(): Int = R.layout.person_switch_tab

    override fun initializeViewBinding(view: View): PersonSwitchTabBinding = PersonSwitchTabBinding.bind(view)

    interface OnClickListener {
        fun onGenderClick(gender: Gender)
    }
}
