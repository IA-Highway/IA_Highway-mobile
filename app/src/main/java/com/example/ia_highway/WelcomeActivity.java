package com.example.ia_highway;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import eightbitlab.com.blurview.BlurView;
import eightbitlab.com.blurview.RenderScriptBlur;


public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button_welcome_view;
    private BlurView blurView_welcome_fragment;
    private CardView card_view_welcome_activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        getSupportActionBar().hide();
        card_view_welcome_activity = findViewById(R.id.card_view_welcome_activity);
        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        final DisplayMetrics displayMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        ViewGroup.MarginLayoutParams layoutParams =
                (ViewGroup.MarginLayoutParams) card_view_welcome_activity.getLayoutParams();
        card_view_welcome_activity.requestLayout();

        blurView_welcome_fragment = findViewById(R.id.blurView_welcome_fragment);
        BlurView();
        button_welcome_view=findViewById(R.id.button_welcome_view);
        button_welcome_view.setOnClickListener(this);
    }

    private void BlurView() {
        float radius = 10;
        View decorView = WelcomeActivity.this.getWindow().getDecorView();
        //ViewGroup you want to start blur from. Choose root as close to BlurView in hierarchy as possible.
        ViewGroup rootView = (ViewGroup) decorView.findViewById(android.R.id.content);
        //Set drawable to draw in the beginning of each blurred frame (Optional).
        //Can be used in case your layout has a lot of transparent space and your content
        //gets kinda lost after after blur is applied.
        Drawable windowBackground = decorView.getBackground();

        blurView_welcome_fragment.setupWith(rootView)
                .setFrameClearDrawable(windowBackground)
                .setBlurAlgorithm(new RenderScriptBlur(getApplicationContext()))
                .setBlurRadius(radius)
                .setBlurAutoUpdate(true);


    }

    @Override
    public void onClick(View v) {
        if(v== button_welcome_view) {
            Intent it=new Intent(this,ImageActivity.class);
            startActivity(it);
            finish();
        }
    }
}