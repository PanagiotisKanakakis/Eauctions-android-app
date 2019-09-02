package com.subasta.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

import com.subasta.C2037R;

import javax.annotation.Nullable;

public class ActivitySignUpBindingImpl extends ActivitySignUpBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
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
        sViewsWithIds.put(C2037R.C2039id.cardViewProfile, 3);
        sViewsWithIds.put(C2037R.C2039id.ivProfile, 4);
        sViewsWithIds.put(C2037R.C2039id.ivProfilePic, 5);
        sViewsWithIds.put(C2037R.C2039id.et_Name, 6);
        sViewsWithIds.put(C2037R.C2039id.et_Email, 7);
        sViewsWithIds.put(C2037R.C2039id.cCodePicker, 8);
        sViewsWithIds.put(C2037R.C2039id.et_Mobile, 9);
        sViewsWithIds.put(C2037R.C2039id.et_Password, 10);
        sViewsWithIds.put(C2037R.C2039id.ivPass, 11);
        sViewsWithIds.put(C2037R.C2039id.btnSignUp, 12);
        sViewsWithIds.put(C2037R.C2039id.rlSnackbar, 13);
    }

    public ActivitySignUpBindingImpl(@Nullable androidx.databinding.DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 14, sIncludes, sViewsWithIds));
    }

    private ActivitySignUpBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[12], objArr[8], objArr[1], objArr[3], objArr[7], objArr[9], objArr[6], objArr[10], objArr[2], objArr[11], objArr[4], objArr[5], objArr[13]);
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
