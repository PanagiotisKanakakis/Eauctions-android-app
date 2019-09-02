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
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import de.hdodenhof.circleimageview.CircleImageView;
import com.subasta.C2037R;
import com.subasta.utils.CustomButton;
import com.subasta.utils.CustomEditText;
import com.subasta.utils.CustomTextView;

import javax.annotation.Nullable;

public abstract class ActivityProfileBinding extends ViewDataBinding {
    @NonNull
    public final CustomButton btnsubmitdata;
    @NonNull
    public final CustomEditText cetAddress;
    @NonNull
    public final CustomEditText cetPhoneno;
    @NonNull
    public final CircleImageView civProfile;
    @NonNull
    public final CustomTextView ctvContact;
    @NonNull
    public final CustomTextView ctvGender;
    @NonNull
    public final CustomEditText ctvName;
    @NonNull
    public final CustomTextView etEmail;
    @NonNull
    public final RadioButton female;
    @NonNull
    public final LinearLayout iActProfile;
    @NonNull
    public final ImageView imageView2;
    @NonNull
    public final LinearLayout llProfile;
    @NonNull
    public final RadioButton male;
    @NonNull
    public final ImageView profileback;
    @NonNull
    public final ImageView profilenotification;
    @NonNull
    public final RadioGroup radioGroup;

    protected ActivityProfileBinding(Object obj, View view, int i, Object customButton, Object customEditText, Object customEditText2, Object circleImageView, Object customTextView, Object customTextView2, Object customEditText3, Object customTextView3, Object radioButton, Object linearLayout, Object imageView, Object linearLayout2, Object radioButton2, Object imageView3, Object imageView4, Object radioGroup2) {
        super(obj, view, i);
        this.btnsubmitdata = (CustomButton) customButton;
        this.cetAddress = (CustomEditText) customEditText;
        this.cetPhoneno = (CustomEditText) customEditText2;
        this.civProfile = (CircleImageView) circleImageView;
        this.ctvContact = (CustomTextView) customTextView;
        this.ctvGender = (CustomTextView) customTextView2;
        this.ctvName = (CustomEditText) customEditText3;
        this.etEmail = (CustomTextView) customTextView3;
        this.female = (RadioButton) radioButton;
        this.iActProfile = (LinearLayout) linearLayout;
        this.imageView2 = (ImageView) imageView;
        this.llProfile = (LinearLayout) linearLayout2;
        this.male = (RadioButton) radioButton2;
        this.profileback = (ImageView) imageView3;
        this.profilenotification = (ImageView) imageView4;
        this.radioGroup = (RadioGroup) radioGroup2;
    }

    @NonNull
    public static ActivityProfileBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityProfileBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityProfileBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_profile, viewGroup, z, obj);
    }

    @NonNull
    public static ActivityProfileBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityProfileBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityProfileBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_profile, null, false, obj);
    }

    public static ActivityProfileBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityProfileBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityProfileBinding) bind(obj, view, C2037R.layout.activity_profile);
    }
}
