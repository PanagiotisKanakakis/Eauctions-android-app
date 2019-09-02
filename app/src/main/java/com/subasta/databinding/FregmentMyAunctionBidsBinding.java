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

public abstract class FregmentMyAunctionBidsBinding extends ViewDataBinding {
    @NonNull
    public final RecyclerView rvMyBids;
    @NonNull
    public final SwipeRefreshLayout swipeRefreshMybids;
    @NonNull
    public final CustomTextView tvNo;

    protected FregmentMyAunctionBidsBinding(Object obj, View view, int i, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout, CustomTextView customTextView) {
        super(obj, view, i);
        this.rvMyBids = recyclerView;
        this.swipeRefreshMybids = swipeRefreshLayout;
        this.tvNo = customTextView;
    }

    @NonNull
    public static FregmentMyAunctionBidsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static FregmentMyAunctionBidsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FregmentMyAunctionBidsBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.fregment_my_aunction_bids, viewGroup, z, obj);
    }

    @NonNull
    public static FregmentMyAunctionBidsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static FregmentMyAunctionBidsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FregmentMyAunctionBidsBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.fregment_my_aunction_bids, null, false, obj);
    }

    public static FregmentMyAunctionBidsBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FregmentMyAunctionBidsBinding bind(@NonNull View view, @Nullable Object obj) {
        return (FregmentMyAunctionBidsBinding) bind(obj, view, C2037R.layout.fregment_my_aunction_bids);
    }
}
