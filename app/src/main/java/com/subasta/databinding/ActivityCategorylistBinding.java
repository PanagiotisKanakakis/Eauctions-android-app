package com.subasta.databinding;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.subasta.C2037R;
import com.subasta.utils.CustomTextViewBold;

import javax.annotation.Nullable;

public abstract class ActivityCategorylistBinding extends ViewDataBinding {
    @NonNull
    public final ActionbarHeaderNavBinding iAHN;
    @NonNull
    public final RecyclerView recycleview1;
    @NonNull
    public final CustomTextViewBold tvcatname;

    protected ActivityCategorylistBinding(Object obj, View view, int i, ActionbarHeaderNavBinding actionbarHeaderNavBinding, RecyclerView recyclerView, CustomTextViewBold customTextViewBold) {
        super(obj, view, i);
        this.iAHN = actionbarHeaderNavBinding;
        setContainedBinding(this.iAHN);
        this.recycleview1 = recyclerView;
        this.tvcatname = customTextViewBold;
    }

    @NonNull
    public static ActivityCategorylistBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityCategorylistBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityCategorylistBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_categorylist, viewGroup, z, obj);
    }

    @NonNull
    public static ActivityCategorylistBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @SuppressLint("RestrictedApi")
    @Deprecated
    @NonNull
    public static ActivityCategorylistBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityCategorylistBinding) ViewDataBinding.inflateInternal(layoutInflater, C2037R.layout.activity_categorylist, null, false, obj);
    }

    public static ActivityCategorylistBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityCategorylistBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityCategorylistBinding) bind(obj, view, C2037R.layout.activity_categorylist);
    }
}
