package net.kuncilagu.kuncigitar.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import net.kuncilagu.kuncigitar.R;
import net.kuncilagu.kuncigitar.utils.Tools;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Tools.setSystemBarTransparent(this);

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                        finish();
                        startActivity(intent);
                    }
                },
                3000);
    }
}
