package com.nemo.androiduitraining.view.fragment.ranking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nemo.androiduitraining.databinding.FragmentRankingDetailBinding
import com.nemo.androiduitraining.viewModel.ranking.RankingDetailViewModel
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RankingDetailFragment: Fragment() {
    private lateinit var binding: FragmentRankingDetailBinding
    private lateinit var viewModel: RankingDetailViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRankingDetailBinding.inflate(inflater, container, false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = RankingDetailViewModel()
        val groupAdapter = GroupAdapter<GroupieViewHolder>()
        binding.recyclerView.adapter = groupAdapter
        viewModel.items.observe(viewLifecycleOwner, {
            groupAdapter.clear()
            groupAdapter.addAll(it)
        })
        viewModel.getRankingItems()
    }
}
