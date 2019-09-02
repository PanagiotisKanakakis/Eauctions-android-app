package com.subasta.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.subasta.C2037R;
import com.subasta.utils.CustomTextView;

import javax.annotation.Nullable;

public abstract class AdapterChatItemListBinding extends ViewDataBinding {
    @NonNull
    public final LinearLayout chatLeftMsgLayout;
    @NonNull
    public final CustomTextView chatLeftMsgTextView;
    @NonNull
    public final LinearLayout chatRightMsgLayout;
    @NonNull
    public final CustomTextView chatRightMsgTextView;

    protected AdapterChatItemListBinding(Object obj, View view, int i, LinearLayout linearLayout, CustomTextView customTextView, LinearLayout linearLayout2, CustomTextView customTextView2) {
        super(obj, view, i);
        this.chatLeftMsgLayout = linearLayout;
        this.chatLeftMsgTextView = customTextView;
        this.chatRightMsgLayout = linearLayout2;
        this.chatRightMsgTextView = customTextView2;
    }

    @NonNull
    public static AdapterChatItemListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static AdapterChatItemListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AdapterChatItemListBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.adapter_chat_item_list, viewGroup, z, obj);
    }

    @NonNull
    public static AdapterChatItemListBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static AdapterChatItemListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (AdapterChatItemListBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.adapter_chat_item_list, null, false, obj);
    }

    public static AdapterChatItemListBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterChatItemListBinding bind(@NonNull View view, @Nullable Object obj) {
        return (AdapterChatItemListBinding) bind(obj, view, C2037R.layout.adapter_chat_item_list);
    }
}
