package com.example.ia_highway.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ia_highway.R;
import com.example.ia_highway.models.Image;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class MyAdapter extends FirebaseRecyclerAdapter<Image, MyAdapter.myviewholder> {
    public MyAdapter(@NonNull FirebaseRecyclerOptions<Image> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull Image model) {
        holder.description.setText("Description ici");
        holder.date.setText(model.getCapturedDate());

        //Convert String to int and get the Integer Value
        float longitude = Float.parseFloat(model.getLocation().getLongitude());
        float latitude = Float.parseFloat(model.getLocation().getLatitude());
        int longitudeSimplifie = (int) longitude;
        int latitudeSimplifie = (int) latitude;

        holder.location.setText(longitudeSimplifie + ", " + latitudeSimplifie);
        Glide.with(holder.img.getContext()).load(model.getUrlImage()).into(holder.img);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView description, location, date;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.item_image);
            description = (TextView) itemView.findViewById(R.id.item_description);
            location = (TextView) itemView.findViewById(R.id.item_location);
            date = (TextView) itemView.findViewById(R.id.item_date);
        }
    }
}
