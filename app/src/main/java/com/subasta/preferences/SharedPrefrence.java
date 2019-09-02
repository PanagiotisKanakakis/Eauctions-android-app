package com.subasta.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.subasta.model.UserDTO;

public class SharedPrefrence {
    public static SharedPrefrence myObj;
    public static SharedPreferences myPrefs;
    public static Editor prefsEditor;

    private SharedPrefrence() {
    }

    public void clearAllPreferences() {
        prefsEditor = myPrefs.edit();
        prefsEditor.clear();
        prefsEditor.commit();
    }

    public static SharedPrefrence getInstance(Context context) {
        if (myObj == null) {
            myObj = new SharedPrefrence();
            myPrefs = PreferenceManager.getDefaultSharedPreferences(context);
            prefsEditor = myPrefs.edit();
        }
        return myObj;
    }

    public void clearPreferences(String str) {
        prefsEditor.remove(str);
        prefsEditor.commit();
    }

    public void setIntValue(String str, int i) {
        prefsEditor.putInt(str, i);
        prefsEditor.apply();
    }

    public int getIntValue(String str) {
        return myPrefs.getInt(str, 0);
    }

    public void setLongValue(String str, long j) {
        prefsEditor.putLong(str, j);
        prefsEditor.apply();
    }

    public long getLongValue(String str) {
        return myPrefs.getLong(str, 0);
    }

    public void setValue(String str, String str2) {
        prefsEditor.putString(str, str2);
        prefsEditor.commit();
    }

    public String getValue(String str) {
        if (str.equalsIgnoreCase("latitude")) {
            return myPrefs.getString(str, "22.7497853");
        }
        if (str.equalsIgnoreCase("longitude")) {
            return myPrefs.getString(str, "75.8989044");
        }
        return myPrefs.getString(str, "");
    }

    public boolean getBooleanValue(String str) {
        return myPrefs.getBoolean(str, false);
    }

    public void setBooleanValue(String str, boolean z) {
        prefsEditor.putBoolean(str, z);
        prefsEditor.commit();
    }

    public void setParentUser(UserDTO userDTO, String str) {
        prefsEditor.putString(str, new Gson().toJson((Object) userDTO));
        prefsEditor.apply();
    }

    public UserDTO getParentUser(String str) {
        String str2 = "defValue";
        if (myPrefs.getString(str, str2).equals(str2)) {
            return new UserDTO();
        }
        return (UserDTO) new Gson().fromJson(myPrefs.getString(str, ""), new TypeToken<UserDTO>() {
        }.getType());
    }
}
