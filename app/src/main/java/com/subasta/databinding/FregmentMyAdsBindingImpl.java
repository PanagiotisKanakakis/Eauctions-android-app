package com.subasta.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.subasta.C2037R;
import com.subasta.utils.CustomTextView;

import javax.annotation.Nullable;

public class FregmentMyAdsBindingImpl extends FregmentMyAdsBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    @Nullable
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    @NonNull
    private final LinearLayout mboundView0;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        sViewsWithIds.put(C2037R.C2039id.tvSelling, 1);
        sViewsWithIds.put(C2037R.C2039id.tvSellingSelect, 2);
        sViewsWithIds.put(C2037R.C2039id.tvSold, 3);
        sViewsWithIds.put(C2037R.C2039id.tvSoldSelect, 4);
        sViewsWithIds.put(C2037R.C2039id.tvFavourites, 5);
        sViewsWithIds.put(C2037R.C2039id.tvFavouritesSelect, 6);
        sViewsWithIds.put(C2037R.C2039id.swipe_refresh_layout, 7);
        sViewsWithIds.put(C2037R.C2039id.recycleview1, 8);
        sViewsWithIds.put(C2037R.C2039id.tvNo, 9);
    }

    public FregmentMyAdsBindingImpl(@Nullable androidx.databinding.DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private FregmentMyAdsBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RecyclerView) objArr[8], (SwipeRefreshLayout) objArr[7], (CustomTextView) objArr[5], (CustomTextView) objArr[6], (CustomTextView) objArr[9], (CustomTextView) objArr[1], (CustomTextView) objArr[2], (CustomTextView) objArr[3], (CustomTextView) objArr[4]);
        this.mDirtyFlags = -1;
        this.mboundView0 = (LinearLayout) objArr[0];
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
