package com.subasta.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;

import com.subasta.C2037R;

import javax.annotation.Nullable;

public class ActivityDetailsAutionBindingImpl extends ActivityDetailsAutionBinding {
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
        sViewsWithIds.put(C2037R.C2039id.ivBack, 2);
        sViewsWithIds.put(C2037R.C2039id.llImages, 3);
        sViewsWithIds.put(C2037R.C2039id.ivAddImages, 4);
        sViewsWithIds.put(C2037R.C2039id.addMoreimages, 5);
        sViewsWithIds.put(C2037R.C2039id.rvImage, 6);
        sViewsWithIds.put(C2037R.C2039id.tvTitle, 7);
        sViewsWithIds.put(C2037R.C2039id.etTitle, 8);
        sViewsWithIds.put(C2037R.C2039id.tvbrandname, 9);
        sViewsWithIds.put(C2037R.C2039id.etBrandName, 10);
        sViewsWithIds.put(C2037R.C2039id.tvdescription, 11);
        sViewsWithIds.put(C2037R.C2039id.etDescription, 12);
        sViewsWithIds.put(C2037R.C2039id.etAdress, 13);
        sViewsWithIds.put(C2037R.C2039id.etPrice, 14);
        sViewsWithIds.put(C2037R.C2039id.et_S_date, 15);
        sViewsWithIds.put(C2037R.C2039id.et_end_date, 16);
        sViewsWithIds.put(C2037R.C2039id.et_owner, 17);
        sViewsWithIds.put(C2037R.C2039id.line1, 18);
        sViewsWithIds.put(C2037R.C2039id.rGroup, 19);
        sViewsWithIds.put(C2037R.C2039id.rbYes, 20);
        sViewsWithIds.put(C2037R.C2039id.rbNo, 21);
        sViewsWithIds.put(C2037R.C2039id.btnpost, 22);
        sViewsWithIds.put(C2037R.C2039id.rlSnackbar, 23);
    }

    public ActivityDetailsAutionBindingImpl(@Nullable androidx.databinding.DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 24, sIncludes, sViewsWithIds));
    }

    private ActivityDetailsAutionBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[5], objArr[22], objArr[1], objArr[13], objArr[10], objArr[12], objArr[16], objArr[17], objArr[14], objArr[15], objArr[8], objArr[4], objArr[2], objArr[18], objArr[3], objArr[19], objArr[21], objArr[20], objArr[23], objArr[6], objArr[7], objArr[9], objArr[11]);
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
