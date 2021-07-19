package com.example.minibank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 5000;
    Animation topAnim,bottomAnim;
    ImageView img;
    TextView devolped,name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Animate
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim. bottom);

        //find id by view
        img = findViewById(R.id.my_logo);
        devolped = findViewById(R.id.dev_by);
        name = findViewById(R.id.my_name);

        //animation
        img.setAnimation(topAnim);
        devolped.setAnimation(bottomAnim);
        name.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,ViewUsersActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);

    }
}