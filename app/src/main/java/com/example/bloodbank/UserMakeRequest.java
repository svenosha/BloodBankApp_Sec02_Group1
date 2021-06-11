package com.example.bloodbank;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Locale;

public class UserMakeRequest extends AppCompatActivity implements LocationListener {
    private EditText name,age,gender,email,phone,locations,bloodGroup,reason;
    private Button submit;
    private DatabaseReference reff;
    private Request request;
    private long maxid=0;
    private RadioGroup genders, bloodType;
    private RadioButton male, female, bloodA, bloodB, bloodAB, bloodO;
    private ImageView gps;
    private LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_request);
        name=(EditText)findViewById(R.id.user_name);
        gender=(EditText)findViewById(R.id.user_gender);
        age=(EditText)findViewById(R.id.user_age);
        email=(EditText)findViewById(R.id.user_email);
        phone=(EditText)findViewById(R.id.user_phone);
        locations=(EditText)findViewById(R.id.user_location);
        bloodGroup=(EditText)findViewById(R.id.user_blood_group);
        reason=(EditText)findViewById(R.id.user_reason);
        gps = findViewById(R.id.locateSearch);
        genders = findViewById(R.id.rggender);
        bloodType = findViewById(R.id.rgblood);
        male = findViewById(R.id.rbmale);
        female = findViewById(R.id.rbfemale);
        bloodA = findViewById(R.id.rbA);
        bloodB = findViewById(R.id.rbB);
        bloodAB = findViewById(R.id.rbAB);
        bloodO = findViewById(R.id.rbO);
        submit=findViewById(R.id.btn_submit);
        request = new Request();
        reff= FirebaseDatabase.getInstance().getReference().child("Request");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                    maxid=(dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String m = male.getText().toString().trim();
                String f = female.getText().toString().trim();

                String a = bloodA.getText().toString().trim();
                String b = bloodB.getText().toString().trim();
                String ab = bloodAB.getText().toString().trim();
                String o = bloodO.getText().toString().trim();

                int agea=Integer.parseInt(age.getText().toString().trim());
                request.setName(name.getText().toString().trim());
//                request.setGender(gender.getText().toString().trim());
                request.setEmail(email.getText().toString().trim());
                request.setLocation(locations.getText().toString().trim());
//
                request.setReason(reason.getText().toString().trim());
                request.setAge(agea);
                request.setPhone(phone.getText().toString().trim());

                if (male.isChecked()) {
                    request.setGender(m);
                } else {
                    request.setGender(f);
                }

                if (bloodA.isChecked()) {
                    request.setBloodGroup(a);
                } else if (bloodB.isChecked()) {
                    request.setBloodGroup(b);
                } else if (bloodAB.isChecked()) {
                    request.setBloodGroup(ab);
                } else {
                    request.setBloodGroup(o);
                }


                reff.child(String.valueOf(maxid+1)).setValue(request);
                Toast.makeText(UserMakeRequest.this,"submit successfully",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),UserHomepage.class));


            }
        });





    //create sensor location
        if (ContextCompat.checkSelfPermission(UserMakeRequest.this, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED){
        ActivityCompat.requestPermissions(UserMakeRequest.this,new String[]{
                Manifest.permission.ACCESS_FINE_LOCATION
        }, 100);
    }


        gps.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getLocation();
        }
    });
}

    @SuppressLint("MissingPermission")
    private void getLocation() {
        try {
            locationManager = (LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,5000,5, UserMakeRequest.this);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    @Override
    public void onLocationChanged(@NonNull Location location) {
        Toast.makeText(this,""+location.getLatitude()+","+location.getLongitude(), Toast.LENGTH_SHORT).show();
        try {
            Geocoder geocoder=new Geocoder(UserMakeRequest.this, Locale.getDefault());
            List<Address> adsresses = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
            String address = adsresses.get(0).getAddressLine(0);

            locations.setText(address);


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {

    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {

    }

}