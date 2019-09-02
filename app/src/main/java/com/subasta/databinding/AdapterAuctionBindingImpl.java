package com.subasta.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import de.hdodenhof.circleimageview.CircleImageView;
import com.subasta.C2037R;
import com.subasta.utils.CustomTextView;

import javax.annotation.Nullable;

public class AdapterAuctionBindingImpl extends AdapterAuctionBinding {
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
        sViewsWithIds.put(C2037R.C2039id.cardView, 1);
        sViewsWithIds.put(C2037R.C2039id.Line1, 2);
        sViewsWithIds.put(C2037R.C2039id.ivCatimg, 3);
        sViewsWithIds.put(C2037R.C2039id.relay2, 4);
        sViewsWithIds.put(C2037R.C2039id.tvProductname, 5);
        sViewsWithIds.put(C2037R.C2039id.tvLocation, 6);
        sViewsWithIds.put(C2037R.C2039id.tvAddress, 7);
        sViewsWithIds.put(C2037R.C2039id.tvMinBidTxt, 8);
        sViewsWithIds.put(C2037R.C2039id.tvPrice, 9);
        sViewsWithIds.put(C2037R.C2039id.card_view, 10);
        sViewsWithIds.put(C2037R.C2039id.ivbid, 11);
    }

    public AdapterAuctionBindingImpl(@Nullable androidx.databinding.DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    private AdapterAuctionBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[2], (CardView) objArr[1], (CardView) objArr[10], (ImageView) objArr[3], (CircleImageView) objArr[11], (LinearLayout) objArr[0], (RelativeLayout) objArr[4], (CustomTextView) objArr[7], (CustomTextView) objArr[6], (CustomTextView) objArr[8], (CustomTextView) objArr[9], (CustomTextView) objArr[5]);
        this.mDirtyFlags = -1;
        this.line1.setTag(null);
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
