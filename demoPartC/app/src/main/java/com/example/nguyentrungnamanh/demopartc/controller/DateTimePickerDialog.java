package com.example.nguyentrungnamanh.demopartc.controller;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.nguyentrungnamanh.demopartc.R;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Objects;

public class DateTimePickerDialog {

    private Context context;
    private Activity activity;

    public DateTimePickerDialog(Context context,Activity activity) {
        this.context = context;
        this.activity = activity;
    }

    public void dateTimePicker() {
        final EditText editText = activity.findViewById(R.id.editBirthDay);
        final Button btnEdit = activity.findViewById(R.id.btnEdit);
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar myCalendar = Calendar.getInstance();
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                editText.setText(DateFormat.getDateInstance(DateFormat.SHORT).format(myCalendar.getTime()));
            }
        };
        Calendar currentime = Calendar.getInstance();
        int year = currentime.get(Calendar.YEAR);
        int month = currentime.get(Calendar.MONTH);
        int day = currentime.get(Calendar.DATE);
        DatePickerDialog datePickerDialog = new DatePickerDialog(context, android.R.style.Theme_Holo_Dialog_MinWidth, dateSetListener,year,month,day);
        Objects.requireNonNull(datePickerDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        datePickerDialog.show();
    }
}
