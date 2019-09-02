package com.subasta.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.subasta.C2037R;
import com.subasta.utils.CustomTextViewBold;

import javax.annotation.Nullable;

public abstract class AdapterCategoryBinding extends ViewDataBinding {
    @NonNull
    public final ImageView civCat;
    @NonNull
    public final LinearLayout clcat;
    @NonNull
    public final LinearLayout llcat;
    @NonNull
    public final CustomTextViewBold tvCat;

    protected AdapterCategoryBinding(Object obj, View view, int i, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, CustomTextViewBold customTextViewBold) {
        super(obj, view, i);
        this.civCat = imageView;
        this.clcat = linearLayout;
        this.llcat = linearLayout2;
        this.tvCat = customTextViewBold;
    }

    @NonNull
    public static AdapterCategoryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static AdapterCategoryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AdapterCategoryBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.adapter_category, viewGroup, z, obj);
    }

    @NonNull
    public static AdapterCategoryBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static AdapterCategoryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (AdapterCategoryBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.adapter_category, null, false, obj);
    }

    public static AdapterCategoryBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterCategoryBinding bind(@NonNull View view, @Nullable Object obj) {
        return (AdapterCategoryBinding) bind(obj, view, C2037R.layout.adapter_category);
    }
}
