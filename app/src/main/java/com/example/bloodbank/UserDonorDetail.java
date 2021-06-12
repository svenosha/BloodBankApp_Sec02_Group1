package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserDonorDetail extends AppCompatActivity {

    private TextView location, name, age, btype, gender;
    private Button email, phone;
    DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_donor_detail);

        location = (TextView)findViewById(R.id.ed_location);
        name = (TextView)findViewById(R.id.ed_donorname);
        age = (TextView)findViewById(R.id.ed_donorage);
        gender = (TextView)findViewById(R.id.ed_donorgender);
        btype = (TextView)findViewById(R.id.ed_donorbt);
        email = findViewById(R.id.btn_email);
        phone = findViewById(R.id.btn_phone);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");


        Log.d("Debug",id.toString());
        database=FirebaseDatabase.getInstance().getReference().child("Member").child(id.toString());
        database.get().addOnSuccessListener(new OnSuccessListener<DataSnapshot>() {
            @Override
            public void onSuccess(DataSnapshot dataSnapshot) {
                if (dataSnapshot!=null){
                    if (dataSnapshot.exists()) {
                        Member member = dataSnapshot.getValue(Member.class);
                        name.setText(member.getName());
                        age.setText(member.getAge());
                        gender.setText(member.getGender());
                        btype.setText(member.getBloodtype());
                        location.setText(member.getLocation());

                        phone.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String number = ""+ member.getPhone();
                                Intent intentphone = new Intent(Intent.ACTION_DIAL);
                                intentphone.setData(Uri.parse("tel:"+number));
                                startActivity(intentphone);
                            }
                        });

                        email.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String mail = ""+ member.getEmail();
                                Intent intentdonor2email = new Intent (UserDonorDetail.this, EmailDonor.class);
                                intentdonor2email.putExtra("mail", mail);
                                startActivity(intentdonor2email);
                            }
                        });
                    }
                }
            }

        });



       /* email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent for email
                Intent intentEmail = new Intent(UserDonorDetail.this,Email.class);
                startActivity(intentEmail);
            }
        });*/




    }
}