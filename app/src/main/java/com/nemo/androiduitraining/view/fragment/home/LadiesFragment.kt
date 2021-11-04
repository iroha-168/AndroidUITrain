package com.nemo.androiduitraining.view.fragment.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FragmentLadiesBinding

class LadiesFragment : Fragment(R.layout.fragment_ladies) {

    companion object {
        fun newInstance() = LadiesFragment()
    }

    var sampleTextList: ArrayList<String> = ArrayList()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentLadiesBinding.bind(view)

        createSampleData()
        binding.ladiesRecyclerView.adapter = SampleAdapter(sampleTextList)
    }

    private fun createSampleData() {
        for (i in 15..25) {
            sampleTextList.add(i.toString())
        }
    }
}
