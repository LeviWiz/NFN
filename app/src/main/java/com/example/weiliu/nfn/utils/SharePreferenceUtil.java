package com.example.weiliu.nfn.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.weiliu.nfn.R;

/**
 * Created by wei.liu on 2018/5/28.
 */

public class SharePreferenceUtil {

    private SharePreferenceUtil() {
    }

    public static int getNavigationId(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getInt(context.getString(R.string.nevigation_id), R.id.navigation_home);
    }

    public static void putNavigationId(Context context, int t) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(context.getString(R.string.nevigation_id), t);
        editor.commit();
    }
}
