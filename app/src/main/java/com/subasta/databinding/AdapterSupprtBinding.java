package com.subasta.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.subasta.C2037R;
import com.subasta.utils.CustomTextView;
import com.subasta.utils.CustomTextViewBold;

import javax.annotation.Nullable;

public abstract class AdapterSupprtBinding extends ViewDataBinding {
    @NonNull
    public final CardView cardView;
    @NonNull
    public final CustomTextViewBold title;
    @NonNull
    public final CustomTextView tvDescription;
    @NonNull
    public final CustomTextViewBold tvStatus;
    @NonNull
    public final CustomTextViewBold tvTime;

    protected AdapterSupprtBinding(Object obj, View view, int i, CardView cardView2, CustomTextViewBold customTextViewBold, CustomTextView customTextView, CustomTextViewBold customTextViewBold2, CustomTextViewBold customTextViewBold3) {
        super(obj, view, i);
        this.cardView = cardView2;
        this.title = customTextViewBold;
        this.tvDescription = customTextView;
        this.tvStatus = customTextViewBold2;
        this.tvTime = customTextViewBold3;
    }

    @NonNull
    public static AdapterSupprtBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static AdapterSupprtBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AdapterSupprtBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.adapter_supprt, viewGroup, z, obj);
    }

    @NonNull
    public static AdapterSupprtBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static AdapterSupprtBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (AdapterSupprtBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.adapter_supprt, null, false, obj);
    }

    public static AdapterSupprtBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterSupprtBinding bind(@NonNull View view, @Nullable Object obj) {
        return (AdapterSupprtBinding) bind(obj, view, C2037R.layout.adapter_supprt);
    }
}
