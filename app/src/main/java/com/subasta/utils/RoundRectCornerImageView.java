package com.subasta.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

public class RoundRectCornerImageView extends ImageView {
    private Path path;
    private float radius = 28.0f;
    private RectF rect;

    public RoundRectCornerImageView(Context context) {
        super(context);
        init();
    }

    public RoundRectCornerImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public RoundRectCornerImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.path = new Path();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.rect = new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        Path path2 = this.path;
        RectF rectF = this.rect;
        float f = this.radius;
        path2.addRoundRect(rectF, f, f, Direction.CW);
        canvas.clipPath(this.path);
        super.onDraw(canvas);
    }
}
