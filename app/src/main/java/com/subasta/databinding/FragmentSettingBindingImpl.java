package com.subasta.databinding;

import android.util.SparseIntArray;
import android.view.View;
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

public class FragmentSettingBindingImpl extends FragmentSettingBinding {
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
        sViewsWithIds.put(C2037R.C2039id.llID, 2);
        sViewsWithIds.put(C2037R.C2039id.cvdp, 3);
        sViewsWithIds.put(C2037R.C2039id.imagedp, 4);
        sViewsWithIds.put(C2037R.C2039id.tvname, 5);
        sViewsWithIds.put(C2037R.C2039id.tvdate, 6);
        sViewsWithIds.put(C2037R.C2039id.cardView1, 7);
        sViewsWithIds.put(C2037R.C2039id.tvchangepass, 8);
        sViewsWithIds.put(C2037R.C2039id.tvinvited, 9);
        sViewsWithIds.put(C2037R.C2039id.tvsupport, 10);
    }

    public FragmentSettingBindingImpl(@Nullable androidx.databinding.DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private FragmentSettingBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CardView) objArr[1], (CardView) objArr[7], (CardView) objArr[3], (CircleImageView) objArr[4], (LinearLayout) objArr[2], (CustomTextView) objArr[8], (CustomTextView) objArr[6], (CustomTextView) objArr[9], (CustomTextViewBold) objArr[5], (CustomTextView) objArr[10]);
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
