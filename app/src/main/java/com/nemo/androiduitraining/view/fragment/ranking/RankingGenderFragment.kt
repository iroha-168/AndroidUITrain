package com.nemo.androiduitraining.view.fragment.ranking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.nemo.androiduitraining.databinding.FragmentRankingCategoryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RankingGenderFragment: Fragment() {
    private lateinit var binding: FragmentRankingCategoryBinding

    private sealed class IndexItem {
        abstract fun newInstance(): Fragment

        object FistItem: IndexItem() {
            override fun newInstance() = RankingDetailFragment()
        }
    }

    private val indexItems = listOf(IndexItem.FistItem, IndexItem.FistItem, IndexItem.FistItem)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRankingCategoryBinding.inflate(inflater, container, false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            rankingDetailViewPager.adapter = object : FragmentStateAdapter(this@RankingGenderFragment) {
                override fun getItemCount(): Int = 3
                override fun createFragment(position: Int): Fragment {
                    return indexItems[position].newInstance()
                }
            }
            rankingDetailViewPager.isUserInputEnabled = false
            TabLayoutMediator(rankingDetailTabLayout, rankingDetailViewPager) {
                tab, position ->
                tab.text = when(position) {
                    0 -> {
                        "メンズ"
                    }
                    1 -> {
                        "レディース"
                    }
                    2 -> {
                        "キッズ"
                    }
                    else -> ""
                }
            }.attach()
        }
    }
}
