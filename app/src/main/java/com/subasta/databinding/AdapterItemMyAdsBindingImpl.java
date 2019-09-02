package com.subasta.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import com.subasta.C2037R;
import com.subasta.utils.CustomTextView;

import javax.annotation.Nullable;

public class AdapterItemMyAdsBindingImpl extends AdapterItemMyAdsBinding {
    @Nullable
    private static final IncludedLayouts sIncludes = null;
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
        sViewsWithIds.put(C2037R.C2039id.iv1, 1);
        sViewsWithIds.put(C2037R.C2039id.tvtitle, 2);
        sViewsWithIds.put(C2037R.C2039id.tvPrice, 3);
        sViewsWithIds.put(C2037R.C2039id.tvDescription, 4);
    }

    public AdapterItemMyAdsBindingImpl(@Nullable androidx.databinding.DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private AdapterItemMyAdsBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CardView) objArr[0], (ImageView) objArr[1], (CustomTextView) objArr[4], (CustomTextView) objArr[3], (CustomTextView) objArr[2]);
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
