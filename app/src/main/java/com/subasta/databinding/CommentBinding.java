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
import com.subasta.utils.CustomButton;
import com.subasta.utils.CustomEditText;
import com.subasta.utils.CustomTextViewBold;
import com.willy.ratingbar.ScaleRatingBar;

import javax.annotation.Nullable;

public abstract class CommentBinding extends ViewDataBinding {
    @NonNull
    public final CustomButton btnComment;
    @NonNull
    public final CardView cardView;
    @NonNull
    public final CustomEditText etComment;
    @NonNull
    public final ImageView ivClose;
    @NonNull
    public final ScaleRatingBar simpleRatingBar;
    @NonNull
    public final CustomTextViewBold tvtitle;

    protected CommentBinding(Object obj, View view, int i, CustomButton customButton, CardView cardView2, CustomEditText customEditText, ImageView imageView, ScaleRatingBar scaleRatingBar, CustomTextViewBold customTextViewBold) {
        super(obj, view, i);
        this.btnComment = customButton;
        this.cardView = cardView2;
        this.etComment = customEditText;
        this.ivClose = imageView;
        this.simpleRatingBar = scaleRatingBar;
        this.tvtitle = customTextViewBold;
    }

    @NonNull
    public static CommentBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static CommentBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (CommentBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.comment, viewGroup, z, obj);
    }

    @NonNull
    public static CommentBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static CommentBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (CommentBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.comment, null, false, obj);
    }

    public static CommentBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CommentBinding bind(@NonNull View view, @Nullable Object obj) {
        return (CommentBinding) bind(obj, view, C2037R.layout.comment);
    }
}
