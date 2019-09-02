package com.subasta.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.subasta.C2037R;
import com.subasta.utils.CustomTextViewBold;

import javax.annotation.Nullable;

public abstract class ItemPostAunctionBinding extends ViewDataBinding {
    @NonNull
    public final ImageView civCat;
    @NonNull
    public final LinearLayout llAuction;
    @NonNull
    public final LinearLayout llcat;
    @NonNull
    public final CustomTextViewBold osTexts;
    @NonNull
    public final RelativeLayout rlCat;

    protected ItemPostAunctionBinding(Object obj, View view, int i, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, CustomTextViewBold customTextViewBold, RelativeLayout relativeLayout) {
        super(obj, view, i);
        this.civCat = imageView;
        this.llAuction = linearLayout;
        this.llcat = linearLayout2;
        this.osTexts = customTextViewBold;
        this.rlCat = relativeLayout;
    }

    @NonNull
    public static ItemPostAunctionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ItemPostAunctionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemPostAunctionBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.item_post_aunction, viewGroup, z, obj);
    }

    @NonNull
    public static ItemPostAunctionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ItemPostAunctionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemPostAunctionBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.item_post_aunction, null, false, obj);
    }

    public static ItemPostAunctionBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPostAunctionBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ItemPostAunctionBinding) bind(obj, view, C2037R.layout.item_post_aunction);
    }
}
