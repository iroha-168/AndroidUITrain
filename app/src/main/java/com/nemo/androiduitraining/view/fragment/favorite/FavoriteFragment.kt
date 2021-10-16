package com.nemo.androiduitraining.view.fragment.favorite

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.FragmentFavoriteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment(R.layout.fragment_favorite) {
    private var _binding: FragmentFavoriteBinding? = null
    private val binding: FragmentFavoriteBinding
        get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFavoriteBinding.bind(view)

        setupViewPager()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupViewPager() {
        binding.favoriteViewPager.adapter = FavoriteViewPagerAdapter(this)

        TabLayoutMediator(binding.favoriteTabLayout, binding.favoriteViewPager) { tab, position ->
            tab.text = FragmentsOrder.values()[position].title
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