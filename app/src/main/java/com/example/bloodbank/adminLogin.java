package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class adminLogin extends AppCompatActivity {

    EditText username, password;
    TextView textView;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        username = findViewById(R.id.et_adminUsername);
        password = findViewById(R.id.et_adminPassword);
        textView = findViewById(R.id.tv_admin);
        btnLogin = findViewById(R.id.btn_login);



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String adminusername = username.getText().toString().trim();
                String pass = password.getText().toString().trim();

                if(adminusername.isEmpty()){
                    username.setError("Username is Required");
                    username.requestFocus();
                    return;
                }

                if (pass.isEmpty()) {
                    password.setError("Password is Required");
                    password.requestFocus();
                    return;
                }

                if(adminusername.equals("Admin") && pass.equals("admin123")){
                    openAdminHomepage();
                } else {
                    Toast.makeText(adminLogin.this, "Error Login! ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void openAdminHomepage(){
        Intent intentAdminHomepage = new Intent(this, AdminHomepage.class);
        startActivity(intentAdminHomepage);
    }
}