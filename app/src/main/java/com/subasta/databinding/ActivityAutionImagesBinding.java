package com.subasta.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;

import com.subasta.C2037R;

import javax.annotation.Nullable;

public abstract class ActivityAutionImagesBinding extends ViewDataBinding {
    @NonNull
    public final ImageView ivBack;
    @NonNull
    public final ViewPager viewpager;

    protected ActivityAutionImagesBinding(Object obj, View view, int i, ImageView imageView, ViewPager viewPager) {
        super(obj, view, i);
        this.ivBack = imageView;
        this.viewpager = viewPager;
    }

    @NonNull
    public static ActivityAutionImagesBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityAutionImagesBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityAutionImagesBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_aution_images, viewGroup, z, obj);
    }

    @NonNull
    public static ActivityAutionImagesBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityAutionImagesBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityAutionImagesBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_aution_images, null, false, obj);
    }

    public static ActivityAutionImagesBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityAutionImagesBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityAutionImagesBinding) bind(obj, view, C2037R.layout.activity_aution_images);
    }
}
