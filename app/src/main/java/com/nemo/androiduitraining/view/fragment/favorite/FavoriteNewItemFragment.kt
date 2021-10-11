package com.nemo.androiduitraining.view.fragment.favorite

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FragmentFavoriteNewItemBinding
import com.nemo.androiduitraining.viewModel.favorite.FavoriteNewItemViewModel
import com.xwray.groupie.GroupieAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteNewItemFragment : Fragment(R.layout.fragment_favorite_new_item) {
    companion object {
        fun newInstance() = FavoriteNewItemFragment()
    }

    private val viewModel: FavoriteNewItemViewModel by viewModels()

    private var _binding: FragmentFavoriteNewItemBinding? = null
    private val binding: FragmentFavoriteNewItemBinding
        get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFavoriteNewItemBinding.bind(view)

        setupRecycler()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initializeGroupieAdapter(): GroupieAdapter {
        viewModel.createItemCells()
        return GroupieAdapter().apply {
            this.update(viewModel.defaultViewList)
        }
    }

    private fun setupRecycler() {
        val layoutManager = LinearLayoutManager(requireContext())

        binding.favoriteNewItemRecycler.also {
            it.layoutManager = layoutManager
            it.addItemDecoration(createRecyclerDiver(layoutManager))
            it.adapter = initializeGroupieAdapter()
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
}