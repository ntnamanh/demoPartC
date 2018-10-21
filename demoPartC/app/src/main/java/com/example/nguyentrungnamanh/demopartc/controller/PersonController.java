package com.example.nguyentrungnamanh.demopartc.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import com.example.nguyentrungnamanh.demopartc.model.Person;
import com.example.nguyentrungnamanh.demopartc.view.DateTimePicker;
import com.example.nguyentrungnamanh.demopartc.view.EditPerson;
import com.example.nguyentrungnamanh.demopartc.view.MainActivity;

public class PersonController implements AdapterView.OnItemClickListener,View.OnClickListener{

    private Context context;
    private Person person;
    private int index;

    public PersonController(Context context,int index) {
        this.context = context;
        this.person = Person.getSingletonInstance(this.context);
        this.index = index;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Person.personInformation personInformation = (Person.personInformation) parent.getItemAtPosition(position);
        Intent intent = new Intent(context,EditPerson.class);
        intent.putExtra("index",person.getIndex(personInformation));
        context.startActivity(intent);
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context,DateTimePicker.class);
        intent.putExtra("index",this.index);
        context.startActivity(intent);
    }
}
