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

    public void putBoolean(String key, boolean value) {
        if (prefs == null) return;
        try { prefs.edit().putBoolean(key, value).apply(); } catch (Exception e) {}
    }

    public void putString(String key, String value) {
        if (prefs == null) return;
        try { prefs.edit().putString(key, value).apply(); } catch (Exception e) {}
    }

    public void putInt(String key, int value) {
        if (prefs == null) return;
        try { prefs.edit().putInt(key, value).apply(); } catch (Exception e) {}
    }
}
