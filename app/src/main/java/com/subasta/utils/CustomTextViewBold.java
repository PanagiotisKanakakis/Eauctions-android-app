package com.subasta.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class CustomTextViewBold extends TextView {
    public void setBackground(int i) {
    }

    public CustomTextViewBold(Context context) {
        super(context);
        applyCustomFont(context);
    }

    public CustomTextViewBold(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        applyCustomFont(context);
    }

    public CustomTextViewBold(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        applyCustomFont(context);
    }

    public CustomTextViewBold(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        setTypeface(FontCache.getTypeface("Montserrat-SemiBold.otf", context), 1);
    }
}
