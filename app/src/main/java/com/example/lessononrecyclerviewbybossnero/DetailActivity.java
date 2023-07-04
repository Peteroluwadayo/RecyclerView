package com.example.lessononrecyclerviewbybossnero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // get intent data
        Intent intent = getIntent();
        String countryName = intent.getStringExtra("name");
        String continent = intent.getStringExtra("continent");
        String description = intent.getStringExtra("description");
        String countryImage = intent.getStringExtra("image");

        //now init views
        TextView countryNameTv = findViewById(R.id.country_name_d_1);
        TextView continentTv = findViewById(R.id.country_name_d_3);
        TextView descriptionTv = findViewById(R.id.country_name_d_2);
        ImageView imageView = findViewById(R.id.country_image);

        //now set data
        countryNameTv.setText(countryName);
        continentTv.setText(continent);
        descriptionTv.setText(description);

        Glide.with(this).load(countryImage).into(imageView);


    }
}