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

public abstract class ChatBubbleLeft1Binding extends ViewDataBinding {
    @NonNull
    public final CardView cardView;
    @NonNull
    public final CircleImageView ivCat;
    @NonNull
    public final CustomTextView txtMsg;
    @NonNull
    public final CustomTextView txtTime;

    protected ChatBubbleLeft1Binding(Object obj, View view, int i, CardView cardView2, CircleImageView circleImageView, CustomTextView customTextView, CustomTextView customTextView2) {
        super(obj, view, i);
        this.cardView = cardView2;
        this.ivCat = circleImageView;
        this.txtMsg = customTextView;
        this.txtTime = customTextView2;
    }

    @NonNull
    public static ChatBubbleLeft1Binding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ChatBubbleLeft1Binding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChatBubbleLeft1Binding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.chat_bubble_left1, viewGroup, z, obj);
    }

    @NonNull
    public static ChatBubbleLeft1Binding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ChatBubbleLeft1Binding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChatBubbleLeft1Binding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.chat_bubble_left1, null, false, obj);
    }

    public static ChatBubbleLeft1Binding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChatBubbleLeft1Binding bind(@NonNull View view, @Nullable Object obj) {
        return (ChatBubbleLeft1Binding) bind(obj, view, C2037R.layout.chat_bubble_left1);
    }
}
