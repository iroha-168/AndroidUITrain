package com.nemo.androiduitraining.view.fragment.favorite

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FragmentFavoriteBrandBinding

class FavoriteBrandFragment : Fragment(R.layout.fragment_favorite_brand) {
    companion object {
        fun newInstance() = FavoriteBrandFragment()
    }

    private var _binding: FragmentFavoriteBrandBinding? = null
    private val binding: FragmentFavoriteBrandBinding
        get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFavoriteBrandBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
