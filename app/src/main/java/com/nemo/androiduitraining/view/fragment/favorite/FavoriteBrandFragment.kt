package com.nemo.androiduitraining.view.fragment.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FragmentFavoriteBrandBinding
import com.nemo.androiduitraining.viewModel.favorite.FavoriteBrandViewModel

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
    }
}