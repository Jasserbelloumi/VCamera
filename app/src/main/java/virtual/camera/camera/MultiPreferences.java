package virtual.camera.camera;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class MultiPreferences {
    private static MultiPreferences instance;
    private SharedPreferences prefs;
    private static final String TAG = "MultiPreferences";
    private static final String PREF_NAME = "vcamera_prefs";

    private MultiPreferences(Context context) {
        if (context != null) {
            prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        }
    }

    public static synchronized MultiPreferences getInstance() {
        if (instance == null) {
            try {
                Context ctx = virtual.camera.app.app.App.getContext();
                instance = new MultiPreferences(ctx);
            } catch (Exception e) {
                Log.e(TAG, "Failed to init", e);
                instance = new MultiPreferences(null);
            }
        }
        return instance;
    }

    public boolean getBoolean(String key, boolean defValue) {
        if (prefs == null) return defValue;
        try { return prefs.getBoolean(key, defValue); } catch (Exception e) { return defValue; }
    }

    public String getString(String key, String defValue) {
        if (prefs == null) return defValue;
        try { return prefs.getString(key, defValue); } catch (Exception e) { return defValue; }
    }

    public int getInt(String key, int defValue) {
        if (prefs == null) return defValue;
        try { return prefs.getInt(key, defValue); } catch (Exception e) { return defValue; }
    }

    public long getLong(String key, long defValue) {
        if (prefs == null) return defValue;
        try { return prefs.getLong(key, defValue); } catch (Exception e) { return defValue; }
    }

    public float getFloat(String key, float defValue) {
        if (prefs == null) return defValue;
        try { return prefs.getFloat(key, defValue); } catch (Exception e) { return defValue; }
    }

    public void setBoolean(String key, boolean value) {
        if (prefs == null) return;
        try { prefs.edit().putBoolean(key, value).apply(); } catch (Exception e) {}
    }

    public void setString(String key, String value) {
        if (prefs == null) return;
        try { prefs.edit().putString(key, value).apply(); } catch (Exception e) {}
    }

    public void setInt(String key, int value) {
        if (prefs == null) return;
        try { prefs.edit().putInt(key, value).apply(); } catch (Exception e) {}
    }

    public void setLong(String key, long value) {
        if (prefs == null) return;
        try { prefs.edit().putLong(key, value).apply(); } catch (Exception e) {}
    }

    public void setFloat(String key, float value) {
        if (prefs == null) return;
        try { prefs.edit().putFloat(key, value).apply(); } catch (Exception e) {}
    }

    public void putBoolean(String key, boolean value) { setBoolean(key, value); }
    public void putString(String key, String value) { setString(key, value); }
    public void putInt(String key, int value) { setInt(key, value); }
}
