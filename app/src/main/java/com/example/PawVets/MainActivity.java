package com.example.PawVets;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import info.hoang8f.widget.FButton;

public class MainActivity extends AppCompatActivity {

    //Adding Variables for Animation
    Animation topAnim, bottomAnim;
    ImageView image;
    FButton SignUp;
    FButton SignIn;
    Button btnSignIn, btnSignUp;
    TextView name;

    //Changing Layout to Full Screen
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Defining Animation
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);


        //Hooks
        image = findViewById(R.id.background);
        SignUp = findViewById(R.id.SignUpbtn);
        SignIn = findViewById(R.id.SignIn);
        name = findViewById(R.id.name);

        //Setting Animation
        image.setAnimation(topAnim);
        SignUp.setAnimation(bottomAnim);
        SignIn.setAnimation(bottomAnim);
        name.setAnimation(topAnim);

        btnSignIn = (Button) findViewById(R.id.SignIn);
        btnSignUp = (Button) findViewById(R.id.SignUpbtn);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signIn = new Intent(MainActivity.this, Login.class);
                startActivity(signIn);

            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUp = new Intent(MainActivity.this, SignUp.class);
                startActivity(signUp);


            }
        });

    }
}