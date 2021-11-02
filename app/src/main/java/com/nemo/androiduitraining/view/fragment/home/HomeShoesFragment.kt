package com.nemo.androiduitraining.view.fragment.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FragmentHomeShoesBinding

class HomeShoesFragment : Fragment(R.layout.fragment_home_shoes) {
    companion object {
        fun newInstance() = HomeShoesFragment()
    }

    var sampleTextList: ArrayList<String> = ArrayList()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentHomeShoesBinding.bind(view)

        createSampleData()

        binding.shoesRecyclerView.adapter = SampleAdapter(sampleTextList)
    }

    // RecyclerViewに配置する適当な数字を作成
    private fun createSampleData() {
        for (i in 1..10) {
            sampleTextList.add(i.toString())
        }
    }
}