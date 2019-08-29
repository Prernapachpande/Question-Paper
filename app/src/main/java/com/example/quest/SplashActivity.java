package com.example.quest;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {
    public static int Splash_Time_out=4000;
    ImageView tree,title;
    Animation top,bottom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
       tree = (ImageView)findViewById(R.id.tree);
       title = (ImageView) findViewById(R.id.title);
        top = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fromtop);
        bottom = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
        tree.startAnimation(top);
        title.startAnimation(bottom);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splash = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(splash);
                finish();
            }
        },Splash_Time_out);
    }
}
