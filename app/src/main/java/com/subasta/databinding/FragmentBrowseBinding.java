package com.subasta.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.subasta.C2037R;
import com.subasta.utils.CustomButton;
import com.subasta.utils.CustomTextView;

import javax.annotation.Nullable;

public abstract class FragmentBrowseBinding extends ViewDataBinding {
    @NonNull
    public final ConstraintLayout brActivity;
    @NonNull
    public final CustomButton btnViewAllAuc;
    @NonNull
    public final FloatingActionButton fabPostAuction;
    @NonNull
    public final CustomTextView ftvNoAuction;
    @NonNull
    public final LinearLayout llBrCatagory;
    @NonNull
    public final LinearLayout llDisc;
    @NonNull
    public final LinearLayout llLoca;
    @NonNull
    public final RelativeLayout rlAuc;
    @NonNull
    public final RecyclerView rvAuction;
    @NonNull
    public final RecyclerView rvChosse;
    @NonNull
    public final CustomTextView tvDes;

    protected FragmentBrowseBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, CustomButton customButton, FloatingActionButton floatingActionButton, CustomTextView customTextView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, RelativeLayout relativeLayout, RecyclerView recyclerView, RecyclerView recyclerView2, CustomTextView customTextView2) {
        super(obj, view, i);
        this.brActivity = constraintLayout;
        this.btnViewAllAuc = customButton;
        this.fabPostAuction = floatingActionButton;
        this.ftvNoAuction = customTextView;
        this.llBrCatagory = linearLayout;
        this.llDisc = linearLayout2;
        this.llLoca = linearLayout3;
        this.rlAuc = relativeLayout;
        this.rvAuction = recyclerView;
        this.rvChosse = recyclerView2;
        this.tvDes = customTextView2;
    }

    @NonNull
    public static FragmentBrowseBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static FragmentBrowseBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentBrowseBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.fragment_browse, viewGroup, z, obj);
    }

    @NonNull
    public static FragmentBrowseBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static FragmentBrowseBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentBrowseBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.fragment_browse, null, false, obj);
    }

    public static FragmentBrowseBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentBrowseBinding bind(@NonNull View view, @Nullable Object obj) {
        return (FragmentBrowseBinding) bind(obj, view, C2037R.layout.fragment_browse);
    }
}
