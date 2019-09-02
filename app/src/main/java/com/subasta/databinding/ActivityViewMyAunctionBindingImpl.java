package com.subasta.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;

import com.subasta.C2037R;

import javax.annotation.Nullable;

public class ActivityViewMyAunctionBindingImpl extends ActivityViewMyAunctionBinding {
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
        sViewsWithIds.put(C2037R.C2039id.ivGallery, 1);
        sViewsWithIds.put(C2037R.C2039id.llClick, 2);
        sViewsWithIds.put(C2037R.C2039id.tvName, 3);
        sViewsWithIds.put(C2037R.C2039id.tvDate, 4);
        sViewsWithIds.put(C2037R.C2039id.simpleRatingBar1, 5);
        sViewsWithIds.put(C2037R.C2039id.catname, 6);
        sViewsWithIds.put(C2037R.C2039id.tvPrice, 7);
        sViewsWithIds.put(C2037R.C2039id.tvShortDescription, 8);
        sViewsWithIds.put(C2037R.C2039id.ivMap, 9);
        sViewsWithIds.put(C2037R.C2039id.tvKm, 10);
        sViewsWithIds.put(C2037R.C2039id.tvAddress, 11);
        sViewsWithIds.put(C2037R.C2039id.tvDescription, 12);
        sViewsWithIds.put(C2037R.C2039id.linear, 13);
        sViewsWithIds.put(C2037R.C2039id.rvBids, 14);
        sViewsWithIds.put(C2037R.C2039id.tvViewAllBid, 15);
        sViewsWithIds.put(C2037R.C2039id.linRating, 16);
        sViewsWithIds.put(C2037R.C2039id.rvAllRating, 17);
        sViewsWithIds.put(C2037R.C2039id.tvViewRating, 18);
        sViewsWithIds.put(C2037R.C2039id.ivProfile, 19);
        sViewsWithIds.put(C2037R.C2039id.deactivate, 20);
        sViewsWithIds.put(C2037R.C2039id.ivBack, 21);
        sViewsWithIds.put(C2037R.C2039id.llViewImage, 22);
        sViewsWithIds.put(C2037R.C2039id.imgegallery, 23);
        sViewsWithIds.put(C2037R.C2039id.tvMediaCount, 24);
        sViewsWithIds.put(C2037R.C2039id.ivShare, 25);
        sViewsWithIds.put(C2037R.C2039id.ivFav, 26);
        sViewsWithIds.put(C2037R.C2039id.ivFavfilled, 27);
        sViewsWithIds.put(C2037R.C2039id.rlBottom, 28);
        sViewsWithIds.put(C2037R.C2039id.btnEdit, 29);
        sViewsWithIds.put(C2037R.C2039id.btnDelete, 30);
    }

    public ActivityViewMyAunctionBindingImpl(@Nullable androidx.databinding.DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 31, sIncludes, sViewsWithIds));
    }

    private ActivityViewMyAunctionBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[30], objArr[29], objArr[6], objArr[20], objArr[23], objArr[21], objArr[26], objArr[27], objArr[1], objArr[9], objArr[19], objArr[25], objArr[16], objArr[13], objArr[2], objArr[22], objArr[28], objArr[17], objArr[14], objArr[5], objArr[11], objArr[4], objArr[12], objArr[10], objArr[24], objArr[3], objArr[7], objArr[8], objArr[15], objArr[18]);
        this.mDirtyFlags = -1;
        this.mboundView0 = (RelativeLayout) objArr[0];
        this.mboundView0.setTag("layout/activity_view_my_aunction_0");
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
