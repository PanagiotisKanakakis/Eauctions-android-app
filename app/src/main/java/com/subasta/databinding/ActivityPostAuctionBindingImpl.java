package com.subasta.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.subasta.C2037R;
import com.subasta.utils.CustomTextViewBold;

import javax.annotation.Nullable;

public class ActivityPostAuctionBindingImpl extends ActivityPostAuctionBinding {
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
        sViewsWithIds.put(C2037R.C2039id.customgrid, 1);
        sViewsWithIds.put(C2037R.C2039id.cardView, 2);
        sViewsWithIds.put(C2037R.C2039id.rlHeader, 3);
        sViewsWithIds.put(C2037R.C2039id.os_texts, 4);
        sViewsWithIds.put(C2037R.C2039id.ivBack, 5);
    }

    public ActivityPostAuctionBindingImpl(@Nullable androidx.databinding.DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private ActivityPostAuctionBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CardView) objArr[2], (RecyclerView) objArr[1], (ImageView) objArr[5], (CustomTextViewBold) objArr[4], (RelativeLayout) objArr[3]);
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
