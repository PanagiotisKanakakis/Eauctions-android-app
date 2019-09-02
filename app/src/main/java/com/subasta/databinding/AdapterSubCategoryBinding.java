package com.subasta.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.subasta.C2037R;
import com.subasta.utils.CustomTextView;

import javax.annotation.Nullable;

public abstract class AdapterSubCategoryBinding extends ViewDataBinding {
    @NonNull
    public final RelativeLayout relSubCat;
    @NonNull
    public final CustomTextView tvtitle;

    protected AdapterSubCategoryBinding(Object obj, View view, int i, RelativeLayout relativeLayout, CustomTextView customTextView) {
        super(obj, view, i);
        this.relSubCat = relativeLayout;
        this.tvtitle = customTextView;
    }

    @NonNull
    public static AdapterSubCategoryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static AdapterSubCategoryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AdapterSubCategoryBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.adapter_sub_category, viewGroup, z, obj);
    }

    @NonNull
    public static AdapterSubCategoryBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static AdapterSubCategoryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (AdapterSubCategoryBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.adapter_sub_category, null, false, obj);
    }

    public static AdapterSubCategoryBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterSubCategoryBinding bind(@NonNull View view, @Nullable Object obj) {
        return (AdapterSubCategoryBinding) bind(obj, view, C2037R.layout.adapter_sub_category);
    }
}
