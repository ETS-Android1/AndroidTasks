package com.carol.twoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private static final String LOG_TAG = MainActivity.class.getSimpleName();
public static final String EXTRA_MESSAGE="My key";
public static final int TEXT_REQUEST = 1;
private TextView mReplyHeadTextView;
private TextView mReplyTextView;

private EditText messageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messageEditText = findViewById(R.id.edit_text_message);
        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_view_reply);
    }


    public void LaunchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button Clicked");

        Intent myIntent = new Intent(this,SecondActivity.class);
        String myMessage = messageEditText.getText().toString();

        myIntent.putExtra(EXTRA_MESSAGE, myMessage);

        startActivityForResult(myIntent, TEXT_REQUEST);

    }
    @Override
    public void onActivityResult (int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST){
            if( resultCode == RESULT_OK){
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }

}