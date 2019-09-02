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
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.subasta.C2037R;
import com.subasta.utils.CustomButton;
import com.subasta.utils.CustomEditText;
import com.subasta.utils.CustomTextViewBold;

import javax.annotation.Nullable;

import de.hdodenhof.circleimageview.CircleImageView;


public abstract class ActivityChatstalkingBinding extends ViewDataBinding {
    @NonNull
    public final CustomButton btnChatSend;
    @NonNull
    public final CardView cardView;
    @NonNull
    public final ImageView ivBack;
    @NonNull
    public final CircleImageView ivalia;
    @NonNull
    public final ImageView menu;
    @NonNull
    public final CustomEditText msgType;
    @NonNull
    public final RecyclerView recycleChat;
    @NonNull
    public final SwipeRefreshLayout swipeRefreshLayout;
    @NonNull
    public final CustomTextViewBold tvname;

    protected ActivityChatstalkingBinding(Object obj, View view, int i, CustomButton customButton, CardView cardView2, ImageView imageView, CircleImageView circleImageView, ImageView imageView2, CustomEditText customEditText, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout2, CustomTextViewBold customTextViewBold) {
        super(obj, view, i);
        this.btnChatSend = customButton;
        this.cardView = cardView2;
        this.ivBack = imageView;
        this.ivalia = circleImageView;
        this.menu = imageView2;
        this.msgType = customEditText;
        this.recycleChat = recyclerView;
        this.swipeRefreshLayout = swipeRefreshLayout2;
        this.tvname = customTextViewBold;
    }

    @NonNull
    public static ActivityChatstalkingBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityChatstalkingBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityChatstalkingBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_chatstalking, viewGroup, z, obj);
    }

    @NonNull
    public static ActivityChatstalkingBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityChatstalkingBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityChatstalkingBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_chatstalking, null, false, obj);
    }

    public static ActivityChatstalkingBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityChatstalkingBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityChatstalkingBinding) bind(obj, view, C2037R.layout.activity_chatstalking);
    }
}
