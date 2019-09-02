package com.subasta.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.subasta.C2037R;

import javax.annotation.Nullable;

public abstract class AdapterAddImageBinding extends ViewDataBinding {
    @NonNull
    public final ImageView addImages;
    @NonNull
    public final ImageView cancel;
    @NonNull
    public final CardView cardView;

    protected AdapterAddImageBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, CardView cardView2) {
        super(obj, view, i);
        this.addImages = imageView;
        this.cancel = imageView2;
        this.cardView = cardView2;
    }

    @NonNull
    public static AdapterAddImageBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static AdapterAddImageBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AdapterAddImageBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.adapter_add_image, viewGroup, z, obj);
    }

    @NonNull
    public static AdapterAddImageBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static AdapterAddImageBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (AdapterAddImageBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.adapter_add_image, null, false, obj);
    }

    public static AdapterAddImageBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterAddImageBinding bind(@NonNull View view, @Nullable Object obj) {
        return (AdapterAddImageBinding) bind(obj, view, C2037R.layout.adapter_add_image);
    }
}
