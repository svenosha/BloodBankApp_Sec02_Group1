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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_homepage);

        setTitle("Home");

        username = findViewById(R.id.tv_username);
        profile = findViewById(R.id.btn_myprofile);
        BDonor = findViewById(R.id.btn_blooddonor);
        BBank = findViewById(R.id.btn_bloodbank);
        btnMakeRequest = findViewById(R.id.btn_makerequest);


        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                reference = FirebaseDatabase.getInstance().getReference().child("Member").child("1");

                reference = FirebaseDatabase.getInstance().getReference().child("Member").child("1");
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {


                            String namefromDB = snapshot.child("name").getValue().toString();
                            String agefromDB = snapshot.child("age").getValue().toString();
                            String genderfromDB = snapshot.child("gender").getValue().toString();
                            String phonefromDB = snapshot.child("phone").getValue().toString();
                            String emailfromDB = snapshot.child("email").getValue().toString();
                            String locationfromDB = snapshot.child("location").getValue().toString();
                            String usernamefromDB = snapshot.child("username").getValue().toString();
                            String bloodtypefromDB = snapshot.child("bloodtype").getValue().toString();

                            Intent intentHome2profile = new Intent(UserHomepage.this, UserViewProfile.class);

                            intentHome2profile.putExtra("name", namefromDB);
                            intentHome2profile.putExtra("age", agefromDB);
                            intentHome2profile.putExtra("location", locationfromDB);
                            intentHome2profile.putExtra("phone", phonefromDB);
                            intentHome2profile.putExtra("email", emailfromDB);
                            intentHome2profile.putExtra("username", usernamefromDB);
                            intentHome2profile.putExtra("gender", genderfromDB);
                            intentHome2profile.putExtra("bloodtype", bloodtypefromDB);

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

            }
        });

        BBank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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