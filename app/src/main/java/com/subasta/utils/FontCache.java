package com.subasta.utils;

import android.content.Context;
import android.graphics.Typeface;

import java.util.HashMap;

public class FontCache {
    private static HashMap<String, Typeface> fontCache = new HashMap<>();

    public static Typeface getTypeface(String str, Context context) {
        Typeface typeface = (Typeface) fontCache.get(str);
        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(context.getAssets(), str);
                fontCache.put(str, typeface);
            } catch (Exception unused) {
                return null;
            }
        }
        return typeface;
    }
}
