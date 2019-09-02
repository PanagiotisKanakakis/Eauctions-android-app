package com.subasta.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.subasta.C2037R;
import com.subasta.utils.CustomTextView;
import com.subasta.utils.CustomTextViewBold;

import javax.annotation.Nullable;

public class ActivitySubscriptionPackageBindingImpl extends ActivitySubscriptionPackageBinding {
    @Nullable
    private static final IncludedLayouts sIncludes = null;
    @Nullable
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    @NonNull
    private final RelativeLayout mboundView0;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        sViewsWithIds.put(C2037R.C2039id.cardView, 1);
        sViewsWithIds.put(C2037R.C2039id.linear, 2);
        sViewsWithIds.put(C2037R.C2039id.pkg, 3);
        sViewsWithIds.put(C2037R.C2039id.status, 4);
        sViewsWithIds.put(C2037R.C2039id.pkgName, 5);
        sViewsWithIds.put(C2037R.C2039id.price, 6);
        sViewsWithIds.put(C2037R.C2039id.aunctionCount, 7);
        sViewsWithIds.put(C2037R.C2039id.date, 8);
        sViewsWithIds.put(C2037R.C2039id.rvplans, 9);
        sViewsWithIds.put(C2037R.C2039id.noPackage, 10);
    }

    public ActivitySubscriptionPackageBindingImpl(@Nullable androidx.databinding.DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private ActivitySubscriptionPackageBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CustomTextView) objArr[7], (CardView) objArr[1], (CustomTextView) objArr[8], (LinearLayout) objArr[2], (CustomTextViewBold) objArr[10], (CustomTextViewBold) objArr[3], (CustomTextView) objArr[5], (CustomTextViewBold) objArr[6], (RecyclerView) objArr[9], (CustomTextViewBold) objArr[4]);
        this.mDirtyFlags = -1;
        this.mboundView0 = (RelativeLayout) objArr[0];
        this.mboundView0.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
    }
}
