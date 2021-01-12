package com.example.PawVets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BookingSuccess extends AppCompatActivity {

    //Adding variables
    Button backtohome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_success2);

        //Hooks
        backtohome = findViewById(R.id.homebutton);

        //If user clicks on home button, user is redirected to the home screen
        backtohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(BookingSuccess.this, Home.class);
                startActivity(home);
            }
    });
    }
}
