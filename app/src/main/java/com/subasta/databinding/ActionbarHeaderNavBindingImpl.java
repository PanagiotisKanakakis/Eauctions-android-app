package com.subasta.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.Spinner;

import androidx.annotation.NonNull;

import com.subasta.C2037R;
import com.subasta.utils.CustomTextView;
import com.subasta.utils.CustomTextViewBold;

import javax.annotation.Nullable;

public class ActionbarHeaderNavBindingImpl extends ActionbarHeaderNavBinding {
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
        sViewsWithIds.put(C2037R.C2039id.ivMenu, 1);
        sViewsWithIds.put(C2037R.C2039id.ivBack, 2);
        sViewsWithIds.put(C2037R.C2039id.tvtitlemain, 3);
        sViewsWithIds.put(C2037R.C2039id.tvindrapuri, 4);
        sViewsWithIds.put(C2037R.C2039id.spinner1, 5);
        sViewsWithIds.put(C2037R.C2039id.ivSearch1, 6);
        sViewsWithIds.put(C2037R.C2039id.ivFilter, 7);
        sViewsWithIds.put(C2037R.C2039id.ivHistory, 8);
        sViewsWithIds.put(C2037R.C2039id.svHistoryDash, 9);
    }

    public ActionbarHeaderNavBindingImpl(@Nullable androidx.databinding.DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private ActionbarHeaderNavBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RelativeLayout) objArr[0], (ImageView) objArr[2], (ImageView) objArr[7], (ImageView) objArr[8], (ImageView) objArr[1], (ImageView) objArr[6], (Spinner) objArr[5], (SearchView) objArr[9], (CustomTextView) objArr[4], (CustomTextViewBold) objArr[3]);
        this.mDirtyFlags = -1;
        this.headerBar.setTag(null);
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
