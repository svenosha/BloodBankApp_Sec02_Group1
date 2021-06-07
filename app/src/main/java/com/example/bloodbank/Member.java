package com.example.bloodbank;

import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Member {
    public String name;
    public String age;
    public String location;
    public String phone;
    public String email;
    public String username;

    public String gender;
    public String bloodtype;

    public Member() {
    }

    public Member(String name, String age, String location, String phone, String email, String username){
        this.name = name;
        this.age = age;
        this.location = location;
        this.phone = phone;
        this.email =email;
        this.username = username;

    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodtype() {
        return bloodtype;
    }

    public void setBloodtype(String bloodtype) {
        this.bloodtype = bloodtype;
    }
}