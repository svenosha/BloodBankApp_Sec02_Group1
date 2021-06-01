package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserHomepage extends AppCompatActivity {

    private Button btnMakeRequest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_homepage);

        btnMakeRequest = findViewById(R.id.btn_makerequest);

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