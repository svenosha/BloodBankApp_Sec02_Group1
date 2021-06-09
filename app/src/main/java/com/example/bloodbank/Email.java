package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Email extends AppCompatActivity {

    private EditText to,subject,message;
    private Button Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        to = findViewById(R.id.ed_to);
        subject = findViewById(R.id.ed_subject);
        message = findViewById(R.id.ed_message);
        Email = findViewById(R.id.btn_send);

        Email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String sendto=to.getText().toString();
                String Esubject=subject.getText().toString();
                String Emessage=message.getText().toString();


                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, "jenteoh98@gmail.com");
                email.putExtra(Intent.EXTRA_SUBJECT, Esubject);
                email.putExtra(Intent.EXTRA_TEXT, Emessage);

                //need this to prompts email client only
                email.setType("Emessage/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }
        });



    }
}