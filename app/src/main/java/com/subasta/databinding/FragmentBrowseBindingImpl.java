package com.subasta.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.subasta.C2037R;
import com.subasta.utils.CustomButton;
import com.subasta.utils.CustomTextView;

import javax.annotation.Nullable;

public class FragmentBrowseBindingImpl extends FragmentBrowseBinding {
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
        sViewsWithIds.put(C2037R.C2039id.llBrCatagory, 1);
        sViewsWithIds.put(C2037R.C2039id.rvChosse, 2);
        sViewsWithIds.put(C2037R.C2039id.llLoca, 3);
        sViewsWithIds.put(C2037R.C2039id.llDisc, 4);
        sViewsWithIds.put(C2037R.C2039id.tvDes, 5);
        sViewsWithIds.put(C2037R.C2039id.rlAuc, 6);
        sViewsWithIds.put(C2037R.C2039id.btn_ViewAllAuc, 7);
        sViewsWithIds.put(C2037R.C2039id.rvAuction, 8);
        sViewsWithIds.put(C2037R.C2039id.ftv_NoAuction, 9);
        sViewsWithIds.put(C2037R.C2039id.fab_PostAuction, 10);
    }

    public FragmentBrowseBindingImpl(@Nullable androidx.databinding.DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private FragmentBrowseBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConstraintLayout) objArr[0], (CustomButton) objArr[7], (FloatingActionButton) objArr[10], (CustomTextView) objArr[9], (LinearLayout) objArr[1], (LinearLayout) objArr[4], (LinearLayout) objArr[3], (RelativeLayout) objArr[6], (RecyclerView) objArr[8], (RecyclerView) objArr[2], (CustomTextView) objArr[5]);
        this.mDirtyFlags = -1;
        this.brActivity.setTag(null);
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
