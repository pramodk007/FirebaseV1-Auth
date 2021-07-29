package com.androiddev.firebasev1_auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    Button signUp;
    Button signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        signIn = findViewById(R.id.button_start_signIn);
        signUp = findViewById(R.id.button_start_signUp);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singUp();
            }
        });
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
    }

    private void signIn() {
        startActivity(new Intent(StartActivity.this,SignInActivity.class));
        finish();
    }

    private void singUp() {
        startActivity(new Intent(StartActivity.this,SignUpActivity.class));
        finish();//closes the app you can't go the the startScreen
    }
}