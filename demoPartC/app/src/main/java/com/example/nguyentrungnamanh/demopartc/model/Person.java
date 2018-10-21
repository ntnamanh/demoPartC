package com.example.nguyentrungnamanh.demopartc.model;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Person {

    // PRIVATE PORTION
    private static final String LOG_TAG = Person.class.getName();
    private List<personInformation> personInformationList = new ArrayList<>();
    private static Context context;

    public Person() {
    }

    public class personInformation {
        private int id;
        private String firstName;
        private String lastName;
        private Date birthDay;
        private double height;
        private int weight;

        public personInformation() {
        }

        public personInformation(int id, String firstName, String lastName, Date birthDay, double height, int weight) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.birthDay = birthDay;
            this.height = height;
            this.weight = weight;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public Date getBirthDay() {
            return birthDay;
        }

        public void setBirthDay(Date birthDay) {
            this.birthDay = birthDay;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }

    // singleton support
    private static class LazyHolder
    {
        static final Person INSTANCE = new Person();
    }

    public static Person getSingletonInstance(Context context)
    {
        Person.context = context;
        return LazyHolder.INSTANCE;
    }

    public void initialSomeDataForTest()   {
        try {
            DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
            personInformation p1 = new personInformation(
                    1,"Nguyen Trung","Nam Anh",dateFormat.parse("01/01/1994"),1.80,85);
            personInformation p2 = new personInformation(
                    2,"Nguyen","Meo",dateFormat.parse("01/01/1997"),1.50,45);
            personInformation p3 = new personInformation(
                    3,"Minh","Tu",dateFormat.parse("01/01/1994"),1.78,79);
            this.personInformationList.add(p1);
            this.personInformationList.add(p2);
            this.personInformationList.add(p3);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public boolean deletePerson(personInformation personInformation) {
        return this.personInformationList.remove(personInformation);
    }

    public void editPerson(int index, String firstName, String lastName, String birthDay, String height, String weight) {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        personInformation person = personInformationList.get(index);
        try {
            person.setFirstName(firstName);
            person.setLastName(lastName);
            person.setBirthDay(dateFormat.parse(birthDay));
            person.setHeight(Double.parseDouble(height));
            person.setWeight(Integer.parseInt(weight));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public List<personInformation> getPersonInformationList() {
        return personInformationList;
    }

    public int getIndex(personInformation personInformation) {
        return personInformationList.indexOf(personInformation);
    }

    public personInformation getPersonByIndex(int index) {
        return personInformationList.get(index);
    }

    public String getBirthday(int index) {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        return dateFormat.format(personInformationList.get(index).getBirthDay());
    }

    public void editBirthday(String birthDay, int index) {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        personInformation p = personInformationList.get(index);
        try {
            p.setBirthDay(dateFormat.parse(birthDay));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
