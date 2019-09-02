package com.subasta.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.subasta.C2037R;
import com.subasta.utils.CustomTextView;
import com.subasta.utils.CustomTextViewBold;

import javax.annotation.Nullable;

public abstract class ActionbarHeaderNavBinding extends ViewDataBinding {
    @NonNull
    public final RelativeLayout headerBar;
    @NonNull
    public final ImageView ivBack;
    @NonNull
    public final ImageView ivFilter;
    @NonNull
    public final ImageView ivHistory;
    @NonNull
    public final ImageView ivMenu;
    @NonNull
    public final ImageView ivSearch1;
    @NonNull
    public final Spinner spinner1;
    @NonNull
    public final SearchView svHistoryDash;
    @NonNull
    public final CustomTextView tvindrapuri;
    @NonNull
    public final CustomTextViewBold tvtitlemain;

    protected ActionbarHeaderNavBinding(Object obj, View view, int i, RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, Spinner spinner, SearchView searchView, CustomTextView customTextView, CustomTextViewBold customTextViewBold) {
        super(obj, view, i);
        this.headerBar = relativeLayout;
        this.ivBack = imageView;
        this.ivFilter = imageView2;
        this.ivHistory = imageView3;
        this.ivMenu = imageView4;
        this.ivSearch1 = imageView5;
        this.spinner1 = spinner;
        this.svHistoryDash = searchView;
        this.tvindrapuri = customTextView;
        this.tvtitlemain = customTextViewBold;
    }

    @NonNull
    public static ActionbarHeaderNavBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActionbarHeaderNavBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActionbarHeaderNavBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.actionbar_header_nav, viewGroup, z, obj);
    }

    @NonNull
    public static ActionbarHeaderNavBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActionbarHeaderNavBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActionbarHeaderNavBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.actionbar_header_nav, null, false, obj);
    }

    public static ActionbarHeaderNavBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActionbarHeaderNavBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActionbarHeaderNavBinding) bind(obj, view, C2037R.layout.actionbar_header_nav);
    }
}
