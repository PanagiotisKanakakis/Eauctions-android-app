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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.subasta.C2037R;
import com.subasta.utils.CustomTextViewBold;

import javax.annotation.Nullable;

public abstract class ActivitySupportAcitivityBinding extends ViewDataBinding {
    @NonNull
    public final CardView cardView;
    @NonNull
    public final CardView cardView1;
    @NonNull
    public final SearchView chatSearch;
    @NonNull
    public final ImageView icBack;
    @NonNull
    public final RelativeLayout line1;
    @NonNull
    public final FloatingActionButton myFAB;
    @NonNull
    public final RecyclerView recycleview1;
    @NonNull
    public final SwipeRefreshLayout swipeRefreshLayout;
    @NonNull
    public final CustomTextViewBold tvCategoryName;
    @NonNull
    public final CustomTextViewBold tvNo;

    protected ActivitySupportAcitivityBinding(Object obj, View view, int i, CardView cardView2, CardView cardView3, SearchView searchView, ImageView imageView, RelativeLayout relativeLayout, FloatingActionButton floatingActionButton, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout2, CustomTextViewBold customTextViewBold, CustomTextViewBold customTextViewBold2) {
        super(obj, view, i);
        this.cardView = cardView2;
        this.cardView1 = cardView3;
        this.chatSearch = searchView;
        this.icBack = imageView;
        this.line1 = relativeLayout;
        this.myFAB = floatingActionButton;
        this.recycleview1 = recyclerView;
        this.swipeRefreshLayout = swipeRefreshLayout2;
        this.tvCategoryName = customTextViewBold;
        this.tvNo = customTextViewBold2;
    }

    @NonNull
    public static ActivitySupportAcitivityBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivitySupportAcitivityBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivitySupportAcitivityBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_support_acitivity, viewGroup, z, obj);
    }

    @NonNull
    public static ActivitySupportAcitivityBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivitySupportAcitivityBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivitySupportAcitivityBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_support_acitivity, null, false, obj);
    }

    public static ActivitySupportAcitivityBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivitySupportAcitivityBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivitySupportAcitivityBinding) bind(obj, view, C2037R.layout.activity_support_acitivity);
    }
}
