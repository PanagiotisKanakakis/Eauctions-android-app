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

public abstract class AdapterMyfavBinding extends ViewDataBinding {
    @NonNull
    public final CustomButton btnRemove;
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

    protected AdapterMyfavBinding(Object obj, View view, int i, CustomButton customButton, CardView cardView2, ImageView imageView, CustomTextView customTextView, CustomTextViewBold customTextViewBold, CustomTextViewBold customTextViewBold2) {
        super(obj, view, i);
        this.btnRemove = customButton;
        this.cardView = cardView2;
        this.iv1 = imageView;
        this.tvDate = customTextView;
        this.tvPrice = customTextViewBold;
        this.tvtitle = customTextViewBold2;
    }

    @NonNull
    public static AdapterMyfavBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static AdapterMyfavBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AdapterMyfavBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.adapter_myfav, viewGroup, z, obj);
    }

    @NonNull
    public static AdapterMyfavBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static AdapterMyfavBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (AdapterMyfavBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.adapter_myfav, null, false, obj);
    }

    public static AdapterMyfavBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterMyfavBinding bind(@NonNull View view, @Nullable Object obj) {
        return (AdapterMyfavBinding) bind(obj, view, C2037R.layout.adapter_myfav);
    }
}
