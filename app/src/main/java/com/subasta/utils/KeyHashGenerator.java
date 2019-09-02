package com.subasta.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class KeyHashGenerator {
    public static String generateKey(Activity activity) {
        String str;
        Exception e;
        try {
            @SuppressLint("WrongConstant") PackageInfo packageInfo = activity.getPackageManager().getPackageInfo(activity.getApplicationContext().getPackageName(), 64);
            Log.i("Package Name= ", activity.getApplicationContext().getPackageName());
            Signature[] signatureArr = packageInfo.signatures;
            int length = signatureArr.length;
            str = null;
            int i = 0;
            while (i < length) {
                try {
                    Signature signature = signatureArr[i];
                    MessageDigest instance = MessageDigest.getInstance("SHA");
                    instance.update(signature.toByteArray());
                    String str2 = new String(Base64.encode(instance.digest(), 0));
                    try {
                        Log.i("Key Hash= ", str2);
                        i++;
                        str = str2;
                    } catch (Exception e3) {
                        e = e3;
                        str = str2;
                        Log.e("Exception", e.toString());
                        return str;
                    }
                } catch (NoSuchAlgorithmException e5) {
                    e = e5;
                    Log.e("No such an algorithm", e.toString());
                    return str;
                } catch (Exception e6) {
                    e = e6;
                    Log.e("Exception", e.toString());
                    return str;
                }
            }
        } catch (NameNotFoundException e7) {
            e = e7;
            str = null;
            Log.e("Name not found", e.toString());
            return str;
        } catch (Exception e9) {
            e = e9;
            str = null;
            Log.e("Exception", e.toString());
            return str;
        }
        return str;
    }
}
