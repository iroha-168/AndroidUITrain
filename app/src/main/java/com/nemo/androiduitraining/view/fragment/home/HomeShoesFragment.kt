package com.nemo.androiduitraining.view.fragment.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FragmentHomeShoesBinding

class HomeShoesFragment : Fragment(R.layout.fragment_home_shoes) {
    companion object {
        fun newInstance() = HomeShoesFragment()
    }

    private var _binding: FragmentHomeShoesBinding? = null
    private val binding: FragmentHomeShoesBinding
        get() = _binding!!
    var sampleTextList: ArrayList<String> = ArrayList()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentHomeShoesBinding.bind(view)

        // RecyclerViewに表示するサンプルデータを作成
        createSampleData()

        // RecyclerViewに適当に文字列を表示するためのAdapterの設定
        binding.shoesRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.shoesRecyclerView.adapter = SampleAdapter(sampleTextList)
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
