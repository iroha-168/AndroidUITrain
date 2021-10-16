package com.nemo.androiduitraining.view.fragment.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {
    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
    get() = _binding!!
    var sampleTextList: ArrayList<String> = ArrayList()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)

        // RecyclerViewに表示するサンプルデータを作成
        createSampleData()

        // Adapterの設定(仮)
        binding.containerForRecyclerView.layoutManager = LinearLayoutManager(context)

        binding.containerForRecyclerView.adapter = SampleAdapter(sampleTextList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun createSampleData() {
        for (i in 1..10) {
            sampleTextList.add(i.toString())
        }
    }
}
