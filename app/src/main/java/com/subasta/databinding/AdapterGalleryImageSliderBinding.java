package com.subasta.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.subasta.C2037R;
import com.subasta.utils.TouchImageView;

import javax.annotation.Nullable;

public abstract class AdapterGalleryImageSliderBinding extends ViewDataBinding {
    @NonNull
    public final TouchImageView imageView;
    @NonNull
    public final ImageView ivRemove;

    protected AdapterGalleryImageSliderBinding(Object obj, View view, int i, TouchImageView touchImageView, ImageView imageView2) {
        super(obj, view, i);
        this.imageView = touchImageView;
        this.ivRemove = imageView2;
    }

    @NonNull
    public static AdapterGalleryImageSliderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static AdapterGalleryImageSliderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AdapterGalleryImageSliderBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.adapter_gallery_image_slider, viewGroup, z, obj);
    }

    @NonNull
    public static AdapterGalleryImageSliderBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static AdapterGalleryImageSliderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (AdapterGalleryImageSliderBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.adapter_gallery_image_slider, null, false, obj);
    }

    public static AdapterGalleryImageSliderBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterGalleryImageSliderBinding bind(@NonNull View view, @Nullable Object obj) {
        return (AdapterGalleryImageSliderBinding) bind(obj, view, C2037R.layout.adapter_gallery_image_slider);
    }
}
