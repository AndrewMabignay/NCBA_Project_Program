package com.example.ncba_project_program;

import android.app.Activity;
import android.os.Bundle;
import android.view.SurfaceView;

public class MainSnakeGame extends Activity {
    private GameViewSnakeGame gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entertainment_snake_game);

        // Hanapin ang SurfaceView sa XML
        SurfaceView surfaceView = findViewById(R.id.gameSurface);

        // Gamitin ang SurfaceView sa GameView
        gameView = new GameViewSnakeGame(this, surfaceView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        gameView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        gameView.resume();
    }
}

