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
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.subasta.C2037R;
import com.subasta.utils.CustomTextViewBold;

import javax.annotation.Nullable;

public abstract class ActivityGetAllRatingBinding extends ViewDataBinding {
    @NonNull
    public final CardView cardView;
    @NonNull
    public final ImageView icRatBack;
    @NonNull
    public final LinearLayout line1;
    @NonNull
    public final CustomTextViewBold nodata;
    @NonNull
    public final RecyclerView rvAllRating;
    @NonNull
    public final SwipeRefreshLayout simpleSwipeRefreshLayout;
    @NonNull
    public final CustomTextViewBold tvTitleRat;

    protected ActivityGetAllRatingBinding(Object obj, View view, int i, CardView cardView2, ImageView imageView, LinearLayout linearLayout, CustomTextViewBold customTextViewBold, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout, CustomTextViewBold customTextViewBold2) {
        super(obj, view, i);
        this.cardView = cardView2;
        this.icRatBack = imageView;
        this.line1 = linearLayout;
        this.nodata = customTextViewBold;
        this.rvAllRating = recyclerView;
        this.simpleSwipeRefreshLayout = swipeRefreshLayout;
        this.tvTitleRat = customTextViewBold2;
    }

    @NonNull
    public static ActivityGetAllRatingBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityGetAllRatingBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityGetAllRatingBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_get_all_rating, viewGroup, z, obj);
    }

    @NonNull
    public static ActivityGetAllRatingBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityGetAllRatingBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityGetAllRatingBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_get_all_rating, null, false, obj);
    }

    public static ActivityGetAllRatingBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityGetAllRatingBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityGetAllRatingBinding) bind(obj, view, C2037R.layout.activity_get_all_rating);
    }
}
