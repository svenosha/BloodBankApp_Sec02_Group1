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
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UserHomepage extends AppCompatActivity {

    private TextView username, name;
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

//                isUser();

//                reference = FirebaseDatabase.getInstance().getReference().child("Member").child("1");

                List<String> userIdList = new ArrayList();
                reference = FirebaseDatabase.getInstance().getReference().child("Member");
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        if(snapshot == null) return;
                        for (DataSnapshot postsnapshot: snapshot.getChildren()) {
                            userIdList.add(postsnapshot.getKey());


                            String namefromDB = snapshot.child("Member").child("name").getValue().toString();
                            String agefromDB = snapshot.child("Member").child("age").getValue().toString();
                            String genderfromDB = snapshot.child("Member").child("gender").getValue().toString();
                            String phonefromDB = snapshot.child("Member").child("phone").getValue().toString();
                            String emailfromDB = snapshot.child("Member").child("email").getValue().toString();
                            String locationfromDB = snapshot.child("Member").child("location").getValue().toString();
                            String usernamefromDB = snapshot.child("Member").child("username").getValue().toString();
                            String bloodtypefromDB = snapshot.child("Member").child("bloodtype").getValue().toString();

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

//    private void isUser() {
//
//        String userEnteredName = username.getText().toString().trim();
//
//        reference = FirebaseDatabase.getInstance().getReference("Member");
//        Query checkUser = reference.orderByChild("name").equalTo(userEnteredName);
//
//        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                String namefromDB = snapshot.child("Member").child("name").getValue().toString();
//                String agefromDB = snapshot.child("Member").child("age").getValue().toString();
//                String locationfromDB = snapshot.child("Member").child("location").getValue().toString();
//                String phonefromDB = snapshot.child("Member").child("phone").getValue().toString();
//                String emailfromDB = snapshot.child("Member").child("email").getValue().toString();
//                String usernamefromDB = snapshot.child("Member").child("username").getValue().toString();
//                String genderfromDB = snapshot.child("Member").child("gender").getValue().toString();
//                String bloodtypefromDB = snapshot.child("Member").child("bloodtype").getValue().toString();
//
//                Intent intentHome2profile = new Intent(UserHomepage.this, UserViewProfile.class);
//
//                intentHome2profile.putExtra("name", namefromDB);
//                intentHome2profile.putExtra("age", agefromDB);
//                intentHome2profile.putExtra("location", locationfromDB);
//                intentHome2profile.putExtra("phone", phonefromDB);
//                intentHome2profile.putExtra("email", emailfromDB);
//                intentHome2profile.putExtra("username", usernamefromDB);
//                intentHome2profile.putExtra("gender", genderfromDB);
//                intentHome2profile.putExtra("bloodtype", bloodtypefromDB);
//
//                startActivity(intentHome2profile);
//
//            }
//
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//    }
}