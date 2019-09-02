package com.subasta.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.subasta.C2037R;
import com.subasta.utils.CustomTextView;
import com.subasta.utils.CustomTextViewBold;

import javax.annotation.Nullable;

public abstract class FregmentMyAuctionBinding extends ViewDataBinding {
    @NonNull
    public final FrameLayout container;
    @NonNull
    public final LinearLayout llmyauction;
    @NonNull
    public final LinearLayout llmybids;
    @NonNull
    public final LinearLayout llmyfavourites;
    @NonNull
    public final LinearLayout llmywonbids;
    @NonNull
    public final CustomTextView tvAuctionSelect;
    @NonNull
    public final CustomTextView tvBidsSelect;
    @NonNull
    public final CustomTextViewBold tvFavourites;
    @NonNull
    public final CustomTextView tvFavouritesSelect;
    @NonNull
    public final CustomTextViewBold tvmyauction;
    @NonNull
    public final CustomTextViewBold tvmybids;
    @NonNull
    public final CustomTextView tvwonBidsSelect;
    @NonNull
    public final CustomTextViewBold tvwonbids;

    protected FregmentMyAuctionBinding(Object obj, View view, int i, Object frameLayout, Object linearLayout, Object linearLayout2, Object linearLayout3, Object linearLayout4, Object customTextView, Object customTextView2, Object customTextViewBold, Object customTextView3, Object customTextViewBold2, Object customTextViewBold3, Object customTextView4, Object customTextViewBold4) {
        super(obj, view, i);
        this.container = (FrameLayout) frameLayout;
        this.llmyauction = (LinearLayout) linearLayout;
        this.llmybids = (LinearLayout) linearLayout2;
        this.llmyfavourites = (LinearLayout) linearLayout3;
        this.llmywonbids = (LinearLayout) linearLayout4;
        this.tvAuctionSelect = (CustomTextView) customTextView;
        this.tvBidsSelect = (CustomTextView) customTextView2;
        this.tvFavourites = (CustomTextViewBold) customTextViewBold;
        this.tvFavouritesSelect = (CustomTextView) customTextView3;
        this.tvmyauction = (CustomTextViewBold) customTextViewBold2;
        this.tvmybids = (CustomTextViewBold) customTextViewBold3;
        this.tvwonBidsSelect = (CustomTextView) customTextView4;
        this.tvwonbids = (CustomTextViewBold) customTextViewBold4;
    }

    @NonNull
    public static FregmentMyAuctionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static FregmentMyAuctionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FregmentMyAuctionBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.fregment_my_auction, viewGroup, z, obj);
    }

    @NonNull
    public static FregmentMyAuctionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static FregmentMyAuctionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FregmentMyAuctionBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.fregment_my_auction, null, false, obj);
    }

    public static FregmentMyAuctionBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FregmentMyAuctionBinding bind(@NonNull View view, @Nullable Object obj) {
        return (FregmentMyAuctionBinding) bind(obj, view, C2037R.layout.fregment_my_auction);
    }
}
