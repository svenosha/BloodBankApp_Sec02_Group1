package com.example.bloodbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AdminManageBloodBank extends AppCompatActivity {

    private EditText location,email, phone,  aPlusAmt, bPlusAmt, aMinusAmt, bMinusAmt, oPlusAmt, abPlusAmt, oMinusAmt, abMinusAmt;
    private Button update;
    DatabaseReference reff;

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
        reff = FirebaseDatabase.getInstance().getReference().child("BloodBank").child("penang");


        /*reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //get value
                String Location=dataSnapshot.child("location").getValue().toString();
                String Email=dataSnapshot.child("Email").getValue().toString();
                String Phone=dataSnapshot.child("Phone").getValue().toString();
                String APlus = dataSnapshot.child("APlus").getValue().toString();
                String BPlus = dataSnapshot.child("BPlus").getValue().toString();
                String OPlus = dataSnapshot.child("OPlus").getValue().toString();
                String ABPlus = dataSnapshot.child("ABPlus").getValue().toString();
                String AMinus = dataSnapshot.child("AMinus").getValue().toString();
                String BMinus = dataSnapshot.child("BMinus").getValue().toString();
                String OMinus = dataSnapshot.child("OMinus").getValue().toString();
                String ABMinus = dataSnapshot.child("ABMinus").getValue().toString();

                //set value
                location.setText(Location);
                email.setText(Email);
                phone.setText(Phone);
                aPlusAmt.setText(APlus);
                bPlusAmt.setText(BPlus);
                oPlusAmt.setText(OPlus);
                abPlusAmt.setText(ABPlus);
                aMinusAmt.setText(AMinus);
                bMinusAmt.setText(BMinus);
                oMinusAmt.setText(OMinus);
                abMinusAmt.setText(ABMinus);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGoToUpdate = new Intent(AdminManageBloodBank.this,AdminConfirmUpdateBloodBank.class);
                startActivity(intentGoToUpdate);

            }
        });
    }
}