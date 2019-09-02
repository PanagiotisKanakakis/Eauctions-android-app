package com.subasta.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.subasta.C2037R;
import com.subasta.utils.CustomButton;
import com.subasta.utils.CustomTextView;
import com.subasta.utils.CustomTextViewBold;

import javax.annotation.Nullable;

public abstract class AdapterItemMyAunctionBinding extends ViewDataBinding {
    @NonNull
    public final CustomButton btnDelete;
    @NonNull
    public final CustomButton btnEdit;
    @NonNull
    public final CardView cardView;
    @NonNull
    public final ImageView iv1;
    @NonNull
    public final CustomTextView tvDate;
    @NonNull
    public final CustomTextViewBold tvPrice;
    @NonNull
    public final CustomTextViewBold tvtitle;

    protected AdapterItemMyAunctionBinding(Object obj, View view, int i, CustomButton customButton, CustomButton customButton2, CardView cardView2, ImageView imageView, CustomTextView customTextView, CustomTextViewBold customTextViewBold, CustomTextViewBold customTextViewBold2) {
        super(obj, view, i);
        this.btnDelete = customButton;
        this.btnEdit = customButton2;
        this.cardView = cardView2;
        this.iv1 = imageView;
        this.tvDate = customTextView;
        this.tvPrice = customTextViewBold;
        this.tvtitle = customTextViewBold2;
    }

    @NonNull
    public static AdapterItemMyAunctionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static AdapterItemMyAunctionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AdapterItemMyAunctionBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.adapter_item_my_aunction, viewGroup, z, obj);
    }

    @NonNull
    public static AdapterItemMyAunctionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static AdapterItemMyAunctionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (AdapterItemMyAunctionBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.adapter_item_my_aunction, null, false, obj);
    }

    public static AdapterItemMyAunctionBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemMyAunctionBinding bind(@NonNull View view, @Nullable Object obj) {
        return (AdapterItemMyAunctionBinding) bind(obj, view, C2037R.layout.adapter_item_my_aunction);
    }
}
