package com.codingtester.developers;

import android.content.Context;
import android.content.SharedPreferences;

public class AppSharedPref {
    private static SharedPreferences getSharedPref(Context context) {
        return context.getSharedPreferences("devLogin", Context.MODE_PRIVATE);
    }

    public static void writeToSharedPref(Context context, String name, String pass) {
        getSharedPref(context).edit().putString("name", name).apply();
        getSharedPref(context).edit().putString("pass", pass).apply();
    }

    public static boolean isUserLogin(Context context) {
        return getSharedPref(context).contains("name");
    }
}
