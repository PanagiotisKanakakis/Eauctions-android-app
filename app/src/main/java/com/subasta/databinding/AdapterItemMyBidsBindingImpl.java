package com.subasta.databinding;

import android.util.SparseIntArray;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

import com.subasta.C2037R;

import javax.annotation.Nullable;

public class AdapterItemMyBidsBindingImpl extends AdapterItemMyBidsBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    @Nullable
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        sViewsWithIds.put(C2037R.C2039id.Line1, 1);
        sViewsWithIds.put(C2037R.C2039id.image, 2);
        sViewsWithIds.put(C2037R.C2039id.relay2, 3);
        sViewsWithIds.put(C2037R.C2039id.tvProductname, 4);
        sViewsWithIds.put(C2037R.C2039id.tvAuctionPrice, 5);
        sViewsWithIds.put(C2037R.C2039id.line1, 6);
        sViewsWithIds.put(C2037R.C2039id.tvLocation, 7);
        sViewsWithIds.put(C2037R.C2039id.tvPrice, 8);
        sViewsWithIds.put(C2037R.C2039id.line2, 9);
        sViewsWithIds.put(C2037R.C2039id.tvMinBidTxt, 10);
        sViewsWithIds.put(C2037R.C2039id.btnEdit, 11);
        sViewsWithIds.put(C2037R.C2039id.btnDelete, 12);
    }

    public AdapterItemMyBidsBindingImpl(@Nullable androidx.databinding.DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 13, sIncludes, sViewsWithIds));
    }

    private AdapterItemMyBidsBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[1], objArr[12], objArr[11], objArr[0], objArr[2], objArr[6], objArr[9], objArr[3], objArr[5], objArr[7], objArr[10], objArr[8], objArr[4]);
        this.mDirtyFlags = -1;
        this.cardView.setTag(null);
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
