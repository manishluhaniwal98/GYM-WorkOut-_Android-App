package com.app.fitnessandnutrition;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    String email;
    String password;
    ProgressBar pbLoading;

    FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        Button btnLogin = findViewById(R.id.btnLogin);
        TextView tvSignUp = findViewById(R.id.tv_sign_up);
        pbLoading = findViewById(R.id.pbLoadingLogin);

        btnLogin.setOnClickListener(v -> {
            getUserCredentials();
            loginUser();
        });

        tvSignUp.setOnClickListener(v -> {
            startActivity(new Intent(this, RegisterActivity.class));
            finish();
        });
    }

    private void getUserCredentials() {
        EditText etEmail = findViewById(R.id.etEmail);
        EditText etPassword = findViewById(R.id.etPassword);

        email = etEmail.getText().toString().trim();
        password = etPassword.getText().toString().trim();
    }

    private void loginUser() {

        if(validateUserCredentials()) {
            pbLoading.setVisibility(View.VISIBLE);
            Toast.makeText(this, "Logging in..", Toast.LENGTH_SHORT).show();

            auth.signInWithEmailAndPassword(email, password)
                    .addOnSuccessListener(authResult -> {
                        pbLoading.setVisibility(View.GONE);
                        startActivity(new Intent(this, HomeActivity.class));
                        finish();
                    })
                    .addOnFailureListener(e -> {
                        Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                        pbLoading.setVisibility(View.GONE);
                    });
        }
    }

    private Boolean validateUserCredentials() {

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Enter a valid email address", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(password.length() < 6) {
            Toast.makeText(this, "Invalid password", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}