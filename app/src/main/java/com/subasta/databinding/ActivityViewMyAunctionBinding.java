package com.subasta.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;
import com.subasta.C2037R;
import com.subasta.utils.CustomTextView;
import com.subasta.utils.CustomTextViewBold;
import com.willy.ratingbar.ScaleRatingBar;

import javax.annotation.Nullable;

public abstract class ActivityViewMyAunctionBinding extends ViewDataBinding {
    @NonNull
    public final Button btnDelete;
    @NonNull
    public final Button btnEdit;
    @NonNull
    public final CustomTextViewBold catname;
    @NonNull
    public final CircleImageView deactivate;
    @NonNull
    public final ImageView imgegallery;
    @NonNull
    public final ImageView ivBack;
    @NonNull
    public final ImageView ivFav;
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
    public final LinearLayout linRating;
    @NonNull
    public final LinearLayout linear;
    @NonNull
    public final LinearLayout llClick;
    @NonNull
    public final LinearLayout llViewImage;
    @NonNull
    public final LinearLayout rlBottom;
    @NonNull
    public final RecyclerView rvAllRating;
    @NonNull
    public final RecyclerView rvBids;
    @NonNull
    public final ScaleRatingBar simpleRatingBar1;
    @NonNull
    public final CustomTextView tvAddress;
    @NonNull
    public final CustomTextView tvDate;
    @NonNull
    public final CustomTextView tvDescription;
    @NonNull
    public final CustomTextViewBold tvKm;
    @NonNull
    public final CustomTextView tvMediaCount;
    @NonNull
    public final CustomTextViewBold tvName;
    @NonNull
    public final CustomTextViewBold tvPrice;
    @NonNull
    public final CustomTextView tvShortDescription;
    @NonNull
    public final CustomTextViewBold tvViewAllBid;
    @NonNull
    public final CustomTextViewBold tvViewRating;

    protected ActivityViewMyAunctionBinding(Object obj, View view, int i, Object button, Object button2, Object customTextViewBold, Object circleImageView, Object imageView, Object imageView2, Object imageView3, Object imageView4, Object imageView5, Object circleImageView2, Object circleImageView3, Object imageView6, Object linearLayout, Object linearLayout2, Object linearLayout3, Object linearLayout4, Object linearLayout5, Object recyclerView, Object recyclerView2, Object scaleRatingBar, Object customTextView, Object customTextView2, Object customTextView3, Object customTextViewBold2, Object customTextView4, Object customTextViewBold3, Object customTextViewBold4, Object customTextView5, Object customTextViewBold5, Object customTextViewBold6) {
        super(obj, view, i);
        this.btnDelete = (Button) button;
        this.btnEdit = (Button) button2;
        this.catname = (CustomTextViewBold) customTextViewBold;
        this.deactivate = (CircleImageView) circleImageView;
        this.imgegallery = (ImageView) imageView;
        this.ivBack = (ImageView) imageView2;
        this.ivFav = (ImageView) imageView3;
        this.ivFavfilled = (ImageView) imageView4;
        this.ivGallery = (ImageView) imageView5;
        this.ivMap = (CircleImageView) circleImageView2;
        this.ivProfile = (CircleImageView) circleImageView3;
        this.ivShare = (ImageView) imageView6;
        this.linRating = (LinearLayout) linearLayout;
        this.linear = (LinearLayout) linearLayout2;
        this.llClick = (LinearLayout) linearLayout3;
        this.llViewImage = (LinearLayout) linearLayout4;
        this.rlBottom = (LinearLayout) linearLayout5;
        this.rvAllRating = (RecyclerView) recyclerView;
        this.rvBids = (RecyclerView) recyclerView2;
        this.simpleRatingBar1 = (ScaleRatingBar) scaleRatingBar;
        this.tvAddress = (CustomTextView) customTextView;
        this.tvDate = (CustomTextView) customTextView2;
        this.tvDescription = (CustomTextView) customTextView3;
        this.tvKm = (CustomTextViewBold) customTextViewBold2;
        this.tvMediaCount = (CustomTextView) customTextView4;
        this.tvName = (CustomTextViewBold) customTextViewBold3;
        this.tvPrice = (CustomTextViewBold) customTextViewBold4;
        this.tvShortDescription = (CustomTextView) customTextView5;
        this.tvViewAllBid = (CustomTextViewBold) customTextViewBold5;
        this.tvViewRating = (CustomTextViewBold) customTextViewBold6;
    }

    @NonNull
    public static ActivityViewMyAunctionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityViewMyAunctionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityViewMyAunctionBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_view_my_aunction, viewGroup, z, obj);
    }

    @NonNull
    public static ActivityViewMyAunctionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityViewMyAunctionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityViewMyAunctionBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_view_my_aunction, null, false, obj);
    }

    public static ActivityViewMyAunctionBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityViewMyAunctionBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityViewMyAunctionBinding) bind(obj, view, C2037R.layout.activity_view_my_aunction);
    }
}
