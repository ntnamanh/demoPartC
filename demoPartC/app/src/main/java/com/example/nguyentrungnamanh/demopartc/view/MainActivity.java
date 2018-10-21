package com.example.nguyentrungnamanh.demopartc.view;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.nguyentrungnamanh.demopartc.R;
import com.example.nguyentrungnamanh.demopartc.controller.PersonController;
import com.example.nguyentrungnamanh.demopartc.model.Person;
import com.example.nguyentrungnamanh.demopartc.view.itemAdapter.ItemAdapter;

import java.text.ParseException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Person person;
    private ListView listView;
    private ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.person = Person.getSingletonInstance(this);
        this.listView = findViewById(R.id.personListView);
        itemAdapter = new ItemAdapter(this,R.layout.item_layout,person.getPersonInformationList());
        this.listView.setAdapter(itemAdapter);
        this.listView.setOnItemClickListener(new PersonController(this,-1));
    }

    @Override
    protected void onResume() {
        super.onResume();
        itemAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(person.getPersonInformationList().isEmpty()){
            this.person.initialSomeDataForTest();
        }
    }
}
