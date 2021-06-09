package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

public class UserViewProfile extends AppCompatActivity {

    private Button update;
    private TextView name, age, location, phone, email, username, status, gender, bloodtype;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_view_profile);

        name = findViewById(R.id.tv_getName);
        age = findViewById(R.id.tv_getAge);
        gender = findViewById(R.id.tv_getGender);
        bloodtype = findViewById(R.id.tv_getBlood);
        location = findViewById(R.id.tv_getLocation);
        phone = findViewById(R.id.tv_getPhone);
        email = findViewById(R.id.tv_getEmail);
        username = findViewById(R.id.tv_getUsername);
        status = findViewById(R.id.tv_getDonorStatus);

        update = findViewById(R.id.btn_update);

        showAllUserData();

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentProfile2Edit = new Intent (UserViewProfile.this, UserEditProfile.class);
                startActivity(intentProfile2Edit);
            }
        });

    }

    private void showAllUserData() {
        Intent intent = getIntent();
        String user_name = intent.getStringExtra("name");
        String user_age = intent.getStringExtra("age");
        String user_location = intent.getStringExtra("location");
        String user_phone = intent.getStringExtra("phone");
        String user_email = intent.getStringExtra("email");
        String user_username = intent.getStringExtra("username");
        String user_gender = intent.getStringExtra("gender");
        String user_bloodtype = intent.getStringExtra("bloodtype");

        name.setText(user_name);
        age.setText(user_age);
        location.setText(user_location);
        phone.setText(user_phone);
        email.setText(user_email);
        username.setText(user_username);
        gender.setText(user_gender);
        bloodtype.setText(user_bloodtype);



    }
}