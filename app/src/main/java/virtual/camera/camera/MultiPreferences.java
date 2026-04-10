package virtual.camera.camera;

import android.content.Context;
import android.content.SharedPreferences;
import virtual.camera.app.app.App;

public class MultiPreferences {
    private static final String PREFS_NAME = "vcamera_prefs";
    private static MultiPreferences instance;
    private final SharedPreferences prefs;

    private MultiPreferences() {
        prefs = App.getContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public static MultiPreferences getInstance() {
        if (instance == null) {
            instance = new MultiPreferences();
        }
        return instance;
    }

    public int getInt(String key, int defaultValue) {
        return prefs.getInt(key, defaultValue);
    }

    public void setInt(String key, int value) {
        prefs.edit().putInt(key, value).apply();
    }

    public String getString(String key, String defaultValue) {
        return prefs.getString(key, defaultValue);
    }

    public void setString(String key, String value) {
        prefs.edit().putString(key, value).apply();
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        return prefs.getBoolean(key, defaultValue);
    }

    public void setBoolean(String key, boolean value) {
        prefs.edit().putBoolean(key, value).apply();
    }

    public float getFloat(String key, float defaultValue) {
        return prefs.getFloat(key, defaultValue);
    }

    public void setFloat(String key, float value) {
        prefs.edit().putFloat(key, value).apply();
    }

    public long getLong(String key, long defaultValue) {
        return prefs.getLong(key, defaultValue);
    }

    public void setLong(String key, long value) {
        prefs.edit().putLong(key, value).apply();
    }
}
