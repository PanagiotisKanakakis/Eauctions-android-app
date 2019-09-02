package com.subasta.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.os.Build.VERSION;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.subasta.C2037R;
import com.subasta.interfaces.Const;

import java.net.URL;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProjectUtils {
    public static final String TAG = "ProjectUtility";
    private static final String VERSION_UNAVAILABLE = "N/A";
    public static Bitmap bmp;
    private static AlertDialog dialog;
    private static Dialog dialog_gif;
    private static ProgressDialog mProgressDialog;

    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public static void changeStatusBarColor(Activity activity) {
        Window window = activity.getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.clearFlags(67108864);
        if (VERSION.SDK_INT >= 21) {
            window.setStatusBarColor(activity.getResources().getColor(C2037R.color.colorPrimaryDark));
        }
    }

    public static void changeStatusBarColorNew(Activity activity, int i) {
        Window window = activity.getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.clearFlags(67108864);
        if (VERSION.SDK_INT >= 21) {
            window.setStatusBarColor(activity.getResources().getColor(i));
        }
    }

    public static void Fullscreen(Activity activity) {
        activity.requestWindowFeature(1);
        activity.getWindow().setFlags(1024, 1024);
    }

    @SuppressLint("ResourceType")
    public static void statusbarBackgroundTrans(Activity activity, int i) {
        if (VERSION.SDK_INT >= 21) {
            Window window = activity.getWindow();
            Drawable drawable = activity.getResources().getDrawable(i);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(activity.getResources().getColor(17170445));
            window.setBackgroundDrawable(drawable);
        }
    }

    @SuppressLint("ResourceType")
    public static void statusbarBackgroundTransformURL(Activity activity, String str) {
        if (VERSION.SDK_INT >= 21) {
            try {
                bmp = BitmapFactory.decodeStream(new URL(str).openConnection().getInputStream());
            } catch (Exception e) {
                e.printStackTrace();
            }
            Window window = activity.getWindow();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(activity.getResources(), bmp);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(activity.getResources().getColor(17170445));
            window.setBackgroundDrawable(bitmapDrawable);
        }
    }

    public static boolean hasPermissionInManifest(Activity activity, int i, String str) {
        if (ContextCompat.checkSelfPermission(activity, str) == 0) {
            return true;
        }
        ActivityCompat.requestPermissions(activity, new String[]{str}, i);
        return false;
    }

    public static boolean isPriceBid(String str, String str2) {
        return !str2.equals(str);
    }

    public static ProgressDialog getProgressDialog(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(false);
        progressDialog.setMessage(context.getResources().getString(C2037R.string.please_wait));
        return progressDialog;
    }

    public static boolean containsOnlyNumbers(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static Dialog createDialog(Context context, int i, int i2, OnClickListener onClickListener, OnClickListener onClickListener2) {
        Builder builder = new Builder(context);
        builder.setTitle(i);
        builder.setMessage(i2);
        builder.setPositiveButton(C2037R.string.f1292ok, onClickListener);
        builder.setNegativeButton(C2037R.string.cancel, onClickListener2);
        return builder.create();
    }

    public static Dialog createDialog(Context context, int i, int i2, View view, OnClickListener onClickListener, OnClickListener onClickListener2) {
        Builder builder = new Builder(context);
        builder.setTitle(i);
        builder.setMessage(i2);
        builder.setView(view);
        builder.setPositiveButton(C2037R.string.f1292ok, onClickListener);
        builder.setNegativeButton(C2037R.string.cancel, onClickListener2);
        return builder.create();
    }

    public static void showDialog(Context context, String str, String str2, OnClickListener onClickListener, boolean z) {
        if (str == null) {
            str = context.getResources().getString(C2037R.string.app_name);
        }
        if (onClickListener == null) {
            onClickListener = new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    ProjectUtils.hideDialog();
                }
            };
        }
        if (dialog == null) {
            Builder builder = new Builder(context);
            builder.setTitle(str);
            builder.setMessage(str2);
            builder.setPositiveButton("OK", onClickListener);
            dialog = builder.create();
            dialog.setCancelable(z);
        }
        try {
            dialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showDialog(Context context, String str, String str2, OnClickListener onClickListener, OnClickListener onClickListener2, boolean z) {
        if (str == null) {
            str = context.getResources().getString(C2037R.string.app_name);
        }
        if (onClickListener == null) {
            onClickListener = new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    ProjectUtils.hideDialog();
                }
            };
        }
        if (onClickListener2 == null) {
            onClickListener2 = new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    ProjectUtils.hideDialog();
                }
            };
        }
        if (dialog == null) {
            Builder builder = new Builder(context);
            builder.setTitle(str);
            builder.setMessage(str2);
            builder.setPositiveButton("OK", onClickListener);
            builder.setNegativeButton("Cancel", onClickListener2);
            dialog = builder.create();
            dialog.setCancelable(z);
        }
        try {
            dialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Dialog showProgressDialog(Context context, boolean z, String str) {
        mProgressDialog = new ProgressDialog(context);
        mProgressDialog.setProgressStyle(0);
        mProgressDialog.setMessage(str);
        mProgressDialog.show();
        mProgressDialog.setCancelable(z);
        return mProgressDialog;
    }

    public static void pauseProgressDialog() {
        try {
            if (mProgressDialog != null) {
                mProgressDialog.cancel();
                mProgressDialog.dismiss();
                mProgressDialog = null;
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("WrongConstant")
    public static void showToast(Context context, String str) {
        Toast.makeText(context, str, 0).show();
    }

    public static void showLog(String str, String str2) {
        Log.e(str, str2);
    }

    public static void cancelDialog() {
        try {
            if (dialog != null) {
                dialog.cancel();
                dialog.dismiss();
                dialog = null;
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public static void hideDialog() {
        AlertDialog alertDialog = dialog;
        if (alertDialog != null && alertDialog.isShowing()) {
            dialog.dismiss();
            dialog.cancel();
            dialog = null;
        }
    }

    @SuppressLint("WrongConstant")
    public static boolean isEmailValid(String str) {
        if (Pattern.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", 2).matcher(str).matches()) {
            return true;
        }
        if (str.equals("")) {
        }
        return false;
    }

    @SuppressLint("WrongConstant")
    public static boolean urlValidate(String str) {
        if (Pattern.compile(".*(youtube|youtu.be).*", 2).matcher(str).matches()) {
            return true;
        }
        if (str.equals("")) {
        }
        return false;
    }

    public static boolean isPhoneNumberValid(String str) {
        return str.length() >= 4 && str.length() <= 16;
    }

    public static boolean isPasswordValid(String str) {
        return str.length() >= 6 && str.length() <= 13;
    }

    public static long currentTimeInMillis() {
        Time time = new Time();
        time.setToNow();
        return time.toMillis(false);
    }

    public static String getEditTextValue(EditText editText) {
        return editText.getText().toString().trim();
    }

    public static boolean isEditTextFilled(EditText editText) {
        return editText.getText() != null && editText.getText().toString().trim().length() > 0;
    }

    public static boolean isPasswordLengthCorrect(EditText editText) {
        return editText.getText() != null && editText.getText().toString().trim().length() >= 8;
    }

    @SuppressLint("WrongConstant")
    public static boolean isNetworkConnected(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() != null;
    }

    public static void InternetAlertDialog(Context context) {
        Builder builder = new Builder(context);
        builder.setTitle("Error Connecting");
        builder.setMessage("No Internet Connection");
        builder.setPositiveButton("Ok", new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    public static int getAppVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not get package name: ");
            sb.append(e);
            throw new RuntimeException(sb.toString());
        }
    }

    public static String capWordFirstLetter(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        String str2 = "";
        while (stringTokenizer.hasMoreTokens()) {
            String lowerCase = stringTokenizer.nextToken().toLowerCase();
            if (str2.length() == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(lowerCase.substring(0, 1).toUpperCase());
                sb.append(lowerCase.substring(1));
                str2 = sb.toString();
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str2);
                sb2.append(" ");
                sb2.append(lowerCase.substring(0, 1).toUpperCase());
                sb2.append(lowerCase.substring(1));
                str2 = sb2.toString();
            }
        }
        return str2;
    }

    public static String getDisplayableTime(long j) {
        String str;
        String str2;
        String str3;
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (valueOf.longValue() <= j) {
            return null;
        }
        long longValue = (valueOf.longValue() - j) / 1000;
        long j2 = longValue / 60;
        long j3 = j2 / 60;
        long j4 = j3 / 24;
        long j5 = j4 / 31;
        long j6 = j4 / 365;
        if (longValue < 0) {
            return "not yet";
        }
        if (longValue < 60) {
            if (longValue == 1) {
                str3 = "one second ago";
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(longValue);
                sb.append(" seconds ago");
                str3 = sb.toString();
            }
            return str3;
        } else if (longValue < 120) {
            return "a minute ago";
        } else {
            if (longValue < 2700) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(j2);
                sb2.append(" minutes ago");
                return sb2.toString();
            } else if (longValue < 5400) {
                return "an hour ago";
            } else {
                if (longValue < 86400) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(j3);
                    sb3.append(" hours ago");
                    return sb3.toString();
                } else if (longValue < 172800) {
                    return "yesterday";
                } else {
                    if (longValue < 2592000) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(j4);
                        sb4.append(" days ago");
                        return sb4.toString();
                    } else if (longValue < 31104000) {
                        if (j5 <= 1) {
                            str2 = "one month ago";
                        } else {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append(j4);
                            sb5.append(" months ago");
                            str2 = sb5.toString();
                        }
                        return str2;
                    } else {
                        if (j6 <= 1) {
                            str = "one year ago";
                        } else {
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append(j6);
                            sb6.append(" years ago");
                            str = sb6.toString();
                        }
                        return str;
                    }
                }
            }
        }
    }

    public static String getDisplayableDay(long j) {
        String str;
        String str2;
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (valueOf.longValue() <= j) {
            return null;
        }
        long longValue = (valueOf.longValue() - j) / 1000;
        long j2 = ((longValue / 60) / 60) / 24;
        long j3 = j2 / 31;
        long j4 = j2 / 365;
        if (longValue < 0) {
            return "not yet";
        }
        if (DateUtils.isToday(j)) {
            return "TODAY";
        }
        if (longValue < 172800) {
            return "yesterday";
        }
        if (longValue < 2592000) {
            StringBuilder sb = new StringBuilder();
            sb.append(j2);
            sb.append(" days ago");
            return sb.toString();
        } else if (longValue < 31104000) {
            if (j3 <= 1) {
                str2 = "one month ago";
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(j2);
                sb2.append(" months ago");
                str2 = sb2.toString();
            }
            return str2;
        } else {
            if (j4 <= 1) {
                str = "one year ago";
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(j4);
                sb3.append(" years ago");
                str = sb3.toString();
            }
            return str;
        }
    }

    public static long correctTimestamp(long j) {
        if (String.valueOf(j).length() >= 13) {
            return j;
        }
        int length = 13 - String.valueOf(j).length();
//        String str = AppEventsConstants.EVENT_PARAM_VALUE_YES;
//        for (int i = 0; i < length; i++) {
//            StringBuilder sb = new StringBuilder();
//            sb.append(str);
//            sb.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
//            str = sb.toString();
//        }
//        return (j * ((long) Integer.parseInt(str))) + (System.currentTimeMillis() % ((long) Integer.parseInt(str)));
        return 0;
    }

    public static String convertTimestampToTime(long j) {
        Timestamp timestamp = new Timestamp(j);
        String str = "hh:mm a";
        if (DateUtils.isToday(j)) {
            return new SimpleDateFormat(str).format(timestamp);
        }
        return new SimpleDateFormat(str).format(timestamp);
    }

    public static String convertTimestampDateToTime(long j) {
        return new SimpleDateFormat("dd MMM, yyyy hh:mm a").format(new Timestamp(j));
    }

    public static String getFirstLetterCapital(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(Character.toUpperCase(str.charAt(0)));
            sb.append(str.substring(1));
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String changeDateFormate(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return new SimpleDateFormat("dd MMM yyyy").format(simpleDateFormat.parse(str));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String extractYoutubeVideoId(String str) {
        @SuppressLint("WrongConstant") Matcher matcher = Pattern.compile("^https?://.*(?:youtu.be/|v/|u/\\w/|embed/|watch?v=)([^#&?]*).*$", 2).matcher(str);
        return matcher.matches() ? matcher.group(1) : "";
    }

    public static boolean isDateAfter(String str, String str2) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            if (simpleDateFormat.parse(str).after(simpleDateFormat.parse(str2))) {
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static int indexOfNotification(String str) {
        if (str.equalsIgnoreCase(Const.CHAT_TYPE)) {
            return 1;
        }
        if (str.equalsIgnoreCase(Const.BID_TYPE)) {
            return 3;
        }
        if (str.equalsIgnoreCase(Const.ADMIN_NOTIFICATION_TYPE)) {
        }
        return 0;
    }
}
