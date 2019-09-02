package com.subasta.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.subasta.C2037R;
import com.subasta.utils.CustomTextViewBold;

import javax.annotation.Nullable;

public abstract class ActivityPostAuctionBinding extends ViewDataBinding {
    @NonNull
    public final CardView cardView;
    @NonNull
    public final RecyclerView customgrid;
    @NonNull
    public final ImageView ivBack;
    @NonNull
    public final CustomTextViewBold osTexts;
    @NonNull
    public final RelativeLayout rlHeader;

    protected ActivityPostAuctionBinding(Object obj, View view, int i, CardView cardView2, RecyclerView recyclerView, ImageView imageView, CustomTextViewBold customTextViewBold, RelativeLayout relativeLayout) {
        super(obj, view, i);
        this.cardView = cardView2;
        this.customgrid = recyclerView;
        this.ivBack = imageView;
        this.osTexts = customTextViewBold;
        this.rlHeader = relativeLayout;
    }

    @NonNull
    public static ActivityPostAuctionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityPostAuctionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityPostAuctionBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_post_auction, viewGroup, z, obj);
    }

    @NonNull
    public static ActivityPostAuctionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityPostAuctionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityPostAuctionBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_post_auction, null, false, obj);
    }

    public static ActivityPostAuctionBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityPostAuctionBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityPostAuctionBinding) bind(obj, view, C2037R.layout.activity_post_auction);
    }
}
