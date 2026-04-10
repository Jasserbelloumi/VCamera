package virtual.camera.app.app;

import android.app.Application;
import android.util.Log;

public class App extends Application {
    private static App instance;
    private static final String TAG = "App";

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Log.i(TAG, "App initialized");
    }

    public static App getInstance() {
        return instance;
    }

    public static android.content.Context getContext() {
        return instance != null ? instance.getApplicationContext() : null;
    }
}
