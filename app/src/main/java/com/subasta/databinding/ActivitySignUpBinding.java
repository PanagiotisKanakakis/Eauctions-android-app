package com.subasta.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.hbb20.CountryCodePicker;
import de.hdodenhof.circleimageview.CircleImageView;
import com.subasta.C2037R;
import com.subasta.utils.CustomButton;
import com.subasta.utils.CustomEditText;

import javax.annotation.Nullable;


public abstract class ActivitySignUpBinding extends ViewDataBinding {
    @NonNull
    public final CustomButton btnSignUp;
    @NonNull
    public final CountryCodePicker cCodePicker;
    @NonNull
    public final CardView cardView;
    @NonNull
    public final CardView cardViewProfile;
    @NonNull
    public final CustomEditText etEmail;
    @NonNull
    public final CustomEditText etMobile;
    @NonNull
    public final CustomEditText etName;
    @NonNull
    public final CustomEditText etPassword;
    @NonNull
    public final ImageView ivBack;
    @NonNull
    public final ImageView ivPass;
    @NonNull
    public final ImageView ivProfile;
    @NonNull
    public final CircleImageView ivProfilePic;
    @NonNull
    public final RelativeLayout rlSnackbar;

    protected ActivitySignUpBinding(Object obj, View view, int i, Object customButton, Object countryCodePicker, Object cardView2, Object cardView3, Object customEditText, Object customEditText2, Object customEditText3, Object customEditText4, Object imageView, Object imageView2, Object imageView3, Object circleImageView, Object relativeLayout) {
        super(obj, view, i);
        this.btnSignUp = (CustomButton) customButton;
        this.cCodePicker = (CountryCodePicker) countryCodePicker;
        this.cardView = (CardView) cardView2;
        this.cardViewProfile = (CardView) cardView3;
        this.etEmail = (CustomEditText) customEditText;
        this.etMobile = (CustomEditText) customEditText2;
        this.etName = (CustomEditText) customEditText3;
        this.etPassword = (CustomEditText) customEditText4;
        this.ivBack = (ImageView) imageView;
        this.ivPass = (ImageView) imageView2;
        this.ivProfile = (ImageView) imageView3;
        this.ivProfilePic = (CircleImageView) circleImageView;
        this.rlSnackbar = (RelativeLayout) relativeLayout;
    }

    @NonNull
    public static ActivitySignUpBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivitySignUpBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivitySignUpBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_sign__up, viewGroup, z, obj);
    }

    @NonNull
    public static ActivitySignUpBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivitySignUpBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivitySignUpBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_sign__up, null, false, obj);
    }

    public static ActivitySignUpBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivitySignUpBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivitySignUpBinding) bind(obj, view, C2037R.layout.activity_sign__up);
    }
}
