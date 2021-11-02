package com.nemo.androiduitraining.view.fragment.ranking

import android.view.View
import com.bumptech.glide.Glide
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.ItemRankingBinding
import com.xwray.groupie.viewbinding.BindableItem

class RankingItem: BindableItem<ItemRankingBinding>() {

    private var binding: ItemRankingBinding? = null

    override fun initializeViewBinding(view: View): ItemRankingBinding {
        binding = ItemRankingBinding.bind(view)
        return binding!!
    }
    override fun getLayout(): Int = R.layout.item_ranking
    override fun bind(viewBinding: ItemRankingBinding, position: Int) {
        val dededeUrl = "https://www.kirby.jp/special/personalityquiz/assets/img/result/16-dedede.png"
        Glide.with(viewBinding.root.context).load(dededeUrl).into(viewBinding.rankingImage)
        viewBinding.rankingCategory.text = "どすこい"
        viewBinding.rankingBrand.text = "どすこいブランド"
        viewBinding.rankingPrice.text = "￥2,000"
    }
}