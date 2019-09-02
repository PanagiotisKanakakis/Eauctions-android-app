package com.subasta.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.subasta.C2037R;

import javax.annotation.Nullable;

public abstract class ActivitySplashBinding extends ViewDataBinding {
    protected ActivitySplashBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    @NonNull
    public static ActivitySplashBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivitySplashBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivitySplashBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_splash, viewGroup, z, obj);
    }

    @NonNull
    public static ActivitySplashBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivitySplashBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivitySplashBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_splash, null, false, obj);
    }

    public static ActivitySplashBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivitySplashBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivitySplashBinding) bind(obj, view, C2037R.layout.activity_splash);
    }
}
