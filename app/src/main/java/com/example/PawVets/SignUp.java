package com.example.PawVets;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.PawVets.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;


public class SignUp extends AppCompatActivity {

    MaterialEditText editPhone, editName, editPassword;
    Button SignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        editName = (MaterialEditText)findViewById(R.id.editName);
        editPassword = (MaterialEditText)findViewById(R.id.editPassword);
        editPhone = (MaterialEditText)findViewById(R.id.editPhone);

        SignUp = (Button)findViewById(R.id.SignUpbtn);

        //Init Firebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)  {
                final ProgressDialog mDialog = new ProgressDialog(SignUp.this);
                mDialog.setMessage("Please wait..");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        //Check if user already registered
                        if(snapshot.child(editPhone.getText().toString()).exists())
                        {
                           mDialog.dismiss();
                            Toast.makeText(SignUp.this, "Phone number already registered", Toast.LENGTH_SHORT).show();
                        }
                        mDialog.dismiss();
                        User user = new User(editName.getText().toString(),editPassword.getText().toString());
                        table_user.child(editPhone.getText().toString()).setValue(user);
                        Toast.makeText(SignUp.this, "Sign Up Successful", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });


    }
}




