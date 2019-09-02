package com.subasta.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.subasta.C2037R;
import com.subasta.utils.CustomTextView;
import com.subasta.utils.CustomTextViewBold;

import javax.annotation.Nullable;

import de.hdodenhof.circleimageview.CircleImageView;

public abstract class AdapterMyChatBinding extends ViewDataBinding {
    @NonNull
    public final CardView cardView;
    @NonNull
    public final CircleImageView ivPro;
    @NonNull
    public final RelativeLayout relay1;
    @NonNull
    public final RelativeLayout rvChat;
    @NonNull
    public final CustomTextViewBold tvDate;
    @NonNull
    public final CustomTextView tvMsg;
    @NonNull
    public final CustomTextViewBold tvTitle;

    protected AdapterMyChatBinding(Object obj, View view, int i, CardView cardView2, CircleImageView circleImageView, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, CustomTextViewBold customTextViewBold, CustomTextView customTextView, CustomTextViewBold customTextViewBold2) {
        super(obj, view, i);
        this.cardView = cardView2;
        this.ivPro = circleImageView;
        this.relay1 = relativeLayout;
        this.rvChat = relativeLayout2;
        this.tvDate = customTextViewBold;
        this.tvMsg = customTextView;
        this.tvTitle = customTextViewBold2;
    }

    @NonNull
    public static AdapterMyChatBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static AdapterMyChatBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AdapterMyChatBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.adapter_my_chat, viewGroup, z, obj);
    }

    @NonNull
    public static AdapterMyChatBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static AdapterMyChatBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (AdapterMyChatBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.adapter_my_chat, null, false, obj);
    }

    public static AdapterMyChatBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterMyChatBinding bind(@NonNull View view, @Nullable Object obj) {
        return (AdapterMyChatBinding) bind(obj, view, C2037R.layout.adapter_my_chat);
    }
}
