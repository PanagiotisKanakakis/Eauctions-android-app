package permissions.dispatcher;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;

import androidx.collection.SimpleArrayMap;
import androidx.core.app.ActivityCompat;
import androidx.core.content.PermissionChecker;
//import android.support.p000v4.app.ActivityCompat;
//import android.support.p000v4.content.PermissionChecker;
//import android.support.p000v4.util.SimpleArrayMap;

public final class PermissionUtils {
    private static final SimpleArrayMap<String, Integer> MIN_SDK_PERMISSIONS = new SimpleArrayMap<>(8);
    private static volatile int targetSdkVersion = -1;

    static {
        MIN_SDK_PERMISSIONS.put("com.android.voicemail.permission.ADD_VOICEMAIL", Integer.valueOf(14));
        MIN_SDK_PERMISSIONS.put("android.permission.BODY_SENSORS", Integer.valueOf(20));
        SimpleArrayMap<String, Integer> simpleArrayMap = MIN_SDK_PERMISSIONS;
        Integer valueOf = Integer.valueOf(16);
        simpleArrayMap.put("android.permission.READ_CALL_LOG", valueOf);
        MIN_SDK_PERMISSIONS.put("android.permission.READ_EXTERNAL_STORAGE", valueOf);
        MIN_SDK_PERMISSIONS.put("android.permission.USE_SIP", Integer.valueOf(9));
        MIN_SDK_PERMISSIONS.put("android.permission.WRITE_CALL_LOG", valueOf);
        SimpleArrayMap<String, Integer> simpleArrayMap2 = MIN_SDK_PERMISSIONS;
        Integer valueOf2 = Integer.valueOf(23);
        simpleArrayMap2.put("android.permission.SYSTEM_ALERT_WINDOW", valueOf2);
        MIN_SDK_PERMISSIONS.put("android.permission.WRITE_SETTINGS", valueOf2);
    }

    private PermissionUtils() {
    }

    public static boolean verifyPermissions(int... iArr) {
        if (iArr.length == 0) {
            return false;
        }
        for (int i : iArr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean permissionExists(String str) {
        Integer num = (Integer) MIN_SDK_PERMISSIONS.get(str);
        return num == null || VERSION.SDK_INT >= num.intValue();
    }

    public static boolean hasSelfPermissions(Context context, String... strArr) {
        for (String str : strArr) {
            if (permissionExists(str) && !hasSelfPermission(context, str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasSelfPermission(Context context, String str) {
        try {
            return PermissionChecker.checkSelfPermission(context, str) == 0;
        } catch (RuntimeException unused) {
            return false;
        }
    }

    public static boolean shouldShowRequestPermissionRationale(Activity activity, String... strArr) {
        for (String shouldShowRequestPermissionRationale : strArr) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, shouldShowRequestPermissionRationale)) {
                return true;
            }
        }
        return false;
    }

    @TargetApi(4)
    public static int getTargetSdkVersion(Context context) {
        if (targetSdkVersion != -1) {
            return targetSdkVersion;
        }
        try {
            targetSdkVersion = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.targetSdkVersion;
        } catch (NameNotFoundException unused) {
        }
        return targetSdkVersion;
    }
}
