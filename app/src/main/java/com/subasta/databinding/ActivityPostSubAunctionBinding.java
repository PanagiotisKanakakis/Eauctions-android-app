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

import com.subasta.C2037R;
import com.subasta.utils.CustomTextViewBold;

import javax.annotation.Nullable;

public abstract class ActivityPostSubAunctionBinding extends ViewDataBinding {
    @NonNull
    public final CardView cardView;
    @NonNull
    public final ImageView icBack;
    @NonNull
    public final LinearLayout line1;
    @NonNull
    public final LinearLayout line2;
    @NonNull
    public final RecyclerView rvSubCategory;
    @NonNull
    public final CustomTextViewBold tvCategoryName;

    protected ActivityPostSubAunctionBinding(Object obj, View view, int i, CardView cardView2, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, RecyclerView recyclerView, CustomTextViewBold customTextViewBold) {
        super(obj, view, i);
        this.cardView = cardView2;
        this.icBack = imageView;
        this.line1 = linearLayout;
        this.line2 = linearLayout2;
        this.rvSubCategory = recyclerView;
        this.tvCategoryName = customTextViewBold;
    }

    @NonNull
    public static ActivityPostSubAunctionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityPostSubAunctionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityPostSubAunctionBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_post_sub_aunction, viewGroup, z, obj);
    }

    @NonNull
    public static ActivityPostSubAunctionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityPostSubAunctionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityPostSubAunctionBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_post_sub_aunction, null, false, obj);
    }

    public static ActivityPostSubAunctionBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityPostSubAunctionBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityPostSubAunctionBinding) bind(obj, view, C2037R.layout.activity_post_sub_aunction);
    }
}
