package com.subasta.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;

import com.subasta.C2037R;
import com.subasta.utils.CustomButton;
import com.subasta.utils.CustomEditText;

import javax.annotation.Nullable;

public class ActivityChangPasswordBindingImpl extends ActivityChangPasswordBinding {
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
        sViewsWithIds.put(C2037R.C2039id.ivBack, 1);
        sViewsWithIds.put(C2037R.C2039id.etOldPass, 2);
        sViewsWithIds.put(C2037R.C2039id.ivOldPass, 3);
        sViewsWithIds.put(C2037R.C2039id.etNewPass, 4);
        sViewsWithIds.put(C2037R.C2039id.ivNewPass, 5);
        sViewsWithIds.put(C2037R.C2039id.etConfirmPass, 6);
        sViewsWithIds.put(C2037R.C2039id.ivConfirmPass, 7);
        sViewsWithIds.put(C2037R.C2039id.chang_save, 8);
    }

    public ActivityChangPasswordBindingImpl(@Nullable androidx.databinding.DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private ActivityChangPasswordBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CustomButton) objArr[8], (CustomEditText) objArr[6], (CustomEditText) objArr[4], (CustomEditText) objArr[2], (ImageView) objArr[1], (ImageView) objArr[7], (ImageView) objArr[5], (ImageView) objArr[3]);
        this.mDirtyFlags = -1;
        this.mboundView0 = (RelativeLayout) objArr[0];
        this.mboundView0.setTag(null);
        View view2 = view;
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
