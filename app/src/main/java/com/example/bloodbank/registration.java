package com.example.bloodbank;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.regex.Pattern;


public class registration extends AppCompatActivity {

    TextView tvRegistration;
    ProgressBar progressBar;
    EditText name, age, location, phone, email, username, password;
    RadioGroup gender, bloodType;
    RadioButton male, female, bloodA, bloodB, bloodAB, bloodO;
    Button btnRegister;

    private FirebaseAuth mAuth;

    DatabaseReference reference;
    long id=0;
    Member member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        setTitle("User Registration");

        tvRegistration = findViewById(R.id.tv_registration);
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

        mAuth = FirebaseAuth.getInstance();


        reference = FirebaseDatabase.getInstance().getReference().child("Member");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                    id = (snapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(registration.this, "Registration Failed", Toast.LENGTH_LONG).show();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {

                String nama = name.getText().toString().trim();
                String umur = age.getText().toString().trim();
                String lokasi = location.getText().toString().trim();
                String telefon = phone.getText().toString().trim();
                String emel = email.getText().toString().trim();
                String uname = username.getText().toString().trim();
                String pass = password.getText().toString().trim();

                String m = male.getText().toString();
                String f = female.getText().toString();

                String a = bloodA.getText().toString();
                String b = bloodB.getText().toString();
                String ab = bloodAB.getText().toString();
                String o = bloodO.getText().toString();






                if (nama.isEmpty()) {
                    name.setError("Name is Required");
                    name.requestFocus();
                    return;
                }

                if (umur.isEmpty()) {
                    age.setError("Age is Required");
                    age.requestFocus();
                    return;
                }

                if(gender.getCheckedRadioButtonId() <= 0){
                    female.setError("Gender is Required");
                    return;
                }

                if (lokasi.isEmpty()) {
                    location.setError("Location is Required");
                    location.requestFocus();
                    return;
                }

                if (telefon.isEmpty()) {
                    phone.setError("Phone Number is Required");
                    phone.requestFocus();
                    return;
                }

                if (emel.isEmpty()) {
                    email.setError("Email is Required");
                    email.requestFocus();
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(emel).matches()) {
                    email.setError("Please provide valid email");
                    email.requestFocus();
                    return;
                }

                if (uname.isEmpty()) {
                    username.setError("Username is Required");
                    username.requestFocus();
                    return;
                }

                if (pass.isEmpty()) {
                    password.setError("Password is Required");
                    password.requestFocus();
                    return;
                }

                if (pass.length() < 6) {
                    password.setError("Min Pass is 6 characters!");
                    password.requestFocus();
                    return;
                }

                if(bloodType.getCheckedRadioButtonId() <= 0){
                    bloodO.setError("Blood Type is Required");
                    return;
                }










                //register the user in firebase
                mAuth.createUserWithEmailAndPassword(emel, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                            //set data into realtime database
                            Member member = new Member(nama, umur, lokasi, telefon, emel, uname);

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


                            reference.child(String.valueOf(id+1)).setValue(member);
//                            reference.child("Member").child(userId).setValue(member);

                            Toast.makeText(registration.this, "User Created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),userLogin.class));

                        }else{
                            Toast.makeText(registration.this, "Error! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });
    }
}