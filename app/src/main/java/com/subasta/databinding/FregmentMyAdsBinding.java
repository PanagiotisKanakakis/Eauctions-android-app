package com.subasta.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.subasta.C2037R;
import com.subasta.utils.CustomTextView;

import javax.annotation.Nullable;

public abstract class FregmentMyAdsBinding extends ViewDataBinding {
    @NonNull
    public final RecyclerView recycleview1;
    @NonNull
    public final SwipeRefreshLayout swipeRefreshLayout;
    @NonNull
    public final CustomTextView tvFavourites;
    @NonNull
    public final CustomTextView tvFavouritesSelect;
    @NonNull
    public final CustomTextView tvNo;
    @NonNull
    public final CustomTextView tvSelling;
    @NonNull
    public final CustomTextView tvSellingSelect;
    @NonNull
    public final CustomTextView tvSold;
    @NonNull
    public final CustomTextView tvSoldSelect;

    protected FregmentMyAdsBinding(Object obj, View view, int i, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout2, CustomTextView customTextView, CustomTextView customTextView2, CustomTextView customTextView3, CustomTextView customTextView4, CustomTextView customTextView5, CustomTextView customTextView6, CustomTextView customTextView7) {
        super(obj, view, i);
        this.recycleview1 = recyclerView;
        this.swipeRefreshLayout = swipeRefreshLayout2;
        this.tvFavourites = customTextView;
        this.tvFavouritesSelect = customTextView2;
        this.tvNo = customTextView3;
        this.tvSelling = customTextView4;
        this.tvSellingSelect = customTextView5;
        this.tvSold = customTextView6;
        this.tvSoldSelect = customTextView7;
    }

    @NonNull
    public static FregmentMyAdsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static FregmentMyAdsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FregmentMyAdsBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.fregment_my_ads, viewGroup, z, obj);
    }

    @NonNull
    public static FregmentMyAdsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static FregmentMyAdsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FregmentMyAdsBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.fregment_my_ads, null, false, obj);
    }

    public static FregmentMyAdsBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FregmentMyAdsBinding bind(@NonNull View view, @Nullable Object obj) {
        return (FregmentMyAdsBinding) bind(obj, view, C2037R.layout.fregment_my_ads);
    }
}
