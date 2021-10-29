package com.carol.mydroidcafev1;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class Pastry2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pastry2);

        TextView pastry2Title = findViewById(R.id.pastry2_title);
        pastry2Title.setText(getIntent().getStringExtra("p2Title"));
        TextView pastry2Description = findViewById(R.id.pastry2_description);
        pastry2Description.setText(getIntent().getStringExtra("p2Description"));
        ImageView froyoImage = findViewById(R.id.froyo_image);
        Glide.with(this).load(getIntent().getIntExtra("fImage",0)).into(froyoImage);
    }
}
