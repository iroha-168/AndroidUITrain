package com.nemo.androiduitraining.view.fragment.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {
    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
    get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)

        // ViewPagerのAdapterの設定
        val homeViewPagerAdapter = HomeViewPagerAdapter(this)
        setupViewPager(homeViewPagerAdapter)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupViewPager(adapter: HomeViewPagerAdapter) {
        binding.homeViewPager.adapter = adapter
        binding.homeViewPager.isUserInputEnabled = false

        TabLayoutMediator(binding.homeTabLayout, binding.homeViewPager) { tab, position ->
            val tabTitle = getString(FragmentsOrder.values()[position].titleResId)

            tab.text = tabTitle
        }.attach()
    }

    private class HomeViewPagerAdapter(parentFragment: Fragment) : FragmentStateAdapter(parentFragment) {
        val errorMsg = parentFragment.getString(R.string.error_msg_not_found_fragment)
        override fun getItemCount(): Int = FragmentsOrder.values().size
        override fun createFragment(position: Int): Fragment {
            return when (position) {
                FragmentsOrder.ALL.ordinal -> HomeAllFragment.newInstance()
                FragmentsOrder.SHOES.ordinal -> HomeShoesFragment.newInstance()
                FragmentsOrder.COSME.ordinal -> HomeCosmeFragment.newInstance()
                else -> throw IllegalArgumentException(errorMsg)
            }
        }
    }

    private enum class FragmentsOrder(val titleResId: Int) {
        ALL(R.string.all),
        SHOES(R.string.shoes),
        COSME(R.string.cosme)
    }
}
