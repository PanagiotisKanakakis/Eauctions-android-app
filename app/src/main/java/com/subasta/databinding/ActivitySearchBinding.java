package com.subasta.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.subasta.C2037R;
import com.subasta.utils.CustomTextView;
import com.subasta.utils.CustomTextViewBold;

import javax.annotation.Nullable;

public abstract class ActivitySearchBinding extends ViewDataBinding {
    @NonNull
    public final CardView cardView;
    @NonNull
    public final ImageView ivBack;
    @NonNull
    public final SearchView search;
    @NonNull
    public final RecyclerView searchAuctionRecycle;
    @NonNull
    public final CustomTextView stringName;
    @NonNull
    public final CustomTextViewBold tvno;

    protected ActivitySearchBinding(Object obj, View view, int i, CardView cardView2, ImageView imageView, SearchView searchView, RecyclerView recyclerView, CustomTextView customTextView, CustomTextViewBold customTextViewBold) {
        super(obj, view, i);
        this.cardView = cardView2;
        this.ivBack = imageView;
        this.search = searchView;
        this.searchAuctionRecycle = recyclerView;
        this.stringName = customTextView;
        this.tvno = customTextViewBold;
    }

    @NonNull
    public static ActivitySearchBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivitySearchBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivitySearchBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_search, viewGroup, z, obj);
    }

    @NonNull
    public static ActivitySearchBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivitySearchBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivitySearchBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_search, null, false, obj);
    }

    public static ActivitySearchBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivitySearchBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivitySearchBinding) bind(obj, view, C2037R.layout.activity_search);
    }
}
