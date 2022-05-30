package com.dev.alarmapplication.utils.extention

import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.Transformation
import androidx.recyclerview.widget.RecyclerView
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.maps.MapboxMap


fun initShowOut(v: View) {
    v.visibility = View.GONE
    v.translationY = v.height.toFloat()
    v.alpha = 0f
}

fun initAnimationDefaultCameraPosition(mapboxMap: MapboxMap, target: LatLng) {
    mapboxMap.animateCamera(CameraUpdateFactory.newLatLngZoom(target, 15.0))
}

fun toggleArrow(view: View): Boolean {
    return if (view.rotation == 0f) {
        view.animate().setDuration(200).rotation(180f)
        true
    } else {
        view.animate().setDuration(200).rotation(0f)
        false
    }
}

fun expand(v: View, animListener: AnimListener) {
    val a: Animation = expandAction(v)
    a.setAnimationListener(object : Animation.AnimationListener {
        override fun onAnimationStart(animation: Animation) {}
        override fun onAnimationEnd(animation: Animation) {
            animListener.onFinish()
        }

        override fun onAnimationRepeat(animation: Animation) {}
    })
    v.startAnimation(a)
}

private fun expandAction(v: View): Animation {
    v.measure(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    val targetHeight = v.measuredHeight
    v.layoutParams.height = 0
    v.visibility = View.VISIBLE
    val a: Animation = object : Animation() {
        override fun applyTransformation(interpolatedTime: Float, t: Transformation) {
            v.layoutParams.height =
                if (interpolatedTime == 1f) ViewGroup.LayoutParams.WRAP_CONTENT else (targetHeight * interpolatedTime).toInt()
            v.requestLayout()
        }

        override fun willChangeBounds(): Boolean {
            return true
        }
    }
    a.duration = ((targetHeight / v.context.resources.displayMetrics.density).toInt()).toLong()
    v.startAnimation(a)
    return a
}

fun nestedScrollTo(recyclerView: RecyclerView, targetView: View) {
    recyclerView.post { recyclerView.scrollTo(500, targetView.bottom) }
}

fun collapse(v: View) {
    val initialHeight = v.measuredHeight
    val a: Animation = object : Animation() {
        override fun applyTransformation(interpolatedTime: Float, t: Transformation) {
            if (interpolatedTime == 1f) {
                v.visibility = View.GONE
            } else {
                v.layoutParams.height = initialHeight - (initialHeight * interpolatedTime).toInt()
                v.requestLayout()
            }
        }

        override fun willChangeBounds(): Boolean {
            return true
        }
    }
    a.duration = ((initialHeight / v.context.resources.displayMetrics.density).toInt()).toLong()
    v.startAnimation(a)
}

interface AnimListener {
    fun onFinish()
}