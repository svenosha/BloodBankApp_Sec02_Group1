package com.example.bloodbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class userLogin extends AppCompatActivity {

    private TextView registerText;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        registerText = findViewById(R.id.tv_newuser);
        btnLogin = findViewById(R.id.btn_login);

        registerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegister();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUserHomepage();
            }
        });
    }
    public void openRegister(){
        Intent intentRegister = new Intent(this, registration.class);
        startActivity(intentRegister);
    }

    public void openUserHomepage(){
        Intent intentUserHomepage = new Intent(this, UserHomepage.class);
        startActivity(intentUserHomepage);
    }
}