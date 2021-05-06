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
import com.shuhart.stepview.StepView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Appointment extends AppCompatActivity {

    @BindView(R.id.step_view)
    StepView stepView;
 //   @BindView(R.id.view_pager)
    ViewPager viewPager;
  //  @BindView(R.id.btn_previous_step)
    Button btn_previous_step;
  //  @BindView(R.id.btn_next_step)
    Button btn_next_step;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);
        ButterKnife.bind(Appointment.this);

        setupStepView();
        setColorButton();

    }

    public void setupStepView() {
        List<String> stepList = new ArrayList<>();
        stepList.add("Vet");
        stepList.add("Time");
        stepList.add("Confirm");
        stepView.setSteps(stepList);
    }

    public void setColorButton() {
        if(btn_next_step.isEnabled())
        {
            btn_next_step.setBackgroundResource(R.color.SignInBtn);
        }
        else
        {
           btn_next_step.setBackgroundResource(R.color.dark_grey);
        }

        if(btn_previous_step.isEnabled())
        {
            btn_previous_step.setBackgroundResource(R.color.SignUpBtn);
        }
        else
        {
            btn_previous_step.setBackgroundResource(R.color.dark_grey);
        }
    }



}