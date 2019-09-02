package com.subasta.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkManager {
    public static boolean isConnectToInternet(Context context) {
        if (context != null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && (activeNetworkInfo.getType() == 1 || activeNetworkInfo.getType() == 0)) {
                return true;
            }
        }
        return false;
    }
}
