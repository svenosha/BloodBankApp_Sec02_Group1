package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EmailDonor extends AppCompatActivity {
    private TextView to;
    private EditText subject;
    private EditText message;
    private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle bundle =getIntent().getExtras();
        String mail =bundle.getString("mail");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_donor);

        TextView to =(TextView) findViewById(R.id.ed_to);
        to.setText(mail);
        subject = findViewById(R.id.ed_subject);
        message = findViewById(R.id.ed_messg);
        send = findViewById(R.id.btn_send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!to.getText().toString().isEmpty()&& !subject.getText().toString().isEmpty() && !message.getText().toString().isEmpty()){
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{to.getText().toString()});
                    intent.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
                    intent.putExtra(Intent.EXTRA_TEXT, message.getText().toString());
                    intent.setType("message/rfc822");
                    if(intent.resolveActivity(getPackageManager()) != null){
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(EmailDonor.this, "There is no application that supports this action",Toast.LENGTH_SHORT).show();
                    }

                }
                else{
                    Toast.makeText(EmailDonor.this, "Please Fill All the Field",Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

}