package com.example.PawVets;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ContactUs extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;
    private TextView callText;
    private Button callBtn;
    private TextView emailText;
    private Button emailBtn;
    private Button btn_livechat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        //Defining variables
        callText = findViewById(R.id.callText);
        callBtn = findViewById(R.id.callBtn);
        btn_livechat = findViewById(R.id.btn_livechat);

        //Setting on click listener for call button
        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallButton();
            }
        });


        btn_livechat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent livechat = new Intent(ContactUs.this, LiveChat.class);
                startActivity(livechat);

            }
        });
    }

        private void CallButton() {
            String number = callText.getText().toString();
            if(number.trim().length() > 0) {
                if(ContextCompat.checkSelfPermission(ContactUs.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                {
                    ActivityCompat.requestPermissions(ContactUs.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
                }
                else {
                    String dial = "tel:" + number;
                    startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
                }
        }

    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_CALL) {
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                CallButton();
            }
            else {
                Toast.makeText(this, "Permission Denied",Toast.LENGTH_SHORT).show();
            }
        }
    }


}