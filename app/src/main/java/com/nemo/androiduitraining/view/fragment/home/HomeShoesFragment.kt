package com.nemo.androiduitraining.view.fragment.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FragmentHomeShoesBinding

class HomeShoesFragment : Fragment(R.layout.fragment_home_shoes) {
    companion object {
        fun newInstance() = HomeShoesFragment()
    }

    private var _binding: FragmentHomeShoesBinding? = null
    private val binding: FragmentHomeShoesBinding
        get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentHomeShoesBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

}
