package com.example.u_sic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

public class songPlaying extends AppCompatActivity {
    TextView textView;
    ImageView play, previous, next, pause;

    ArrayList<File> songs;
    String textContent;
    MediaPlayer mediaPlayer;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_playing);

        textView = findViewById(R.id.textView);
        play = findViewById(R.id.play);
        previous = findViewById(R.id.previous);
        next = findViewById(R.id.next);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        songs = (ArrayList)bundle.getParcelableArrayList("songList");
        textContent = intent.getStringExtra("currentSong");
        textView.setText(textContent);
        position = intent.getIntExtra("position", 0);

        Uri uri = Uri.parse(songs.get(position).toString());

        mediaPlayer = MediaPlayer.create(this, uri);
        mediaPlayer.start();

    }
}