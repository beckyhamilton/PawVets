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

public class Login extends AppCompatActivity {

    //Creating variables
    EditText editPhone, editPassword;
    Button SignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Setting variables
        editPassword = (MaterialEditText)findViewById(R.id.editPassword);
        editPhone = (MaterialEditText)findViewById(R.id.editPhone);
        SignIn = (Button) findViewById(R.id.SignIn);

        //Init Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        //Creating on click listener for Sign In button
        SignIn.setOnClickListener(new View.OnClickListener()  {
            @Override
                    public void onClick(View view) {

                final ProgressDialog mDialog = new ProgressDialog(Login.this);
                mDialog.setMessage("Please wait...");
                mDialog.show();

            table_user.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                //Check if user exists in database
                    if(snapshot.child(editPhone.getText().toString()).exists()) {

                //Get user information
                    mDialog.dismiss();
                    User user = snapshot.child(editPhone.getText().toString()).getValue(User.class);
                    if (user.getPassword().equals(editPassword.getText().toString()))
                    {
                        Intent loginsucess = new Intent(Login.this, Home.class);
                        startActivity(loginsucess);
                        Toast.makeText(Login.this,"Sign in Successful", Toast.LENGTH_SHORT).show();
                    }

                    }
                    else
                    {
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
}
}
