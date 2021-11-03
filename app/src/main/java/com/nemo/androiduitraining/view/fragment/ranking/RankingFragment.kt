package com.nemo.androiduitraining.view.fragment.ranking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FragmentRankingBinding
import com.nemo.androiduitraining.view.util.Constant.COUNT_SECOND
import com.nemo.androiduitraining.view.util.Constant.POSITION_FIRST
import com.nemo.androiduitraining.view.util.Constant.POSITION_ZERO
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RankingFragment : Fragment() {

    private lateinit var binding: FragmentRankingBinding
    private val indexItems = listOf(IndexItem.FistItem, IndexItem.FistItem)

    private sealed class IndexItem {
        abstract fun newInstance(): Fragment

        object FistItem : IndexItem() {
            override fun newInstance() = RankingGenderFragment()
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRankingBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            rankingViewPager.adapter = object : FragmentStateAdapter(this@RankingFragment) {
                override fun getItemCount(): Int = COUNT_SECOND
                override fun createFragment(position: Int): Fragment {
                    return indexItems[position].newInstance()
                }
            }
            TabLayoutMediator(rankingTabLayout, rankingViewPager) {
                tab, position ->
                tab.text = when (position) {
                    POSITION_ZERO -> getString(R.string.accessory)
                    POSITION_FIRST -> getString(R.string.under_wear)
                    else -> ""
                }
            }.attach()
        }
    }
}
