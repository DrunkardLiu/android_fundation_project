package liu.drunkard.foundationproject.utility;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by laurenceliu on 2018/4/4.
 */


public class Preference {

    private static SharedPreferences mSharedPreferences;

    static public void init(Context context) {
        mSharedPreferences = context.getSharedPreferences(Constants.SETTING_PREFERENCE, 0);
    }

    static public void clearAll() {
        mSharedPreferences.edit().clear().commit();
    }

    static public void saveInt(String key, int value) {
        mSharedPreferences.edit().putInt(key, value).commit();
    }

    static public int getInt(String key, int value) {
        return mSharedPreferences.getInt(key, value);
    }

    static public void saveString(String key, String value) {
        mSharedPreferences.edit().putString(key, value).commit();
    }

    static public String getString(String key, String value) {
        return mSharedPreferences.getString(key, value);
    }
    static public void removeString(String key) {
        mSharedPreferences.edit().remove(key).commit();
    }

    static public void saveBoolean(String key, boolean value) {
        mSharedPreferences.edit().putBoolean(key, value).commit();
    }

    static public boolean getBoolean(String key, boolean value) {
        return mSharedPreferences.getBoolean(key, value);
    }

}
