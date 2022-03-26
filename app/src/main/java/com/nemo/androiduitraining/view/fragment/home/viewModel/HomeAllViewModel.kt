package com.nemo.androiduitraining.view.fragment.home.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nemo.androiduitraining.view.fragment.home.Gender
import com.nemo.androiduitraining.view.fragment.home.HomePromotionListener
import com.nemo.androiduitraining.view.fragment.home.Promotion
import com.nemo.androiduitraining.view.fragment.home.SwitchTabItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeAllViewModel @Inject constructor() : ViewModel(), SwitchTabItem.OnClickListener, HomePromotionListener {
    val renderData = MutableLiveData<RenderData>(RenderData(Gender.MAN, generatePromotionList()))
    data class RenderData(
        val selectedGender: Gender,
        val promotionList: List<Promotion>,
        val promotionIndex: Int = 0,
    )

    fun autoSwipeViewPager() {
        viewModelScope.launch {
            while (true) {
                delay(5000)
                if (renderData.value?.promotionList?.lastIndex != renderData.value?.promotionIndex) {
                    renderData.value = renderData.value?.copy(
                        promotionIndex = (renderData.value?.promotionIndex ?: 0) + 1
                    )
                } else {
                    renderData.value = renderData.value?.copy(promotionIndex = 0)
                }
            }
        }
    }

    private fun generatePromotionList(): List<Promotion> {
        return listOf(
            Promotion(
                1,
                "https://media.wwdjapan.com/wp-content/uploads/2018/09/10101619/180910_parco_01.jpg",
                "私は裸になれない。",
                "みんなそうやろ。"
            ),
            Promotion(
                2,
                "https://m-78.jp/wp-content/uploads/2015/08/amu-02-660x466.jpg",
                "AMU EST",
                "ﾈｺﾁｬｶﾜｲﾚﾁｭﾈﾖﾁﾖﾁﾖﾁﾖﾁ"
            ),
            Promotion(
                3,
                "https://s3-ap-northeast-1.amazonaws.com/statics.pen-online.jp/image/upload/creator/jil-sander-19-aw/jil-sander-19-aw_N0lDkYA.jpg",
                "JIL SANDER",
                "裸アウターで屋上ぼっちはさすがに寒いで"
            )
        )
    }

    override fun onGenderClick(gender: Gender) {
        renderData.value = renderData.value?.copy(selectedGender = gender)
    }

    override fun onTabSelected(index: Int) {
        renderData.value = renderData.value?.copy(promotionIndex = index)
    }
}
