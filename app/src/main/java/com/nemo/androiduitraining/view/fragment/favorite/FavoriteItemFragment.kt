package com.nemo.androiduitraining.view.fragment.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FragmentFavoriteItemBinding

class FavoriteItemFragment : Fragment(R.layout.fragment_favorite_item) {
    companion object {
        fun newInstance() = FavoriteItemFragment()
    }

    private var _binding: FragmentFavoriteItemBinding? = null
    private val binding: FragmentFavoriteItemBinding
        get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFavoriteItemBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}