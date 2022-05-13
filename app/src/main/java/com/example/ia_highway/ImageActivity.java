package com.example.ia_highway;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.ia_highway.bitmapHelper.BitmapHelper;
import com.example.ia_highway.cadrage.PopUp;
import com.example.ia_highway.models.Image;
import com.example.ia_highway.models.gps_location;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ImageActivity extends AppCompatActivity implements View.OnClickListener, LocationListener {
    private FloatingActionButton floatingActionButton, addDataButton;
    private Button button;
    private ImageView image;
    private Bitmap bitmap = null;
    private LocationManager locationManager;
    private Double latitude, longitude;
    private Date capturedDate;
    private Uri uri;
    private double width, height;
    private EditText descriptionEditText;
    private String description;
    private boolean imageCharged = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image2);
        getSupportActionBar().hide();
        floatingActionButton = findViewById(R.id.floatingActionButton2);
        image = findViewById(R.id.imageView3);
        button = findViewById(R.id.button_Picture);
        addDataButton = findViewById(R.id.floatingActionButton);
        descriptionEditText = findViewById(R.id.button_metadonnees);
        if (ContextCompat.checkSelfPermission(ImageActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(ImageActivity.this, new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION
            }, 100);
        }
        getLocation();
        floatingActionButton.setOnClickListener(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePicker.with(ImageActivity.this)
                        .crop()                    //Crop image(Optional), Check Customization for more option
                        .compress(1024)            //Final image size will be less than 1 MB(Optional)
                        .maxResultSize(1080, 1080)    //Final image resolution will be less than 1080 x 1080(Optional)
                        .start();
            }
        });

        addDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Location", "onLocationChanged: " + latitude + "/" + longitude);
                Log.d("Date", "capturedDate: " + capturedDate);
                description = descriptionEditText.getText().toString();
                Log.d("Description", description);
                if (description.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Veuillez rajouter une description",
                            Toast.LENGTH_LONG).show();
                } else if (!imageCharged) {
                    Toast.makeText(getApplicationContext(), "Veuillez importer ou capturer une " +
                                    "image",
                            Toast.LENGTH_LONG).show();
                } else {
                    uploadToFirebase();
                    Intent i = new Intent(getApplicationContext(), MetadoneeActivity.class);
                    startActivity(i);
                    finish();
                }

            }
        });
    }


    private void uploadToFirebase() {
        FirebaseStorage storage = FirebaseStorage.getInstance();
        final String imageName = "Image" + UUID.randomUUID().toString();
        Log.d("imageName", imageName);
        final StorageReference uploader = storage.getReference("images/" + imageName);
        uploader.putFile(uri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        uploader.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                FirebaseDatabase db = FirebaseDatabase.getInstance();
                                DatabaseReference root = db.getReference("images");
                                gps_location location =
                                        new gps_location(longitude,
                                                latitude);
                                Image image = new Image(uri.toString(), capturedDate.toString(),
                                        location, width, height);
                                root.child(imageName).setValue(image);
                                Toast.makeText(getApplicationContext(), "Uploaded", Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                })
                .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                    }
                });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            uri = data.getData();
            try {
                getCapturedDate();
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
                imageCharged = true;
                //create instance of bitmap with BitmapHelper Class
                BitmapHelper.getInstance().setBitmap(bitmap);
                Intent itent = new Intent(this, PopUp.class); //Show popup to draw polygon
                startActivity(itent);

            } catch (IOException e) {
                e.printStackTrace();
            }
            Glide
                    .with(getApplicationContext())
                    .asBitmap()
                    .load(uri)
                    .apply(RequestOptions.fitCenterTransform())
                    .into(new SimpleTarget<Bitmap>() {
                        @Override
                        public void onResourceReady(Bitmap bitmap,
                                                    Transition<? super Bitmap> transition) {
                            width = bitmap.getWidth();
                            height = bitmap.getHeight();
                            image.setImageBitmap(bitmap);
                        }
                    });
        }

    }


    private void getCapturedDate() {
        Date c = Calendar.getInstance().getTime();
        capturedDate = c;
    }


    //Back Button
    @Override
    public void onClick(View v) {
        if (v == floatingActionButton) {
            Intent it = new Intent(this, MetadoneeActivity.class);
            startActivity(it);
            finish();
        }
    }

    @SuppressLint("MissingPermission")
    private void getLocation() {
        try {
            locationManager = (LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5, ImageActivity.this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        latitude = location.getLatitude();
        longitude = location.getLongitude();
    }

    @Override
    public void onLocationChanged(@NonNull List<Location> locations) {
        LocationListener.super.onLocationChanged(locations);
    }

    @Override
    public void onFlushComplete(int requestCode) {
        LocationListener.super.onFlushComplete(requestCode);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        LocationListener.super.onStatusChanged(provider, status, extras);
    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {
        LocationListener.super.onProviderEnabled(provider);
    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {
        LocationListener.super.onProviderDisabled(provider);
    }
}
