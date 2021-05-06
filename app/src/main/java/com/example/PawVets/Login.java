package com.example.PawVets;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

public class Login extends AppCompatActivity {

    //Creating variables
    EditText editUN, editPW;
    Button SignIn, staffLogin;
    SharedPreferences sharedPreferences;
    static final String mypreference = "mypref";
    static final String Username = "usernameKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Setting variables
        editPW = (MaterialEditText) findViewById(R.id.editPW);
        editUN = (MaterialEditText) findViewById(R.id.editUN);
        SignIn = (Button) findViewById(R.id.SignIn);
        staffLogin = (Button) findViewById(R.id.staff_login);



        //Init Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");



        //Creating on click listener for Sign In button
        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                

                final ProgressDialog mDialog = new ProgressDialog(Login.this);
                mDialog.setMessage("Please wait...");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        //Check if user exists in database
                        if (snapshot.child(editUN.getText().toString()).exists()) {

                            //Get user information
                            mDialog.dismiss();
                            User user = snapshot.child(editUN.getText().toString()).getValue(User.class);
                            if (user.getPassword().equals(editPW.getText().toString())) {
                                Intent loginsucess = new Intent(Login.this, Home.class);
                                startActivity(loginsucess);
                                Toast.makeText(Login.this, "Sign in Successful", Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            mDialog.dismiss();
                            Toast.makeText(Login.this, "Sign in failed", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {


                    }
                });
            }
        });

        staffLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent stafflogin = new Intent(Login.this, AdminLogin.class);
                startActivity(stafflogin);

            }
        });


            }

    public void save(View v) {

    }
        }

