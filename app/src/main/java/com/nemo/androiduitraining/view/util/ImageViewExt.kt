package com.nemo.androiduitraining.view.util

import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.ImageView
import androidx.annotation.ColorRes
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.CircleCropTransformation

@BindingAdapter("imageUrl", "placeholder", "errorImage", "isCircle", requireAll = false)
fun ImageView.setImage(
    imageUrl: String?,
    placeholder: Drawable?,
    errorImage: Drawable?,
    isCircle: Boolean?
) {
    imageUrl ?: return
    this.load(imageUrl) {
        placeholder?.let { placeholder(it) }
        error(errorImage)
        if (isCircle == true) transformations(CircleCropTransformation())
    }
}

@BindingAdapter("tintColor")
fun ImageView.setTintColor(@ColorRes colorResId: Int?) {
    colorResId ?: return

    setColorFilter(colorResId)
}
