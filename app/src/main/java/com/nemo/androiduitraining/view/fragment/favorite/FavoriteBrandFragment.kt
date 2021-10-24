package com.nemo.androiduitraining.view.fragment.favorite

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FragmentFavoriteBrandBinding
import com.nemo.androiduitraining.view.fragment.favorite.entity.FavoriteItemCell
import com.nemo.androiduitraining.view.fragment.favorite.entity.FavoriteNoBrandRegistered
import com.nemo.androiduitraining.view.fragment.favorite.entity.FavoriteNowPopular
import com.nemo.androiduitraining.viewModel.favorite.FavoriteBrandViewModel
import com.xwray.groupie.GroupieAdapter
import com.xwray.groupie.viewbinding.BindableItem

class FavoriteBrandFragment : Fragment(R.layout.fragment_favorite_brand) {
    companion object {
        fun newInstance() = FavoriteBrandFragment()
    }

    private val viewModel: FavoriteBrandViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentFavoriteBrandBinding.bind(view).also {
            it.lifecycleOwner = viewLifecycleOwner
            it.viewModel = viewModel
        }
        val adapter = GroupieCustomAdapter()
        setupRecycler(binding, adapter)
        fetchBrandsItemAndUpdateList(adapter)
    }

    private fun setupRecycler(binding: FragmentFavoriteBrandBinding, adapter: GroupieCustomAdapter) {
        val layoutManager = LinearLayoutManager(requireContext())

        binding.brandRecycler.also {
            it.layoutManager = layoutManager
            it.addItemDecoration(createRecyclerDiver(layoutManager))
            it.adapter = adapter
        }
    }
    private fun createRecyclerDiver(layoutManager: LinearLayoutManager): DividerItemDecoration {
        val dividerDrawable = ContextCompat.getDrawable(requireContext(), R.drawable.fragment_favorite_new_item_divider)
        return DividerItemDecoration(requireContext(), layoutManager.orientation).apply {
            if (dividerDrawable != null) {
                this.setDrawable(dividerDrawable)
            }
        }
    }

    private fun fetchBrandsItemAndUpdateList(adapter: GroupieCustomAdapter) {
        viewModel.brandLD.observe(viewLifecycleOwner) { brands ->
            adapter.updateList(brands)
        }
        viewModel.fetchBrandItems()
    }

    private class GroupieCustomAdapter : GroupieAdapter() {
        private var itemList: List<BindableItem<out ViewBinding>> = listOf()

        private val defaultViewList = mutableListOf(
            FavoriteNoBrandRegistered(),
            FavoriteNowPopular()
        )

        fun updateList(brandsList: List<FavoriteBrandViewModel.BrandTabBrandItem>) {
            this.itemList = defaultViewList + brandsList.map {
                FavoriteItemCell(
                    brandName = it.name,
                    brandNameJapanese = it.nameJapanese
                )
            }
            update(this.itemList)
        }
    }
}
