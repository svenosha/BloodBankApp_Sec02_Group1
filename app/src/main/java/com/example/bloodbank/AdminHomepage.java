package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminHomepage extends AppCompatActivity {

    private Button userList, donorList, btnrequestlist, bloodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_homepage);

        userList = findViewById(R.id.btn_viewusers);
        donorList = findViewById(R.id.btn_viewdonors);
        btnrequestlist = findViewById(R.id.btn_viewrequests);        
        bloodList = findViewById(R.id.btn_viewbloodbank);


        userList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenthome2user = new Intent (AdminHomepage.this, AdminUserList.class);
                startActivity(intenthome2user);
            }
        });

        donorList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intenthome2donor = new Intent (AdminHomepage.this, AdminBloodDonorList.class);
                startActivity(intenthome2donor);
            }
        });


        bloodList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHome2blood = new Intent (AdminHomepage.this, AdminManageBloodBank.class);
                startActivity(intentHome2blood);
            }
        });

        btnrequestlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRequestList();
            }
        });

    }

    public void openRequestList(){
        Intent intentAdminRequestList = new Intent(this, AdminRequestList.class);
        startActivity(intentAdminRequestList);
    }
}