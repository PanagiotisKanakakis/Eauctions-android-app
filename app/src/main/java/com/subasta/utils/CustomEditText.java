package com.subasta.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

public class CustomEditText extends EditText {
    public CustomEditText(Context context) {
        super(context);
        applyCustomFont(context);
    }

    public CustomEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        applyCustomFont(context);
    }

    public CustomEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        applyCustomFont(context);
    }

    public CustomEditText(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        setTypeface(FontCache.getTypeface("Montserrat-Medium.otf", context));
    }
}
