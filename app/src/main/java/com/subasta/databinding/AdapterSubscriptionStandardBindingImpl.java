package com.subasta.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.subasta.C2037R;
import com.subasta.utils.CustomTextView;

import javax.annotation.Nullable;

public class AdapterSubscriptionStandardBindingImpl extends AdapterSubscriptionStandardBinding {
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
        sViewsWithIds.put(C2037R.C2039id.linercv, 1);
        sViewsWithIds.put(C2037R.C2039id.cvsubscription, 2);
        sViewsWithIds.put(C2037R.C2039id.linerplan, 3);
        sViewsWithIds.put(C2037R.C2039id.tvstanderd, 4);
        sViewsWithIds.put(C2037R.C2039id.tvprice, 5);
        sViewsWithIds.put(C2037R.C2039id.tvtotaldays, 6);
        sViewsWithIds.put(C2037R.C2039id.tvaunctioncount, 7);
        sViewsWithIds.put(C2037R.C2039id.status, 8);
        sViewsWithIds.put(C2037R.C2039id.btnupgrade, 9);
    }

    public AdapterSubscriptionStandardBindingImpl(@Nullable androidx.databinding.DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private AdapterSubscriptionStandardBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (MaterialButton) objArr[9], (MaterialCardView) objArr[2], (LinearLayout) objArr[1], (LinearLayout) objArr[3], (CustomTextView) objArr[8], (CustomTextView) objArr[7], (CustomTextView) objArr[5], (CustomTextView) objArr[4], (CustomTextView) objArr[6]);
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
