package com.example.bloodbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import android.content.Intent;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.Executor;

public class adminLogin extends AppCompatActivity {

    EditText username, password;
    TextView textView;
    Button btnLogin;
    BiometricPrompt biometricPrompt;
    BiometricPrompt.PromptInfo promptInfo;
    Executor executor;

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

                if (adminusername.isEmpty()) {
                    username.setError("Username is Required");
                    username.requestFocus();
                    return;
                }

                if (pass.isEmpty()) {
                    password.setError("Password is Required");
                    password.requestFocus();
                    return;
                }

                if (adminusername.equals("Admin") && pass.equals("admin123")) {
                    openAdminHomepage();
                } else {
                    Toast.makeText(adminLogin.this, "Error Login! ", Toast.LENGTH_SHORT).show();
                }
            }
        });




        executor = ContextCompat.getMainExecutor(this);

        biometricPrompt = new BiometricPrompt(this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                Toast.makeText(adminLogin.this, "Error", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                startActivity(new Intent(getApplicationContext(), UserHomepage.class));
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                Toast.makeText(adminLogin.this, "Failure", Toast.LENGTH_LONG).show();
            }
        });

        promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Blood Bank Authentication")
                .setNegativeButtonText("Cancel/Use Password")
                .setConfirmationRequired(false)
                .build();
    }

        public void buttonAuthenticate (View v){
            BiometricManager biometricManager = BiometricManager.from(this);
            if (biometricManager.canAuthenticate() != BiometricManager.BIOMETRIC_SUCCESS){
                Toast.makeText(adminLogin.this, "Biometric Not Supported", Toast.LENGTH_LONG).show();
                return;
            }

            biometricPrompt.authenticate(promptInfo);
        }


    public void openAdminHomepage(){
        Intent intentAdminHomepage = new Intent(this, AdminHomepage.class);
        startActivity(intentAdminHomepage);
    }



}
