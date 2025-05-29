package com.example.quickphrase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FavoritesAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> originalPhrases;    // Full list
    private ArrayList<String> filteredPhrases;    // Filtered (search)
    private ArrayList<Boolean> favorites;         // Favorite status

    public FavoritesAdapter(Context context, ArrayList<String> phrases) {
        this.context = context;
        this.originalPhrases = new ArrayList<>(phrases);
        this.filteredPhrases = new ArrayList<>(phrases);

        // Initialize all as favorited (true)
        this.favorites = new ArrayList<>();
        for (int i = 0; i < phrases.size(); i++) {
            favorites.add(true);
        }
    }

    @Override
    public int getCount() {
        return filteredPhrases.size();
    }

    @Override
    public Object getItem(int position) {
        return filteredPhrases.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            row = inflater.inflate(R.layout.item_favorite, parent, false);
        }

        TextView phraseText = row.findViewById(R.id.phraseText);
        ImageView starIcon = row.findViewById(R.id.starIcon);

        String phrase = filteredPhrases.get(position);
        phraseText.setText(phrase);

        int originalIndex = originalPhrases.indexOf(phrase);
        boolean isFav = favorites.get(originalIndex);

        // Set star icon image
        starIcon.setImageResource(isFav ?
                android.R.drawable.btn_star_big_on :
                android.R.drawable.btn_star_big_off);

        // Toggle favorite status on click
        starIcon.setOnClickListener(v -> {
            favorites.set(originalIndex, !isFav);
            notifyDataSetChanged();
        });

        return row;
    }

    public void filter(String query) {
        filteredPhrases.clear();
        if (query.isEmpty()) {
            filteredPhrases.addAll(originalPhrases);
        } else {
            for (String phrase : originalPhrases) {
                if (phrase.toLowerCase().contains(query.toLowerCase())) {
                    filteredPhrases.add(phrase);
                }
            }
        }
        notifyDataSetChanged();
    }
}
