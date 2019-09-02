package com.subasta.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.subasta.C2037R;
import com.subasta.utils.CustomTextView;
import com.subasta.utils.CustomTextViewBold;

import javax.annotation.Nullable;

public class ActivityCategoryBasedAdsAuctionBindingImpl extends ActivityCategoryBasedAdsAuctionBinding {
    @Nullable
    private static final IncludedLayouts sIncludes = new IncludedLayouts(13);
    @Nullable
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    @NonNull
    private final ConstraintLayout mboundView0;

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        sIncludes.setIncludes(0, new String[]{"actionbar_header_nav"}, new int[]{1}, new int[]{C2037R.layout.actionbar_header_nav});
        sViewsWithIds.put(C2037R.C2039id.rlAllAuc, 2);
        sViewsWithIds.put(C2037R.C2039id.llAuct, 3);
        sViewsWithIds.put(C2037R.C2039id.rlAuc, 4);
        sViewsWithIds.put(C2037R.C2039id.cardView, 5);
        sViewsWithIds.put(C2037R.C2039id.chatSearch, 6);
        sViewsWithIds.put(C2037R.C2039id.rvAuction, 7);
        sViewsWithIds.put(C2037R.C2039id.ftv_NoAuction, 8);
        sViewsWithIds.put(C2037R.C2039id.tvViewMore, 9);
        sViewsWithIds.put(C2037R.C2039id.myview, 10);
        sViewsWithIds.put(C2037R.C2039id.fab_PostAuctionCat, 11);
        sViewsWithIds.put(C2037R.C2039id.tvNo, 12);
    }

    public ActivityCategoryBasedAdsAuctionBindingImpl(@Nullable androidx.databinding.DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 13, sIncludes, sViewsWithIds));
    }

    private ActivityCategoryBasedAdsAuctionBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (CardView) objArr[5], (SearchView) objArr[6], (FloatingActionButton) objArr[11], (CustomTextView) objArr[8], (ActionbarHeaderNavBinding) objArr[1], (LinearLayout) objArr[3], (View) objArr[10], (RelativeLayout) objArr[2], (RelativeLayout) objArr[4], (RecyclerView) objArr[7], (CustomTextViewBold) objArr[12], (CustomTextView) objArr[9]);
        this.mDirtyFlags = -1;
        this.mboundView0 = (ConstraintLayout) objArr[0];
        this.mboundView0.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2;
        }
        this.iAHN.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.iAHN.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasPendingBindings() {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = r6.mDirtyFlags     // Catch:{ all -> 0x0018 }
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x000c
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            return r4
        L_0x000c:
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            com.subasta.databinding.ActionbarHeaderNavBinding r0 = r6.iAHN
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0016
            return r4
        L_0x0016:
            r0 = 0
            return r0
        L_0x0018:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.subasta.databinding.ActivityCategoryBasedAdsAuctionBindingImpl.hasPendingBindings():boolean");
    }

    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.iAHN.setLifecycleOwner(lifecycleOwner);
    }

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeIAHN((ActionbarHeaderNavBinding) obj, i2);
    }

    private boolean onChangeIAHN(ActionbarHeaderNavBinding actionbarHeaderNavBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        executeBindingsOn(this.iAHN);
    }
}
