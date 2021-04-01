package com.example.u_sic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class adapter extends ArrayAdapter<String> {

    private String[] arr;
    public adapter(@NonNull Context context, int resource, @NonNull String[] arr) {
        super(context, resource, arr);

        this.arr = arr;
    }

    @Nullable
    @Override
    public String getItem(int position) {
        return arr[position];
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_play_song, parent, false);
        convertView.findViewById(R.id.musicsymbol);
        TextView textViewmusic = convertView.findViewById(R.id.textViewmusic);
        textViewmusic.setText(getItem(position));
        return convertView;
    }
}
