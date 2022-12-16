package com.app.fitnessandnutrition;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class SplashActivity extends AppCompatActivity {

    Boolean splashLoaded = false;
    Handler handler;
    View mContentView;
    TextView appTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();

        if (!splashLoaded) {
            setContentView(R.layout.activity_splash);
            appTitle = findViewById(R.id.app_title);
            mContentView = appTitle;
            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

            handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    FirebaseAuth auth = FirebaseAuth.getInstance();
                    if(auth.getCurrentUser() != null){
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                    }
                    else {
                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    }
                    finish();
                }
            }, 3000);
            splashLoaded = true;
        }
    }
}