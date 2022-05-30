package com.dev.alarmapplication.utils.tools

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.davemorrissey.labs.subscaleview.ImageSource
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView
import com.dev.alarmapplication.R
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.BASE_URL_IMAGE

class GlideTools(private val context: Context, private val handleErrorTools: HandleErrorTools) {

    fun displayImageSubSlider(img: ImageView?, url: String?) {
        try {

            val resultImage=BASE_URL_IMAGE+ url
            val options: RequestOptions = RequestOptions()
                .placeholder(R.drawable.ic_placeholder)
            img?.let {
                Glide.with(context).load(resultImage)
                    .apply(options)
                    .into(it)
            }
        } catch (e: Exception) {
            handleErrorTools.handleError(e)
        }
    }

    fun displayImageOriginal(img: ImageView?, url: String?) {
        try {
            val resultImage=BASE_URL_IMAGE+url
            val options: RequestOptions = RequestOptions()
                .placeholder(R.drawable.ic_placeholder)
            img?.let {
                Glide.with(context).load(resultImage)
                    .apply(options)
                    .into(it)
            }
        } catch (e: Exception) {
            handleErrorTools.handleError(e)
        }
    }

    fun displayImageOriginalOnlyUrl(img: ImageView?, url: String?) {
        try {
            val options: RequestOptions = RequestOptions()
                .placeholder(R.drawable.ic_placeholder)
            img?.let {
                Glide.with(context).load(url)
                    .apply(options)
                    .into(it)
            }
        } catch (e: Exception) {
            handleErrorTools.handleError(e)
        }
    }


    fun displayImageOriginals(img: ImageView?, url: String?) {
        try {
            val options: RequestOptions = RequestOptions()
                .placeholder(R.drawable.ic_placeholder)
            img?.let {
                Glide.with(context).load(url)
                    .apply(options)
                    .into(it)
            }
        } catch (e: Exception) {
            handleErrorTools.handleError(e)
        }
    }

    fun displayHome(img: ImageView, url: String) {
        try {
            val resultImage=BASE_URL_IMAGE+url
            val options: RequestOptions = RequestOptions()
                .placeholder(R.drawable.ic_placeholder_large
                )
            Glide.with(context).load(resultImage)
                .apply(options)
                .into(img)
        } catch (e: Exception) {
            handleErrorTools.handleError(e)
        }
    }

    fun displayImageSliderZoom(imageViewZoomable: SubsamplingScaleImageView, url: String?) {
        try {
            val resultImage=BASE_URL_IMAGE+url
            Glide.with(context)
                .asBitmap()
                .load(resultImage)
                .into(object : CustomTarget<Bitmap?>() {
                    override
                    fun onLoadCleared(placeholder: Drawable?) {}
                    override fun onResourceReady(
                        resource: Bitmap,
                        transition: Transition<in Bitmap?>?,
                    ) {
                        imageViewZoomable.setImage(ImageSource.bitmap(resource))
                    }
                })
        } catch (e: Exception) {
            handleErrorTools.handleError(e)
        }
    }

    fun displayImageSliderDefault(img: ImageView, url: String) {
        try {
            val resultImage=BASE_URL_IMAGE+url
            val options: RequestOptions = RequestOptions()
                .placeholder(R.drawable.ic_no_pic_detail)
                .error(R.drawable.ic_error)
            Glide.with(context).load(resultImage)
                .apply(options)
                .into(img)
        } catch (e: Exception) {
            handleErrorTools.handleError(e)
        }
    }
}