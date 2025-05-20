package com.example.quickphrase;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button createAccountButton = findViewById(R.id.createAccountButton);
        Button loginButton = findViewById(R.id.loginButton);

        createAccountButton.setOnClickListener(v ->
                Toast.makeText(this, "Create Account Clicked", Toast.LENGTH_SHORT).show()
        );

        loginButton.setOnClickListener(v ->
                Toast.makeText(this, "Log In Clicked", Toast.LENGTH_SHORT).show()
        );
    }
}
