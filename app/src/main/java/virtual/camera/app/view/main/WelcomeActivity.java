package virtual.camera.app.view.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler().postDelayed(() -> {
            startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
            finish();
        }, 1500);
    }
}
