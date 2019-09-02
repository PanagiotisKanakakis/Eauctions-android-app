package com.subasta.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.subasta.C2037R;
import com.subasta.utils.CustomTextViewBold;

import javax.annotation.Nullable;

public abstract class FregmentSubscriptionHistoryBinding extends ViewDataBinding {
    @NonNull
    public final CardView cardView;
    @NonNull
    public final CardView cardView1;
    @NonNull
    public final ImageView icBack;
    @NonNull
    public final RelativeLayout line1;
    @NonNull
    public final RecyclerView rvhistory;
    @NonNull
    public final SearchView svHistory;
    @NonNull
    public final CustomTextViewBold tvCategoryName;
    @NonNull
    public final CustomTextViewBold tvNo;

    protected FregmentSubscriptionHistoryBinding(Object obj, View view, int i, CardView cardView2, CardView cardView3, ImageView imageView, RelativeLayout relativeLayout, RecyclerView recyclerView, SearchView searchView, CustomTextViewBold customTextViewBold, CustomTextViewBold customTextViewBold2) {
        super(obj, view, i);
        this.cardView = cardView2;
        this.cardView1 = cardView3;
        this.icBack = imageView;
        this.line1 = relativeLayout;
        this.rvhistory = recyclerView;
        this.svHistory = searchView;
        this.tvCategoryName = customTextViewBold;
        this.tvNo = customTextViewBold2;
    }

    @NonNull
    public static FregmentSubscriptionHistoryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static FregmentSubscriptionHistoryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FregmentSubscriptionHistoryBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.fregment_subscription_history, viewGroup, z, obj);
    }

    @NonNull
    public static FregmentSubscriptionHistoryBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static FregmentSubscriptionHistoryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FregmentSubscriptionHistoryBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.fregment_subscription_history, null, false, obj);
    }

    public static FregmentSubscriptionHistoryBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FregmentSubscriptionHistoryBinding bind(@NonNull View view, @Nullable Object obj) {
        return (FregmentSubscriptionHistoryBinding) bind(obj, view, C2037R.layout.fregment_subscription_history);
    }
}
