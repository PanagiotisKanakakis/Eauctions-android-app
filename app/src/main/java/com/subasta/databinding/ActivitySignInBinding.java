package com.subasta.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.subasta.C2037R;
import com.subasta.utils.CustomButton;
import com.subasta.utils.CustomEditText;
import com.subasta.utils.CustomTextView;
import com.subasta.utils.CustomTextViewBold;

import javax.annotation.Nullable;

public abstract class ActivitySignInBinding extends ViewDataBinding {
    @NonNull
    public final CustomButton btnFacebook;
    @NonNull
    public final CustomButton btnGmail;
    @NonNull
    public final CustomButton btnSignIn;
    @NonNull
    public final CustomEditText etEmail;
    @NonNull
    public final CustomEditText etPassword;
    @NonNull
    public final ImageView imageLogo;
    @NonNull
    public final ImageView ivPass;
    @NonNull
    public final LinearLayout linerEmail;
    @NonNull
    public final LinearLayout linerLoginwith;
    @NonNull
    public final LinearLayout linerSignin;
    @NonNull
    public final RelativeLayout rlSnackbar;
    @NonNull
    public final CustomTextViewBold tvCreateAccount;
    @NonNull
    public final CustomTextViewBold tvFrogotPass;
    @NonNull
    public final CustomTextView tvOr;

    protected ActivitySignInBinding(Object obj, View view, int i, Object customButton, Object customButton2, Object customButton3, Object customEditText, Object customEditText2, Object imageView, Object imageView2, Object linearLayout, Object linearLayout2, Object linearLayout3, Object relativeLayout, Object customTextViewBold, Object customTextViewBold2, Object customTextView) {
        super(obj, view, i);
        this.btnFacebook = (CustomButton) customButton;
        this.btnGmail = (CustomButton) customButton2;
        this.btnSignIn = (CustomButton) customButton3;
        this.etEmail = (CustomEditText) customEditText;
        this.etPassword = (CustomEditText) customEditText2;
        this.imageLogo = (ImageView) imageView;
        this.ivPass = (ImageView) imageView2;
        this.linerEmail = (LinearLayout) linearLayout;
        this.linerLoginwith = (LinearLayout) linearLayout2;
        this.linerSignin = (LinearLayout) linearLayout3;
        this.rlSnackbar = (RelativeLayout) relativeLayout;
        this.tvCreateAccount = (CustomTextViewBold) customTextViewBold;
        this.tvFrogotPass = (CustomTextViewBold) customTextViewBold2;
        this.tvOr = (CustomTextView) customTextView;
    }

    @NonNull
    public static ActivitySignInBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivitySignInBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivitySignInBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_sign_in, viewGroup, z, obj);
    }

    @NonNull
    public static ActivitySignInBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivitySignInBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivitySignInBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_sign_in, null, false, obj);
    }

    public static ActivitySignInBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivitySignInBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivitySignInBinding) bind(obj, view, C2037R.layout.activity_sign_in);
    }
}
