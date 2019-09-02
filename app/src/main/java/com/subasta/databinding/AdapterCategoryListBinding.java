package com.subasta.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.subasta.C2037R;
import com.subasta.utils.CustomTextViewBold;

import javax.annotation.Nullable;

public abstract class AdapterCategoryListBinding extends ViewDataBinding {
    @NonNull
    public final ImageView civCat;
    @NonNull
    public final CheckBox iv1;
    @NonNull
    public final LinearLayout line1;
    @NonNull
    public final LinearLayout llcat;
    @NonNull
    public final CustomTextViewBold tvCat;

    protected AdapterCategoryListBinding(Object obj, View view, int i, ImageView imageView, CheckBox checkBox, LinearLayout linearLayout, LinearLayout linearLayout2, CustomTextViewBold customTextViewBold) {
        super(obj, view, i);
        this.civCat = imageView;
        this.iv1 = checkBox;
        this.line1 = linearLayout;
        this.llcat = linearLayout2;
        this.tvCat = customTextViewBold;
    }

    @NonNull
    public static AdapterCategoryListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static AdapterCategoryListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AdapterCategoryListBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.adapter_category_list, viewGroup, z, obj);
    }

    @NonNull
    public static AdapterCategoryListBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static AdapterCategoryListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (AdapterCategoryListBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.adapter_category_list, null, false, obj);
    }

    public static AdapterCategoryListBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterCategoryListBinding bind(@NonNull View view, @Nullable Object obj) {
        return (AdapterCategoryListBinding) bind(obj, view, C2037R.layout.adapter_category_list);
    }
}
