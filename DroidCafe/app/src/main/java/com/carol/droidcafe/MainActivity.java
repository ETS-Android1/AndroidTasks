package com.carol.droidcafe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.carol.droidcafe.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String mOrderMessage;
    public static final String EXTRA_ORDER_KEY = "MY KEY FOR ORDER MESSAGE";

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);




        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                intent.putExtra(EXTRA_ORDER_KEY, mOrderMessage);
                startActivity(intent);



            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       // if (id == R.id.action_settings) {
            //return true;
     //   }
        switch (item.getItemId()){
            case R.id.action_order:
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                intent.putExtra(EXTRA_ORDER_KEY, mOrderMessage);
                startActivity(intent);
                return true;

            case R.id.action_call:
                Uri myUri = Uri.parse("tel: 0729766877");
                Intent myIntent = new Intent(Intent.ACTION_DIAL, myUri);
                startActivity(myIntent);
                return true;



            case R.id.action_about_us:

                Uri about = Uri.parse("https://www.wikipedia.com/");
                Intent intent1 = new Intent(Intent.ACTION_VIEW, about);
                if (intent1.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent1);
                }else {
                    Log.d("ImplicitIntents", "Can't handle this!");
                }

               return true;

            case R.id.action_location:
                Uri address = Uri.parse("geo:0,0?q=" + "Moi Avenue");
                Intent intent2 = new Intent(Intent.ACTION_VIEW, address);
                if (intent2.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent2);
                }else {
                    Log.d("ImplicitIntents", "Can't handle this!");
                }

        }

        return super.onOptionsItemSelected(item);
    }

    public void displayToast(String message){

        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

    }

    public void showDonutMessage (View view){

        //displayToast(getString(R.string.donut_order));
        mOrderMessage = getString(R.string.donut_order);
        displayToast(mOrderMessage);
    }

    public void showIceCreamMessage (View view){

       // displayToast(getString(R.string.ice_cream_order));
        mOrderMessage = getString(R.string.ice_cream_order);
        displayToast(mOrderMessage);
    }

    public void showFroyoMessage (View view){

       //  displayToast(getString(R.string.froyo_order));
        mOrderMessage = getString(R.string.froyo_order);
        displayToast(mOrderMessage);
    }


}