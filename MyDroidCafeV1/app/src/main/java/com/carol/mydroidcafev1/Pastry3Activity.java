package com.carol.mydroidcafev1;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class Pastry3Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pastry3);

        TextView pastry3Title = findViewById(R.id.pastry3_title);
        pastry3Title.setText(getIntent().getStringExtra("p3Title"));
        TextView pastry3Description = findViewById(R.id.pastry3_description);
        pastry3Description.setText(getIntent().getStringExtra("p3Description"));
        ImageView iceImage = findViewById(R.id.ice_image);
        Glide.with(this).load(getIntent().getIntExtra("iImage",0)).into(iceImage);
    }
}
