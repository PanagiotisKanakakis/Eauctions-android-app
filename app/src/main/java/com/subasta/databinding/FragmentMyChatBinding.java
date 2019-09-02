package com.subasta.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.subasta.C2037R;
import com.subasta.utils.CustomTextViewBold;

import javax.annotation.Nullable;

public abstract class FragmentMyChatBinding extends ViewDataBinding {
    @NonNull
    public final CardView cardView1;
    @NonNull
    public final SearchView chatSearch;
    @NonNull
    public final RelativeLayout llchat1;
    @NonNull
    public final RecyclerView recycle1;
    @NonNull
    public final SwipeRefreshLayout swipeRefreshLayout;
    @NonNull
    public final CustomTextViewBold tvNo;

    protected FragmentMyChatBinding(Object obj, View view, int i, CardView cardView, SearchView searchView, RelativeLayout relativeLayout, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout2, CustomTextViewBold customTextViewBold) {
        super(obj, view, i);
        this.cardView1 = cardView;
        this.chatSearch = searchView;
        this.llchat1 = relativeLayout;
        this.recycle1 = recyclerView;
        this.swipeRefreshLayout = swipeRefreshLayout2;
        this.tvNo = customTextViewBold;
    }

    @NonNull
    public static FragmentMyChatBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static FragmentMyChatBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentMyChatBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.fragment_my_chat, viewGroup, z, obj);
    }

    @NonNull
    public static FragmentMyChatBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static FragmentMyChatBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentMyChatBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.fragment_my_chat, null, false, obj);
    }

    public static FragmentMyChatBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMyChatBinding bind(@NonNull View view, @Nullable Object obj) {
        return (FragmentMyChatBinding) bind(obj, view, C2037R.layout.fragment_my_chat);
    }
}
