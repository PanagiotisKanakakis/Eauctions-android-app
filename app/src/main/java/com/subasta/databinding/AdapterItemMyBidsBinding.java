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
import com.subasta.utils.CustomButton;
import com.subasta.utils.CustomTextView;
import com.subasta.utils.CustomTextViewBold;

import javax.annotation.Nullable;

public abstract class AdapterItemMyBidsBinding extends ViewDataBinding {
    @NonNull
    public final LinearLayout Line1;
    @NonNull
    public final CustomButton btnDelete;
    @NonNull
    public final CustomButton btnEdit;
    @NonNull
    public final CardView cardView;
    @NonNull
    public final ImageView image;
    @NonNull
    public final LinearLayout line1;
    @NonNull
    public final LinearLayout line2;
    @NonNull
    public final RelativeLayout relay2;
    @NonNull
    public final CustomTextViewBold tvAuctionPrice;
    @NonNull
    public final CustomTextView tvLocation;
    @NonNull
    public final CustomTextView tvMinBidTxt;
    @NonNull
    public final CustomTextViewBold tvPrice;
    @NonNull
    public final CustomTextViewBold tvProductname;

    protected AdapterItemMyBidsBinding(Object obj, View view, int i, Object linearLayout, Object customButton, Object customButton2, Object cardView2, Object imageView, Object linearLayout2, Object linearLayout3, Object relativeLayout, Object customTextViewBold, Object customTextView, Object customTextView2, Object customTextViewBold2, Object customTextViewBold3) {
        super(obj, view, i);
        this.Line1 = (LinearLayout) linearLayout;
        this.btnDelete = (CustomButton) customButton;
        this.btnEdit = (CustomButton) customButton2;
        this.cardView = (CardView) cardView2;
        this.image = (ImageView) imageView;
        this.line1 = (LinearLayout) linearLayout2;
        this.line2 = (LinearLayout) linearLayout3;
        this.relay2 = (RelativeLayout) relativeLayout;
        this.tvAuctionPrice = (CustomTextViewBold) customTextViewBold;
        this.tvLocation = (CustomTextView) customTextView;
        this.tvMinBidTxt = (CustomTextView) customTextView2;
        this.tvPrice = (CustomTextViewBold) customTextViewBold2;
        this.tvProductname = (CustomTextViewBold) customTextViewBold3;
    }

    @NonNull
    public static AdapterItemMyBidsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static AdapterItemMyBidsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AdapterItemMyBidsBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.adapter_item_my_bids, viewGroup, z, obj);
    }

    @NonNull
    public static AdapterItemMyBidsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static AdapterItemMyBidsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (AdapterItemMyBidsBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.adapter_item_my_bids, null, false, obj);
    }

    public static AdapterItemMyBidsBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemMyBidsBinding bind(@NonNull View view, @Nullable Object obj) {
        return (AdapterItemMyBidsBinding) bind(obj, view, C2037R.layout.adapter_item_my_bids);
    }
}
