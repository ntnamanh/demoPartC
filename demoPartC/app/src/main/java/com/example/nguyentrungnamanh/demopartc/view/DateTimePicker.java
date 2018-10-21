package com.example.nguyentrungnamanh.demopartc.view;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;

import com.example.nguyentrungnamanh.demopartc.R;
import com.example.nguyentrungnamanh.demopartc.controller.DateTimePickerController;

public class DateTimePicker extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time_picker);
        DatePicker datePicker = findViewById(R.id.datePicker);
        Button btnChange = findViewById(R.id.btnChange);
        btnChange.setOnClickListener(new DateTimePickerController(this,this));
        datePicker.setOnDateChangedListener(new DateTimePickerController(this,this));
    }
}
