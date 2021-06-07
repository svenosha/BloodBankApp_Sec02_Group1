package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

public class adminConfirmUpdateBloodBank extends AppCompatActivity {

    private EditText location,email, phone,  aPlusAmt, bPlusAmt, aMinusAmt, bMinusAmt, oPlusAmt, abPlusAmt, oMinusAmt, abMinusAmt;
    private Button confirm;
    DatabaseReference reff;
    BloodBank bloodbank;
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
        confirm = findViewById(R.id.btn_Confirm);
        reff = FirebaseDatabase.getInstance().getReference().child("BloodBank");
        bloodbank = new BloodBank;

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int aplus = Integer.parseInt(aPlusAmt.getText().toString().trim());
                int bplus = Integer.parseInt(bPlusAmt.getText().toString().trim());
                int oplus = Integer.parseInt(oPlusAmt.getText().toString().trim());
                int abplus = Integer.parseInt(abPlusAmt.getText().toString().trim());
                int aminus = Integer.parseInt(aMinusAmt.getText().toString().trim());
                int bminus = Integer.parseInt(bMinusAmt.getText().toString().trim());
                int ominus = Integer.parseInt(oMinusAmt.getText().toString().trim());
                int abminus = Integer.parseInt(abMinusAmt.getText().toString().trim());

                bloodbank.setLocation(location.getText().toString().trim());
                bloodbank.setPhone(phone.getText().toString().trim());
                bloodbank.setEmail(email.getText().toString().trim());
                bloodbank.setAPlus(aplus);
                bloodbank.setBPlus(bplus);
                bloodbank.setOPlus(oplus);
                bloodbank.setABPlus(abplus);
                bloodbank.setAMinus(aminus);
                bloodbank.setBMinus(bminus);
                bloodbank.setOMinus(ominus);
                bloodbank.setABMinus(abminus);

                reff.push().setValue(bloodbank);
                Toast.makeText(adminConfirmUpdateBloodBank.this,"Blood Bank Update Successfully",Toast.LENGTH_SHORT).show();



            }
        });
    }
}