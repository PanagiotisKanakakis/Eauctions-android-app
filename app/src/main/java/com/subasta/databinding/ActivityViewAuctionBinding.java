package com.subasta.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;
import com.subasta.C2037R;
import com.subasta.utils.CustomTextView;
import com.subasta.utils.CustomTextViewBold;
import com.willy.ratingbar.ScaleRatingBar;

import javax.annotation.Nullable;

public abstract class ActivityViewAuctionBinding extends ViewDataBinding {
    @NonNull
    public final CustomTextViewBold catname;
    @NonNull
    public final CustomTextViewBold comment;
    @NonNull
    public final ImageView imgegallery;
    @NonNull
    public final ImageView ivBack1;
    @NonNull
    public final ImageView ivFavScreen;
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
    public final CircleImageView ivwin;
    @NonNull
    public final LinearLayout linRating;
    @NonNull
    public final LinearLayout line1;
    @NonNull
    public final LinearLayout llChatscreen;
    @NonNull
    public final LinearLayout llClick;
    @NonNull
    public final LinearLayout llOffer;
    @NonNull
    public final LinearLayout llViewImage;
    @NonNull
    public final LinearLayout rlBottom;
    @NonNull
    public final RecyclerView rvAllRating;
    @NonNull
    public final RecyclerView rvBids;
    @NonNull
    public final NestedScrollView scroll;
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
    public final CustomTextViewBold tvViewProfile;
    @NonNull
    public final CustomTextViewBold tvViewRating;

    protected ActivityViewAuctionBinding(Object obj, View view, int i, Object customTextViewBold, Object customTextViewBold2, Object imageView, Object imageView2, Object imageView3, Object imageView4, Object imageView5, Object circleImageView, Object circleImageView2, Object imageView6, Object circleImageView3, Object linearLayout, Object linearLayout2, Object linearLayout3, Object linearLayout4, Object linearLayout5, Object linearLayout6, Object linearLayout7, Object recyclerView, Object recyclerView2, Object nestedScrollView, Object scaleRatingBar, Object customTextView, Object customTextView2, Object customTextView3, Object customTextViewBold3, Object customTextView4, Object customTextViewBold4, Object customTextViewBold5, Object customTextView5, Object customTextViewBold6, Object customTextViewBold7, Object customTextViewBold8) {
        super(obj, view, i);
        this.catname = (CustomTextViewBold) customTextViewBold;
        this.comment = (CustomTextViewBold) customTextViewBold2;
        this.imgegallery = (ImageView) imageView;
        this.ivBack1 = (ImageView) imageView2;
        this.ivFavScreen = (ImageView) imageView3;
        this.ivFavfilled = (ImageView) imageView4;
        this.ivGallery = (ImageView) imageView5;
        this.ivMap = (CircleImageView) circleImageView;
        this.ivProfile = (CircleImageView) circleImageView2;
        this.ivShare = (ImageView) imageView6;
        this.ivwin = (CircleImageView) circleImageView3;
        this.linRating = (LinearLayout) linearLayout;
        this.line1 = (LinearLayout) linearLayout2;
        this.llChatscreen = (LinearLayout) linearLayout3;
        this.llClick = (LinearLayout) linearLayout4;
        this.llOffer = (LinearLayout) linearLayout5;
        this.llViewImage = (LinearLayout) linearLayout6;
        this.rlBottom = (LinearLayout) linearLayout7;
        this.rvAllRating = (RecyclerView) recyclerView;
        this.rvBids = (RecyclerView) recyclerView2;
        this.scroll = (NestedScrollView) nestedScrollView;
        this.simpleRatingBar1 = (ScaleRatingBar) scaleRatingBar;
        this.tvAddress = (CustomTextView) customTextView;
        this.tvDate = (CustomTextView) customTextView2;
        this.tvDescription = (CustomTextView) customTextView3;
        this.tvKm = (CustomTextViewBold) customTextViewBold3;
        this.tvMediaCount = (CustomTextView) customTextView4;
        this.tvName = (CustomTextViewBold) customTextViewBold4;
        this.tvPrice = (CustomTextViewBold) customTextViewBold5;
        this.tvShortDescription = (CustomTextView) customTextView5;
        this.tvViewAllBid = (CustomTextViewBold) customTextViewBold6;
        this.tvViewProfile = (CustomTextViewBold) customTextViewBold7;
        this.tvViewRating = (CustomTextViewBold) customTextViewBold8;
    }

    @NonNull
    public static ActivityViewAuctionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityViewAuctionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityViewAuctionBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_view_auction, viewGroup, z, obj);
    }

    @NonNull
    public static ActivityViewAuctionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityViewAuctionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityViewAuctionBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_view_auction, null, false, obj);
    }

    public static ActivityViewAuctionBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityViewAuctionBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityViewAuctionBinding) bind(obj, view, C2037R.layout.activity_view_auction);
    }
}
