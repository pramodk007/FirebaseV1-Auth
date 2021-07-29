package com.androiddev.firebasev1_auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity {

    private Button btn_singIn;
    private EditText edt_emailAddress;
    private EditText edt_password;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        btn_singIn = findViewById(R.id.btn_signUp);
        edt_emailAddress = findViewById(R.id.edtText_EmailAddress);
        edt_password = findViewById(R.id.edtText_Password);
        auth = FirebaseAuth.getInstance();

        btn_singIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userSignIn(edt_emailAddress.getText().toString(),edt_password.getText().toString());
            }
        });

    }

    private void userSignIn(String email, String password) {
        auth.signInWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                    Toast.makeText(SignInActivity.this, "SingIn successfully!!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignInActivity.this,HomeActivity.class));
                    finish();
            }
        });
    }
}