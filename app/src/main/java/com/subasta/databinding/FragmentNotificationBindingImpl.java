package com.subasta.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.subasta.C2037R;
import com.subasta.utils.CustomTextViewBold;

import javax.annotation.Nullable;

public class FragmentNotificationBindingImpl extends FragmentNotificationBinding {
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
        sViewsWithIds.put(C2037R.C2039id.relative, 1);
        sViewsWithIds.put(C2037R.C2039id.notification, 2);
        sViewsWithIds.put(C2037R.C2039id.noNotification, 3);
        sViewsWithIds.put(C2037R.C2039id.recycleview1, 4);
    }

    public FragmentNotificationBindingImpl(@Nullable androidx.databinding.DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private FragmentNotificationBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CustomTextViewBold) objArr[3], (ImageView) objArr[2], (RecyclerView) objArr[4], (RelativeLayout) objArr[1], (SwipeRefreshLayout) objArr[0]);
        this.mDirtyFlags = -1;
        this.swipeRefreshLayout.setTag(null);
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
