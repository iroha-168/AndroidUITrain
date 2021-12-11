package com.nemo.androiduitraining.view.fragment.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FragmentHomeAllBinding
import com.nemo.androiduitraining.view.fragment.home.adapter.HomeAllAdapter
import com.nemo.androiduitraining.view.fragment.home.viewModel.HomeAllViewModel

class HomeAllFragment : Fragment(R.layout.fragment_home_all) {
    companion object {
        fun newInstance() = HomeAllFragment()
    }

    private var _binding: FragmentHomeAllBinding? = null
    private val binding
        get() = _binding!!

    private val homeAllAdapter = HomeAllAdapter()
    private val viewModel: HomeAllViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentHomeAllBinding.bind(view)
        binding.allRecyclerView.adapter = homeAllAdapter
        viewModel.renderData.observe(viewLifecycleOwner) {
            homeAllAdapter.update(it, viewModel)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
