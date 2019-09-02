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
import com.subasta.utils.CustomTextView;

import javax.annotation.Nullable;

public abstract class AdapterItemMyAdsBinding extends ViewDataBinding {
    @NonNull
    public final CardView cardView;
    @NonNull
    public final ImageView iv1;
    @NonNull
    public final CustomTextView tvDescription;
    @NonNull
    public final CustomTextView tvPrice;
    @NonNull
    public final CustomTextView tvtitle;

    protected AdapterItemMyAdsBinding(Object obj, View view, int i, CardView cardView2, ImageView imageView, CustomTextView customTextView, CustomTextView customTextView2, CustomTextView customTextView3) {
        super(obj, view, i);
        this.cardView = cardView2;
        this.iv1 = imageView;
        this.tvDescription = customTextView;
        this.tvPrice = customTextView2;
        this.tvtitle = customTextView3;
    }

    @NonNull
    public static AdapterItemMyAdsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static AdapterItemMyAdsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AdapterItemMyAdsBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.adapter_item_my_ads, viewGroup, z, obj);
    }

    @NonNull
    public static AdapterItemMyAdsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static AdapterItemMyAdsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (AdapterItemMyAdsBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.adapter_item_my_ads, null, false, obj);
    }

    public static AdapterItemMyAdsBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemMyAdsBinding bind(@NonNull View view, @Nullable Object obj) {
        return (AdapterItemMyAdsBinding) bind(obj, view, C2037R.layout.adapter_item_my_ads);
    }
}
