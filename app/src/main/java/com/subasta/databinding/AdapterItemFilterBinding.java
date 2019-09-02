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

public abstract class AdapterItemFilterBinding extends ViewDataBinding {
    @NonNull
    public final ImageView civCat;
    @NonNull
    public final LinearLayout llCategory;
    @NonNull
    public final LinearLayout llcat;
    @NonNull
    public final CustomTextViewBold tvCatN;

    protected AdapterItemFilterBinding(Object obj, View view, int i, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, CustomTextViewBold customTextViewBold) {
        super(obj, view, i);
        this.civCat = imageView;
        this.llCategory = linearLayout;
        this.llcat = linearLayout2;
        this.tvCatN = customTextViewBold;
    }

    @NonNull
    public static AdapterItemFilterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static AdapterItemFilterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AdapterItemFilterBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.adapter_item_filter, viewGroup, z, obj);
    }

    @NonNull
    public static AdapterItemFilterBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static AdapterItemFilterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (AdapterItemFilterBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.adapter_item_filter, null, false, obj);
    }

    public static AdapterItemFilterBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemFilterBinding bind(@NonNull View view, @Nullable Object obj) {
        return (AdapterItemFilterBinding) bind(obj, view, C2037R.layout.adapter_item_filter);
    }
}
