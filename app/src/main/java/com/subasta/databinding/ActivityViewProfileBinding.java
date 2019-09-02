package com.subasta.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.subasta.C2037R;
import com.subasta.utils.CustomEditText;
import com.subasta.utils.CustomTextViewBold;
import com.subasta.utils.RoundRectCornerImageView;

import javax.annotation.Nullable;

public abstract class ActivityViewProfileBinding extends ViewDataBinding {
    @NonNull
    public final CardView cardView;
    @NonNull
    public final CustomEditText cetAddress;
    @NonNull
    public final CustomEditText cetPhoneno;
    @NonNull
    public final RoundRectCornerImageView civProfile;
    @NonNull
    public final CustomTextViewBold ctvName;
    @NonNull
    public final CustomEditText etEmail;
    @NonNull
    public final LinearLayout iActProfile;
    @NonNull
    public final LinearLayout line1;
    @NonNull
    public final LinearLayout line2;
    @NonNull
    public final LinearLayout mainlayout;
    @NonNull
    public final ImageView profileback;

    protected ActivityViewProfileBinding(Object obj, View view, int i, CardView cardView2, CustomEditText customEditText, CustomEditText customEditText2, RoundRectCornerImageView roundRectCornerImageView, CustomTextViewBold customTextViewBold, CustomEditText customEditText3, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, ImageView imageView) {
        super(obj, view, i);
        this.cardView = cardView2;
        this.cetAddress = customEditText;
        this.cetPhoneno = customEditText2;
        this.civProfile = roundRectCornerImageView;
        this.ctvName = customTextViewBold;
        this.etEmail = customEditText3;
        this.iActProfile = linearLayout;
        this.line1 = linearLayout2;
        this.line2 = linearLayout3;
        this.mainlayout = linearLayout4;
        this.profileback = imageView;
    }

    @NonNull
    public static ActivityViewProfileBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityViewProfileBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityViewProfileBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_view_profile, viewGroup, z, obj);
    }

    @NonNull
    public static ActivityViewProfileBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityViewProfileBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityViewProfileBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_view_profile, null, false, obj);
    }

    public static ActivityViewProfileBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityViewProfileBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityViewProfileBinding) bind(obj, view, C2037R.layout.activity_view_profile);
    }
}
