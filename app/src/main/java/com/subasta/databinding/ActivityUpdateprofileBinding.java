package com.subasta.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.google.android.material.textfield.TextInputEditText;
import com.hbb20.CountryCodePicker;
import de.hdodenhof.circleimageview.CircleImageView;
import com.subasta.C2037R;
import com.subasta.utils.CustomButton;
import com.subasta.utils.CustomTextViewBold;

import javax.annotation.Nullable;

public abstract class ActivityUpdateprofileBinding extends ViewDataBinding {
    @NonNull
    public final CustomButton btnsubmitdata;
    @NonNull
    public final CountryCodePicker cCodePicker;
    @NonNull
    public final CardView cardView;
    @NonNull
    public final TextInputEditText cetAddress;
    @NonNull
    public final TextInputEditText cetPhoneno;
    @NonNull
    public final CircleImageView civProfile;
    @NonNull
    public final CircleImageView civProfile1;
    @NonNull
    public final CustomTextViewBold ctvGender;
    @NonNull
    public final TextInputEditText ctvName;
    @NonNull
    public final TextInputEditText etEmail;
    @NonNull
    public final RadioButton female;
    @NonNull
    public final LinearLayout iActProfile;
    @NonNull
    public final LinearLayout line1;
    @NonNull
    public final LinearLayout line2;
    @NonNull
    public final LinearLayout mainlayout;
    @NonNull
    public final RadioButton male;
    @NonNull
    public final ImageView profileback;
    @NonNull
    public final RadioGroup radioGroup;

    protected ActivityUpdateprofileBinding(Object obj, View view, int i, Object customButton, Object countryCodePicker, Object cardView2, Object textInputEditText, Object textInputEditText2, Object circleImageView, Object circleImageView2, Object customTextViewBold, Object textInputEditText3, Object textInputEditText4, Object radioButton, Object linearLayout, Object linearLayout2, Object linearLayout3, Object linearLayout4, Object radioButton2, Object imageView, Object radioGroup2) {
        super(obj, view, i);
        this.btnsubmitdata = (CustomButton) customButton;
        this.cCodePicker = (CountryCodePicker) countryCodePicker;
        this.cardView = (CardView) cardView2;
        this.cetAddress = (TextInputEditText) textInputEditText;
        this.cetPhoneno = (TextInputEditText) textInputEditText2;
        this.civProfile = (CircleImageView) circleImageView;
        this.civProfile1 = (CircleImageView) circleImageView2;
        this.ctvGender = (CustomTextViewBold) customTextViewBold;
        this.ctvName = (TextInputEditText) textInputEditText3;
        this.etEmail = (TextInputEditText) textInputEditText4;
        this.female = (RadioButton) radioButton;
        this.iActProfile = (LinearLayout) linearLayout;
        this.line1 = (LinearLayout) linearLayout2;
        this.line2 = (LinearLayout) linearLayout3;
        this.mainlayout = (LinearLayout) linearLayout4;
        this.male = (RadioButton) radioButton2;
        this.profileback = (ImageView) imageView;
        this.radioGroup = (RadioGroup) radioGroup2;
    }

    @NonNull
    public static ActivityUpdateprofileBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityUpdateprofileBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityUpdateprofileBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_updateprofile, viewGroup, z, obj);
    }

    @NonNull
    public static ActivityUpdateprofileBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityUpdateprofileBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityUpdateprofileBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_updateprofile, null, false, obj);
    }

    public static ActivityUpdateprofileBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityUpdateprofileBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityUpdateprofileBinding) bind(obj, view, C2037R.layout.activity_updateprofile);
    }
}
