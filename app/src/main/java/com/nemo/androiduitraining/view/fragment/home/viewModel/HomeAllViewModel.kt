package com.nemo.androiduitraining.view.fragment.home.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nemo.androiduitraining.entity.Promotion
import com.nemo.androiduitraining.view.fragment.home.Gender
import com.nemo.androiduitraining.view.fragment.home.HomePromotion
import com.nemo.androiduitraining.view.fragment.home.SwitchTabItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeAllViewModel @Inject constructor() : ViewModel(), SwitchTabItem.OnClickListener, HomePromotion.HomePromotionListener {
    val renderData = MutableLiveData<RenderData>(RenderData(Gender.MAN, generatePromotionList()))

    fun init() {
        viewModelScope.launch {
            while (true) {
                delay(5000)
                if (renderData.value?.promotionList?.lastIndex != renderData.value?.promotionIndex) {
                    renderData.value = renderData.value?.copy(promotionIndex = (renderData.value?.promotionIndex ?: 0) + 1)
                } else {
                    renderData.value = renderData.value?.copy(promotionIndex = 0)
                }
            }
        }
    }

    override fun onGenderClick(gender: Gender) {
        renderData.value = renderData.value?.copy(selectedGender = gender)
    }

    override fun onTabSelected(index: Int) {
        renderData.value = renderData.value?.copy(promotionIndex = index)
    }

    private fun generatePromotionList(): List<Promotion> {
        return listOf(
            Promotion(
                1,
                "https://media.wwdjapan.com/wp-content/uploads/2018/09/10101622/180910_parco_03.jpg",
                "私は裸になれない",
                "みんなそうやろ"
            ),
            Promotion(
                2,
                "https://former-cdn.cinra.net/uploads/img/review/20150819-mmparis_l_full.jpg",
                "PARCO",
                "赤が好き"
            ),
            Promotion(
                3,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcROnxVWTzMgK_8Ck7WQyT4c_rxrzYj9tm1xBw&usqp=CAU",
                "DIOR",
                "黒が好き"
            )
        )
    }

    data class RenderData(
        val selectedGender: Gender,
        val promotionList: List<Promotion>,
        val promotionIndex: Int = 0
    )
}
