package com.csy6.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {
    int score = 0;
    static int FAKE_BARRIER = 20;
    static int WIN_BARRIER = 30;
    TextView tvScores;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        name = getIntent().getStringExtra("key_name");
        String hello = getString(R.string.hello);
        ((TextView) findViewById(R.id.tv_hello)).setText(hello + name);
        tvScores = findViewById(R.id.tv_scores);
    }

    public void addScore(View v) {
        score++;
        if (score >= WIN_BARRIER) {
            Toast.makeText(this, "you win!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, WinActivity.class);
            intent.putExtra("key_name", name);
            intent.putExtra("socres", score);
            startActivity(intent);

        } else if (score <= FAKE_BARRIER) {
            tvScores.setText("" + score);
        } else if (score == FAKE_BARRIER + 1) {
            Toast.makeText(this, "game over", Toast.LENGTH_SHORT).show();
        }

    }
}