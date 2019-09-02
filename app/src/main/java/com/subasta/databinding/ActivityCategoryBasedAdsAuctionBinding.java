package com.subasta.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.subasta.C2037R;
import com.subasta.utils.CustomTextView;
import com.subasta.utils.CustomTextViewBold;

import javax.annotation.Nullable;

//import com.github.clans.fab.FloatingActionButton;

public abstract class ActivityCategoryBasedAdsAuctionBinding extends ViewDataBinding {
    @NonNull
    public final CardView cardView;
    @NonNull
    public final SearchView chatSearch;
    @NonNull
    public final FloatingActionButton fabPostAuctionCat;
    @NonNull
    public final CustomTextView ftvNoAuction;
    @NonNull
    public final ActionbarHeaderNavBinding iAHN;
    @NonNull
    public final LinearLayout llAuct;
    @NonNull
    public final View myview;
    @NonNull
    public final RelativeLayout rlAllAuc;
    @NonNull
    public final RelativeLayout rlAuc;
    @NonNull
    public final RecyclerView rvAuction;
    @NonNull
    public final CustomTextViewBold tvNo;
    @NonNull
    public final CustomTextView tvViewMore;

    protected ActivityCategoryBasedAdsAuctionBinding(Object obj, View view, int i, CardView cardView2, SearchView searchView, FloatingActionButton floatingActionButton, CustomTextView customTextView, ActionbarHeaderNavBinding actionbarHeaderNavBinding, LinearLayout linearLayout, View view2, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RecyclerView recyclerView, CustomTextViewBold customTextViewBold, CustomTextView customTextView2) {
        super(obj, view, i);
        this.cardView = cardView2;
        this.chatSearch = searchView;
        this.fabPostAuctionCat = floatingActionButton;
        this.ftvNoAuction = customTextView;
        this.iAHN = actionbarHeaderNavBinding;
        setContainedBinding(this.iAHN);
        this.llAuct = linearLayout;
        this.myview = view2;
        this.rlAllAuc = relativeLayout;
        this.rlAuc = relativeLayout2;
        this.rvAuction = recyclerView;
        this.tvNo = customTextViewBold;
        this.tvViewMore = customTextView2;
    }

    @NonNull
    public static ActivityCategoryBasedAdsAuctionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityCategoryBasedAdsAuctionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityCategoryBasedAdsAuctionBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_category_based_ads_auction, viewGroup, z, obj);
    }

    @NonNull
    public static ActivityCategoryBasedAdsAuctionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityCategoryBasedAdsAuctionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityCategoryBasedAdsAuctionBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_category_based_ads_auction, null, false, obj);
    }

    public static ActivityCategoryBasedAdsAuctionBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityCategoryBasedAdsAuctionBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityCategoryBasedAdsAuctionBinding) bind(obj, view, C2037R.layout.activity_category_based_ads_auction);
    }
}
