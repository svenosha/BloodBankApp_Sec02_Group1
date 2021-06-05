package com.example.bloodbank;

import android.os.Bundle;
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


public class registration extends AppCompatActivity {

    EditText name, age, location, phone, email, username, password;
    RadioGroup gender, bloodType;
    RadioButton male, female, bloodA, bloodB, bloodAB, bloodO;
    Button btnRegister;

    DatabaseReference reference;
    int i = 0;
    Member member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        setTitle("User Registration");

        member = new Member();

        name = findViewById(R.id.et_name);
        age = findViewById(R.id.et_age);
        location = findViewById(R.id.et_location);
        phone = findViewById(R.id.et_phone);
        email = findViewById(R.id.et_email);
        username = findViewById(R.id.et_userUsername);
        password = findViewById(R.id.et_userPassword);
        gender = findViewById(R.id.rg_gender);
        bloodType = findViewById(R.id.rg_blood);
        male = findViewById(R.id.rb_male);
        female = findViewById(R.id.rb_female);
        bloodA = findViewById(R.id.rb_A);
        bloodB = findViewById(R.id.rb_B);
        bloodAB = findViewById(R.id.rb_AB);
        bloodO = findViewById(R.id.rb_O);
        btnRegister = findViewById(R.id.btn_register);

        reference = FirebaseDatabase.getInstance().getReference().child("Member");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    i = (int) snapshot.getChildrenCount();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(registration.this, "Database Error", Toast.LENGTH_LONG).show();
            }
        });


        btnRegister.setOnClickListener(v -> {

            member.setName(name.getText().toString().trim());

            int ages = Integer.parseInt(age.getText().toString().trim());
            member.setAge(ages);

            String m = male.getText().toString();
            String f = female.getText().toString();

            if (male.isChecked()) {
                member.setGender(m);
                reference.child(String.valueOf(i + 1)).setValue(member);
            } else {
                member.setGender(f);
                reference.child(String.valueOf(i + 1)).setValue(member);
            }

            member.setLocation(location.getText().toString().trim());

            long phones = Integer.parseInt(phone.getText().toString().trim());
            member.setPhone(phones);

            member.setEmail(email.getText().toString().trim());
            member.setUsername(username.getText().toString().trim());
            member.setPassword(password.getText().toString().trim());

            String a = bloodA.getText().toString();
            String b = bloodB.getText().toString();
            String ab = bloodAB.getText().toString();
            String o = bloodO.getText().toString();

            if (bloodA.isChecked()) {
                member.setBloodtype(a);
                reference.child(String.valueOf(i + 1)).setValue(member);
            }else if(bloodB.isChecked()){
                member.setBloodtype(b);
                reference.child(String.valueOf(i + 1)).setValue(member);
            }else if(bloodAB.isChecked()){
                member.setBloodtype(ab);
                reference.child(String.valueOf(i + 1)).setValue(member);
            }else{
                member.setBloodtype(o);
                reference.child(String.valueOf(i + 1)).setValue(member);
            }

            reference.push().setValue(member);

            Toast.makeText(registration.this, "Data is Inserted", Toast.LENGTH_LONG).show();
        });
    }
}

//    public void openUserHomepage(){
//        Intent intentUserHomepage = new Intent(this, userLogin.class);
//        startActivity(intentUserHomepage);