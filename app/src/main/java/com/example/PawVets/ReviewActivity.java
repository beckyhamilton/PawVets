package com.example.PawVets;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ReviewActivity extends AppCompatActivity {

    TextView username;
    RatingBar ratingBar;
    EditText desc;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        username = (TextView) findViewById(R.id.username);
        ratingBar = (RatingBar) findViewById(R.id.rating_bar);
        desc = (EditText) findViewById(R.id.description_review);
        submit = (Button) findViewById(R.id.btn_submit);

        //Init Firebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_reviews = database.getReference("Reviews");

        TextView t1;
        t1 = findViewById(R.id.username);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String username = preferences.getString("name", "");

        t1.setText(username);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  String s = String.valueOf(ratingBar.getRating());

                //Get number of stars from rating bar
                int numberOfStars = ratingBar.getNumStars();



                table_reviews.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
}