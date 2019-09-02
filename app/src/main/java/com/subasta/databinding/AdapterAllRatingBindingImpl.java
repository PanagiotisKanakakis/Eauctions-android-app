package com.subasta.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;

import de.hdodenhof.circleimageview.CircleImageView;
import com.subasta.C2037R;
import com.subasta.utils.CustomTextView;
import com.subasta.utils.CustomTextViewBold;
import com.willy.ratingbar.ScaleRatingBar;

import javax.annotation.Nullable;

public class AdapterAllRatingBindingImpl extends AdapterAllRatingBinding {
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
        sViewsWithIds.put(C2037R.C2039id.line1, 1);
        sViewsWithIds.put(C2037R.C2039id.llcat, 2);
        sViewsWithIds.put(C2037R.C2039id.cardView1, 3);
        sViewsWithIds.put(C2037R.C2039id.civCat, 4);
        sViewsWithIds.put(C2037R.C2039id.userName, 5);
        sViewsWithIds.put(C2037R.C2039id.tvComment, 6);
        sViewsWithIds.put(C2037R.C2039id.simpleRatingBar, 7);
    }

    public AdapterAllRatingBindingImpl(@Nullable androidx.databinding.DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private AdapterAllRatingBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CardView) objArr[0], (CardView) objArr[3], (CircleImageView) objArr[4], (LinearLayout) objArr[1], (LinearLayout) objArr[2], (ScaleRatingBar) objArr[7], (CustomTextView) objArr[6], (CustomTextViewBold) objArr[5]);
        this.mDirtyFlags = -1;
        this.cardView.setTag(null);
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
