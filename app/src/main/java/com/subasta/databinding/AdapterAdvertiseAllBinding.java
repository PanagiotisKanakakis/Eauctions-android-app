package com.subasta.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.subasta.C2037R;
import com.subasta.utils.CustomButton;
import com.subasta.utils.CustomTextView;

import javax.annotation.Nullable;

public abstract class AdapterAdvertiseAllBinding extends ViewDataBinding {
    @NonNull
    public final CustomButton btnSignIn;
    @NonNull
    public final CardView cardView;
    @NonNull
    public final ImageView ivProduct;
    @NonNull
    public final LinearLayout line1;
    @NonNull
    public final LinearLayout llRecomm;
    @NonNull
    public final CustomTextView tvLocation;
    @NonNull
    public final CustomTextView tvPrice;
    @NonNull
    public final CustomTextView tvProductname;
    @NonNull
    public final CustomTextView tvTime;

    protected AdapterAdvertiseAllBinding(Object obj, View view, int i, CustomButton customButton, CardView cardView2, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, CustomTextView customTextView, CustomTextView customTextView2, CustomTextView customTextView3, CustomTextView customTextView4) {
        super(obj, view, i);
        this.btnSignIn = customButton;
        this.cardView = cardView2;
        this.ivProduct = imageView;
        this.line1 = linearLayout;
        this.llRecomm = linearLayout2;
        this.tvLocation = customTextView;
        this.tvPrice = customTextView2;
        this.tvProductname = customTextView3;
        this.tvTime = customTextView4;
    }

    @NonNull
    public static AdapterAdvertiseAllBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static AdapterAdvertiseAllBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AdapterAdvertiseAllBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.adapter_advertise_all, viewGroup, z, obj);
    }

    @NonNull
    public static AdapterAdvertiseAllBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static AdapterAdvertiseAllBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (AdapterAdvertiseAllBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.adapter_advertise_all, null, false, obj);
    }

    public static AdapterAdvertiseAllBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterAdvertiseAllBinding bind(@NonNull View view, @Nullable Object obj) {
        return (AdapterAdvertiseAllBinding) bind(obj, view, C2037R.layout.adapter_advertise_all);
    }
}
