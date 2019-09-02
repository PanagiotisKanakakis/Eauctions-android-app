package com.subasta.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import de.hdodenhof.circleimageview.CircleImageView;
import com.subasta.C2037R;
import com.subasta.utils.CustomButton;
import com.subasta.utils.CustomEditText;
import com.subasta.utils.CustomTextViewBold;

import javax.annotation.Nullable;


public class ActivityChatstalkingBindingImpl extends ActivityChatstalkingBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    @Nullable
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    @NonNull
    private final LinearLayout mboundView0;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        sViewsWithIds.put(C2037R.C2039id.cardView, 1);
        sViewsWithIds.put(C2037R.C2039id.ivBack, 2);
        sViewsWithIds.put(C2037R.C2039id.ivalia, 3);
        sViewsWithIds.put(C2037R.C2039id.tvname, 4);
        sViewsWithIds.put(C2037R.C2039id.menu, 5);
        sViewsWithIds.put(C2037R.C2039id.swipe_refresh_layout, 6);
        sViewsWithIds.put(C2037R.C2039id.recycleChat, 7);
        sViewsWithIds.put(C2037R.C2039id.msg_type, 8);
        sViewsWithIds.put(C2037R.C2039id.btn_chat_send, 9);
    }

    public ActivityChatstalkingBindingImpl(@Nullable androidx.databinding.DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private ActivityChatstalkingBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CustomButton) objArr[9], (CardView) objArr[1], (ImageView) objArr[2], (CircleImageView) objArr[3], (ImageView) objArr[5], (CustomEditText) objArr[8], (RecyclerView) objArr[7], (SwipeRefreshLayout) objArr[6], (CustomTextViewBold) objArr[4]);
        this.mDirtyFlags = -1;
        this.mboundView0 = (LinearLayout) objArr[0];
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
