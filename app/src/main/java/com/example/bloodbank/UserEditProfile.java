package com.example.bloodbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;


public class UserEditProfile extends AppCompatActivity {

    private Button confirm;
    private EditText name, age, location, phone, email, username, pwd;
    private RadioButton male, female, bldA, bldB, bldAB, bldO;
    private CheckBox donor;
    DatabaseReference reference;
    long id=0;
    Member member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_edit_profile);

        name = findViewById(R.id.et_name);
        age = findViewById(R.id.et_age);
        location = findViewById(R.id.et_location);
        phone = findViewById(R.id.et_phone);
        email = findViewById(R.id.et_email);
        username = findViewById(R.id.et_userUsername);
        pwd = findViewById(R.id.et_userPassword);
        male = findViewById(R.id.rb_male);
        female = findViewById(R.id.rb_female);
        bldA = findViewById(R.id.rb_A);
        bldB = findViewById(R.id.rb_B);
        bldAB = findViewById(R.id.rb_AB);
        bldO = findViewById(R.id.rb_O);
        donor = findViewById(R.id.cb_reqDonor);
        confirm = findViewById(R.id.btn_confirm);

        reference = FirebaseDatabase.getInstance().getReference().child("Member");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                    id = (snapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UserEditProfile.this, "Registration Failed", Toast.LENGTH_LONG).show();
            }
        });

        showAllUser();

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                private void writeNewPost(String id, String username, String title, String body) {
//                    // Create new post at /user-posts/$userid/$postid and at
//                    // /posts/$postid simultaneously
//                    String key = mDatabase.child("posts").push().getKey();
//                    Post post = new Post(uid, username, title, body);
//                    Map<String, Object> postValues = post.toMap();
//
//                    Map<String, Object> childUpdates = new HashMap<>();
//                    childUpdates.put("/posts/" + key, postValues);
//                    childUpdates.put("/user-posts/" + userId + "/" + key, postValues);
//
//                    mDatabase.updateChildren(childUpdates);
//                }
//
//
            }
        });
    }


        private void showAllUser(){

            Intent intent = getIntent();
            String user_name = intent.getStringExtra("name");
            String user_age = intent.getStringExtra("age");
            String user_location = intent.getStringExtra("location");
            String user_phone = intent.getStringExtra("phone");
            String user_email = intent.getStringExtra("email");
            String user_username = intent.getStringExtra("username");

            if (male.isChecked()) {
                member.setGender(m);
            } else {
                member.setGender(f);
            }

            if (bloodA.isChecked()) {
                member.setBloodtype(a);
            } else if (bloodB.isChecked()) {
                member.setBloodtype(b);
            } else if (bloodAB.isChecked()) {
                member.setBloodtype(ab);
            } else {
                member.setBloodtype(o);
            }
//        String user_gender = intent.getStringExtra("gender");
//        String user_bloodtype = intent.getStringExtra("bloodtype");

            name.setText(user_name);
            age.setText(user_age);
            location.setText(user_location);
            phone.setText(user_phone);
            email.setText(user_email);
            username.setText(user_username);
//        gender.setText(user_gender);
//        bloodtype.setText(user_bloodtype);
        }
}