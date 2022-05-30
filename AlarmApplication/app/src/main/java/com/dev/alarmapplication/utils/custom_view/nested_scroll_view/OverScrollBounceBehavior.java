package com.dev.alarmapplication.utils.custom_view.nested_scroll_view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;

import org.jetbrains.annotations.NotNull;

public class OverScrollBounceBehavior extends CoordinatorLayout.Behavior<View> {

    private int mOverScrollY;

    public OverScrollBounceBehavior() {
    }

    public OverScrollBounceBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(@NotNull CoordinatorLayout coordinatorLayout, @NotNull View child, @NotNull View directTargetChild, @NotNull View target, int nestedScrollAxes) {
        mOverScrollY = 0;
        return true;
    }

    @Override
    public void onNestedScroll(@NotNull CoordinatorLayout coordinatorLayout, @NotNull View child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        if (dyUnconsumed == 0) {
            return;
        }

        mOverScrollY -= dyUnconsumed;
        final ViewGroup group = (ViewGroup) target;
        final int count = group.getChildCount();
        for (int i = 0; i < count; i++) {
            final View view = group.getChildAt(i);
            view.setTranslationY(mOverScrollY);
        }
    }

    @Override
    public void onStopNestedScroll(@NotNull CoordinatorLayout coordinatorLayout, @NotNull View child, @NotNull View target) {
        final ViewGroup group = (ViewGroup) target;
        final int count = group.getChildCount();
        for (int i = 0; i < count; i++) {
            final View view = group.getChildAt(i);
            ViewCompat.animate(view).translationY(0).start();
        }
    }
}