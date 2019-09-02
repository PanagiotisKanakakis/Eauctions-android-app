package com.subasta.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import de.hdodenhof.circleimageview.CircleImageView;
import com.subasta.C2037R;
import com.subasta.utils.CustomTextView;

import javax.annotation.Nullable;

public abstract class ChatBubbleRightBinding extends ViewDataBinding {
    @NonNull
    public final CardView cardView;
    @NonNull
    public final CircleImageView ivCat;
    @NonNull
    public final CustomTextView tvTime;
    @NonNull
    public final CustomTextView txtMsg;

    protected ChatBubbleRightBinding(Object obj, View view, int i, CardView cardView2, CircleImageView circleImageView, CustomTextView customTextView, CustomTextView customTextView2) {
        super(obj, view, i);
        this.cardView = cardView2;
        this.ivCat = circleImageView;
        this.tvTime = customTextView;
        this.txtMsg = customTextView2;
    }

    @NonNull
    public static ChatBubbleRightBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ChatBubbleRightBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChatBubbleRightBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.chat_bubble_right, viewGroup, z, obj);
    }

    @NonNull
    public static ChatBubbleRightBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ChatBubbleRightBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChatBubbleRightBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.chat_bubble_right, null, false, obj);
    }

    public static ChatBubbleRightBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChatBubbleRightBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ChatBubbleRightBinding) bind(obj, view, C2037R.layout.chat_bubble_right);
    }
}
