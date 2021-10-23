package com.nemo.androiduitraining.view.fragment.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FragmentHomeCosmeBinding

class HomeCosmeFragment : Fragment(R.layout.fragment_home_cosme) {
    companion object {
        fun newInstance() = HomeCosmeFragment()
    }

    private var _binding: FragmentHomeCosmeBinding? = null
    private val binding: FragmentHomeCosmeBinding
        get() = _binding!!
    var sampleTextList: ArrayList<String> = ArrayList()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentHomeCosmeBinding.bind(view)

        // RecyclerViewに表示するサンプルデータを作成
        createSampleData()

        // RecyclerViewに適当に文字列を表示するためのAdapterの設定
        binding.cosmeRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.cosmeRecyclerView.adapter = SampleAdapter(sampleTextList)
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