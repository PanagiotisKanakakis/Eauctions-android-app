package com.subasta.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import de.hdodenhof.circleimageview.CircleImageView;
import com.subasta.C2037R;
import com.subasta.utils.CustomTextView;
import com.subasta.utils.CustomTextViewBold;
import com.willy.ratingbar.ScaleRatingBar;

import javax.annotation.Nullable;

public abstract class AdapterAllRatingBinding extends ViewDataBinding {
    @NonNull
    public final CardView cardView;
    @NonNull
    public final CardView cardView1;
    @NonNull
    public final CircleImageView civCat;
    @NonNull
    public final LinearLayout line1;
    @NonNull
    public final LinearLayout llcat;
    @NonNull
    public final ScaleRatingBar simpleRatingBar;
    @NonNull
    public final CustomTextView tvComment;
    @NonNull
    public final CustomTextViewBold userName;

    protected AdapterAllRatingBinding(Object obj, View view, int i, CardView cardView2, CardView cardView3, CircleImageView circleImageView, LinearLayout linearLayout, LinearLayout linearLayout2, ScaleRatingBar scaleRatingBar, CustomTextView customTextView, CustomTextViewBold customTextViewBold) {
        super(obj, view, i);
        this.cardView = cardView2;
        this.cardView1 = cardView3;
        this.civCat = circleImageView;
        this.line1 = linearLayout;
        this.llcat = linearLayout2;
        this.simpleRatingBar = scaleRatingBar;
        this.tvComment = customTextView;
        this.userName = customTextViewBold;
    }

    @NonNull
    public static AdapterAllRatingBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static AdapterAllRatingBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AdapterAllRatingBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.adapter_all_rating, viewGroup, z, obj);
    }

    @NonNull
    public static AdapterAllRatingBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static AdapterAllRatingBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (AdapterAllRatingBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.adapter_all_rating, null, false, obj);
    }

    public static AdapterAllRatingBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterAllRatingBinding bind(@NonNull View view, @Nullable Object obj) {
        return (AdapterAllRatingBinding) bind(obj, view, C2037R.layout.adapter_all_rating);
    }
}
