package com.example.nguyentrungnamanh.demopartc.view.itemAdapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.nguyentrungnamanh.demopartc.R;
import com.example.nguyentrungnamanh.demopartc.controller.PersonController;
import com.example.nguyentrungnamanh.demopartc.model.Person;

import java.text.DateFormat;
import java.util.List;
import java.util.Objects;

public class ItemAdapter extends ArrayAdapter<Person.personInformation> {

    private Person person;
    private Context context;
    private int resource;
    private LayoutInflater layoutInflater = null;
    private List<Person.personInformation> personInformationList;

    public ItemAdapter( @NonNull Context context, int resource, @NonNull List<Person.personInformation> objects) {
        super(context, resource, objects);
        this.context = context;
        this.person = Person.getSingletonInstance(context);
        this.personInformationList = objects;
        this.resource = resource;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return personInformationList.size();
    }

    @Override
    public Person.personInformation getItem(int pos) {
        return personInformationList.get(pos);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        StringBuilder stringBuffer = new StringBuilder();

        String id = String.valueOf(Objects.requireNonNull(getItem(position)).getId());
        String firstName = Objects.requireNonNull(getItem(position)).getFirstName();
        String lastName = Objects.requireNonNull(getItem(position)).getLastName();
        String birthDay = dateFormat.format(Objects.requireNonNull(getItem(position)).getBirthDay());
        String height = String.valueOf(Objects.requireNonNull(getItem(position)).getHeight());
        String weight = String.valueOf(Objects.requireNonNull(getItem(position)).getWeight());

        convertView = this.layoutInflater.inflate(resource,parent,false);

        TextView txtId = convertView.findViewById(R.id.txtId);
        txtId.setText(id);
        TextView txtName = convertView.findViewById(R.id.txtName);
        stringBuffer.append(firstName).append(" ").append(lastName);
        txtName.setText(stringBuffer.toString());
        TextView txtBirthDay = convertView.findViewById(R.id.txtBirthDay);
        txtBirthDay.setText(birthDay);
        TextView txtHeight = convertView.findViewById(R.id.txtHeight);
        txtHeight.setText(height);
        TextView txtWeight = convertView.findViewById(R.id.txtWeight);
        txtWeight.setText(weight);
        Button btnChange = convertView.findViewById(R.id.btnChange);

        btnChange.setOnClickListener(new PersonController(context,person.getIndex(getItem(position))));
        
        return convertView;
    }

}
