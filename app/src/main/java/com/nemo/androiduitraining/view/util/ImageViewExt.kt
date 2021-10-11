package com.nemo.androiduitraining.view.util

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.CircleCropTransformation

@BindingAdapter("imageUrl", "placeholder", "errorImage", "isCircle", requireAll = false)
fun ImageView.setImage(imageUrl: String?, @DrawableRes drawableResId: Int, @DrawableRes errorDrawableResId: Int, isCircle: Boolean) {
    imageUrl ?: return
    this.load(imageUrl) {
        placeholder(drawableResId)
        error(errorDrawableResId)
        if (isCircle) transformations(CircleCropTransformation())
    }
}