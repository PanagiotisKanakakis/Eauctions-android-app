package com.subasta.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import de.hdodenhof.circleimageview.CircleImageView;
import com.subasta.C2037R;
import com.subasta.utils.CustomTextView;
import com.subasta.utils.CustomTextViewBold;

import javax.annotation.Nullable;

public class AdapterMyChatBindingImpl extends AdapterMyChatBinding {
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
        sViewsWithIds.put(C2037R.C2039id.rvChat, 1);
        sViewsWithIds.put(C2037R.C2039id.relay1, 2);
        sViewsWithIds.put(C2037R.C2039id.ivPro, 3);
        sViewsWithIds.put(C2037R.C2039id.tvTitle, 4);
        sViewsWithIds.put(C2037R.C2039id.tvDate, 5);
        sViewsWithIds.put(C2037R.C2039id.tvMsg, 6);
    }

    public AdapterMyChatBindingImpl(@Nullable androidx.databinding.DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private AdapterMyChatBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CardView) objArr[0], (CircleImageView) objArr[3], (RelativeLayout) objArr[2], (RelativeLayout) objArr[1], (CustomTextViewBold) objArr[5], (CustomTextView) objArr[6], (CustomTextViewBold) objArr[4]);
        this.mDirtyFlags = -1;
        this.cardView.setTag(null);
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
