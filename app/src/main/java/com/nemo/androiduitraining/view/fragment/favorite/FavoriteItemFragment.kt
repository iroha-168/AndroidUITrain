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
import com.nemo.androiduitraining.view.fragment.favorite.entity.FavoriteItemDescription
import com.nemo.androiduitraining.view.fragment.favorite.entity.item.FavoriteItemNoItem
import com.nemo.androiduitraining.view.fragment.favorite.entity.item.FavoriteItemNowPopular
import com.nemo.androiduitraining.viewModel.favorite.FavoriteItemViewModel
import com.xwray.groupie.GroupieAdapter
import com.xwray.groupie.viewbinding.BindableItem
import dagger.hilt.android.AndroidEntryPoint

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
        val spanSize = DisplayItemKind.values().maxOf { it.spanSize }
        val gridLayoutManager = GridLayoutManager(requireContext(), spanSize).also {
            it.spanSizeLookup = CustomGridSpanSizeLookup(adapter, resources)
        }
        binding.favoriteItemRecycler.layoutManager = gridLayoutManager
        binding.favoriteItemRecycler.adapter = adapter
    }

    private class CustomGroupieAdapter : GroupieAdapter() {
        private var _itemList: List<BindableItem<out ViewBinding>> = makeDefaultList()
        val itemList: List<BindableItem<out ViewBinding>>
            get() = _itemList

        private fun makeDefaultList() = listOf(
            FavoriteItemNoItem(),
            FavoriteItemNowPopular()
        )

        fun updateList(newItemList: List<FavoriteItemViewModel.DisplayClothsData>) {
            _itemList = makeDefaultList() + newItemList.map {
                FavoriteItemDescription(displayData = it)
            }
            update(_itemList)
        }
    }

    private class CustomGridSpanSizeLookup(
        private val adapter: CustomGroupieAdapter,
        private val res: Resources
    ) : GridLayoutManager.SpanSizeLookup() {
        override fun getSpanSize(position: Int): Int {
            return when (adapter.itemList[position]) {
                is FavoriteItemNoItem -> DisplayItemKind.NO_ITEM.spanSize
                is FavoriteItemNowPopular -> DisplayItemKind.POPULAR.spanSize
                is FavoriteItemDescription -> DisplayItemKind.DESCRIPTION.spanSize
                else -> throw IllegalArgumentException(res.getString(R.string.illegal_class))
            }
        }
    }

    private enum class DisplayItemKind(val spanSize: Int) {
        NO_ITEM(3), POPULAR(3), DESCRIPTION(1)
    }
}