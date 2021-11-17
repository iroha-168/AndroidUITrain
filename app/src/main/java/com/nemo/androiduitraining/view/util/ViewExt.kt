package com.nemo.androiduitraining.view.util

import android.view.View
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import java.time.Instant

@BindingAdapter("visible")
fun View.setVisible(visible: Boolean?) {
    visible ?: return
    isVisible = visible
}

/**
 * 連打対策付きクリックイベント
 */
@BindingAdapter("onClick")
fun View.setOnClickListenerWithoutDoubleTap(onClickListener: View.OnClickListener?) {
    setOnClickListener(DoubleTapOnClickListener(onClickListener))
}

class DoubleTapOnClickListener(private val listener: View.OnClickListener?) : View.OnClickListener {
    private var lastTapAtMs = 0L

    override fun onClick(view: View?) {
        val now = Instant.now().toEpochMilli()
        if (now - lastTapAtMs >= 500) {
            listener?.onClick(view)
        }
        lastTapAtMs = now
    }
}

@BindingAdapter("isSelected")
fun View.setScale(isSelected: Boolean?) {
    isSelected ?: return

    val animation =  if (isSelected) {
        ScaleAnimation(1f, 1.5f, 1f, 1.5f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,0.5f)
    } else {
        ScaleAnimation(1.5f, 1f, 1.5f, 1f, Animation.RELATIVE_TO_SELF,0.5f, Animation.RELATIVE_TO_SELF,0.5f)
    }.apply { fillAfter = true }
    startAnimation(animation)
}


