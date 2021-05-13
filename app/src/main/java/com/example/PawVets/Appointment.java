package com.example.PawVets;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
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
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import com.example.PawVets.Model.Appt;
import com.example.PawVets.Model.Booking;
import com.example.PawVets.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.shuhart.stepview.StepView;

import org.w3c.dom.Text;

import java.sql.Array;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Appointment extends AppCompatActivity {

    private TextView waitTime;
    private ArrayList<TextView> times;
    private Button date, time, book;
    private MaterialSpinner serviceSpinner;
    private ArrayList<Booking> bookings;

    private static DatabaseReference databaseBookings = FirebaseDatabase.getInstance().getReference("Bookings");
    private static DatabaseReference databaseServices = FirebaseDatabase.getInstance().getReference("Services");

    private DatePicker aptDate;
    private TimePicker aptTime;

    private Date currentDate = new Date(System.currentTimeMillis());
    private Date savedDate;
    private boolean pickedTime;

  //  String[] services = {"Select Appointment Type", "Vet Consultation", "First Vaccination", "Health Check", "Other"};


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);


        //Adding drop down options for spinner
        final MaterialSpinner spinner = findViewById(R.id.selectservice_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.services, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
     //   serviceSpinner.setAdapter(adapter);

        }
            }





                ///Set up selecting pet to book appointment for
                /// Create list for reason for appointment
                /// set current date into textview - use when viewing appointment

