package com.subasta.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.subasta.C2037R;
import com.subasta.utils.CustomTextViewBold;

import javax.annotation.Nullable;

public abstract class FragmentNotificationBinding extends ViewDataBinding {
    @NonNull
    public final CustomTextViewBold noNotification;
    @NonNull
    public final ImageView notification;
    @NonNull
    public final RecyclerView recycleview1;
    @NonNull
    public final RelativeLayout relative;
    @NonNull
    public final SwipeRefreshLayout swipeRefreshLayout;

    protected FragmentNotificationBinding(Object obj, View view, int i, CustomTextViewBold customTextViewBold, ImageView imageView, RecyclerView recyclerView, RelativeLayout relativeLayout, SwipeRefreshLayout swipeRefreshLayout2) {
        super(obj, view, i);
        this.noNotification = customTextViewBold;
        this.notification = imageView;
        this.recycleview1 = recyclerView;
        this.relative = relativeLayout;
        this.swipeRefreshLayout = swipeRefreshLayout2;
    }

    @NonNull
    public static FragmentNotificationBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static FragmentNotificationBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentNotificationBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.fragment_notification, viewGroup, z, obj);
    }

    @NonNull
    public static FragmentNotificationBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static FragmentNotificationBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentNotificationBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.fragment_notification, null, false, obj);
    }

    public static FragmentNotificationBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentNotificationBinding bind(@NonNull View view, @Nullable Object obj) {
        return (FragmentNotificationBinding) bind(obj, view, C2037R.layout.fragment_notification);
    }
}
