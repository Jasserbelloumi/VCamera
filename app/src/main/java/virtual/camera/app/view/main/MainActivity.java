package virtual.camera.app.view.main;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import virtual.camera.app.R;
import virtual.camera.app.view.list.ListActivity;
import virtual.camera.app.view.setting.SettingActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_main);
        } catch (Exception e) {
            Log.e(TAG, "Failed to set content view", e);
            return;
        }

        try {
            View toolbarLayout = findViewById(R.id.toolbar_layout);
            if (toolbarLayout != null) {
                Toolbar toolbar = toolbarLayout.findViewById(R.id.toolbar);
                if (toolbar != null) {
                    setSupportActionBar(toolbar);
                    if (getSupportActionBar() != null) {
                        getSupportActionBar().setTitle(R.string.app_name);
                    }
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "Toolbar setup failed", e);
        }

        try {
            View fab = findViewById(R.id.fab);
            if (fab != null) {
                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            Intent intent = new Intent(MainActivity.this, ListActivity.class);
                            startActivity(intent);
                        } catch (Exception e) {
                            Log.e(TAG, "Failed to start ListActivity", e);
                        }
                    }
                });
            }
        } catch (Exception e) {
            Log.e(TAG, "FAB setup failed", e);
        }

        try {
            DialogUtil.showDialog(this, true);
        } catch (Exception e) {
            Log.e(TAG, "Dialog failed", e);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        try {
            getMenuInflater().inflate(R.menu.main_menu, menu);
        } catch (Exception e) {
            Log.e(TAG, "Menu inflate failed", e);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        try {
            if (item.getItemId() == R.id.menu_setting) {
                startActivity(new Intent(this, SettingActivity.class));
                return true;
            }
        } catch (Exception e) {
            Log.e(TAG, "Menu item failed", e);
        }
        return super.onOptionsItemSelected(item);
    }
}