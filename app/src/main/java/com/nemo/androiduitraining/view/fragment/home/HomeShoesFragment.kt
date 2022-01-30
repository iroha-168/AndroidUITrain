package com.nemo.androiduitraining.view.fragment.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FragmentHomeShoesBinding
import com.nemo.androiduitraining.view.fragment.home.adapter.HomeShoesAdapter
import com.nemo.androiduitraining.view.fragment.home.viewModel.HomeShoesViewModel

class HomeShoesFragment : Fragment(R.layout.fragment_home_shoes) {
    companion object {
        fun newInstance() = HomeShoesFragment()
    }

    private val homeShoesAdapter = HomeShoesAdapter()
    private val viewModel: HomeShoesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentHomeShoesBinding.bind(view)

        binding.shoesRecyclerView.adapter = homeShoesAdapter
        viewModel.renderData.observe(viewLifecycleOwner) {
            homeShoesAdapter.update(it, viewModel)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}
