package com.subasta.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.subasta.C2037R;
import com.subasta.utils.CustomTextView;
import com.subasta.utils.CustomTextViewBold;

import javax.annotation.Nullable;

public abstract class AdapterHistoryBinding extends ViewDataBinding {
    @NonNull
    public final CardView cardClick;
    @NonNull
    public final CustomTextView date;
    @NonNull
    public final ImageView dis;
    @NonNull
    public final CustomTextView discount;
    @NonNull
    public final CustomTextViewBold distitle;
    @NonNull
    public final CustomTextViewBold pkgName;
    @NonNull
    public final CustomTextView tax;
    @NonNull
    public final ImageView tax1;
    @NonNull
    public final CustomTextViewBold taxtitle;
    @NonNull
    public final CustomTextView totalPrice;
    @NonNull
    public final CustomTextViewBold validaty;

    protected AdapterHistoryBinding(Object obj, View view, int i, CardView cardView, CustomTextView customTextView, ImageView imageView, CustomTextView customTextView2, CustomTextViewBold customTextViewBold, CustomTextViewBold customTextViewBold2, CustomTextView customTextView3, ImageView imageView2, CustomTextViewBold customTextViewBold3, CustomTextView customTextView4, CustomTextViewBold customTextViewBold4) {
        super(obj, view, i);
        this.cardClick = cardView;
        this.date = customTextView;
        this.dis = imageView;
        this.discount = customTextView2;
        this.distitle = customTextViewBold;
        this.pkgName = customTextViewBold2;
        this.tax = customTextView3;
        this.tax1 = imageView2;
        this.taxtitle = customTextViewBold3;
        this.totalPrice = customTextView4;
        this.validaty = customTextViewBold4;
    }

    @NonNull
    public static AdapterHistoryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static AdapterHistoryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AdapterHistoryBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.adapter_history, viewGroup, z, obj);
    }

    @NonNull
    public static AdapterHistoryBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static AdapterHistoryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (AdapterHistoryBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.adapter_history, null, false, obj);
    }

    public static AdapterHistoryBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterHistoryBinding bind(@NonNull View view, @Nullable Object obj) {
        return (AdapterHistoryBinding) bind(obj, view, C2037R.layout.adapter_history);
    }
}
