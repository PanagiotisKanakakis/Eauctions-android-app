package com.subasta.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.subasta.C2037R;

import javax.annotation.Nullable;

public abstract class FragmentSubscriptionBinding extends ViewDataBinding {
    @NonNull
    public final RecyclerView rvplans;

    protected FragmentSubscriptionBinding(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.rvplans = recyclerView;
    }

    @NonNull
    public static FragmentSubscriptionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static FragmentSubscriptionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentSubscriptionBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.fragment_subscription, viewGroup, z, obj);
    }

    @NonNull
    public static FragmentSubscriptionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static FragmentSubscriptionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentSubscriptionBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.fragment_subscription, null, false, obj);
    }

    public static FragmentSubscriptionBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSubscriptionBinding bind(@NonNull View view, @Nullable Object obj) {
        return (FragmentSubscriptionBinding) bind(obj, view, C2037R.layout.fragment_subscription);
    }
}
