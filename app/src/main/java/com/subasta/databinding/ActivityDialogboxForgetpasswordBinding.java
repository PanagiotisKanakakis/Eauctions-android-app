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

public abstract class ActivityDialogboxForgetpasswordBinding extends ViewDataBinding {
    @NonNull
    public final CustomButton btnSubmit;
    @NonNull
    public final CustomEditText etEmail;
    @NonNull
    public final ImageView ivClose;

    protected ActivityDialogboxForgetpasswordBinding(Object obj, View view, int i, CustomButton customButton, CustomEditText customEditText, ImageView imageView) {
        super(obj, view, i);
        this.btnSubmit = customButton;
        this.etEmail = customEditText;
        this.ivClose = imageView;
    }

    @NonNull
    public static ActivityDialogboxForgetpasswordBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityDialogboxForgetpasswordBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityDialogboxForgetpasswordBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_dialogbox_forgetpassword, viewGroup, z, obj);
    }

    @NonNull
    public static ActivityDialogboxForgetpasswordBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityDialogboxForgetpasswordBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityDialogboxForgetpasswordBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_dialogbox_forgetpassword, null, false, obj);
    }

    public static ActivityDialogboxForgetpasswordBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityDialogboxForgetpasswordBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityDialogboxForgetpasswordBinding) bind(obj, view, C2037R.layout.activity_dialogbox_forgetpassword);
    }
}
