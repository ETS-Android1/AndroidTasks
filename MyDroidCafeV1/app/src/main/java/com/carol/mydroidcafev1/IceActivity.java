package com.carol.mydroidcafev1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class IceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ice);

        TextView iceTitle = findViewById(R.id.ice_title);
        iceTitle.setText(getIntent().getStringExtra("iTitle"));
        TextView iceDescription = findViewById(R.id.ice_description);
        iceDescription.setText(getIntent().getStringExtra("iDescription"));
        ImageView iceImage = findViewById(R.id.ice_image);
        Glide.with(this).load(getIntent().getIntExtra("iImage",0)).into(iceImage);
    }
}