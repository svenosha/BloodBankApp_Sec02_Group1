package com.example.bloodbank;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminEmail extends AppCompatActivity {

    EditText to, subject, message;
    Button send;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_email);

        to = findViewById(R.id.et_to);
        subject = findViewById(R.id.et_subject);
        message = findViewById(R.id.et_message);
        send = findViewById(R.id.btn_sendEmail);


                        send.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + to.getText().toString()));
                                intent.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
                                intent.putExtra(Intent.EXTRA_TEXT, message.getText().toString());
                                startActivity(intent);
                            }
                        });
                    }


                }


