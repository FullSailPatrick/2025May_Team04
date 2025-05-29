package com.example.quickphrase;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FavoritesActivity extends AppCompatActivity {

    private FavoritesAdapter adapter;
    private ArrayList<String> allPhrases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        // Back/home icon setup
        ImageView homeIcon = findViewById(R.id.homeIcon);
        homeIcon.setOnClickListener(v -> finish()); // Goes back to MainActivity

        // ListView setup
        ListView favoriteList = findViewById(R.id.favoriteList);
        EditText searchBar = findViewById(R.id.searchBar);

        // Initial favorite phrases (could later be loaded from SharedPreferences or a database)
        allPhrases = new ArrayList<>();
        allPhrases.add("Emergencies");
        allPhrases.add("Food");
        allPhrases.add("Directions");
        allPhrases.add("Greetings");

        // Set up adapter
        adapter = new FavoritesAdapter(this, allPhrases);
        favoriteList.setAdapter(adapter);

        // Search bar filtering
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Not needed
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Not needed
            }
        });
    }
}
