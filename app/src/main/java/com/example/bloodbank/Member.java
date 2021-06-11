package com.example.bloodbank;

import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

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



        public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBloodtype() {
        return bloodtype;
    }

    public void setBloodtype(String bloodtype) {
        this.bloodtype = bloodtype;
    }

    public String toString(){
        return this.name;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("name", name);
        result.put("age", age);
        result.put("location", location);
        result.put("phone", phone);
        result.put("email", email);
        result.put("username", username);
        result.put("bloodtype", bloodtype);


        return result;
    }
}