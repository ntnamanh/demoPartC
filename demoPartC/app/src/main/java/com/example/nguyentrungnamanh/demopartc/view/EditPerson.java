package com.example.nguyentrungnamanh.demopartc.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.nguyentrungnamanh.demopartc.R;
import com.example.nguyentrungnamanh.demopartc.controller.EditController;

public class EditPerson extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_person);
        Button btnSave = findViewById(R.id.btnSave);
        Button btnCancel = findViewById(R.id.btnCancel);
        btnSave.setOnClickListener(new EditController(this,this));
        btnCancel.setOnClickListener(new EditController(this,this));

    }
}
