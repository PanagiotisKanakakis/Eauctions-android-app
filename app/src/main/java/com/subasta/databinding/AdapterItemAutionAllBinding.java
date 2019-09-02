package com.subasta.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.subasta.C2037R;
import com.subasta.utils.CustomTextView;
import com.subasta.utils.CustomTextViewBold;

import javax.annotation.Nullable;

import de.hdodenhof.circleimageview.CircleImageView;

public abstract class AdapterItemAutionAllBinding extends ViewDataBinding {
    @NonNull
    public final LinearLayout Line1;
    @NonNull
    public final CardView cardView;
    @NonNull
    public final CardView cardView1;
    @NonNull
    public final ImageView image;
    @NonNull
    public final CircleImageView ivbid;
    @NonNull
    public final RelativeLayout relay2;
    @NonNull
    public final CustomTextView tvAddress;
    @NonNull
    public final CustomTextView tvLocation;
    @NonNull
    public final CustomTextView tvMinBidTxt;
    @NonNull
    public final CustomTextViewBold tvPrice;
    @NonNull
    public final CustomTextViewBold tvProductname;

    protected AdapterItemAutionAllBinding(Object obj, View view, int i, LinearLayout linearLayout, CardView cardView2, CardView cardView3, ImageView imageView, CircleImageView circleImageView, RelativeLayout relativeLayout, CustomTextView customTextView, CustomTextView customTextView2, CustomTextView customTextView3, CustomTextViewBold customTextViewBold, CustomTextViewBold customTextViewBold2) {
        super(obj, view, i);
        this.Line1 = linearLayout;
        this.cardView = cardView2;
        this.cardView1 = cardView3;
        this.image = imageView;
        this.ivbid = circleImageView;
        this.relay2 = relativeLayout;
        this.tvAddress = customTextView;
        this.tvLocation = customTextView2;
        this.tvMinBidTxt = customTextView3;
        this.tvPrice = customTextViewBold;
        this.tvProductname = customTextViewBold2;
    }

    @NonNull
    public static AdapterItemAutionAllBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static AdapterItemAutionAllBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AdapterItemAutionAllBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.adapter_item_aution_all, viewGroup, z, obj);
    }

    @NonNull
    public static AdapterItemAutionAllBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static AdapterItemAutionAllBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (AdapterItemAutionAllBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.adapter_item_aution_all, null, false, obj);
    }

    public static AdapterItemAutionAllBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemAutionAllBinding bind(@NonNull View view, @Nullable Object obj) {
        return (AdapterItemAutionAllBinding) bind(obj, view, C2037R.layout.adapter_item_aution_all);
    }
}
