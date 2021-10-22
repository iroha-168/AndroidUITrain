package com.nemo.androiduitraining.view.fragment.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FragmentHomeCosmeBinding

class HomeCosmeFragment : Fragment(R.layout.fragment_home_cosme) {
    companion object {
        fun newInstance() = HomeCosmeFragment()
    }

    private var _binding: FragmentHomeCosmeBinding? = null
    private val binding: FragmentHomeCosmeBinding
        get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentHomeCosmeBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}
