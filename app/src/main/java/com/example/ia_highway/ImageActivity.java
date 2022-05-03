package com.example.ia_highway;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ImageActivity extends AppCompatActivity implements View.OnClickListener  {
    private FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image2);
        getSupportActionBar().hide();
        floatingActionButton=findViewById(R.id.floatingActionButton2);
        floatingActionButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == floatingActionButton){
            Intent it=new Intent(this,MetadoneeActivity.class);
            startActivity(it);
            finish();
        }
    }
}
