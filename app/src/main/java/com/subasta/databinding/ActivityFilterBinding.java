package com.subasta.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.subasta.C2037R;
import com.subasta.utils.CustomButton;
import com.subasta.utils.CustomEditText;
import com.subasta.utils.CustomTextViewBold;
import com.xw.repo.BubbleSeekBar;

import javax.annotation.Nullable;

public abstract class ActivityFilterBinding extends ViewDataBinding {
    @NonNull
    public final CustomButton Applyfilter;
    @NonNull
    public final CustomEditText MaxPrice;
    @NonNull
    public final CustomEditText MinPrice;
    @NonNull
    public final BubbleSeekBar bsbFilter;
    @NonNull
    public final CardView cardView;
    @NonNull
    public final CardView cardView2;
    @NonNull
    public final CardView cardView3;
    @NonNull
    public final CardView cardViewbottom;
    @NonNull
    public final CustomButton clearfilter;
    @NonNull
    public final ImageView ivBackFilter;
    @NonNull
    public final LinearLayout line1;
    @NonNull
    public final RecyclerView recycleview1;
    @NonNull
    public final ScrollView scroll;
    @NonNull
    public final CustomTextViewBold tvdis;
    @NonNull
    public final CustomTextViewBold tvtitle;
    @NonNull
    public final CustomTextViewBold tvtitle3;
    @NonNull
    public final CustomTextViewBold tvtitle4;

    protected ActivityFilterBinding(Object obj, View view, int i, Object customButton, Object customEditText, Object customEditText2, Object bubbleSeekBar, Object cardView4, Object cardView5, Object cardView6, Object cardView7, Object customButton2, Object imageView, Object linearLayout, Object recyclerView, Object scrollView, Object customTextViewBold, Object customTextViewBold2, Object customTextViewBold3, Object customTextViewBold4) {
        super(obj, view, i);
        this.Applyfilter = (CustomButton) customButton;
        this.MaxPrice = (CustomEditText) customEditText;
        this.MinPrice = (CustomEditText) customEditText2;
        this.bsbFilter = (BubbleSeekBar) bubbleSeekBar;
        this.cardView = (CardView) cardView4;
        this.cardView2 = (CardView) cardView5;
        this.cardView3 = (CardView) cardView6;
        this.cardViewbottom = (CardView) cardView7;
        this.clearfilter = (CustomButton) customButton2;
        this.ivBackFilter = (ImageView) imageView;
        this.line1 = (LinearLayout) linearLayout;
        this.recycleview1 = (RecyclerView) recyclerView;
        this.scroll = (ScrollView) scrollView;
        this.tvdis = (CustomTextViewBold) customTextViewBold;
        this.tvtitle = (CustomTextViewBold) customTextViewBold2;
        this.tvtitle3 = (CustomTextViewBold) customTextViewBold3;
        this.tvtitle4 = (CustomTextViewBold) customTextViewBold4;
    }

    @NonNull
    public static ActivityFilterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityFilterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityFilterBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_filter, viewGroup, z, obj);
    }

    @NonNull
    public static ActivityFilterBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityFilterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityFilterBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_filter, null, false, obj);
    }

    public static ActivityFilterBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityFilterBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityFilterBinding) bind(obj, view, C2037R.layout.activity_filter);
    }
}
