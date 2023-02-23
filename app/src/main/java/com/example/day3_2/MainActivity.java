package com.example.day3_2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatePickerDialog dp = new DatePickerDialog(MainActivity.this, null, 0, 0, 0);
        //Current Time
        Toast.makeText(this, dp.toString(), Toast.LENGTH_SHORT).show();

        //CurrentTimeWithDateAndGMT
        Date c = Calendar.getInstance().getTime();
        TextView currentTimeWithDateAndGMT = findViewById(R.id.textView);
        currentTimeWithDateAndGMT.setText("Current time => " + c);

        //Current date
        SimpleDateFormat df = new SimpleDateFormat("dd/MMM/yyyy", Locale.getDefault());
        String formattedDate = df.format(c);
        Toast.makeText(this, formattedDate, Toast.LENGTH_SHORT).show();


        DatePickerDialog dpWithListener = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                TextView tv = findViewById(R.id.tv);
                tv.setText(year + "/" + (month+1) + "/" + dayOfMonth);
            }
        }, 2022, 0, 1);


        dpWithListener.show();
    }
}