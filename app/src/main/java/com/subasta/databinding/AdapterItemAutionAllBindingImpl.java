package com.subasta.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;

import de.hdodenhof.circleimageview.CircleImageView;
import com.subasta.C2037R;
import com.subasta.utils.CustomTextView;
import com.subasta.utils.CustomTextViewBold;

import javax.annotation.Nullable;

public class AdapterItemAutionAllBindingImpl extends AdapterItemAutionAllBinding {
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
        sViewsWithIds.put(C2037R.C2039id.Line1, 1);
        sViewsWithIds.put(C2037R.C2039id.image, 2);
        sViewsWithIds.put(C2037R.C2039id.relay2, 3);
        sViewsWithIds.put(C2037R.C2039id.tvProductname, 4);
        sViewsWithIds.put(C2037R.C2039id.tvLocation, 5);
        sViewsWithIds.put(C2037R.C2039id.tvAddress, 6);
        sViewsWithIds.put(C2037R.C2039id.tvMinBidTxt, 7);
        sViewsWithIds.put(C2037R.C2039id.tvPrice, 8);
        sViewsWithIds.put(C2037R.C2039id.card_view, 9);
        sViewsWithIds.put(C2037R.C2039id.ivbid, 10);
    }

    public AdapterItemAutionAllBindingImpl(@Nullable androidx.databinding.DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private AdapterItemAutionAllBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[1], (CardView) objArr[9], (CardView) objArr[0], (ImageView) objArr[2], (CircleImageView) objArr[10], (RelativeLayout) objArr[3], (CustomTextView) objArr[6], (CustomTextView) objArr[5], (CustomTextView) objArr[7], (CustomTextViewBold) objArr[8], (CustomTextViewBold) objArr[4]);
        this.mDirtyFlags = -1;
        this.cardView1.setTag(null);
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
