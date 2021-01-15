package com.ipsoft.livros.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    Livros
 *  Date:       11/01/2021
 */

object ImageBinding {

    @JvmStatic
    @BindingAdapter("app:imageUrl")
    fun setImageUrl(imageView: ImageView, url: String) {

        if(url.isNotEmpty()) {
            Glide.with(imageView)
                .load(url)
                .into(imageView)
        }

    }
}