package com.nemo.androiduitraining.viewModel.ranking

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nemo.androiduitraining.view.fragment.ranking.RankingItem
import com.xwray.groupie.Group
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RankingDetailViewModel @Inject constructor(): ViewModel() {
    val items: MutableLiveData<List<Group>> = MutableLiveData()

    fun getRankingItems() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val rankingImageItems = RankingItem()
                items.postValue(
                    listOf(
                        rankingImageItems,
                        rankingImageItems,
                        rankingImageItems,
                        rankingImageItems,
                        rankingImageItems,
                        rankingImageItems,
                        rankingImageItems,
                        rankingImageItems,
                        rankingImageItems,
                        rankingImageItems,
                        rankingImageItems
                    )
                )
            } catch (e: Exception) {
                Log.d("ranking_detail_view_model", "${e}")
            }
        }
    }
}
