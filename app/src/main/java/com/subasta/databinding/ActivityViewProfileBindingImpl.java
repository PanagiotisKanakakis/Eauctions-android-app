package com.subasta.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;

import com.subasta.C2037R;
import com.subasta.utils.CustomEditText;
import com.subasta.utils.CustomTextViewBold;
import com.subasta.utils.RoundRectCornerImageView;

import javax.annotation.Nullable;

public class ActivityViewProfileBindingImpl extends ActivityViewProfileBinding {
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
        sViewsWithIds.put(C2037R.C2039id.iActProfile, 2);
        sViewsWithIds.put(C2037R.C2039id.profileback, 3);
        sViewsWithIds.put(C2037R.C2039id.mainlayout, 4);
        sViewsWithIds.put(C2037R.C2039id.line1, 5);
        sViewsWithIds.put(C2037R.C2039id.civProfile, 6);
        sViewsWithIds.put(C2037R.C2039id.ctvName, 7);
        sViewsWithIds.put(C2037R.C2039id.line2, 8);
        sViewsWithIds.put(C2037R.C2039id.etEmail, 9);
        sViewsWithIds.put(C2037R.C2039id.cetPhoneno, 10);
        sViewsWithIds.put(C2037R.C2039id.cetAddress, 11);
    }

    public ActivityViewProfileBindingImpl(@Nullable androidx.databinding.DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    private ActivityViewProfileBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CardView) objArr[1], (CustomEditText) objArr[11], (CustomEditText) objArr[10], (RoundRectCornerImageView) objArr[6], (CustomTextViewBold) objArr[7], (CustomEditText) objArr[9], (LinearLayout) objArr[2], (LinearLayout) objArr[5], (LinearLayout) objArr[8], (LinearLayout) objArr[4], (ImageView) objArr[3]);
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
