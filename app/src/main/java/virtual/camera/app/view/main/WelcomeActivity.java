package virtual.camera.app.view.main;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import virtual.camera.app.R;

public class WelcomeActivity extends AppCompatActivity {
    private static final String TAG = "WelcomeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_welcome);
        } catch (Exception e) {
            Log.e(TAG, "Failed to set content view", e);
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(
                        getPackageName(),
                        "virtual.camera.app.view.main.MainActivity"
                    ));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                } catch (Exception e) {
                    Log.e(TAG, "Failed to start MainActivity", e);
                }
                finish();
            }
        }, 2000);
    }
}
