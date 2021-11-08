package com.nemo.androiduitraining.view.fragment.home

import android.os.Bundle
import android.view.View
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FragmentHomeAllBinding

class HomeAllFragment : Fragment(R.layout.fragment_home_all) {
    private var _binding: FragmentHomeAllBinding? = null
    private val binding: FragmentHomeAllBinding
        get() = _binding!!

    companion object {
        fun newInstance() = HomeAllFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeAllBinding.bind(view)

        val homeAllViewPagerAdapter = HomeAllViewPagerAdapter(this)
        setUpViewPager(homeAllViewPagerAdapter)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setUpViewPager(adapter: HomeAllViewPagerAdapter) {
        binding.homeAllViewPager.adapter = adapter

        TabLayoutMediator(
            binding.genderSwitchTab,
            binding.homeAllViewPager,
            false,
            false
        ) { tab, position ->
            val tabImage =
                getDrawable(requireContext(), FragmentsOrder.values()[position].drawableResId)

            tab.icon = tabImage
        }.attach()
    }

    private class HomeAllViewPagerAdapter(parentFragment: Fragment) :
        FragmentStateAdapter(parentFragment) {
        val errorMsg = parentFragment.getString(R.string.error_msg_not_found_fragment)

        override fun getItemCount(): Int = FragmentsOrder.values().size

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                FragmentsOrder.MENS.ordinal -> MensFragment.newInstance()
                FragmentsOrder.LADIES.ordinal -> LadiesFragment.newInstance()
                FragmentsOrder.KIDS.ordinal -> KidsFragment.newInstance()
                else -> throw IllegalArgumentException(errorMsg)
            }
        }
    }

    private enum class FragmentsOrder(val drawableResId: Int) {
        MENS(R.drawable.ic_mens_before),
        LADIES(R.drawable.ladies_selector),
        KIDS(R.drawable.ic_kids_before)
    }

}
