package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button user, admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Blood Bank");

        //linking
        user = findViewById(R.id.btn_user);
        admin = findViewById(R.id.btn_admin);

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUserLogin();
            }
        });

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAdminLogin();
            }
        });
    }

    public void openUserLogin(){
        Intent intentUserLogin = new Intent (this, userLogin.class);
        startActivity(intentUserLogin);
    }

    public void openAdminLogin(){
        Intent intentAdminLogin = new Intent (this, adminLogin.class);
        startActivity(intentAdminLogin);
    }
}