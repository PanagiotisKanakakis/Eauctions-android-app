package com.subasta.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.subasta.C2037R;
import com.subasta.utils.CustomButton;
import com.subasta.utils.CustomEditText;

import javax.annotation.Nullable;

public abstract class ActivityChangPasswordBinding extends ViewDataBinding {
    @NonNull
    public final CustomButton changSave;
    @NonNull
    public final CustomEditText etConfirmPass;
    @NonNull
    public final CustomEditText etNewPass;
    @NonNull
    public final CustomEditText etOldPass;
    @NonNull
    public final ImageView ivBack;
    @NonNull
    public final ImageView ivConfirmPass;
    @NonNull
    public final ImageView ivNewPass;
    @NonNull
    public final ImageView ivOldPass;

    protected ActivityChangPasswordBinding(Object obj, View view, int i, CustomButton customButton, CustomEditText customEditText, CustomEditText customEditText2, CustomEditText customEditText3, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4) {
        super(obj, view, i);
        this.changSave = customButton;
        this.etConfirmPass = customEditText;
        this.etNewPass = customEditText2;
        this.etOldPass = customEditText3;
        this.ivBack = imageView;
        this.ivConfirmPass = imageView2;
        this.ivNewPass = imageView3;
        this.ivOldPass = imageView4;
    }

    @NonNull
    public static ActivityChangPasswordBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityChangPasswordBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityChangPasswordBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_chang_password, viewGroup, z, obj);
    }

    @NonNull
    public static ActivityChangPasswordBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityChangPasswordBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityChangPasswordBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_chang_password, null, false, obj);
    }

    public static ActivityChangPasswordBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityChangPasswordBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityChangPasswordBinding) bind(obj, view, C2037R.layout.activity_chang_password);
    }
}
