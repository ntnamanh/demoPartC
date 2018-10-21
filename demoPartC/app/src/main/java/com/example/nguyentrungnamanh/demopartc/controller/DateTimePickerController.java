package com.example.nguyentrungnamanh.demopartc.controller;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.nguyentrungnamanh.demopartc.R;
import com.example.nguyentrungnamanh.demopartc.model.Person;


public class DateTimePickerController implements View.OnClickListener,DatePicker.OnDateChangedListener {

    private Context context;
    private Activity activity;
    private Person person;
    private DatePicker datePicker;
    private int index;
    private TextView txtBirdDate;

    public DateTimePickerController(Context context, Activity activity) {
        this.context = context;
        this.person = Person.getSingletonInstance(context);
        this.activity = activity;
        this.datePicker = activity.findViewById(R.id.datePicker);
        this.index = activity.getIntent().getIntExtra("index",-1);
        this.txtBirdDate = activity.findViewById(R.id.txtBd);
        this.txtBirdDate.setText(person.getBirthday(this.index));

    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(view.getMonth()+1).append("/").append(view.getDayOfMonth()).append("/").append(view.getYear());
        txtBirdDate.setText(stringBuffer.toString());
    }

    @Override
    public void onClick(View v) {
        person.editBirthday(txtBirdDate.getText().toString(),index);
        activity.finish();
    }
}
