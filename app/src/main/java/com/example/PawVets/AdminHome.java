package com.example.PawVets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminHome extends AppCompatActivity {

    Button addVet;
    Button reviewList;
    Button addStaff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminhome);

        reviewList = findViewById(R.id.reviewList);
        addVet = findViewById(R.id.addvet);
        addStaff = findViewById(R.id.staffaccount);

        reviewList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reviews = new Intent(AdminHome.this, AdminReviews.class);
                startActivity(reviews);
            }
        });

        addStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent staff = new Intent(AdminHome.this, AddStaffAccount.class);
                startActivity(staff);
            }
        });


        }
    }
