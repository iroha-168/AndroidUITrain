package com.nemo.androiduitraining.view.fragment.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nemo.androiduitraining.R

class SampleAdapter(private val sampleDataset: ArrayList<String>) :
    RecyclerView.Adapter<SampleAdapter.ViewHolder>() {

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleAdapter.ViewHolder {
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false) as TextView
        return ViewHolder(textView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = sampleDataset[position]
    }

    override fun getItemCount() = sampleDataset.size
}
