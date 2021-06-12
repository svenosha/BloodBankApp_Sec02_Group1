package com.example.bloodbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.net.Uri;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserViewProfile extends AppCompatActivity {

    private Button update;
    private TextView name, age, location, phone, email, username, status, gender, bloodtype;
    DatabaseReference reference;
    long id=0;
    Member member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_view_profile);

        name = findViewById(R.id.tv_getName);
        age = findViewById(R.id.tv_getAge);
        gender = findViewById(R.id.tv_getGender);
        bloodtype = findViewById(R.id.tv_getBlood);
        location = findViewById(R.id.tv_getLocation);
        phone = findViewById(R.id.tv_getPhone);
        email = findViewById(R.id.tv_getEmail);
        username = findViewById(R.id.tv_getUsername);
        status = findViewById(R.id.tv_getDonorStatus);
        update = findViewById(R.id.btn_userUpdate);

//        showAllUserData();

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");


        Log.d("Debuggggg", id.toString());
        reference = FirebaseDatabase.getInstance().getReference().child("Member").child(id.toString());
        reference.get().addOnSuccessListener(new OnSuccessListener<DataSnapshot>() {
            @Override
            public void onSuccess(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    if (dataSnapshot.exists()) {
                        Member member = dataSnapshot.getValue(Member.class);
                        name.setText(member.getName());
                        age.setText(member.getAge());
                        gender.setText(member.getGender());
                        phone.setText(member.getPhone());
                        email.setText(member.getEmail());
                        location.setText(member.getLocation());
                        username.setText(member.getUser());
                        bloodtype.setText(member.getBloodtype());


                        update.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String number = ""+ member.getPhone();
                                Intent intentphone = new Intent(Intent.ACTION_DIAL);
                                intentphone.setData(Uri.parse("tel:"+number));
                                startActivity(intentphone);
                            }

                        });
                    }
                }
            }
            });

//                        addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//
//                        String namefromDB = snapshot.child("name").getValue().toString();
//                        String agefromDB = snapshot.child("age").getValue().toString();
//                        String genderfromDB = snapshot.child("gender").getValue().toString();
//                        String phonefromDB = snapshot.child("phone").getValue().toString();
//                        String emailfromDB = snapshot.child("email").getValue().toString();
//                        String locationfromDB = snapshot.child("location").getValue().toString();
//                        String usernamefromDB = snapshot.child("username").getValue().toString();
//                        String bloodtypefromDB = snapshot.child("bloodtype").getValue().toString();
//
//                        Intent intentProfile2Edit = new Intent (getApplicationContext(), UserEditProfile.class);
//
//                        intentProfile2Edit.putExtra("name", namefromDB);
//                        intentProfile2Edit.putExtra("age", agefromDB);
//                        intentProfile2Edit.putExtra("location", locationfromDB);
//                        intentProfile2Edit.putExtra("phone", phonefromDB);
//                        intentProfile2Edit.putExtra("email", emailfromDB);
//                        intentProfile2Edit.putExtra("username", usernamefromDB);
//                        intentProfile2Edit.putExtra("gender", genderfromDB);
//                        intentProfile2Edit.putExtra("bloodtype", bloodtypefromDB);
//
//                        startActivity(intentProfile2Edit);
//                    }
//
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });

    }
}