package com.nemo.androiduitraining.view.fragment.home.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nemo.androiduitraining.view.fragment.home.Gender
import com.nemo.androiduitraining.view.fragment.home.SwitchTabItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeShoesViewModel @Inject constructor() : ViewModel(), SwitchTabItem.OnClickListener {
    val renderData = MutableLiveData<RenderData>(RenderData(Gender.MAN))

    data class RenderData(val selectedGender: Gender)

    override fun onGenderClick(gender: Gender) {
        renderData.value = renderData.value?.copy(selectedGender = gender)
    }
}


