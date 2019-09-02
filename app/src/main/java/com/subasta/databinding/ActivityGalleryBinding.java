package com.subasta.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.subasta.C2037R;

import javax.annotation.Nullable;

public abstract class ActivityGalleryBinding extends ViewDataBinding {
    @NonNull
    public final ImageView ivBack;
    @NonNull
    public final ImageView ivGalleryUpload;
    @NonNull
    public final RecyclerView recycleview1;

    protected ActivityGalleryBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, RecyclerView recyclerView) {
        super(obj, view, i);
        this.ivBack = imageView;
        this.ivGalleryUpload = imageView2;
        this.recycleview1 = recyclerView;
    }

    @NonNull
    public static ActivityGalleryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityGalleryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityGalleryBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_gallery, viewGroup, z, obj);
    }

    @NonNull
    public static ActivityGalleryBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityGalleryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityGalleryBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_gallery, null, false, obj);
    }

    public static ActivityGalleryBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityGalleryBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityGalleryBinding) bind(obj, view, C2037R.layout.activity_gallery);
    }
}
