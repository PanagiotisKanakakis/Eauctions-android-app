package com.subasta.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.ExifInterface;
import android.os.AsyncTask;
import android.os.Environment;

import com.subasta.interfaces.Const;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageCompression extends AsyncTask<String, Void, String> {
    private static final float maxHeight = 1280.0f;
    private static final float maxWidth = 1280.0f;
    private Context context;
    public AsyncResponse delegate = null;

    public interface AsyncResponse {
        void processFinish(String str);
    }

    public ImageCompression(Context context2) {
        this.context = context2;
    }

    public void setOnTaskFinishedEvent(AsyncResponse asyncResponse) {
        if (asyncResponse != null) {
            this.delegate = asyncResponse;
        }
    }

    /* access modifiers changed from: protected */
    public String doInBackground(String... strArr) {
        if (strArr.length == 0 || strArr[0] == null) {
            return null;
        }
        return compressImage(strArr[0]);
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(String str) {
        AsyncResponse asyncResponse = this.delegate;
        if (asyncResponse != null) {
            asyncResponse.processFinish(str);
        }
    }

    public String compressImage(String str) {
        Bitmap bitmap;
        Options options = new Options();
        options.inJustDecodeBounds = true;
        Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
        int i = options.outHeight;
        int i2 = options.outWidth;
        float f = (float) i2;
        float f2 = (float) i;
        float f3 = f / f2;
        if (f2 > 1280.0f || f > 1280.0f) {
            if (f3 < 1.0f) {
                i2 = (int) ((1280.0f / f2) * f);
                i = 1280;
            } else {
                i = f3 > 1.0f ? (int) ((1280.0f / f) * f2) : 1280;
                i2 = 1280;
            }
        }
        options.inSampleSize = calculateInSampleSize(options, i2, i);
        options.inJustDecodeBounds = false;
        options.inDither = false;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inTempStorage = new byte[16384];
        try {
            decodeFile = BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }
        try {
            bitmap = Bitmap.createBitmap(i2, i, Config.RGB_565);
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            bitmap = null;
        }
        float f4 = (float) i2;
        float f5 = f4 / ((float) options.outWidth);
        float f6 = (float) i;
        float f7 = f6 / ((float) options.outHeight);
        float f8 = f4 / 2.0f;
        float f9 = f6 / 2.0f;
        Matrix matrix = new Matrix();
        matrix.setScale(f5, f7, f8, f9);
        Canvas canvas = new Canvas(bitmap);
        canvas.setMatrix(matrix);
        canvas.drawBitmap(decodeFile, f8 - ((float) (decodeFile.getWidth() / 2)), f9 - ((float) (decodeFile.getHeight() / 2)), new Paint(2));
        if (decodeFile != null) {
            decodeFile.recycle();
        }
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 0);
            Matrix matrix2 = new Matrix();
            if (attributeInt == 6) {
                matrix2.postRotate(90.0f);
            } else if (attributeInt == 3) {
                matrix2.postRotate(180.0f);
            } else if (attributeInt == 8) {
                matrix2.postRotate(270.0f);
            }
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix2, true);
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        String filename = getFilename();
        try {
            bitmap.compress(CompressFormat.JPEG, 80, new FileOutputStream(filename));
        } catch (FileNotFoundException e4) {
            e4.printStackTrace();
        }
        return filename;
    }

    public static int calculateInSampleSize(Options options, int i, int i2) {
        int i3;
        int i4 = options.outHeight;
        int i5 = options.outWidth;
        if (i4 > i2 || i5 > i) {
            i3 = Math.round(((float) i4) / ((float) i2));
            int round = Math.round(((float) i5) / ((float) i));
            if (i3 >= round) {
                i3 = round;
            }
        } else {
            i3 = 1;
        }
        while (((float) (i5 * i4)) / ((float) (i3 * i3)) > ((float) (i * i2 * 2))) {
            i3++;
        }
        return i3;
    }

    public String getFilename() {
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory());
        sb.append(File.separator);
        sb.append(Const.APP_NAME);
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("IMG_");
        sb2.append(String.valueOf(System.currentTimeMillis()));
        sb2.append(".jpg");
        String sb3 = sb2.toString();
        StringBuilder sb4 = new StringBuilder();
        sb4.append(file.getAbsolutePath());
        sb4.append("/");
        sb4.append(sb3);
        return sb4.toString();
    }
}
