package com.example.nguyentrungnamanh.demopartc.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import com.example.nguyentrungnamanh.demopartc.model.Person;
import com.example.nguyentrungnamanh.demopartc.view.EditPerson;

public class PersonController implements AdapterView.OnItemClickListener {

    private Context context;
    private Person person;

    public PersonController(Context context) {
        this.context = context;
        this.person = Person.getSingletonInstance(this.context);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Person.personInformation personInformation = (Person.personInformation) parent.getItemAtPosition(position);
        Intent intent = new Intent(context,EditPerson.class);
        intent.putExtra("index",person.getIndex(personInformation));
        context.startActivity(intent);
    }
}
