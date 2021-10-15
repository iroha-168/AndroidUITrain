package com.nemo.androiduitraining.view.fragment.favorite

import android.content.res.Resources
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewbinding.ViewBinding
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FragmentFavoriteItemBinding
import com.nemo.androiduitraining.view.fragment.favorite.entity.*
import com.nemo.androiduitraining.viewModel.favorite.FavoriteItemViewModel
import com.xwray.groupie.GroupieAdapter
import com.xwray.groupie.viewbinding.BindableItem
import dagger.hilt.android.AndroidEntryPoint
import java.lang.IllegalArgumentException

@AndroidEntryPoint
class FavoriteItemFragment : Fragment(R.layout.fragment_favorite_item) {
    companion object {
        fun newInstance() = FavoriteItemFragment()
    }

    private val viewModel: FavoriteItemViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentFavoriteItemBinding.bind(view)
        fetchClothsAndSetupRecycler(binding)
    }

    private fun fetchClothsAndSetupRecycler(binding: FragmentFavoriteItemBinding) {
        viewModel.clothsLD.observe(viewLifecycleOwner) {
            setupRecycler(binding, it)
        }
        viewModel.fetchDisplayClothsList()
    }

    private fun setupRecycler(binding: FragmentFavoriteItemBinding, itemList: List<FavoriteItemViewModel.DisplayClothsData>) {
        val adapter = CustomGroupieAdapter(itemList).also {
            it.updateList()
        }
        val gridLayoutManager = GridLayoutManager(requireContext(), 3).also {
            it.spanSizeLookup = CustomGridSpanSizeLookup(adapter.itemList, resources)
        }

        binding.favoriteItemRecycler.also {
            it.adapter = adapter
            it.layoutManager = gridLayoutManager
        }
    }

    private class CustomGroupieAdapter(
        private val displayDataList: List<FavoriteItemViewModel.DisplayClothsData>
    ) : GroupieAdapter() {
        private val _itemList: MutableList<BindableItem<out ViewBinding>> = mutableListOf()
        val itemList: List<BindableItem<out ViewBinding>>
            get() = _itemList

        private fun createItemCells() {
            _itemList.add(FavoriteNoItemRegistered())
            _itemList.add(FavoriteNowPopularItem())

            displayDataList.forEach {
                _itemList.add(FavoriteItemDescription(it))
            }
        }

        fun updateList() {
            createItemCells()
            update(_itemList)
        }
    }

    private class CustomGridSpanSizeLookup(
        private val nowItemList: List<BindableItem<out ViewBinding>>,
        private val res: Resources
    ) : GridLayoutManager.SpanSizeLookup() {
        override fun getSpanSize(position: Int): Int {
            return when (nowItemList[position]) {
                is FavoriteNoItemRegistered -> 3
                is FavoriteNowPopularItem -> 3
                is FavoriteItemDescription -> 1
                else -> throw IllegalArgumentException(res.getString(R.string.illegal_class))
            }
        }
    }
}