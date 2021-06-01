package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminHomepage extends AppCompatActivity {

    private Button btnrequestlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_homepage);

        btnrequestlist = findViewById(R.id.btn_viewrequests);

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