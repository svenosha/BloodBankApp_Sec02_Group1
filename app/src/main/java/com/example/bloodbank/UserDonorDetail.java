package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserDonorDetail extends AppCompatActivity {

    private EditText location, name, age, btype, gender;
    private Button email, phone;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_donor_detail);

        location = findViewById(R.id.ed_location);
        name = findViewById(R.id.ed_donorname);
        age = findViewById(R.id.ed_donorage);
        gender = findViewById(R.id.ed_donorgender);
        btype = findViewById(R.id.ed_donorbt);
        email = findViewById(R.id.btn_email);
        phone = findViewById(R.id.btn_phone);
        reff = FirebaseDatabase.getInstance().getReference().child("Member");

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent for email
                Intent intentEmail = new Intent(UserDonorDetail.this,Email.class);
                startActivity(intentEmail);
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