package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserViewBloodBank extends AppCompatActivity {

    //user view blood bank amount
    //declaration
    private EditText location, aPlusAmt, bPlusAmt, aMinusAmt, bMinusAmt, oPlusAmt, abPlusAmt, oMinusAmt, abMinusAmt;
    private Button email, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_view_blood_bank);

        //manage blood bank module for user

        location = findViewById(R.id.ed_location);
        aPlusAmt = findViewById(R.id.ed_APlusAmount);
        bPlusAmt = findViewById(R.id.ed_BPlusAmount);
        aMinusAmt = findViewById(R.id.ed_AMinusAmount);
        bMinusAmt = findViewById(R.id.ed_BMinusAmount);
        oPlusAmt = findViewById(R.id.ed_OPlusAmount);
        abPlusAmt = findViewById(R.id.ed_ABPlusAmount);
        oMinusAmt = findViewById(R.id.ed_OMinusAmount);
        abMinusAmt = findViewById(R.id.ed_ABMinusAmount);
        email = findViewById(R.id.btn_email);
        phone = findViewById(R.id.btn_phone);

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent for email
                // Intent intentEmail = new Intent(Intent.ACTIO)
                //startActivity(intentemail);
            }
        });


        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentphone = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01138134345"));
                startActivity(intentphone);
            }
        });

    }
}