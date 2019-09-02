package com.subasta.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

import com.subasta.C2037R;

import javax.annotation.Nullable;

public class ActivitySignInBindingImpl extends ActivitySignInBinding {
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
        sViewsWithIds.put(C2037R.C2039id.liner_signin, 1);
        sViewsWithIds.put(C2037R.C2039id.image_logo, 2);
        sViewsWithIds.put(C2037R.C2039id.liner_loginwith, 3);
        sViewsWithIds.put(C2037R.C2039id.btnFacebook, 4);
        sViewsWithIds.put(C2037R.C2039id.btnGmail, 5);
        sViewsWithIds.put(C2037R.C2039id.tv_or, 6);
        sViewsWithIds.put(C2037R.C2039id.liner_email, 7);
        sViewsWithIds.put(C2037R.C2039id.etEmail, 8);
        sViewsWithIds.put(C2037R.C2039id.etPassword, 9);
        sViewsWithIds.put(C2037R.C2039id.ivPass, 10);
        sViewsWithIds.put(C2037R.C2039id.btnSignIn, 11);
        sViewsWithIds.put(C2037R.C2039id.tvCreateAccount, 12);
        sViewsWithIds.put(C2037R.C2039id.tvFrogotPass, 13);
        sViewsWithIds.put(C2037R.C2039id.rlSnackbar, 14);
    }

    public ActivitySignInBindingImpl(@Nullable androidx.databinding.DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 15, sIncludes, sViewsWithIds));
    }

    private ActivitySignInBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[4], objArr[5], objArr[11], objArr[8], objArr[9], objArr[2], objArr[10], objArr[7], objArr[3], objArr[1], objArr[14], objArr[12], objArr[13], objArr[6]);
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
