package com.nemo.androiduitraining.view.fragment.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    class FavoriteViewPagerAdapter(parentFragment: Fragment) : FragmentStateAdapter(parentFragment) {
        override fun getItemCount(): Int = 3
        override fun createFragment(position: Int): Fragment {
            return when(position) {
                0 -> FavoriteNewItemFragment.newInstance()
                1 -> FavoriteItemFragment.newInstance()
                2 -> FavoriteBrandFragment.newInstance()
                else -> throw IllegalArgumentException("予想外のFragmentです")
            }
        }
    }
}