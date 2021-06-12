package com.example.bloodbank;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AdminViewRequestList extends AppCompatActivity {


    private TextView names, ages,genders,emails,phones,locations,bloodGroups,reasons;
    private DatabaseReference reff;
    private Button btnphone,btnemail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_request_list);
        btnphone=findViewById(R.id.btn_phone);
        btnemail=findViewById(R.id.btn_email);
        names=(TextView)findViewById(R.id.user_name);
        ages=(TextView)findViewById(R.id.user_age);
        genders=(TextView)findViewById(R.id.user_gender);
        emails=(TextView)findViewById(R.id.user_email);
        phones=(TextView)findViewById(R.id.user_phone);
        locations=(TextView)findViewById(R.id.user_location);
        bloodGroups=(TextView)findViewById(R.id.user_blood_group);
        reasons=(TextView)findViewById(R.id.user_reason);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");


        Log.d("Debuggggg",id.toString());
        reff=FirebaseDatabase.getInstance().getReference().child("Request").child(id.toString());
        reff.get().addOnSuccessListener(new OnSuccessListener<DataSnapshot>() {
            @Override
            public void onSuccess(DataSnapshot dataSnapshot) {
                if (dataSnapshot!=null){
                    if (dataSnapshot.exists()) {
                        Request request = dataSnapshot.getValue(Request.class);
                        names.setText(request.getName());
                        ages.setText(request.getAge().toString());
                        genders.setText(request.getGender());
                        emails.setText(request.getEmail());
                        phones.setText(request.getPhone());
                        locations.setText(request.getLocation());
                        bloodGroups.setText(request.getBloodGroup());
                        reasons.setText(request.getReason());

                        btnphone.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String number = ""+ request.getPhone();
                                Intent intentphone = new Intent(Intent.ACTION_DIAL);
                                intentphone.setData(Uri.parse("tel:"+number));
                                startActivity(intentphone);
                            }
                        });

                        btnemail.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intentAdminEmail = new Intent(AdminViewRequestList.this, AdminEmail.class);
                                startActivity(intentAdminEmail);
                            }
                        });


                    }
                }
            }
        });

//        btnphone.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String mobileNo =
//                Intent intentcall = new Intent(Intent.ACTION_DIAL);
//                intent.setData(Uri.parse(mobileNo));
//                startActivity(intentcall);
//            }
//        });


    }
}