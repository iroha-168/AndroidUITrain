package com.nemo.androiduitraining.view.fragment.favorite

import android.content.res.Resources
import android.os.Bundle
import android.util.Log
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
import timber.log.Timber
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

        val adapter = CustomGroupieAdapter()
        fetchClothsAndUpdateList(binding, adapter)
        setupRecycler(binding, adapter)
    }

    private fun fetchClothsAndUpdateList(binding: FragmentFavoriteItemBinding, adapter: CustomGroupieAdapter) {
        viewModel.clothsLD.observe(viewLifecycleOwner) { cloths ->
            if (cloths.isEmpty()) return@observe

            adapter.updateList(cloths)

            val spanSize = DisplayItemKind.values().maxOf { it.spanSize }
            val gridLayoutManager = GridLayoutManager(requireContext(), spanSize).also {
                it.spanSizeLookup = CustomGridSpanSizeLookup(adapter.itemList, resources)
            }

            binding.favoriteItemRecycler.layoutManager = gridLayoutManager

        }
        viewModel.fetchDisplayClothsList()
    }

    private fun setupRecycler(
        binding: FragmentFavoriteItemBinding,
        adapter: CustomGroupieAdapter
    ) {
        binding.favoriteItemRecycler.adapter = adapter
    }

    private class CustomGroupieAdapter : GroupieAdapter() {
        private var _itemList: List<BindableItem<out ViewBinding>> = listOf(
            FavoriteNoItemRegistered(),
            FavoriteNowPopularItem()
        )
        val itemList: List<BindableItem<out ViewBinding>>
            get() = _itemList

        fun updateList(newItemList: List<FavoriteItemViewModel.DisplayClothsData>) {
            _itemList = _itemList + newItemList.map {
                FavoriteItemDescription(displayData = it)
            }
            update(_itemList)
        }
    }

    private class CustomGridSpanSizeLookup(
        private val nowItemList: List<BindableItem<out ViewBinding>>,
        private val res: Resources
    ) : GridLayoutManager.SpanSizeLookup() {
        override fun getSpanSize(position: Int): Int {
            return when (nowItemList[position]) {
                is FavoriteNoItemRegistered -> DisplayItemKind.NO_ITEM.spanSize
                is FavoriteNowPopularItem -> DisplayItemKind.POPULAR.spanSize
                is FavoriteItemDescription -> DisplayItemKind.DESCRIPTION.spanSize
                else -> throw IllegalArgumentException(res.getString(R.string.illegal_class))
            }
        }
    }

    private enum class DisplayItemKind(val spanSize: Int) {
        NO_ITEM(3), POPULAR(3), DESCRIPTION(1)
    }
}