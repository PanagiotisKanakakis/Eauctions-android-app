package com.subasta.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.subasta.C2037R;
import com.subasta.utils.CustomTextViewBold;

import javax.annotation.Nullable;

public class FragmentMyChatBindingImpl extends FragmentMyChatBinding {
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
        sViewsWithIds.put(C2037R.C2039id.cardView1, 1);
        sViewsWithIds.put(C2037R.C2039id.chatSearch, 2);
        sViewsWithIds.put(C2037R.C2039id.swipe_refresh_layout, 3);
        sViewsWithIds.put(C2037R.C2039id.recycle1, 4);
        sViewsWithIds.put(C2037R.C2039id.tvNo, 5);
    }

    public FragmentMyChatBindingImpl(@Nullable androidx.databinding.DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private FragmentMyChatBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CardView) objArr[1], (SearchView) objArr[2], (RelativeLayout) objArr[0], (RecyclerView) objArr[4], (SwipeRefreshLayout) objArr[3], (CustomTextViewBold) objArr[5]);
        this.mDirtyFlags = -1;
        this.llchat1.setTag(null);
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
