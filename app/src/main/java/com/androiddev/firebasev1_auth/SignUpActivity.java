package com.androiddev.firebasev1_auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    private Button signUp;
    private EditText email;
    private EditText password;

    //auth reference
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //initialize
        signUp = findViewById(R.id.button_signUp);
        email = findViewById(R.id.editText_EmailAddress);
        password = findViewById(R.id.editText_Password);
        auth = FirebaseAuth.getInstance();


        //regestration
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userSignUp(email.getText().toString(),password.getText().toString());
            }
        });
    }
    private void userSignUp(String email,String password) {
        if(TextUtils.isEmpty(email) && TextUtils.isEmpty(password)){
            Toast.makeText(SignUpActivity.this, "Please enter your email and password", Toast.LENGTH_SHORT).show();
        }else if(password.length() < 6){
            Toast.makeText(SignUpActivity.this, "password should be more than 6 characters", Toast.LENGTH_SHORT).show();
        }else
        registerUser(email,password);
    }

    private void registerUser(String email, String password) {
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(SignUpActivity.this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(SignUpActivity.this, "signUp successful!!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignUpActivity.this,HomeActivity.class));
                    finish();
                }else{
                    Toast.makeText(SignUpActivity.this, "signUp failed...", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}