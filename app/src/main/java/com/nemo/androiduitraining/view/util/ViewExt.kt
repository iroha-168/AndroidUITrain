package com.nemo.androiduitraining.view.util

import android.view.View
import androidx.databinding.BindingAdapter
import java.time.Instant

/**
 * 連打対策付きクリックイベント
 */
@BindingAdapter("onClick")
fun View.setOnClickListenerWithoutDoubleTap(onClickListener: View.OnClickListener?) {
    setOnClickListener(DoubleTapOnClickListener(onClickListener))
}

class DoubleTapOnClickListener(val listener: View.OnClickListener?) : View.OnClickListener {
    private var lastTapAtMs = 0L

    override fun onClick(view: View?) {
        val now = Instant.now().toEpochMilli()
        if (now - lastTapAtMs >= 500) {
            listener?.onClick(view)
        }
        lastTapAtMs = now
    }
}