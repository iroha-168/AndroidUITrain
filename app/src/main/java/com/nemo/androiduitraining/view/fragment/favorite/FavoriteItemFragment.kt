package com.nemo.androiduitraining.view.fragment.favorite

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
    }

    private class CustomGroupieAdapter : GroupieAdapter() {
        private class GroupieCustomAdapter : GroupieAdapter() {
            private val defaultViewList = mutableListOf(
                FavoriteNoItemRegistered(),
                FavoriteNowPopularItem()
            )

            private fun createItemCells() {
                for (i in 0..29) {
                    defaultViewList.add(
                        FavoriteItemDescription()
                    )
                }
            }

            fun updateList() {
                createItemCells()
                update(defaultViewList)
            }
        }
    }

    private class CustomGridSpanSizeLookup(
        private val nowItemList: List<BindableItem<out ViewBinding>>,
        private val res: Resources
    ) : GridLayoutManager.SpanSizeLookup() {
        override fun getSpanSize(position: Int): Int {
            return when (nowItemList[position]) {
                is FavoriteNoItemRegistered -> 1
                is FavoriteNowPopularItem -> 1
                is FavoriteItemDescription -> 3
                else -> throw IllegalArgumentException(res.getString(R.string.illegal_class))
            }
        }
    }
}