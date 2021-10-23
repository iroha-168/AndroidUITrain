package com.nemo.androiduitraining.view.fragment.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FragmentHomeBinding
import java.lang.IllegalArgumentException

class HomeFragment : Fragment(R.layout.fragment_home) {
    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
    get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)

        // ViewPagerのAdapterの設定
        val homeViewPagerAdapter = HomeViewPagerAdapter(this)
        setUpViewPager2(homeViewPagerAdapter)
        connectTabLayoutAndViewPager2()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setUpViewPager2(adapter: HomeViewPagerAdapter) {
        binding.homeViewPager.adapter = adapter
    }

    private fun connectTabLayoutAndViewPager2() {
        TabLayoutMediator(binding.homeTabLayout, binding.homeViewPager) { tab, position ->
            val tabTitle = when (position) {
                FragmentsOrder.ALL.ordinal -> FragmentsOrder.ALL.title
                FragmentsOrder.SHOES.ordinal -> FragmentsOrder.SHOES.title
                FragmentsOrder.COSME.ordinal -> FragmentsOrder.COSME.title
                else -> ""
            }
            tab.text = tabTitle
        }.attach()
    }

    private class HomeViewPagerAdapter(parentFragment: Fragment) : FragmentStateAdapter(parentFragment) {
        override fun getItemCount(): Int = FragmentsOrder.values().size
        override fun createFragment(position: Int): Fragment {
            return when (position) {
                FragmentsOrder.ALL.ordinal -> HomeAllFragment.newInstance()
                FragmentsOrder.SHOES.ordinal -> HomeShoesFragment.newInstance()
                FragmentsOrder.COSME.ordinal -> HomeCosmeFragment.newInstance()
                else -> throw IllegalArgumentException("予想外のFragmentです")
            }
        }
    }

    private enum class FragmentsOrder(val title: String) {
        ALL("すべて"), SHOES("シューズ"), COSME("コスメ")
    }
}
