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
import android.widget.Toast;

import com.example.PawVets.Model.Review;
import com.example.PawVets.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ReviewActivity extends AppCompatActivity {

    EditText username;
    RatingBar ratingBar;
    EditText description;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        username = (EditText) findViewById(R.id.username);
        ratingBar = (RatingBar) findViewById(R.id.rating_bar);
        description = (EditText) findViewById(R.id.description_review);
        submit = (Button) findViewById(R.id.btn_submit);

        //Init Firebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_reviews = database.getReference("Reviews");

        final TextView t1;
        t1 = findViewById(R.id.username);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        final String username = preferences.getString("name", "");

        t1.setText(username);

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Review review = new Review((int) ratingBar.getRating(),description.getText().toString());
                table_reviews.child(t1.getText().toString()).setValue(review);
                review.setDescription(description.getText().toString());
                Toast.makeText(ReviewActivity.this, "Thank you for your review!", Toast.LENGTH_SHORT).show();
                finish();
            }
                    });
    }
}

