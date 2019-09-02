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
import com.subasta.utils.CustomTextViewBold;

import javax.annotation.Nullable;

public abstract class AdapterWonBidsBinding extends ViewDataBinding {
    @NonNull
    public final CardView cardView;
    @NonNull
    public final ImageView iv1;
    @NonNull
    public final CustomTextView tvDate;
    @NonNull
    public final CustomTextViewBold tvPrice;
    @NonNull
    public final CustomTextViewBold tvProPrice;
    @NonNull
    public final CustomTextViewBold tvtitle;

    protected AdapterWonBidsBinding(Object obj, View view, int i, CardView cardView2, ImageView imageView, CustomTextView customTextView, CustomTextViewBold customTextViewBold, CustomTextViewBold customTextViewBold2, CustomTextViewBold customTextViewBold3) {
        super(obj, view, i);
        this.cardView = cardView2;
        this.iv1 = imageView;
        this.tvDate = customTextView;
        this.tvPrice = customTextViewBold;
        this.tvProPrice = customTextViewBold2;
        this.tvtitle = customTextViewBold3;
    }

    @NonNull
    public static AdapterWonBidsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static AdapterWonBidsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AdapterWonBidsBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.adapter_won_bids, viewGroup, z, obj);
    }

    @NonNull
    public static AdapterWonBidsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static AdapterWonBidsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (AdapterWonBidsBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.adapter_won_bids, null, false, obj);
    }

    public static AdapterWonBidsBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterWonBidsBinding bind(@NonNull View view, @Nullable Object obj) {
        return (AdapterWonBidsBinding) bind(obj, view, C2037R.layout.adapter_won_bids);
    }
}
