package com.example.ncba_project_program;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainSnakeGame extends AppCompatActivity {
    private SnakeGameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameView = new SnakeGameView(this);
        setContentView(gameView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        gameView.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        gameView.pause();
    }
}
