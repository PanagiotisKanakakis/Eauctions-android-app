package com.subasta.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import com.subasta.C2037R;
import com.subasta.utils.CustomTextView;
import com.subasta.utils.CustomTextViewBold;

import javax.annotation.Nullable;

public class AdapterWonBidsBindingImpl extends AdapterWonBidsBinding {
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
        sViewsWithIds.put(C2037R.C2039id.tvProPrice, 3);
        sViewsWithIds.put(C2037R.C2039id.tvPrice, 4);
        sViewsWithIds.put(C2037R.C2039id.tvDate, 5);
    }

    public AdapterWonBidsBindingImpl(@Nullable androidx.databinding.DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private AdapterWonBidsBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CardView) objArr[0], (ImageView) objArr[1], (CustomTextView) objArr[5], (CustomTextViewBold) objArr[4], (CustomTextViewBold) objArr[3], (CustomTextViewBold) objArr[2]);
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
