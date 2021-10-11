package com.nemo.androiduitraining.view.fragment.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FragmentFavoriteNewItemBinding

class FavoriteNewItemFragment : Fragment(R.layout.fragment_favorite_new_item) {
    companion object {
        fun newInstance() = FavoriteNewItemFragment()
    }

    private var _binding: FragmentFavoriteNewItemBinding? = null
    private val binding: FragmentFavoriteNewItemBinding
        get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFavoriteNewItemBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}