package com.nemo.androiduitraining.view.fragment.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject
import kotlin.math.log

@HiltViewModel
class HomeAllViewModel @Inject constructor() : ViewModel(), SwitchTabItem.OnClickListener {
    val renderData = MutableLiveData<RenderData>(RenderData(Gender.KIDS))
    data class RenderData(val selectedGender: Gender)

    override fun onGenderClick(gender: Gender) {
        renderData.value = renderData.value?.copy(selectedGender = gender)
    }
}


enum class Gender {
    MAN,
    WOMAN,
    KIDS
}
