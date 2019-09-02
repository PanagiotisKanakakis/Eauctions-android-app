package com.subasta.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import com.subasta.C2037R;
import com.subasta.utils.CustomButton;
import com.subasta.utils.CustomEditText;
import com.subasta.utils.CustomTextViewBold;

import javax.annotation.Nullable;

public class ActivityAddBidBindingImpl extends ActivityAddBidBinding {
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
        sViewsWithIds.put(C2037R.C2039id.cardView, 1);
        sViewsWithIds.put(C2037R.C2039id.tvtitle, 2);
        sViewsWithIds.put(C2037R.C2039id.ivClose, 3);
        sViewsWithIds.put(C2037R.C2039id.tvBidProductname, 4);
        sViewsWithIds.put(C2037R.C2039id.tvBidProductprice, 5);
        sViewsWithIds.put(C2037R.C2039id.etBidPrice, 6);
        sViewsWithIds.put(C2037R.C2039id.btnAddBid, 7);
    }

    public ActivityAddBidBindingImpl(@Nullable androidx.databinding.DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private ActivityAddBidBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CustomButton) objArr[7], (CardView) objArr[1], (CustomEditText) objArr[6], (ImageView) objArr[3], (CustomTextViewBold) objArr[4], (CustomTextViewBold) objArr[5], (CustomTextViewBold) objArr[2]);
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
