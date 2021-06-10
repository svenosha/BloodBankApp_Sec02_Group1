package com.example.bloodbank;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Member;

public class UserMakeRequest extends AppCompatActivity {
    private EditText name,age,gender,email,phone,location,bloodGroup,reason;
    private Button submit;
    private DatabaseReference reff;
    private Request request;
    private long maxid=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_request);
        name=(EditText)findViewById(R.id.user_name);
        gender=(EditText)findViewById(R.id.user_gender);
        age=(EditText)findViewById(R.id.user_age);
        email=(EditText)findViewById(R.id.user_email);
        phone=(EditText)findViewById(R.id.user_phone);
        location=(EditText)findViewById(R.id.user_location);
        bloodGroup=(EditText)findViewById(R.id.user_blood_group);
        reason=(EditText)findViewById(R.id.user_reason);
        submit=findViewById(R.id.btn_submit);
        request = new Request();
        reff= FirebaseDatabase.getInstance().getReference().child("Request");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                    maxid=(dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int agea=Integer.parseInt(age.getText().toString().trim());
                request.setName(name.getText().toString().trim());
                request.setGender(gender.getText().toString().trim());
                request.setEmail(email.getText().toString().trim());
                request.setLocation(location.getText().toString().trim());
                request.setBloodGroup(bloodGroup.getText().toString().trim());
                request.setReason(reason.getText().toString().trim());
                request.setAge(agea);
                request.setPhone(reason.getText().toString().trim());
                reff.child(String.valueOf(maxid+1)).setValue(request);
                Toast.makeText(UserMakeRequest.this,"submit successfully",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),UserHomepage.class));


            }
        });




    }


}