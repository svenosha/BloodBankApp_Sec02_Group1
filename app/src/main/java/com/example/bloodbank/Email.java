package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Email extends AppCompatActivity {

    private EditText subject,message;
    private Button Email;
    private TextView to;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle bundle =getIntent().getExtras();
        String mail =bundle.getString("mail");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        to = findViewById(R.id.ed_to);
        to.setText(mail);
        subject = findViewById(R.id.ed_subject);
        message = findViewById(R.id.ed_message);
        Email = findViewById(R.id.btn_send);

        Email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!to.getText().toString().isEmpty() &&!subject.getText().toString().isEmpty() && !message.getText().toString().isEmpty()){

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{to.getText().toString()});
                email.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
                email.putExtra(Intent.EXTRA_TEXT, message.getText().toString());

                    email.setType("message/rfc822");
                    if(email.resolveActivity(getPackageManager()) != null){
                        startActivity(email);
                    }
                    else{
                        Toast.makeText(Email.this, "There is no application that supports this action",Toast.LENGTH_SHORT).show();
                    }

                }
                else{
                    Toast.makeText(Email.this, "Please Fill All the Field",Toast.LENGTH_SHORT).show();
                }



            }


        });

    }
}