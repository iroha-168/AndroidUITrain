package com.nemo.androiduitraining.view.fragment.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FragmentMensBinding

class MensFragment : Fragment(R.layout.fragment_mens) {
    companion object {
        fun newInstance() = MensFragment()
    }

    var sampleTextList: ArrayList<String> = ArrayList()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentMensBinding.bind(view)

        createSampleData()
        binding.mensRecyclerView.adapter = SampleAdapter(sampleTextList)
    }

    private fun createSampleData() {
        for (i in 1..10) {
            sampleTextList.add(i.toString())
        }
    }
}
