package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminUserDetails extends AppCompatActivity {

    private TextView location, name, age, gender;
    private Button email, phone;
    DatabaseReference reference;
    Member member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_user_details);


        Intent intent = getIntent();
        String id = intent.getStringExtra("id");


        Log.d("Debuggggg",id.toString());
        reference=FirebaseDatabase.getInstance().getReference().child("Member").child(id.toString());
        reference.get().addOnSuccessListener(new OnSuccessListener<DataSnapshot>() {
            @Override
            public void onSuccess(DataSnapshot dataSnapshot) {
                if (dataSnapshot!=null){
                    if (dataSnapshot.exists()) {
                        Member member = dataSnapshot.getValue(Member.class);
                        name.setText(member.getName());
                        age.setText(member.getAge());
                        gender.setText(member.getGender());
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
                                Intent intentdonor2email = new Intent (AdminUserDetails.this, EmailDonor.class);
                                intentdonor2email.putExtra("mail", mail);
                                startActivity(intentdonor2email);
                            }
                        });
                    }
                }
            }

        });
    }
}