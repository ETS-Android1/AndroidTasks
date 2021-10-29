package com.carol.implicitintents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mWebsiteEditText;
    private EditText mLocationEditText;
    private EditText mShareTextEditText;
    private EditText mDialNumberEditText;
    private EditText mShareLocation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebsiteEditText = findViewById(R.id.website_edittext);
        mLocationEditText = findViewById(R.id.location_edittext);
        mShareTextEditText = findViewById(R.id.share_edittext);
        mDialNumberEditText = findViewById(R.id.dial_edittext);
        mShareLocation = findViewById(R.id.share_location_edittext);

    }

    public void openWebsite(View view) {
        String url = mWebsiteEditText.getText().toString();
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }else {
            Log.d("ImplicitIntents", "Can't handle this!");
        }
    }

    public void openLocation(View view) {
        String loc = mLocationEditText.getText().toString();
        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void shareText(View view) {
        String txt = mShareTextEditText.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle(getString(R.string.Chooster_Title))
                .setText(txt)
                .startChooser();
    }

    public void dialNumber(View view) {
        String number = mDialNumberEditText.getText().toString();
        Uri dial = Uri.parse("tel:" + Uri.encode(number));
        Intent intent = new Intent(Intent.ACTION_DIAL, dial);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }


    }

    public void shareLocation(View view) {
        String sloc = mShareLocation.getText().toString();
        //Uri shareUri = Uri.parse("geo:0,0?q=" + sloc);
        String shloc = "geo:0,0?q=" + sloc;
        ShareCompat.IntentBuilder
                .from(this)
                .setType(shloc)
                .setChooserTitle(getString(R.string.Chooster_Title))
                .setText(sloc)
                .startChooser();
    }
}