package com.nemo.androiduitraining.view.fragment.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FragmentHomeAllBinding
import com.xwray.groupie.GroupAdapter

class HomeAllFragment : Fragment(R.layout.fragment_home_all) {
    companion object {
        fun newInstance() = HomeAllFragment()
    }

    private var _binding: FragmentHomeAllBinding? = null
    private val binding
        get() = _binding!!

    private val adapter = HomeAdapter()
    private val viewModel: HomeAllViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentHomeAllBinding.bind(view)
        binding.allRecyclerView.adapter = adapter
        viewModel.renderData.observe(viewLifecycleOwner) {
            adapter.update(it, viewModel)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
