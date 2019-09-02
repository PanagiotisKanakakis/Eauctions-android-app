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

import com.subasta.C2037R;
import com.subasta.utils.CustomTextView;
import com.subasta.utils.CustomTextViewBold;

import javax.annotation.Nullable;

public abstract class AdapterNotificationBinding extends ViewDataBinding {
    @NonNull
    public final CardView cardView1;
    @NonNull
    public final ImageView image;
    @NonNull
    public final RelativeLayout layout;
    @NonNull
    public final CustomTextView message;
    @NonNull
    public final CustomTextViewBold title;

    protected AdapterNotificationBinding(Object obj, View view, int i, CardView cardView, ImageView imageView, RelativeLayout relativeLayout, CustomTextView customTextView, CustomTextViewBold customTextViewBold) {
        super(obj, view, i);
        this.cardView1 = cardView;
        this.image = imageView;
        this.layout = relativeLayout;
        this.message = customTextView;
        this.title = customTextViewBold;
    }

    @NonNull
    public static AdapterNotificationBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static AdapterNotificationBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AdapterNotificationBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.adapter_notification, viewGroup, z, obj);
    }

    @NonNull
    public static AdapterNotificationBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static AdapterNotificationBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (AdapterNotificationBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.adapter_notification, null, false, obj);
    }

    public static AdapterNotificationBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterNotificationBinding bind(@NonNull View view, @Nullable Object obj) {
        return (AdapterNotificationBinding) bind(obj, view, C2037R.layout.adapter_notification);
    }
}
