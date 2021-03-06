package com.nemo.androiduitraining.view.fragment.favorite

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewbinding.ViewBinding
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FragmentFavoriteItemBinding
import com.nemo.androiduitraining.view.fragment.favorite.uiModel.item.*
import com.nemo.androiduitraining.viewModel.favorite.FavoriteItemViewModel
import com.xwray.groupie.GroupieAdapter
import com.xwray.groupie.viewbinding.BindableItem
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class FavoriteItemFragment : Fragment(R.layout.fragment_favorite_item) {
    companion object {
        fun newInstance() = FavoriteItemFragment()
    }

    private val viewModel: FavoriteItemViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentFavoriteItemBinding.bind(view)

        val adapter = CustomGroupieAdapter()
        fetchClothsAndUpdateList(adapter)
        setupRecycler(binding, adapter)
    }

    private fun fetchClothsAndUpdateList(adapter: CustomGroupieAdapter) {
        viewModel.clothsLD.observe(viewLifecycleOwner) { cloths ->
            adapter.updateList(cloths)
        }
        viewModel.fetchDisplayClothsList()
    }

    private fun setupRecycler(
        binding: FragmentFavoriteItemBinding,
        adapter: CustomGroupieAdapter
    ) {
        val spanSize = adapter.itemList.maxOf { item -> (item as HasSpanSizeItem).spanSize }
        val gridLayoutManager = GridLayoutManager(requireContext(), spanSize).also {
            it.spanSizeLookup = CustomGridSpanSizeLookup(adapter)
        }
        binding.favoriteItemRecycler.layoutManager = gridLayoutManager
        binding.favoriteItemRecycler.adapter = adapter
    }

    private class CustomGroupieAdapter : GroupieAdapter() {
        private var _itemList: List<BindableItem<out ViewBinding>> = makeDefaultList()
        val itemList: List<BindableItem<out ViewBinding>>
            get() = _itemList

        private fun makeDefaultList(): List<BindableItem<out ViewBinding>> = listOf(
            FavoriteItemNoItem(),
            FavoriteItemNowPopular()
        )

        fun updateList(newItems: List<FavoriteItemViewModel.DisplayClothsData>) {
            val newItemList: List<BindableItem<out ViewBinding>> = newItems.map {
                FavoriteItemDescription(displayData = it)
            }
            _itemList = makeDefaultList() + newItemList
            updateAsync(_itemList)
        }
    }

    private class CustomGridSpanSizeLookup(
        private val adapter: CustomGroupieAdapter
    ) : GridLayoutManager.SpanSizeLookup() {
        override fun getSpanSize(position: Int) =
            (adapter.getItem(position) as? HasSpanSizeItem)?.spanSize ?: 0
    }
}
