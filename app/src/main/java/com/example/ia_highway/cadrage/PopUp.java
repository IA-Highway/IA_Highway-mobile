package com.example.ia_highway.cadrage;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ia_highway.R;

public class PopUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up2);
        setContentView(new SomeView(PopUp.this));
    }
}