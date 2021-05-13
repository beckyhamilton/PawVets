package com.example.PawVets;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.PawVets.Model.AdminUser;
import com.example.PawVets.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;

public class AddStaffAccount extends AppCompatActivity {

    EditText staffid;
    EditText staffname;
    EditText staffpassword;
    Button addstaff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_staff_account);

        staffid = findViewById(R.id.staffid);
        staffname = findViewById(R.id.staffname);
        staffpassword = findViewById(R.id.staffpassword);
        addstaff = (Button) findViewById(R.id.addstaff_btn);

        //Init Firebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_admin = database.getReference("Admin");

        addstaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog mDialog = new ProgressDialog(AddStaffAccount.this);
                mDialog.setMessage("Please wait..");
                mDialog.show();

                table_admin.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.child(staffid.getText().toString()).exists()) {
                            Transaction.abort();
                            Toast.makeText(AddStaffAccount.this, "User ID already exists", Toast.LENGTH_SHORT).show();
                        }
                        AdminUser adminUser = new AdminUser(staffname.getText().toString(), staffpassword.getText().toString());
                        table_admin.child(staffid.getText().toString()).setValue(adminUser);
                        Toast.makeText(AddStaffAccount.this, "Staff account created", Toast.LENGTH_SHORT).show();
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
