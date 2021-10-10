package com.nemo.androiduitraining.view.fragment.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FragmentFavoriteBinding

class FavoriteFragment : Fragment() {
    private var _binding: FragmentFavoriteBinding? = null
    private val binding: FragmentFavoriteBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = FavoriteViewPagerAdapter(this)
        setUpViewPager2(adapter)
        connectTabLayoutAndViewPager2()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setUpViewPager2(adapter: FavoriteViewPagerAdapter) {
        binding.favoriteViewPager.adapter = adapter
    }

    private fun connectTabLayoutAndViewPager2() {
        TabLayoutMediator(binding.favoriteTabLayout, binding.favoriteViewPager) { tab, position ->
            val tabTitle = when (position) {
                FragmentsOrder.NEW_ITEM.ordinal -> FragmentsOrder.NEW_ITEM.title
                FragmentsOrder.ITEM.ordinal -> FragmentsOrder.ITEM.title
                FragmentsOrder.BRAND.ordinal -> FragmentsOrder.BRAND.title
                else -> ""
            }
            tab.text = tabTitle
        }.attach()
    }

    class FavoriteViewPagerAdapter(parentFragment: Fragment) : FragmentStateAdapter(parentFragment) {
        override fun getItemCount(): Int = FragmentsOrder.values().size
        override fun createFragment(position: Int): Fragment {
            return when (position) {
                FragmentsOrder.NEW_ITEM.ordinal -> FavoriteNewItemFragment.newInstance()
                FragmentsOrder.ITEM.ordinal -> FavoriteItemFragment.newInstance()
                FragmentsOrder.BRAND.ordinal -> FavoriteBrandFragment.newInstance()
                else -> throw IllegalArgumentException("予想外のFragmentです")
            }
        }
    }

    private enum class FragmentsOrder(val title: String) {
        NEW_ITEM("新着"), ITEM("アイテム"), BRAND("ブランド")
    }
}