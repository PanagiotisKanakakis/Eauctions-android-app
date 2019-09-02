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

public abstract class ActivityPlansBinding extends ViewDataBinding {
    @NonNull
    public final ImageView ivBack;
    @NonNull
    public final RecyclerView rvplans;

    protected ActivityPlansBinding(Object obj, View view, int i, ImageView imageView, RecyclerView recyclerView) {
        super(obj, view, i);
        this.ivBack = imageView;
        this.rvplans = recyclerView;
    }

    @NonNull
    public static ActivityPlansBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityPlansBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityPlansBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_plans, viewGroup, z, obj);
    }

    @NonNull
    public static ActivityPlansBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityPlansBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityPlansBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_plans, null, false, obj);
    }

    public static ActivityPlansBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityPlansBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityPlansBinding) bind(obj, view, C2037R.layout.activity_plans);
    }
}
