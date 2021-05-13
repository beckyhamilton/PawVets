package com.example.PawVets;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.PawVets.Model.Model;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ContactUs extends AppCompatActivity {

    ImageView phoneus;
    ImageView facebook;

    private static final int REQUEST_CALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        phoneus = findViewById(R.id.phoneus);
        facebook = findViewById(R.id.facebook);

        //Setting on click listener for call button
           phoneus.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   String s = "tel:" + "+1-555-521-5554";
                   Intent intent = new Intent(Intent.ACTION_CALL);
                   intent.setData(Uri.parse(s));
                   startActivity(intent);
               }
            });

        //Setting on click listener for facebook button
            facebook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goToFacebookPage("101342458807544");
                }
            });


          }

          private void goToFacebookPage(String id) {
            try {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/" +  id));
                startActivity(intent);
            }
            catch(ActivityNotFoundException e) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("www.facebook.com/" +  id));
                startActivity(intent);
              }
          }
    }








