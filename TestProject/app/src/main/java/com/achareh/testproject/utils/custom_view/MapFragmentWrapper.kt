package com.achareh.testproject.utils.custom_view

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import com.achareh.testproject.R
import com.mapbox.mapboxsdk.annotations.Marker
import com.mapbox.mapboxsdk.geometry.LatLng

class MapFragmentWrapper : RelativeLayout {

    interface OnDragListener {
        fun onDragStart()
        fun onDragEnd()
        fun onStartMap()
    }

    private var mOnDragListener: OnDragListener? = null

    private var stateMarker: Int = -1
    private var stateVanet: Int = -1
    private lateinit var targetOne: LatLng
    private lateinit var targetTwo: LatLng
    private lateinit var targetThree: LatLng
    private lateinit var markerOne: Marker
    private lateinit var markerTwo: Marker
    private lateinit var markerThree: Marker
    private var mMarkImageView: ImageView? = null
    private var mShadowView: View? = null
    lateinit var params: LayoutParams

    fun setStateVanet(stateVanet: Int) {
        this.stateVanet = stateVanet
    }

    fun getStateVanet(): Int {
        return stateVanet
    }

    fun setStateMarker(stateMarker: Int) {
        this.stateMarker = stateMarker
    }

    fun getStateMarker(): Int {
        return stateMarker
    }

    fun setMarkerOne(markerOne: Marker) {
        this.markerOne = markerOne
    }

    fun getMarkerOne(): Marker {
        return markerOne
    }

    fun setMarkerTwo(markerTwo: Marker) {
        this.markerTwo = markerTwo
    }

    fun getMarkerTwo(): Marker {
        return markerTwo
    }

    fun setMarkerThree(markerThree: Marker) {
        this.markerThree = markerThree
    }

    fun getMarkerThree(): Marker {
        return markerThree
    }

    fun isMarkerOne(): Boolean {
        return ::markerOne.isInitialized
    }

    fun isMarkerTwo(): Boolean {
        return ::markerTwo.isInitialized
    }

    fun isMarkerThree(): Boolean {
        return ::markerThree.isInitialized
    }

    fun setTargetOne(targetOne: LatLng) {
        this.targetOne = targetOne
    }

    fun getTargetOne(): LatLng {
        return targetOne
    }

    fun setTargetTwo(targetTwo: LatLng) {
        this.targetTwo = targetTwo
    }

    fun getTargetTwo(): LatLng {
        return targetTwo
    }

    fun setTargetThree(targetThree: LatLng) {
        this.targetThree = targetThree
    }

    fun getTargetThree(): LatLng {
        return targetThree
    }


    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        super.onLayout(changed, l, t, r, b)

        removeView(mMarkImageView)
        removeView(mShadowView)
        addView(mMarkImageView, -1, params)
        addView(mShadowView, -1, params)
    }

    fun setVisibilityMarker(state: Int) {
        mMarkImageView?.visibility=state
        mShadowView?.visibility=state
    }

    fun setImageResource(state: Int) {
        mMarkImageView?.setImageResource(state)
    }

    private fun init(context: Context) {
        stateMarker = 1
        mMarkImageView = ImageView(context)
        mMarkImageView?.setImageResource(R.drawable.ic_location_pointer_origin)
        mMarkImageView!!.setPadding(0, 0, 0, 200)


        params = LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        params.addRule(CENTER_IN_PARENT, TRUE)

        mShadowView = View(context)
        mShadowView?.setBackgroundResource(R.drawable.map_pin_shadow)
    }

    @SuppressLint("ObjectAnimatorBinding")
    fun animateDown() {
        if (mMarkImageView != null && mShadowView != null) {
            val translateYInverse = ObjectAnimator.ofFloat(
                mMarkImageView,
                "translationY",
                mMarkImageView!!.height.toFloat() / 25
            )

            val alphaShadowInverse = ObjectAnimator.ofFloat(
                mShadowView,
                "alpha",
                0.6f,
                1f
            )

            val animatorSet = AnimatorSet()
            animatorSet.playTogether(translateYInverse, alphaShadowInverse)
            animatorSet.start()
        }
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        when (ev.action) {
            MotionEvent.ACTION_DOWN -> {
                animateUp(this)
                mOnDragListener?.onDragStart()
            }
            MotionEvent.ACTION_UP -> {
                animateDown()
                mOnDragListener?.onDragEnd()
            }
        }

        return super.dispatchTouchEvent(ev)
    }

    fun setOnDragListener(mOnDragListener: OnDragListener) {
        this.mOnDragListener = mOnDragListener
        mOnDragListener.onStartMap()

    }

    companion object {
        @SuppressLint("ObjectAnimatorBinding")
        fun animateUp(mapFragmentWrapper: MapFragmentWrapper) {
            if (mapFragmentWrapper.mMarkImageView != null && mapFragmentWrapper.mShadowView != null) {
                val translateY = ObjectAnimator.ofFloat(
                    mapFragmentWrapper.mMarkImageView,
                    "translationY",
                    -(mapFragmentWrapper.mMarkImageView!!.height.toFloat()) / 10
                )

                val alphaShadow = ObjectAnimator.ofFloat(
                    mapFragmentWrapper.mShadowView,
                    "alpha",
                    1f,
                    0.6f
                )

                val animatorSet = AnimatorSet()
                animatorSet.playTogether(translateY, alphaShadow)
                animatorSet.start()
            }
        }
    }

}
