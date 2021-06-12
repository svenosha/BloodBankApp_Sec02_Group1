package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class AdminConfirmUpdateBloodBank extends AppCompatActivity {

    private EditText location,email, phone,  aPlusAmt, bPlusAmt, aMinusAmt, bMinusAmt, oPlusAmt, abPlusAmt, oMinusAmt, abMinusAmt;
    private Button confirm;
    DatabaseReference reff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_confirm_update_blood_bank);

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
        confirm = findViewById(R.id.btn_confirm);
        reff = FirebaseDatabase.getInstance().getReference().child("BloodBank");


       /* confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int aplus = Integer.parseInt(aPlusAmt.getText().toString());
                int bplus = Integer.parseInt(bPlusAmt.getText().toString());
                int oplus = Integer.parseInt(oPlusAmt.getText().toString());
                int abplus = Integer.parseInt(abPlusAmt.getText().toString());
                int aminus = Integer.parseInt(aMinusAmt.getText().toString());
                int bminus = Integer.parseInt(bMinusAmt.getText().toString());
                int ominus = Integer.parseInt(oMinusAmt.getText().toString());
                int abminus = Integer.parseInt(abMinusAmt.getText().toString());

                HashMap hashmap = new HashMap();
                hashmap.put("APlus",aplus);
                hashmap.put("BPlus",bplus);
                hashmap.put("OPlus",oplus);
                hashmap.put("ABPlus",abplus);
                hashmap.put("AMinus",aminus);
                hashmap.put("BMinus",bminus);
                hashmap.put("OMinus",ominus);
                hashmap.put("ABMinus",abminus);


                reff.child("penang").updateChildren(hashmap).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(AdminConfirmUpdateBloodBank.this,"Blood Bank Update Successfully",Toast.LENGTH_SHORT).show();
                    }
                });

                


            }
        });*/
    }
}