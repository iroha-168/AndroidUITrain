package com.nemo.androiduitraining.view.fragment.favorite

import android.content.res.Resources
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewbinding.ViewBinding
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FragmentFavoriteItemBinding
import com.nemo.androiduitraining.view.fragment.favorite.entity.*
import com.xwray.groupie.GroupieAdapter
import com.xwray.groupie.viewbinding.BindableItem
import java.lang.IllegalArgumentException

class FavoriteItemFragment : Fragment(R.layout.fragment_favorite_item) {
    companion object {
        fun newInstance() = FavoriteItemFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentFavoriteItemBinding.bind(view)

        setupRecycler(binding)
    }

    private fun setupRecycler(binding: FragmentFavoriteItemBinding) {
        val adapter = CustomGroupieAdapter().also { it.updateList() }
        val gridLayoutManager = GridLayoutManager(requireContext(), 3).also {
            it.spanSizeLookup = CustomGridSpanSizeLookup(adapter.itemList, resources)
        }

        binding.favoriteItemRecycler.also {
            it.adapter = adapter
            it.layoutManager = gridLayoutManager
        }
    }

    private class CustomGroupieAdapter : GroupieAdapter() {
        private val _itemList: MutableList<BindableItem<out ViewBinding>> = mutableListOf()
        val itemList: List<BindableItem<out ViewBinding>>
            get() = _itemList

        private fun createItemCells() {
            _itemList.add(FavoriteNoItemRegistered())
            _itemList.add(FavoriteNowPopularItem())
            for (i in 0..29) {
                _itemList.add(
                    FavoriteItemDescription()
                )
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