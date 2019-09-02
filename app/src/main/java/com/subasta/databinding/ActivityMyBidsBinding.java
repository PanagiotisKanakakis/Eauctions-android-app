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

import javax.annotation.Nullable;

public abstract class ActivityMyBidsBinding extends ViewDataBinding {
    @NonNull
    public final LinearLayout Line1;
    @NonNull
    public final CardView cardView;
    @NonNull
    public final CardView cardView1;
    @NonNull
    public final CardView cardView2;
    @NonNull
    public final ImageView image;
    @NonNull
    public final LinearLayout line1;
    @NonNull
    public final LinearLayout line2;
    @NonNull
    public final RelativeLayout relay2;
    @NonNull
    public final CustomTextView tvAddress;
    @NonNull
    public final CustomTextView tvLocation;
    @NonNull
    public final CustomTextView tvMinBidTxt;
    @NonNull
    public final CustomTextView tvProductname;

    protected ActivityMyBidsBinding(Object obj, View view, int i, LinearLayout linearLayout, CardView cardView3, CardView cardView4, CardView cardView5, ImageView imageView, LinearLayout linearLayout2, LinearLayout linearLayout3, RelativeLayout relativeLayout, CustomTextView customTextView, CustomTextView customTextView2, CustomTextView customTextView3, CustomTextView customTextView4) {
        super(obj, view, i);
        this.Line1 = linearLayout;
        this.cardView = cardView3;
        this.cardView1 = cardView4;
        this.cardView2 = cardView5;
        this.image = imageView;
        this.line1 = linearLayout2;
        this.line2 = linearLayout3;
        this.relay2 = relativeLayout;
        this.tvAddress = customTextView;
        this.tvLocation = customTextView2;
        this.tvMinBidTxt = customTextView3;
        this.tvProductname = customTextView4;
    }

    @NonNull
    public static ActivityMyBidsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityMyBidsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityMyBidsBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_my_bids, viewGroup, z, obj);
    }

    @NonNull
    public static ActivityMyBidsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityMyBidsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityMyBidsBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_my_bids, null, false, obj);
    }

    public static ActivityMyBidsBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityMyBidsBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityMyBidsBinding) bind(obj, view, C2037R.layout.activity_my_bids);
    }
}
