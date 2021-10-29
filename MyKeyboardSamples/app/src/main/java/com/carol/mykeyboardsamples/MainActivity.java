package com.carol.mykeyboardsamples;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private EditText birthday;
    private int mYear;
    private int mMonth;
    private int mDay;

    private String mSpinnerLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        birthday = findViewById(R.id.birthday);
        birthday.setOnClickListener(this);

        Spinner phoneSpinner = findViewById(R.id.phone_spinner);
        if (phoneSpinner != null){
            phoneSpinner.setOnItemSelectedListener(this);
        }

        ArrayAdapter<CharSequence> adapter =ArrayAdapter.createFromResource(this, R.array.spinner_label, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if(phoneSpinner !=null) {
            phoneSpinner.setAdapter(adapter);
        }

    }

    @Override
    public void onClick(View v) {

        if (v == birthday){

            final Calendar C = Calendar.getInstance();
            mYear = C.get(Calendar.YEAR);
            mMonth = C.get(Calendar.MONTH);
            mDay = C.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                    birthday.setText(dayOfMonth +"-"+(month+1 +"-"+ year));

                }
            }, mYear, mMonth, mDay);

            datePickerDialog.show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        mSpinnerLabel = adapterView.getItemAtPosition(i).toString();
        Toast myToast = Toast.makeText(this, "Selected phone as: " +mSpinnerLabel, Toast.LENGTH_SHORT);
        myToast.show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

        Toast toast = Toast.makeText(this, "Nothing selected", Toast.LENGTH_SHORT);
        toast.show();

    }

    public void showToast(View view) {

        Toast check = Toast.makeText(this, "Please Accept Terms and Conditions", Toast.LENGTH_SHORT);
        check.show();

    }

    public void CreateAccount(View view) {

        Toast toastSubmit = Toast.makeText(this, "Account Creation Successful", Toast.LENGTH_SHORT);
        toastSubmit.show();
    }
}