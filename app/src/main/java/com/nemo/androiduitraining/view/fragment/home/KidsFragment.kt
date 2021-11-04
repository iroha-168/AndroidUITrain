package com.nemo.androiduitraining.view.fragment.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FragmentKidsBinding

class KidsFragment : Fragment(R.layout.fragment_kids) {
    companion object {
        fun newInstance() = KidsFragment()
    }

    var sampleTextList: ArrayList<String> = ArrayList()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentKidsBinding.bind(view)

        createSampleData()
        binding.kidsRecyclerView.adapter = SampleAdapter(sampleTextList)
    }

    private fun createSampleData() {
        for (i in 10..20) {
            sampleTextList.add(i.toString())
        }
    }
}
