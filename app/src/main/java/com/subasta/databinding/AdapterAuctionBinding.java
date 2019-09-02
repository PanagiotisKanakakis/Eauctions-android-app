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

import de.hdodenhof.circleimageview.CircleImageView;
import com.subasta.C2037R;
import com.subasta.utils.CustomTextView;

import javax.annotation.Nullable;

public abstract class AdapterAuctionBinding extends ViewDataBinding {
    @NonNull
    public final LinearLayout Line1;
    @NonNull
    public final CardView cardView;
    @NonNull
    public final CardView cardView1;
    @NonNull
    public final ImageView ivCatimg;
    @NonNull
    public final CircleImageView ivbid;
    @NonNull
    public final LinearLayout line1;
    @NonNull
    public final RelativeLayout relay2;
    @NonNull
    public final CustomTextView tvAddress;
    @NonNull
    public final CustomTextView tvLocation;
    @NonNull
    public final CustomTextView tvMinBidTxt;
    @NonNull
    public final CustomTextView tvPrice;
    @NonNull
    public final CustomTextView tvProductname;

    protected AdapterAuctionBinding(Object obj, View view, int i, LinearLayout linearLayout, CardView cardView2, CardView cardView3, ImageView imageView, CircleImageView circleImageView, LinearLayout linearLayout2, RelativeLayout relativeLayout, CustomTextView customTextView, CustomTextView customTextView2, CustomTextView customTextView3, CustomTextView customTextView4, CustomTextView customTextView5) {
        super(obj, view, i);
        this.Line1 = linearLayout;
        this.cardView = cardView2;
        this.cardView1 = cardView3;
        this.ivCatimg = imageView;
        this.ivbid = circleImageView;
        this.line1 = linearLayout2;
        this.relay2 = relativeLayout;
        this.tvAddress = customTextView;
        this.tvLocation = customTextView2;
        this.tvMinBidTxt = customTextView3;
        this.tvPrice = customTextView4;
        this.tvProductname = customTextView5;
    }

    @NonNull
    public static AdapterAuctionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static AdapterAuctionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AdapterAuctionBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.adapter_auction, viewGroup, z, obj);
    }

    @NonNull
    public static AdapterAuctionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static AdapterAuctionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (AdapterAuctionBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.adapter_auction, null, false, obj);
    }

    public static AdapterAuctionBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterAuctionBinding bind(@NonNull View view, @Nullable Object obj) {
        return (AdapterAuctionBinding) bind(obj, view, C2037R.layout.adapter_auction);
    }
}
