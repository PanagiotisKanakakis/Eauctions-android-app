package com.subasta.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.subasta.C2037R;
import com.subasta.utils.CustomTextView;
import com.subasta.utils.CustomTextViewBold;

import javax.annotation.Nullable;

public abstract class ActivitySubscriptionPackageBinding extends ViewDataBinding {
    @NonNull
    public final CustomTextView aunctionCount;
    @NonNull
    public final CardView cardView;
    @NonNull
    public final CustomTextView date;
    @NonNull
    public final LinearLayout linear;
    @NonNull
    public final CustomTextViewBold noPackage;
    @NonNull
    public final CustomTextViewBold pkg;
    @NonNull
    public final CustomTextView pkgName;
    @NonNull
    public final CustomTextViewBold price;
    @NonNull
    public final RecyclerView rvplans;
    @NonNull
    public final CustomTextViewBold status;

    protected ActivitySubscriptionPackageBinding(Object obj, View view, int i, CustomTextView customTextView, CardView cardView2, CustomTextView customTextView2, LinearLayout linearLayout, CustomTextViewBold customTextViewBold, CustomTextViewBold customTextViewBold2, CustomTextView customTextView3, CustomTextViewBold customTextViewBold3, RecyclerView recyclerView, CustomTextViewBold customTextViewBold4) {
        super(obj, view, i);
        this.aunctionCount = customTextView;
        this.cardView = cardView2;
        this.date = customTextView2;
        this.linear = linearLayout;
        this.noPackage = customTextViewBold;
        this.pkg = customTextViewBold2;
        this.pkgName = customTextView3;
        this.price = customTextViewBold3;
        this.rvplans = recyclerView;
        this.status = customTextViewBold4;
    }

    @NonNull
    public static ActivitySubscriptionPackageBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivitySubscriptionPackageBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivitySubscriptionPackageBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_subscription_package, viewGroup, z, obj);
    }

    @NonNull
    public static ActivitySubscriptionPackageBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivitySubscriptionPackageBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivitySubscriptionPackageBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_subscription_package, null, false, obj);
    }

    public static ActivitySubscriptionPackageBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivitySubscriptionPackageBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivitySubscriptionPackageBinding) bind(obj, view, C2037R.layout.activity_subscription_package);
    }
}
