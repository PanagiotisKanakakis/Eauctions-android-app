package com.subasta.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;

import com.subasta.C2037R;

import javax.annotation.Nullable;

public class ActivityUpdateprofileBindingImpl extends ActivityUpdateprofileBinding {
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
        sViewsWithIds.put(C2037R.C2039id.iActProfile, 2);
        sViewsWithIds.put(C2037R.C2039id.profileback, 3);
        sViewsWithIds.put(C2037R.C2039id.mainlayout, 4);
        sViewsWithIds.put(C2037R.C2039id.line1, 5);
        sViewsWithIds.put(C2037R.C2039id.civProfile, 6);
        sViewsWithIds.put(C2037R.C2039id.civProfile1, 7);
        sViewsWithIds.put(C2037R.C2039id.line2, 8);
        sViewsWithIds.put(C2037R.C2039id.ctvName, 9);
        sViewsWithIds.put(C2037R.C2039id.etEmail, 10);
        sViewsWithIds.put(C2037R.C2039id.cCodePicker, 11);
        sViewsWithIds.put(C2037R.C2039id.cetPhoneno, 12);
        sViewsWithIds.put(C2037R.C2039id.cetAddress, 13);
        sViewsWithIds.put(C2037R.C2039id.ctvGender, 14);
        sViewsWithIds.put(C2037R.C2039id.radioGroup, 15);
        sViewsWithIds.put(C2037R.C2039id.male, 16);
        sViewsWithIds.put(C2037R.C2039id.female, 17);
        sViewsWithIds.put(C2037R.C2039id.btnsubmitdata, 18);
    }

    public ActivityUpdateprofileBindingImpl(@Nullable androidx.databinding.DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 19, sIncludes, sViewsWithIds));
    }

    private ActivityUpdateprofileBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[18], objArr[11], objArr[1], objArr[13], objArr[12], objArr[6], objArr[7], objArr[14], objArr[9], objArr[10], objArr[17], objArr[2], objArr[5], objArr[8], objArr[4], objArr[16], objArr[3], objArr[15]);
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
