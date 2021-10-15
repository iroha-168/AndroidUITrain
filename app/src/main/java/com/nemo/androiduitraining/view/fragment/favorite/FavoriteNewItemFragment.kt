package com.nemo.androiduitraining.view.fragment.favorite

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FragmentFavoriteNewItemBinding
import com.nemo.androiduitraining.view.fragment.favorite.entity.FavoriteItemCell
import com.nemo.androiduitraining.view.fragment.favorite.entity.FavoriteNoBrandRegistered
import com.nemo.androiduitraining.view.fragment.favorite.entity.FavoriteNowPopular
import com.xwray.groupie.GroupieAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteNewItemFragment : Fragment(R.layout.fragment_favorite_new_item) {
    companion object {
        fun newInstance() = FavoriteNewItemFragment()
    }

    private var _binding: FragmentFavoriteNewItemBinding? = null
    private val binding: FragmentFavoriteNewItemBinding
        get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFavoriteNewItemBinding.bind(view)

        val adapter = GroupieCustomAdapter()
        setupRecycler(adapter)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupRecycler(adapter: GroupieCustomAdapter) {
        val layoutManager = LinearLayoutManager(requireContext())

        binding.favoriteNewItemRecycler.also {
            it.layoutManager = layoutManager
            it.addItemDecoration(createRecyclerDiver(layoutManager))
            it.adapter = adapter
        }

        adapter.updateList()
    }

    private fun createRecyclerDiver(layoutManager: LinearLayoutManager): DividerItemDecoration {
        val dividerDrawable = ContextCompat.getDrawable(requireContext(), R.drawable.fragment_favorite_new_item_divider)
        return DividerItemDecoration(requireContext(), layoutManager.orientation).apply {
            if (dividerDrawable != null) {
                this.setDrawable(dividerDrawable)
            }
        }
    }

    private class GroupieCustomAdapter : GroupieAdapter() {
        private val defaultViewList = mutableListOf(
            FavoriteNoBrandRegistered(),
            FavoriteNowPopular()
        )

        private fun createItemCells() {
            for (i in 0..29) {
                defaultViewList.add(
                    FavoriteItemCell("ほげほげ", "ふがふが")
                )
            }
        }

        fun updateList() {
            createItemCells()
            update(defaultViewList)
        }
    }
}