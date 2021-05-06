package com.example.PawVets;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.PawVets.Model.Model;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ContactUs extends AppCompatActivity {

    RecyclerView mRecyclerView;

    private static final int REQUEST_CALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }


    private ArrayList<Model> getMyList() {

        ArrayList<Model> models = new ArrayList<>();

        Model m = new Model();
        m.setTitle("+1-555-521-5554");
        m.setDescription("Click here to give us a call");
        m.setImg(R.drawable.phoneus);
        models.add(m);

        m = new Model();
        m.setTitle("pawvets1@gmail.com");
        m.setDescription("Click here to send us an email");
        m.setImg(R.drawable.email);
        models.add(m);

        m = new Model();
        m.setTitle("Paw Vets");
        m.setDescription("Follow us on Facebook");
        m.setImg(R.drawable.facebook);
        models.add(m);

        m = new Model();
        m.setTitle("@pawvets");
        m.setDescription("Follow us on Twitter");
        m.setImg(R.drawable.twitter);
        models.add(m);

        m = new Model();
        m.setTitle("@pawvets");
        m.setDescription("Follow us on Instagram");
        m.setImg(R.drawable.instagram);
        models.add(m);

        m = new Model();
        m.setTitle("Write us a review");
        m.setDescription("We would love to hear your feedback");
        m.setImg(R.drawable.review);
        models.add(m);


                //Setting on click listener for call button
                //  callBtn.setOnClickListener(new View.OnClickListener() {
                //     @Override
                //   public void onClick(View v) {
                //       CallButton();
                //      }
                //   });


                //   private void CallButton() {
                //     String number = callText.getText().toString();
                //   if(number.trim().length() > 0) {
                //     if(ContextCompat.checkSelfPermission(ContactUs.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)//   {
                //     ActivityCompat.requestPermissions(ContactUs.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
                //    }
                //  else {
                //    String dial = "tel:" + number;
                //  startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
                //            }
                //  }

                //  }

                //  public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
                //    if(requestCode == REQUEST_CALL) {
                //      if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //        CallButton();
                //  }
                //   else {
                //     Toast.makeText(this, "Permission Denied",Toast.LENGTH_SHORT).show();
                //   }
                //   }
                //  }

                return models;

            }
        }

