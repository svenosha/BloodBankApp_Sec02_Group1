package com.example.bloodbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class UserHomepage extends AppCompatActivity {

    private TextView username;
    private Button profile, BDonor, BBank, btnMakeRequest;
    DatabaseReference reference;
    long id=0;
    Member member;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_homepage);

        setTitle("Home");

        username = findViewById(R.id.tv_username);
        profile = findViewById(R.id.btn_myprofile);
        BDonor = findViewById(R.id.btn_blooddonor);
        BBank = findViewById(R.id.btn_bloodbank);
        btnMakeRequest = findViewById(R.id.btn_makerequest);


//        Intent intent = getIntent();
//        String id = intent.getStringExtra("id");
//
//        Log.d("Debuggggg",id.toString());
//        reference =FirebaseDatabase.getInstance().getReference().child("Member").child(String.valueOf(id+1));


        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                reference = FirebaseDatabase.getInstance().getReference().child("Member").child("1");

                reference = FirebaseDatabase.getInstance().getReference().child("Member").child(String.valueOf(id+1));
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                            Intent intentHome2profile = new Intent(UserHomepage.this, UserViewProfile.class);
                            startActivity(intentHome2profile);
                        }


                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });

        BDonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHome2list = new Intent (UserHomepage.this, UserBloodDonorList.class);
                startActivity(intentHome2list);

            }
        });

        BBank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHome2blood = new Intent (UserHomepage.this, UserViewBloodBank.class);
                startActivity(intentHome2blood);

            }
        });
        

        btnMakeRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMakeRequest();
            }
        });

    }

    public void openMakeRequest(){
        Intent intentMakeRequest = new Intent(this, UserMakeRequest.class);
        startActivity(intentMakeRequest);
    }
}