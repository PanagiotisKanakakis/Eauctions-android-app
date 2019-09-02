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

public abstract class ActivityMainBinding extends ViewDataBinding {
    protected ActivityMainBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    @NonNull
    public static ActivityMainBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityMainBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityMainBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_main, viewGroup, z, obj);
    }

    @NonNull
    public static ActivityMainBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityMainBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityMainBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_main, null, false, obj);
    }

    public static ActivityMainBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityMainBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityMainBinding) bind(obj, view, C2037R.layout.activity_main);
    }
}
