package com.example.PawVets;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.PawVets.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class AdminLogin extends AppCompatActivity {

    //Creating variables
    EditText editID, editPassword;
    Button signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        //Setting variables
        editID = (MaterialEditText)findViewById(R.id.editadminID);
        editPassword = (MaterialEditText)findViewById(R.id.editpw);
        signIn = (Button) findViewById(R.id.signin);

        //Init Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_admin = database.getReference("Admin");

        //Creating on click listener for Sign In button
        signIn.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View view) {

                final ProgressDialog mDialog = new ProgressDialog(AdminLogin.this);
                mDialog.setMessage("Please wait...");
                mDialog.show();

                table_admin.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        //Check if user exists in database
                        if(snapshot.child(editID.getText().toString()).exists()) {

                            //Get user information
                            mDialog.dismiss();
                            User admin = snapshot.child(editID.getText().toString()).getValue(User.class);
                            if (admin.getPassword().equals(editPassword.getText().toString()))
                            {
                                Intent loginsucess = new Intent(AdminLogin.this, AdminHome.class);
                                startActivity(loginsucess);
                                Toast.makeText(AdminLogin.this,"Sign in Successful", Toast.LENGTH_SHORT).show();
                            }

                        }
                        else
                        {
                            mDialog.dismiss();
                            Toast.makeText(AdminLogin.this, "Sign in failed", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {



                    }
                });
            }
        });
    }
}