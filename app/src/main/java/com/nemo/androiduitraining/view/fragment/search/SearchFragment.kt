package com.nemo.androiduitraining.view.fragment.search

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.nemo.androiduitraining.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private var _binding:FragmentSearchBinding? = null
    private val binding: FragmentSearchBinding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater,container,false)
        return binding.root
    }


}