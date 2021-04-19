package com.amirghm.gerocery.utils.extentions

import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import com.amirghm.gerocery.utils.imageloader.loadImage


/**
 *
 * Usage: Some useful function to define some useful parameters in the xml which generated by
 * databinding process
 *
 */

@BindingAdapter("srcUrl")
fun bindSrcCompat(view: ImageView, imageUrl: String?) {
    if (imageUrl.isNullOrEmpty())
        view.setImageDrawable(null)
    else
        loadImage(imageUrl, view)
}

