package com.nemo.androiduitraining.view.fragment.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FragmentHomeCosmeBinding
import com.nemo.androiduitraining.view.fragment.home.adapter.HomeCosmeAdapter
import com.nemo.androiduitraining.view.fragment.home.viewModel.HomeCosmeViewModel

class HomeCosmeFragment : Fragment(R.layout.fragment_home_cosme) {
    companion object {
        fun newInstance() = HomeCosmeFragment()
    }

    private var _binding: FragmentHomeCosmeBinding? = null
    private val binding
        get() = _binding!!

    private val homeCosmeAdapter = HomeCosmeAdapter()
    private val viewModel: HomeCosmeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentHomeCosmeBinding.bind(view)
        binding.cosmeRecyclerView.adapter = homeCosmeAdapter

        viewModel.renderData.observe(viewLifecycleOwner) {
            homeCosmeAdapter.update(it, viewModel)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
