package com.example.ia_highway;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ia_highway.adapters.MyAdapter;
import com.example.ia_highway.models.Image;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

public class MetadoneeActivity extends AppCompatActivity implements View.OnClickListener {
    private FloatingActionButton floatingActionButton_metadonnee;
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.metadonne2);
        getSupportActionBar().hide();
        floatingActionButton_metadonnee = findViewById(R.id.floatingActionButton_metadonnee);
        floatingActionButton_metadonnee.setOnClickListener(this);

        //Firebase data to recycleView
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<Image> options =
                new FirebaseRecyclerOptions.Builder<Image>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("images"),
                                Image.class)
                        .build();
        myAdapter = new MyAdapter(options);
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void onClick(View v) {
        if (v == floatingActionButton_metadonnee) {
            Intent it = new Intent(this, ImageActivity.class);
            startActivity(it);
            finish();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        myAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        myAdapter.stopListening();
    }
}
