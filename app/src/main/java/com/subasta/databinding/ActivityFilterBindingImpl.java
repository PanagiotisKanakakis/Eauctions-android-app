package com.subasta.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;

import com.subasta.C2037R;

import javax.annotation.Nullable;

public class ActivityFilterBindingImpl extends ActivityFilterBinding {
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
        sViewsWithIds.put(C2037R.C2039id.line1, 2);
        sViewsWithIds.put(C2037R.C2039id.ivBackFilter, 3);
        sViewsWithIds.put(C2037R.C2039id.tvtitle, 4);
        sViewsWithIds.put(C2037R.C2039id.clearfilter, 5);
        sViewsWithIds.put(C2037R.C2039id.scroll, 6);
        sViewsWithIds.put(C2037R.C2039id.tvdis, 7);
        sViewsWithIds.put(C2037R.C2039id.bsbFilter, 8);
        sViewsWithIds.put(C2037R.C2039id.tvtitle3, 9);
        sViewsWithIds.put(C2037R.C2039id.recycleview1, 10);
        sViewsWithIds.put(C2037R.C2039id.tvtitle4, 11);
        sViewsWithIds.put(C2037R.C2039id.cardView2, 12);
        sViewsWithIds.put(C2037R.C2039id.MinPrice, 13);
        sViewsWithIds.put(C2037R.C2039id.cardView3, 14);
        sViewsWithIds.put(C2037R.C2039id.MaxPrice, 15);
        sViewsWithIds.put(C2037R.C2039id.cardViewbottom, 16);
        sViewsWithIds.put(C2037R.C2039id.Applyfilter, 17);
    }

    public ActivityFilterBindingImpl(@Nullable androidx.databinding.DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 18, sIncludes, sViewsWithIds));
    }

    private ActivityFilterBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[17], objArr[15], objArr[13], objArr[8], objArr[1], objArr[12], objArr[14], objArr[16], objArr[5], objArr[3], objArr[2], objArr[10], objArr[6], objArr[7], objArr[4], objArr[9], objArr[11]);
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
