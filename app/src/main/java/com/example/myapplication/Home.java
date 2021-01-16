package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    private static int SPLASH_SCREEN=5000;
    Animation topanimation,bottomanimation;
    ImageView image;
    TextView foodtext,des;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        topanimation= AnimationUtils.loadAnimation(this,R.anim.topanimation);
        bottomanimation=AnimationUtils.loadAnimation(this,R.anim.bottomanimation);
        image=findViewById(R.id.healthyfood);
        foodtext=findViewById(R.id.foodtext);
        des=findViewById(R.id.des);
        image.setAnimation(topanimation);
        foodtext.setAnimation(bottomanimation);
        des.setAnimation(bottomanimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent =new Intent(Home.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }
}