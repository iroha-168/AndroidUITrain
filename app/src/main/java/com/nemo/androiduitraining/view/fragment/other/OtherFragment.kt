package com.nemo.androiduitraining.view.fragment.other

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.nemo.androiduitraining.databinding.FragmentOtherBinding
import com.nemo.androiduitraining.viewModel.other.OtherViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OtherFragment : Fragment() {
    private val viewModel: OtherViewModel by viewModels()

    private var _binding: FragmentOtherBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOtherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
