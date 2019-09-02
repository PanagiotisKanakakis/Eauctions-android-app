package com.subasta.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;

import com.subasta.C2037R;

import javax.annotation.Nullable;

public class ActivityViewAdvertiseBindingImpl extends ActivityViewAdvertiseBinding {
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
        sViewsWithIds.put(C2037R.C2039id.ivGallery, 1);
        sViewsWithIds.put(C2037R.C2039id.ivBack, 2);
        sViewsWithIds.put(C2037R.C2039id.llViewImage, 3);
        sViewsWithIds.put(C2037R.C2039id.ivShare, 4);
        sViewsWithIds.put(C2037R.C2039id.ivFav11, 5);
        sViewsWithIds.put(C2037R.C2039id.ivFavfilled, 6);
        sViewsWithIds.put(C2037R.C2039id.tvName, 7);
        sViewsWithIds.put(C2037R.C2039id.tvDate, 8);
        sViewsWithIds.put(C2037R.C2039id.tvPrice, 9);
        sViewsWithIds.put(C2037R.C2039id.tvShortDescription, 10);
        sViewsWithIds.put(C2037R.C2039id.ivMap, 11);
        sViewsWithIds.put(C2037R.C2039id.tvKm, 12);
        sViewsWithIds.put(C2037R.C2039id.tvAddress, 13);
        sViewsWithIds.put(C2037R.C2039id.tvDescription, 14);
        sViewsWithIds.put(C2037R.C2039id.rbReview, 15);
        sViewsWithIds.put(C2037R.C2039id.ivProfile, 16);
        sViewsWithIds.put(C2037R.C2039id.rlBottom, 17);
        sViewsWithIds.put(C2037R.C2039id.llOffer, 18);
        sViewsWithIds.put(C2037R.C2039id.llChat, 19);
    }

    public ActivityViewAdvertiseBindingImpl(@Nullable androidx.databinding.DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 20, sIncludes, sViewsWithIds));
    }

    private ActivityViewAdvertiseBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[2], objArr[5], objArr[6], objArr[1], objArr[11], objArr[16], objArr[4], objArr[19], objArr[18], objArr[3], objArr[15], objArr[17], objArr[13], objArr[8], objArr[14], objArr[12], objArr[7], objArr[9], objArr[10]);
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
