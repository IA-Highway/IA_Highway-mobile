package com.example.ia_highway;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MetadoneeActivity extends AppCompatActivity implements View.OnClickListener {

    private FloatingActionButton floatingActionButton_metadonnee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.metadonne2);
        getSupportActionBar().hide();
        floatingActionButton_metadonnee=findViewById(R.id.floatingActionButton_metadonnee);
        floatingActionButton_metadonnee.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v== floatingActionButton_metadonnee) {
            Intent it=new Intent(this,ImageActivity.class);
            startActivity(it);
            finish();
        }
    }
}
