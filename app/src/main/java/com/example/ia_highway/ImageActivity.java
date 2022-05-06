package com.example.ia_highway;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.bumptech.glide.Glide;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.request.RequestOptions;
import com.github.dhaval2404.imagepicker.ImagePicker;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.IOException;

public class ImageActivity extends AppCompatActivity implements View.OnClickListener  {
    private FloatingActionButton floatingActionButton;
    private Button button ;
    private ImageView image ;
    private Bitmap bitmap = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image2);
        getSupportActionBar().hide();
        floatingActionButton=findViewById(R.id.floatingActionButton2);
        image = findViewById(R.id.imageView3);
        button = findViewById(R.id.button_Picture);
        floatingActionButton.setOnClickListener(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePicker.with(ImageActivity.this)
                        .crop()	    			//Crop image(Optional), Check Customization for more option
                        .compress(1024)			//Final image size will be less than 1 MB(Optional)
                        .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                        .start();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK) {
            Uri uri = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Glide
                    .with(getApplicationContext())
                    .load(uri)
                    .apply(RequestOptions.fitCenterTransform())
                    .into(image);
        }

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
