package com.subasta.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.subasta.C2037R;
import com.subasta.utils.CustomTextView;

import javax.annotation.Nullable;

public abstract class FregmentMyAunctionAunctionsBinding extends ViewDataBinding {
    @NonNull
    public final RecyclerView rvMyAuction;
    @NonNull
    public final SwipeRefreshLayout swipeRefreshMyauction;
    @NonNull
    public final CustomTextView tvNo;

    protected FregmentMyAunctionAunctionsBinding(Object obj, View view, int i, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout, CustomTextView customTextView) {
        super(obj, view, i);
        this.rvMyAuction = recyclerView;
        this.swipeRefreshMyauction = swipeRefreshLayout;
        this.tvNo = customTextView;
    }

    @NonNull
    public static FregmentMyAunctionAunctionsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static FregmentMyAunctionAunctionsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FregmentMyAunctionAunctionsBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.fregment_my_aunction_aunctions, viewGroup, z, obj);
    }

    @NonNull
    public static FregmentMyAunctionAunctionsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static FregmentMyAunctionAunctionsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FregmentMyAunctionAunctionsBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.fregment_my_aunction_aunctions, null, false, obj);
    }

    public static FregmentMyAunctionAunctionsBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FregmentMyAunctionAunctionsBinding bind(@NonNull View view, @Nullable Object obj) {
        return (FregmentMyAunctionAunctionsBinding) bind(obj, view, C2037R.layout.fregment_my_aunction_aunctions);
    }
}
