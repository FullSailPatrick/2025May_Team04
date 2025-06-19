package com.example.quickphrase; // change if your package name is different

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class CreateAccountActivity extends AppCompatActivity {

    EditText etFullName, etEmail, etPassword;
    Button btnCreateAccount;
    TextView tvLoginRedirect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account); // make sure XML file name matches

        // Link UI components
        etFullName = findViewById(R.id.etFullName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnCreateAccount = findViewById(R.id.btnCreateAccount);
        tvLoginRedirect = findViewById(R.id.tvLoginRedirect);

        // Create account button click
        btnCreateAccount.setOnClickListener(v -> {
            String name = etFullName.getText().toString();
            String email = etEmail.getText().toString();
            String password = etPassword.getText().toString();

            // You can add validation here later
            Toast.makeText(this, "Account created for: " + name, Toast.LENGTH_SHORT).show();

            // Redirect to login
            startActivity(new Intent(this, LoginActivity.class));
        });

        // Redirect to login
        tvLoginRedirect.setOnClickListener(v -> {
            startActivity(new Intent(this, LoginActivity.class));
        });
    }
}
