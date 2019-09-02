//package com.subasta.firebase;
//
//import android.app.NotificationChannel;
//import android.app.NotificationManager;
//import android.app.PendingIntent;
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.content.SharedPreferences.Editor;
//import android.media.RingtoneManager;
//import android.os.Build.VERSION;
//import android.support.p000v4.app.NotificationCompat.Builder;
//import android.support.p000v4.content.LocalBroadcastManager;
//import android.util.Log;
//
//import com.google.common.primitives.Ints;
//import com.google.firebase.messaging.FirebaseMessagingService;
//import com.google.firebase.messaging.RemoteMessage;
//import com.subasta.C2037R;
//import com.subasta.activity.dashbord.Dashboard;
//import com.subasta.interfaces.Const;
//import com.subasta.utils.ProjectUtils;
//
//import java.util.Map;
//
//public class MyFirebaseMessagingService extends FirebaseMessagingService {
//    public static final String MyPREFERENCES = "MyPrefs";
//    private static final String TAG = "MyFirebaseMsgService";
//    String refreshedToken;
//    SharedPreferences sharedpreferences;
//
//    private void sendRegistrationToServer(String str) {
//    }
//
//    public void onMessageReceived(RemoteMessage remoteMessage) {
//        StringBuilder sb = new StringBuilder();
//        sb.append("From: ");
//        sb.append(remoteMessage.getFrom());
//        String sb2 = sb.toString();
//        String str = TAG;
//        Log.d(str, sb2);
//        if (remoteMessage.getData() != null && remoteMessage.getData().size() > 0) {
//            StringBuilder sb3 = new StringBuilder();
//            sb3.append("Message data payload: ");
//            sb3.append(remoteMessage.getData());
//            Log.d(str, sb3.toString());
//            String str2 = "type";
//            String str3 = "body";
//            String str4 = "title";
//            if (((String) remoteMessage.getData().get(str2)).equalsIgnoreCase(Const.CHAT_TYPE)) {
//                Intent intent = new Intent();
//                intent.setAction(Const.BROADCAST);
//                intent.setAction(Const.ALL_CHAT);
//                LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
//                sendNotification(getValue(remoteMessage.getData(), str4), getValue(remoteMessage.getData(), str3), ProjectUtils.indexOfNotification(getValue(remoteMessage.getData(), str2)));
//                return;
//            }
//            sendNotification(getValue(remoteMessage.getData(), str4), getValue(remoteMessage.getData(), str3), ProjectUtils.indexOfNotification(getValue(remoteMessage.getData(), str2)));
//        }
//    }
//
//    public String getValue(Map<String, String> map, String str) {
//        try {
//            if (map.containsKey(str)) {
//                return (String) map.get(str);
//            }
//            return getString(C2037R.string.app_name);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return getString(C2037R.string.app_name);
//        }
//    }
//
//    public void onNewToken(String str) {
//        StringBuilder sb = new StringBuilder();
//        sb.append("Refreshed token: ");
//        sb.append(str);
//        String sb2 = sb.toString();
//        String str2 = TAG;
//        Log.d(str2, sb2);
//        String str3 = "MyPrefs";
//        this.sharedpreferences = getSharedPreferences(str3, 0);
//        Editor edit = this.sharedpreferences.edit();
//        String str4 = Const.DEVICE_TOKEN;
//        edit.putString(str4, str);
//        edit.commit();
//        sendRegistrationToServer(str);
//        SharedPreferences sharedPreferences = getSharedPreferences(str3, 0);
//        StringBuilder sb3 = new StringBuilder();
//        sb3.append("my token: ");
//        sb3.append(sharedPreferences.getString(str4, ""));
//        Log.e(str2, sb3.toString());
//    }
//
//    private void sendNotification(String str, String str2, int i) {
//        Intent intent = new Intent(this, Dashboard.class);
//        intent.addFlags(67108864);
//        intent.addFlags(32768);
//        intent.addFlags(268435456);
//        intent.addFlags(67108864);
//        intent.putExtra("index", i);
//        String str3 = "fcm_default_channel";
//        Builder contentIntent = new Builder(this, str3).setSmallIcon(C2037R.mipmap.ic_launcher).setContentTitle(str).setContentText(str2).setAutoCancel(true).setSound(RingtoneManager.getDefaultUri(2)).setContentIntent(PendingIntent.getActivity(this, 0, intent, Ints.MAX_POWER_OF_TWO));
//        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
//        if (VERSION.SDK_INT >= 26) {
//            notificationManager.createNotificationChannel(new NotificationChannel(str3, "Channel human readable title", 3));
//        }
//        notificationManager.notify(0, contentIntent.build());
//    }
//}
