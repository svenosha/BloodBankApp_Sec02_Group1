package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserHomepage extends AppCompatActivity {

    private TextView username;
    private Button profile, BDonor, BBank, btnMakeRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_homepage);

        setTitle("Home");

        username = findViewById(R.id.tv_username);
        profile = findViewById(R.id.btn_myprofile);
        BDonor = findViewById(R.id.btn_blooddonor);
        BBank = findViewById(R.id.btn_bloodbank);
        btnMakeRequest = findViewById(R.id.btn_makerequest);


        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHome2profile = new Intent (UserHomepage.this, UserViewProfile.class);
                startActivity(intentHome2profile);
            }
        });

        BDonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        BBank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        

        btnMakeRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMakeRequest();
            }
        });

    }

    public void openMakeRequest(){
        Intent intentMakeRequest = new Intent(this, UserMakeRequest.class);
        startActivity(intentMakeRequest);
    }
}