package com.subasta.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputLayout;
import com.subasta.C2037R;
import com.subasta.utils.CustomButton;
import com.subasta.utils.CustomEditText;
import com.subasta.utils.CustomTextViewBold;

import javax.annotation.Nullable;

public abstract class ActivityDetailsAutionBinding extends ViewDataBinding {
    @NonNull
    public final CustomTextViewBold addMoreimages;
    @NonNull
    public final CustomButton btnpost;
    @NonNull
    public final CardView cardView;
    @NonNull
    public final CustomEditText etAdress;
    @NonNull
    public final CustomEditText etBrandName;
    @NonNull
    public final CustomEditText etDescription;
    @NonNull
    public final CustomEditText etEndDate;
    @NonNull
    public final CustomEditText etOwner;
    @NonNull
    public final CustomEditText etPrice;
    @NonNull
    public final CustomEditText etSDate;
    @NonNull
    public final CustomEditText etTitle;
    @NonNull
    public final ImageView ivAddImages;
    @NonNull
    public final ImageView ivBack;
    @NonNull
    public final LinearLayout line1;
    @NonNull
    public final LinearLayout llImages;
    @NonNull
    public final RadioGroup rGroup;
    @NonNull
    public final RadioButton rbNo;
    @NonNull
    public final RadioButton rbYes;
    @NonNull
    public final RelativeLayout rlSnackbar;
    @NonNull
    public final RecyclerView rvImage;
    @NonNull
    public final TextInputLayout tvTitle;
    @NonNull
    public final TextInputLayout tvbrandname;
    @NonNull
    public final TextInputLayout tvdescription;

    protected ActivityDetailsAutionBinding(Object obj, View view, int i, Object customTextViewBold, Object customButton, Object cardView2, Object customEditText, Object customEditText2, Object customEditText3, Object customEditText4, Object customEditText5, Object customEditText6, Object customEditText7, Object customEditText8, Object imageView, Object imageView2, Object linearLayout, Object linearLayout2, Object radioGroup, Object radioButton, Object radioButton2, Object relativeLayout, Object recyclerView, Object textInputLayout, Object textInputLayout2, Object textInputLayout3) {
        super(obj, view, i);
        this.addMoreimages = (CustomTextViewBold) customTextViewBold;
        this.btnpost = (CustomButton) customButton;
        this.cardView = (CardView) cardView2;
        this.etAdress = (CustomEditText) customEditText;
        this.etBrandName = (CustomEditText) customEditText2;
        this.etDescription = (CustomEditText) customEditText3;
        this.etEndDate = (CustomEditText) customEditText4;
        this.etOwner = (CustomEditText) customEditText5;
        this.etPrice = (CustomEditText) customEditText6;
        this.etSDate = (CustomEditText) customEditText7;
        this.etTitle = (CustomEditText) customEditText8;
        this.ivAddImages = (ImageView) imageView;
        this.ivBack = (ImageView) imageView2;
        this.line1 = (LinearLayout) linearLayout;
        this.llImages = (LinearLayout) linearLayout2;
        this.rGroup = (RadioGroup) radioGroup;
        this.rbNo = (RadioButton) radioButton;
        this.rbYes = (RadioButton) radioButton2;
        this.rlSnackbar = (RelativeLayout) relativeLayout;
        this.rvImage = (RecyclerView) recyclerView;
        this.tvTitle = (TextInputLayout) textInputLayout;
        this.tvbrandname = (TextInputLayout) textInputLayout2;
        this.tvdescription = (TextInputLayout) textInputLayout3;
    }

    @NonNull
    public static ActivityDetailsAutionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityDetailsAutionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityDetailsAutionBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_details_aution, viewGroup, z, obj);
    }

    @NonNull
    public static ActivityDetailsAutionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityDetailsAutionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityDetailsAutionBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_details_aution, null, false, obj);
    }

    public static ActivityDetailsAutionBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityDetailsAutionBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityDetailsAutionBinding) bind(obj, view, C2037R.layout.activity_details_aution);
    }
}
