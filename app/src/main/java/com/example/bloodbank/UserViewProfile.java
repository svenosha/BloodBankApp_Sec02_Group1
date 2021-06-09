package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class UserViewProfile extends AppCompatActivity {

    private Button update;
    private TextView name, age, location, phone, email, username, pwd, status;
    private RadioButton male, female;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_view_profile);

        name = findViewById(R.id.tv_getName);
        age = findViewById(R.id.tv_getAge);
        male = findViewById(R.id.rb_getMale);
        female = findViewById(R.id.rb_getFemale);
        location = findViewById(R.id.tv_getLocation);
        phone = findViewById(R.id.tv_getPhone);
        email = findViewById(R.id.tv_getEmail);
        username = findViewById(R.id.tv_getUsername);
        pwd = findViewById(R.id.tv_getPassword);
        status = findViewById(R.id.tv_getDonorStatus);

        update = findViewById(R.id.btn_update);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentProfile2Edit = new Intent (UserViewProfile.this, UserEditProfile.class);
                startActivity(intentProfile2Edit);
            }
        });

    }
}