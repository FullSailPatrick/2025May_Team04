package com.example.quickphrase;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 🔁 THIS MUST point to the main menu layout
        setContentView(R.layout.activity_main_menu);
    }
}
