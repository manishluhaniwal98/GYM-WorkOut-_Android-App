package com.app.fitnessandnutrition;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import static com.app.fitnessandnutrition.Utilities.USERS_COLLECTION_REF;

public class RegisterActivity extends AppCompatActivity {

    String name;
    String height;
    String weight;
    String gender;
    String email;
    String password;
    String confirmPassword;
    ProgressBar pbLoading;

    private final FirebaseAuth auth = FirebaseAuth.getInstance();
    private final FirebaseFirestore db = FirebaseFirestore.getInstance();
    private final CollectionReference usersRef = db.collection(USERS_COLLECTION_REF);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().hide();

        Button btnSignUp = findViewById(R.id.btnSignUp);
        TextView tvLogin = findViewById(R.id.tv_log_in);
        pbLoading = findViewById(R.id.pbLoadingRegister);

        btnSignUp.setOnClickListener(v -> {
            getUserCredentials();
            registerUser();
        });

        tvLogin.setOnClickListener(v -> {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });

    }

    private void getUserCredentials() {

        EditText etName = findViewById(R.id.etName);
        EditText etHeight = findViewById(R.id.etHeight);
        EditText etWeight = findViewById(R.id.etWeight);
        EditText etEmail = findViewById(R.id.etEmail);
        EditText etPassword = findViewById(R.id.etPassword);
        EditText etConfirmPassword = findViewById(R.id.etConfirmPassword);
        Spinner spGender = findViewById(R.id.spGender);

        name = etName.getText().toString().trim();
        height = etHeight.getText().toString().trim();
        weight = etWeight.getText().toString().trim();
        gender = spGender.getSelectedItem().toString();
        email = etEmail.getText().toString().trim();
        password = etPassword.getText().toString().trim();
        confirmPassword = etConfirmPassword.getText().toString().trim();

    }

    private void registerUser() {

        if(validateUserCredentials()) {
            pbLoading.setVisibility(View.VISIBLE);
            Toast.makeText(this, "Signing Up..", Toast.LENGTH_SHORT).show();

            auth.createUserWithEmailAndPassword(email, password)
                    .addOnSuccessListener(authResult -> {
                        saveUserProfileData();
                        startActivity(new Intent(this, HomeActivity.class));
                        finish();
                    })
                    .addOnFailureListener(e -> {
                        Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        pbLoading.setVisibility(View.GONE);
                    });
        }
    }

    private void saveUserProfileData() {

        usersRef.add(new User(name, height, weight, gender, email))
                .addOnSuccessListener(authResult -> {
                    pbLoading.setVisibility(View.GONE);
                    Toast.makeText(this, "Sign up successful", Toast.LENGTH_SHORT).show();
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    pbLoading.setVisibility(View.GONE);
                });
    }

    private Boolean validateUserCredentials() {
        if(name.isEmpty() || height.isEmpty() || weight.isEmpty() || email.isEmpty() ||
                password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "All fields must be filled out", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(!name.matches("^[a-zA-Z\\s]*$")) {
            Toast.makeText(this, "Enter a valid name", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(!(Integer.parseInt(height) > 50 && Integer.parseInt(height) < 300)) {
            Toast.makeText(this, "Enter a valid height", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(!(Integer.parseInt(weight) > 20 && Integer.parseInt(height) < 300)) {
            Toast.makeText(this, "Enter a valid weight", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Enter a valid email address", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(password.length() < 6) {
            Toast.makeText(this, "Password should have at least 6 characters ", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(!password.equals(confirmPassword)) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            return  false;
        }

        return true;
    }
}