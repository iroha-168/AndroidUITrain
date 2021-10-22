package com.nemo.androiduitraining.view.fragment.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FragmentHomeAllBinding

class HomeAllFragment : Fragment(R.layout.fragment_home_all) {
    companion object {
        fun newInstance() = HomeAllFragment()
    }

    private var _binding: FragmentHomeAllBinding? = null
    private val binding: FragmentHomeAllBinding
        get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentHomeAllBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
