package com.subasta.databinding;

import android.util.SparseIntArray;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.subasta.C2037R;

import javax.annotation.Nullable;

public class ActivityProfileBindingImpl extends ActivityProfileBinding {
    @Nullable
    private static final IncludedLayouts sIncludes = null;
    @Nullable
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    @NonNull
    private final ConstraintLayout mboundView0;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        sViewsWithIds.put(C2037R.C2039id.iActProfile, 1);
        sViewsWithIds.put(C2037R.C2039id.profileback, 2);
        sViewsWithIds.put(C2037R.C2039id.profilenotification, 3);
        sViewsWithIds.put(C2037R.C2039id.llProfile, 4);
        sViewsWithIds.put(C2037R.C2039id.civProfile, 5);
        sViewsWithIds.put(C2037R.C2039id.ctvName, 6);
        sViewsWithIds.put(C2037R.C2039id.ctvContact, 7);
        sViewsWithIds.put(C2037R.C2039id.etEmail, 8);
        sViewsWithIds.put(C2037R.C2039id.cetPhoneno, 9);
        sViewsWithIds.put(C2037R.C2039id.imageView2, 10);
        sViewsWithIds.put(C2037R.C2039id.cetAddress, 11);
        sViewsWithIds.put(C2037R.C2039id.ctvGender, 12);
        sViewsWithIds.put(C2037R.C2039id.radioGroup, 13);
        sViewsWithIds.put(C2037R.C2039id.male, 14);
        sViewsWithIds.put(C2037R.C2039id.female, 15);
        sViewsWithIds.put(C2037R.C2039id.btnsubmitdata, 16);
    }

    public ActivityProfileBindingImpl(@Nullable androidx.databinding.DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 17, sIncludes, sViewsWithIds));
    }

    private ActivityProfileBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[16], objArr[11], objArr[9], objArr[5], objArr[7], objArr[12], objArr[6], objArr[8], objArr[15], objArr[1], objArr[10], objArr[4], objArr[14], objArr[2], objArr[3], objArr[13]);
        this.mDirtyFlags = -1;
        this.mboundView0 = (ConstraintLayout) objArr[0];
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
