package com.subasta.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

import com.subasta.C2037R;

import javax.annotation.Nullable;

public class FregmentMyAuctionBindingImpl extends FregmentMyAuctionBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    @Nullable
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    @NonNull
    private final LinearLayout mboundView0;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        sViewsWithIds.put(C2037R.C2039id.llmyauction, 1);
        sViewsWithIds.put(C2037R.C2039id.tvmyauction, 2);
        sViewsWithIds.put(C2037R.C2039id.tvAuctionSelect, 3);
        sViewsWithIds.put(C2037R.C2039id.llmybids, 4);
        sViewsWithIds.put(C2037R.C2039id.tvmybids, 5);
        sViewsWithIds.put(C2037R.C2039id.tvBidsSelect, 6);
        sViewsWithIds.put(C2037R.C2039id.llmyfavourites, 7);
        sViewsWithIds.put(C2037R.C2039id.tvFavourites, 8);
        sViewsWithIds.put(C2037R.C2039id.tvFavouritesSelect, 9);
        sViewsWithIds.put(C2037R.C2039id.llmywonbids, 10);
        sViewsWithIds.put(C2037R.C2039id.tvwonbids, 11);
        sViewsWithIds.put(C2037R.C2039id.tvwonBidsSelect, 12);
        sViewsWithIds.put(C2037R.C2039id.container, 13);
    }

    public FregmentMyAuctionBindingImpl(@Nullable androidx.databinding.DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 14, sIncludes, sViewsWithIds));
    }

    private FregmentMyAuctionBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[13], objArr[1], objArr[4], objArr[7], objArr[10], objArr[3], objArr[6], objArr[8], objArr[9], objArr[2], objArr[5], objArr[12], objArr[11]);
        this.mDirtyFlags = -1;
        this.mboundView0 = (LinearLayout) objArr[0];
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
