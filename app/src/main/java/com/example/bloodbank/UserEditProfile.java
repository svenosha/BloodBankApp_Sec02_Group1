package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;


public class UserEditProfile extends AppCompatActivity {

    private Button confirm;
    private EditText name, age, location, phone, email, username, pwd;
    private RadioButton male, female, bldA, bldB, bldAB, bldO;
    private CheckBox donor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_edit_profile);

        name = findViewById(R.id.et_name);
        age = findViewById(R.id.et_age);
        location = findViewById(R.id.et_location);
        phone = findViewById(R.id.et_phone);
        email = findViewById(R.id.et_email);
        username = findViewById(R.id.et_userUsername);
        pwd = findViewById(R.id.et_userPassword);
        male = findViewById(R.id.rb_male);
        female = findViewById(R.id.rb_female);
        bldA = findViewById(R.id.rb_A);
        bldB = findViewById(R.id.rb_B);
        bldAB = findViewById(R.id.rb_AB);
        bldO = findViewById(R.id.rb_O);
        donor = findViewById(R.id.cb_reqDonor);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}