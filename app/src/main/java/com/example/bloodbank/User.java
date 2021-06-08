package com.example.bloodbank;

import android.widget.EditText;

public class User {

    public String name;
    public String age;
    public String location;
    public String phone;
    public String email;
    public String username;

    public User(String nama, String umur, String lokasi, String telefon, String emel, EditText username) {
    }

    public User(String name, String age, String location, String phone, String email, String username){
        this.name = name;
        this.age = age;
        this.location = location;
        this.phone = phone;
        this.email =email;
        this.username = username;

    }

}
