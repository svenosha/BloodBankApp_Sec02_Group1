package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AdminManageBloodBank extends AppCompatActivity {

    //admin update blood bank amount
    private EditText location,email, phone,  aPlusAmt, bPlusAmt, aMinusAmt, bMinusAmt, oPlusAmt, abPlusAmt, oMinusAmt, abMinusAmt;
    private Button update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_manage_blood_bank);

        location = findViewById(R.id.ed_location);
        email = findViewById(R.id.ed_email);
        phone = findViewById(R.id.ed_phone);
        aPlusAmt = findViewById(R.id.ed_APlusAmount);
        bPlusAmt = findViewById(R.id.ed_BPlusAmount);
        aMinusAmt = findViewById(R.id.ed_AMinusAmount);
        bMinusAmt = findViewById(R.id.ed_BMinusAmount);
        oPlusAmt = findViewById(R.id.ed_OPlusAmount);
        abPlusAmt = findViewById(R.id.ed_ABPlusAmount);
        oMinusAmt = findViewById(R.id.ed_OMinusAmount);
        abMinusAmt = findViewById(R.id.ed_ABMinusAmount);
        update = findViewById(R.id.btn_Update);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}