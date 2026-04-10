package virtual.camera.app.view.main;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends multispace.multiapp.clone.view.main.MainActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
        } catch (Exception e) {
            Log.e(TAG, "Error in onCreate", e);
        }
    }
}
