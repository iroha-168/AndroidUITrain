package com.nemo.androiduitraining.view.fragment.ranking

import android.view.View
import com.bumptech.glide.Glide
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.ItemRankingBinding
import com.nemo.androiduitraining.view.util.Constant.DOSKOI_RANKING_IMAGE
import com.xwray.groupie.viewbinding.BindableItem

class RankingItem: BindableItem<ItemRankingBinding>() {

    private var binding: ItemRankingBinding? = null

    override fun initializeViewBinding(view: View): ItemRankingBinding {
        binding = ItemRankingBinding.bind(view)
        return binding!!
    }
    
    override fun getLayout(): Int = R.layout.item_ranking
    
    override fun bind(viewBinding: ItemRankingBinding, position: Int) {
        Glide.with(viewBinding.root.context).load(DOSKOI_RANKING_IMAGE).into(viewBinding.rankingImage)
        viewBinding.rankingCategory.setText(R.string.doskoi)
        viewBinding.rankingBrand.setText(R.string.doskoi_brand)
        viewBinding.rankingPrice.setText(R.string.two_thousand_yen)
    }
}
