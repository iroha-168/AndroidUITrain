package com.nemo.androiduitraining.view.fragment.home

import android.util.Log
import android.view.View
import androidx.lifecycle.LifecycleOwner
import com.nemo.androiduitraining.R
import com.nemo.androiduitraining.databinding.PromotionContentBinding
import com.nemo.androiduitraining.entity.Promotion
import com.xwray.groupie.Item
import com.xwray.groupie.viewbinding.BindableItem
import timber.log.Timber
import java.util.*

class HomePromotionItem(private val promotion: Promotion) : BindableItem<PromotionContentBinding>() {
    override fun bind(viewBinding: PromotionContentBinding, position: Int) {
        viewBinding.promotion = promotion
        viewBinding.executePendingBindings()
    }

    override fun getLayout(): Int = R.layout.promotion_content

    override fun initializeViewBinding(view: View): PromotionContentBinding = PromotionContentBinding.bind(view)

    override fun hasSameContentAs(other: Item<*>): Boolean = (other as? HomePromotionItem)?.promotion?.id == promotion.id

    override fun isSameAs(other: Item<*>): Boolean = (other as? HomePromotionItem)?.promotion == promotion
}
