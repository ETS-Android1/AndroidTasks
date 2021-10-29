package com.carol.mydroidcafev1;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class Pastry1Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pastry1);

        TextView pastry1Title = findViewById(R.id.pastry1_title);
        pastry1Title.setText(getIntent().getStringExtra("p1Title"));
        TextView pastry1Description = findViewById(R.id.pastry1_description);
        pastry1Description.setText(getIntent().getStringExtra("p1Description"));
        ImageView donutImage = findViewById(R.id.donut_image);
        Glide.with(this).load(getIntent().getIntExtra("dImage",0)).into(donutImage);
    }
}
