package com.subasta.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.subasta.C2037R;
import com.subasta.utils.CustomTextView;

import javax.annotation.Nullable;

public abstract class AdapterSubscriptionStandardBinding extends ViewDataBinding {
    @NonNull
    public final MaterialButton btnupgrade;
    @NonNull
    public final MaterialCardView cvsubscription;
    @NonNull
    public final LinearLayout linercv;
    @NonNull
    public final LinearLayout linerplan;
    @NonNull
    public final CustomTextView status;
    @NonNull
    public final CustomTextView tvaunctioncount;
    @NonNull
    public final CustomTextView tvprice;
    @NonNull
    public final CustomTextView tvstanderd;
    @NonNull
    public final CustomTextView tvtotaldays;

    protected AdapterSubscriptionStandardBinding(Object obj, View view, int i, MaterialButton materialButton, MaterialCardView materialCardView, LinearLayout linearLayout, LinearLayout linearLayout2, CustomTextView customTextView, CustomTextView customTextView2, CustomTextView customTextView3, CustomTextView customTextView4, CustomTextView customTextView5) {
        super(obj, view, i);
        this.btnupgrade = materialButton;
        this.cvsubscription = materialCardView;
        this.linercv = linearLayout;
        this.linerplan = linearLayout2;
        this.status = customTextView;
        this.tvaunctioncount = customTextView2;
        this.tvprice = customTextView3;
        this.tvstanderd = customTextView4;
        this.tvtotaldays = customTextView5;
    }

    @NonNull
    public static AdapterSubscriptionStandardBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static AdapterSubscriptionStandardBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AdapterSubscriptionStandardBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.adapter_subscription_standard, viewGroup, z, obj);
    }

    @NonNull
    public static AdapterSubscriptionStandardBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static AdapterSubscriptionStandardBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (AdapterSubscriptionStandardBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.adapter_subscription_standard, null, false, obj);
    }

    public static AdapterSubscriptionStandardBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterSubscriptionStandardBinding bind(@NonNull View view, @Nullable Object obj) {
        return (AdapterSubscriptionStandardBinding) bind(obj, view, C2037R.layout.adapter_subscription_standard);
    }
}
