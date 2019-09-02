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

import javax.annotation.Nullable;

public abstract class ActivityFavoruiteBinding extends ViewDataBinding {
    @NonNull
    public final ImageView ivBack;

    protected ActivityFavoruiteBinding(Object obj, View view, int i, ImageView imageView) {
        super(obj, view, i);
        this.ivBack = imageView;
    }

    @NonNull
    public static ActivityFavoruiteBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityFavoruiteBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityFavoruiteBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_favoruite, viewGroup, z, obj);
    }

    @NonNull
    public static ActivityFavoruiteBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityFavoruiteBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityFavoruiteBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_favoruite, null, false, obj);
    }

    public static ActivityFavoruiteBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityFavoruiteBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityFavoruiteBinding) bind(obj, view, C2037R.layout.activity_favoruite);
    }
}
