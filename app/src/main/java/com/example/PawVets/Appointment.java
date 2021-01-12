package com.example.PawVets;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.PawVets.Model.Appt;
import com.example.PawVets.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jaredrummler.materialspinner.MaterialSpinner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Appointment extends AppCompatActivity {
    TextView tvDate;
    EditText etDate;
    DatePickerDialog.OnDateSetListener setListener;
    EditText etTime;
    int tHour, tMinute;
    MaterialSpinner vetName;
    EditText petName, selectDate, selectTime;
    Button bookapt;

    String[] vets = {"Select a vet", "Adam", "Amy", "Hannah", "John", "Matthew", "Rebecca"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        tvDate = findViewById(R.id.select_date);
        etDate = findViewById(R.id.select_time);
        vetName = findViewById(R.id.select_vet);
        petName = findViewById(R.id.pet_name);
        selectDate = findViewById(R.id.select_date);
        selectTime = findViewById(R.id.select_time);
        bookapt = findViewById(R.id.BookAppt);


        final Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        //Init Firebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_appt = database.getReference("Appointment");

        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        Appointment.this, android.R.style.Theme_Holo_Light_Dialog_NoActionBar_MinWidth, setListener, year, month, day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();

            }
        });
        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String date = day + "/" + month + "/" + year;
                tvDate.setText(date);
            }
        };

        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        Appointment.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month + 1;
                        String date = day + "/" + month + "/" + year;
                        etDate.setText(date);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        //Assign variable
        etTime = findViewById(R.id.select_time);
        etTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Initialise time picker dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        Appointment.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                //Initialise hour and minute
                                tHour = hourOfDay;
                                tMinute = minute;
                                //Store hour and minute in string
                                String time = tHour + ":" + tMinute;
                                //Initialise 24 hours time format
                                SimpleDateFormat f24Hours = new SimpleDateFormat(
                                        "HH:mm"
                                );
                                try {
                                    Date date = f24Hours.parse(time);
                                    //Initialise 12 hours time format
                                    SimpleDateFormat f12Hours = new SimpleDateFormat(
                                            "hh:mm aa"
                                    );
                                    //Set selected on text view
                                    etTime.setText(f12Hours.format(date));
                                } catch (ParseException e) {
                                    e.printStackTrace();

                                }
                            }
                        }, 12, 0, false
                );
                //Set transparent background
                timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                //Displayed previous selected time
                timePickerDialog.updateTime(tHour, tMinute);
                //Show dialog
                timePickerDialog.show();
            }
        });

        //Adding drop down options for spinner
        final MaterialSpinner vetName = findViewById(R.id.select_vet);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.vets, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vetName.setAdapter(adapter);


    //When user clicks book appointment button, firebase is updated
      bookapt.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View view) {

               table_appt.addValueEventListener(new ValueEventListener() {
                    @Override
                   public void onDataChange(@NonNull DataSnapshot snapshot) {

                        Appt appt = new Appt(vetName.getText().toString(),petName.getText().toString(),selectDate.getText().toString(),selectTime.getText().toString());
                        table_appt.child(petName.getText().toString()).setValue(appt);
                        Toast.makeText(Appointment.this, "Booking Successful", Toast.LENGTH_SHORT).show();
                        finish();
                        Intent bookingsuccess = new Intent(Appointment.this,BookingSuccess.class);
                        startActivity(bookingsuccess);
                    }

                 @Override
                 public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
            }
        });
    }
}