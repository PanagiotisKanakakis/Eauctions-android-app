package com.subasta.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import de.hdodenhof.circleimageview.CircleImageView;
import com.subasta.C2037R;
import com.subasta.utils.CustomButton;
import com.subasta.utils.CustomTextView;
import com.subasta.utils.CustomTextViewBold;

import javax.annotation.Nullable;

public abstract class AdapterViewauntionBidBinding extends ViewDataBinding {
    @NonNull
    public final CardView cardView;
    @NonNull
    public final CardView cvBid;
    @NonNull
    public final CircleImageView ivProfilePic;
    @NonNull
    public final CustomTextViewBold tvdate;
    @NonNull
    public final CustomTextView tvname;
    @NonNull
    public final CustomTextViewBold tvprice;
    @NonNull
    public final CustomButton wintag;

    protected AdapterViewauntionBidBinding(Object obj, View view, int i, CardView cardView2, CardView cardView3, CircleImageView circleImageView, CustomTextViewBold customTextViewBold, CustomTextView customTextView, CustomTextViewBold customTextViewBold2, CustomButton customButton) {
        super(obj, view, i);
        this.cardView = cardView2;
        this.cvBid = cardView3;
        this.ivProfilePic = circleImageView;
        this.tvdate = customTextViewBold;
        this.tvname = customTextView;
        this.tvprice = customTextViewBold2;
        this.wintag = customButton;
    }

    @NonNull
    public static AdapterViewauntionBidBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static AdapterViewauntionBidBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AdapterViewauntionBidBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.adapter_viewauntion_bid, viewGroup, z, obj);
    }

    @NonNull
    public static AdapterViewauntionBidBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static AdapterViewauntionBidBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (AdapterViewauntionBidBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.adapter_viewauntion_bid, null, false, obj);
    }

    public static AdapterViewauntionBidBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterViewauntionBidBinding bind(@NonNull View view, @Nullable Object obj) {
        return (AdapterViewauntionBidBinding) bind(obj, view, C2037R.layout.adapter_viewauntion_bid);
    }
}
