package com.subasta.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import de.hdodenhof.circleimageview.CircleImageView;
import com.subasta.C2037R;
import com.subasta.utils.CustomTextView;

import javax.annotation.Nullable;

public abstract class ActivityViewAdvertiseBinding extends ViewDataBinding {
    @NonNull
    public final ImageView ivBack;
    @NonNull
    public final ImageView ivFav11;
    @NonNull
    public final ImageView ivFavfilled;
    @NonNull
    public final ImageView ivGallery;
    @NonNull
    public final CircleImageView ivMap;
    @NonNull
    public final CircleImageView ivProfile;
    @NonNull
    public final ImageView ivShare;
    @NonNull
    public final LinearLayout llChat;
    @NonNull
    public final LinearLayout llOffer;
    @NonNull
    public final LinearLayout llViewImage;
    @NonNull
    public final RatingBar rbReview;
    @NonNull
    public final LinearLayout rlBottom;
    @NonNull
    public final CustomTextView tvAddress;
    @NonNull
    public final CustomTextView tvDate;
    @NonNull
    public final CustomTextView tvDescription;
    @NonNull
    public final CustomTextView tvKm;
    @NonNull
    public final CustomTextView tvName;
    @NonNull
    public final CustomTextView tvPrice;
    @NonNull
    public final CustomTextView tvShortDescription;

    protected ActivityViewAdvertiseBinding(Object obj, View view, int i, Object imageView, Object imageView2, Object imageView3, Object imageView4, Object circleImageView, Object circleImageView2, Object imageView5, Object linearLayout, Object linearLayout2, Object linearLayout3, Object ratingBar, Object linearLayout4, Object customTextView, Object customTextView2, Object customTextView3, Object customTextView4, Object customTextView5, Object customTextView6, Object customTextView7) {
        super(obj, view, i);
        this.ivBack = (ImageView) imageView;
        this.ivFav11 = (ImageView) imageView2;
        this.ivFavfilled = (ImageView) imageView3;
        this.ivGallery = (ImageView) imageView4;
        this.ivMap = (CircleImageView) circleImageView;
        this.ivProfile = (CircleImageView) circleImageView2;
        this.ivShare = (ImageView) imageView5;
        this.llChat = (LinearLayout) linearLayout;
        this.llOffer = (LinearLayout) linearLayout2;
        this.llViewImage = (LinearLayout) linearLayout3;
        this.rbReview = (RatingBar) ratingBar;
        this.rlBottom = (LinearLayout) linearLayout4;
        this.tvAddress = (CustomTextView) customTextView;
        this.tvDate = (CustomTextView) customTextView2;
        this.tvDescription = (CustomTextView) customTextView3;
        this.tvKm = (CustomTextView) customTextView4;
        this.tvName = (CustomTextView) customTextView5;
        this.tvPrice = (CustomTextView) customTextView6;
        this.tvShortDescription = (CustomTextView) customTextView7;
    }

    @NonNull
    public static ActivityViewAdvertiseBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityViewAdvertiseBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityViewAdvertiseBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_view_advertise, viewGroup, z, obj);
    }

    @NonNull
    public static ActivityViewAdvertiseBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityViewAdvertiseBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityViewAdvertiseBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_view_advertise, null, false, obj);
    }

    public static ActivityViewAdvertiseBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityViewAdvertiseBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityViewAdvertiseBinding) bind(obj, view, C2037R.layout.activity_view_advertise);
    }
}
