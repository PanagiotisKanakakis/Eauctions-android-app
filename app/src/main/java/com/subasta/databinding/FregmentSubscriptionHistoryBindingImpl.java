package com.subasta.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.subasta.C2037R;
import com.subasta.utils.CustomTextViewBold;

import javax.annotation.Nullable;

public class FregmentSubscriptionHistoryBindingImpl extends FregmentSubscriptionHistoryBinding {
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
        sViewsWithIds.put(C2037R.C2039id.line1, 2);
        sViewsWithIds.put(C2037R.C2039id.icBack, 3);
        sViewsWithIds.put(C2037R.C2039id.tvCategoryName, 4);
        sViewsWithIds.put(C2037R.C2039id.cardView1, 5);
        sViewsWithIds.put(C2037R.C2039id.svHistory, 6);
        sViewsWithIds.put(C2037R.C2039id.rvhistory, 7);
        sViewsWithIds.put(C2037R.C2039id.tvNo, 8);
    }

    public FregmentSubscriptionHistoryBindingImpl(@Nullable androidx.databinding.DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private FregmentSubscriptionHistoryBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CardView) objArr[1], (CardView) objArr[5], (ImageView) objArr[3], (RelativeLayout) objArr[2], (RecyclerView) objArr[7], (SearchView) objArr[6], (CustomTextViewBold) objArr[4], (CustomTextViewBold) objArr[8]);
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
