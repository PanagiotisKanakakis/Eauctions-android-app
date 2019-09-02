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
import com.subasta.utils.CustomEditText;
import com.subasta.utils.CustomTextViewBold;

import javax.annotation.Nullable;

public abstract class ActivityAddBidBinding extends ViewDataBinding {
    @NonNull
    public final CustomButton btnAddBid;
    @NonNull
    public final CardView cardView;
    @NonNull
    public final CustomEditText etBidPrice;
    @NonNull
    public final ImageView ivClose;
    @NonNull
    public final CustomTextViewBold tvBidProductname;
    @NonNull
    public final CustomTextViewBold tvBidProductprice;
    @NonNull
    public final CustomTextViewBold tvtitle;

    protected ActivityAddBidBinding(Object obj, View view, int i, CustomButton customButton, CardView cardView2, CustomEditText customEditText, ImageView imageView, CustomTextViewBold customTextViewBold, CustomTextViewBold customTextViewBold2, CustomTextViewBold customTextViewBold3) {
        super(obj, view, i);
        this.btnAddBid = customButton;
        this.cardView = cardView2;
        this.etBidPrice = customEditText;
        this.ivClose = imageView;
        this.tvBidProductname = customTextViewBold;
        this.tvBidProductprice = customTextViewBold2;
        this.tvtitle = customTextViewBold3;
    }

    @NonNull
    public static ActivityAddBidBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityAddBidBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityAddBidBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_add_bid, viewGroup, z, obj);
    }

    @NonNull
    public static ActivityAddBidBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityAddBidBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityAddBidBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_add_bid, null, false, obj);
    }

    public static ActivityAddBidBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityAddBidBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityAddBidBinding) bind(obj, view, C2037R.layout.activity_add_bid);
    }
}
