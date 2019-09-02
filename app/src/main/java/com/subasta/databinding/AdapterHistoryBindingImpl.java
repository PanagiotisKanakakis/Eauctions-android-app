package com.subasta.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;

import com.subasta.C2037R;
import com.subasta.utils.CustomTextView;
import com.subasta.utils.CustomTextViewBold;

import javax.annotation.Nullable;

public class AdapterHistoryBindingImpl extends AdapterHistoryBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
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
        sViewsWithIds.put(C2037R.C2039id.pkgName, 1);
        sViewsWithIds.put(C2037R.C2039id.totalPrice, 2);
        sViewsWithIds.put(C2037R.C2039id.dis, 3);
        sViewsWithIds.put(C2037R.C2039id.distitle, 4);
        sViewsWithIds.put(C2037R.C2039id.discount, 5);
        sViewsWithIds.put(C2037R.C2039id.tax1, 6);
        sViewsWithIds.put(C2037R.C2039id.taxtitle, 7);
        sViewsWithIds.put(C2037R.C2039id.tax, 8);
        sViewsWithIds.put(C2037R.C2039id.validaty, 9);
        sViewsWithIds.put(C2037R.C2039id.date, 10);
    }

    public AdapterHistoryBindingImpl(@Nullable androidx.databinding.DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private AdapterHistoryBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CardView) objArr[0], (CustomTextView) objArr[10], (ImageView) objArr[3], (CustomTextView) objArr[5], (CustomTextViewBold) objArr[4], (CustomTextViewBold) objArr[1], (CustomTextView) objArr[8], (ImageView) objArr[6], (CustomTextViewBold) objArr[7], (CustomTextView) objArr[2], (CustomTextViewBold) objArr[9]);
        this.mDirtyFlags = -1;
        this.cardClick.setTag(null);
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
