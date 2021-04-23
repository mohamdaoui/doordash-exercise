package com.mohamdaoui.doordash.ui.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("bind:imageUrl")
fun setImageUrl(view: ImageView, imageUrl: String?) {
    Glide.with(view.context)
        .load(imageUrl)
        .into(view)
}