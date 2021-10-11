package com.nemo.androiduitraining.view.fragment.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
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
        binding.favoriteNewItemRecycler.adapter = initializeGroupieAdapter()
    }
}