package com.example.nguyentrungnamanh.demopartc.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nguyentrungnamanh.demopartc.R;
import com.example.nguyentrungnamanh.demopartc.model.Person;
import com.example.nguyentrungnamanh.demopartc.view.MainActivity;

import java.text.DateFormat;
import java.util.Date;

public class EditController implements View.OnClickListener {

    private Context context;
    private Activity activity;
    private Person person;
    private Person.personInformation p;
    private int index;

    private EditText editFirstName,editLastName,editBirthDate,editHeight,editWeight;

    public EditController(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;
        this.person = Person.getSingletonInstance(this.context);
        this.index = activity.getIntent().getIntExtra("index",-1);
        this.p = this.person.getPersonByIndex(this.index);

        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);

        this.editFirstName = this.activity.findViewById(R.id.editFirstName);
        this.editLastName = this.activity.findViewById(R.id.editLastName);
        this.editBirthDate = this.activity.findViewById(R.id.editBirthDay);
        this.editHeight = this.activity.findViewById(R.id.editHeight);
        this.editWeight = this.activity.findViewById(R.id.editWeight);

        this.editFirstName.setText(p.getFirstName());
        this.editLastName.setText(p.getLastName());
        this.editBirthDate.setText(dateFormat.format(p.getBirthDay()));
        this.editHeight.setText(String.valueOf(p.getHeight()));
        this.editWeight.setText(String.valueOf(p.getWeight()));

    }



    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnSave) {
            if(TextUtils.isEmpty(editFirstName.getText())){
                Toast.makeText(context, "First name can not be null", Toast.LENGTH_SHORT).show();
                this.editFirstName.requestFocus();
            }
            if(TextUtils.isEmpty(editLastName.getText())){
                Toast.makeText(context, "Last name can not be null", Toast.LENGTH_SHORT).show();
                editLastName.requestFocus();
            }
            if(TextUtils.isEmpty(editBirthDate.getText())){
                Toast.makeText(context, "Birthdate can not be null", Toast.LENGTH_SHORT).show();
                editBirthDate.requestFocus();
            }
            if(TextUtils.isEmpty(editHeight.getText())){
                Toast.makeText(context, "Heigh can not be null", Toast.LENGTH_SHORT).show();
                editHeight.requestFocus();
            }
            if(TextUtils.isEmpty(editWeight.getText())){
                Toast.makeText(context, "Weight can not be null", Toast.LENGTH_SHORT).show();
                editWeight.requestFocus();
            }
            if(!TextUtils.isEmpty(editFirstName.getText())
                    && !TextUtils.isEmpty(editLastName.getText())
                    && !TextUtils.isEmpty(editBirthDate.getText())
                    && !TextUtils.isEmpty(editHeight.getText())
                    && !TextUtils.isEmpty(editWeight.getText())) {
                person.editPerson(index
                        ,editFirstName.getText().toString()
                        ,editLastName.getText().toString()
                        ,editBirthDate.getText().toString()
                        ,editHeight.getText().toString()
                        ,editWeight.getText().toString()
                );
                activity.finish();
            }


        }
        else {
            activity.finish();
        }
    }
}
