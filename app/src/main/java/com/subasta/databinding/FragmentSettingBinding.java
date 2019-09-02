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

import com.subasta.C2037R;
import com.subasta.utils.CustomTextView;
import com.subasta.utils.CustomTextViewBold;

import javax.annotation.Nullable;

import de.hdodenhof.circleimageview.CircleImageView;

public abstract class FragmentSettingBinding extends ViewDataBinding {
    @NonNull
    public final CardView cardView;
    @NonNull
    public final CardView cardView1;
    @NonNull
    public final CardView cvdp;
    @NonNull
    public final CircleImageView imagedp;
    @NonNull
    public final LinearLayout llID;
    @NonNull
    public final CustomTextView tvchangepass;
    @NonNull
    public final CustomTextView tvdate;
    @NonNull
    public final CustomTextView tvinvited;
    @NonNull
    public final CustomTextViewBold tvname;
    @NonNull
    public final CustomTextView tvsupport;

    protected FragmentSettingBinding(Object obj, View view, int i, CardView cardView2, CardView cardView3, CardView cardView4, CircleImageView circleImageView, LinearLayout linearLayout, CustomTextView customTextView, CustomTextView customTextView2, CustomTextView customTextView3, CustomTextViewBold customTextViewBold, CustomTextView customTextView4) {
        super(obj, view, i);
        this.cardView = cardView2;
        this.cardView1 = cardView3;
        this.cvdp = cardView4;
        this.imagedp = circleImageView;
        this.llID = linearLayout;
        this.tvchangepass = customTextView;
        this.tvdate = customTextView2;
        this.tvinvited = customTextView3;
        this.tvname = customTextViewBold;
        this.tvsupport = customTextView4;
    }

    @NonNull
    public static FragmentSettingBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static FragmentSettingBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentSettingBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.fragment_setting, viewGroup, z, obj);
    }

    @NonNull
    public static FragmentSettingBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static FragmentSettingBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentSettingBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.fragment_setting, null, false, obj);
    }

    public static FragmentSettingBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSettingBinding bind(@NonNull View view, @Nullable Object obj) {
        return (FragmentSettingBinding) bind(obj, view, C2037R.layout.fragment_setting);
    }
}
