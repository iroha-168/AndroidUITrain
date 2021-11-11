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
    private val binding
        get() = _binding!!
    var sampleTextList: ArrayList<String> = ArrayList()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentHomeAllBinding.bind(view)

        createSampleData()

        binding.allRecyclerView.adapter = SampleAdapter(sampleTextList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // RecyclerViewに配置する適当な数字を作成
    private fun createSampleData() {
        for (i in 1..10) {
            sampleTextList.add(i.toString())
        }
    }
}
