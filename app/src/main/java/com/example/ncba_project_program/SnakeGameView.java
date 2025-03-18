package com.example.ncba_project_program;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class SnakeGameView extends SurfaceView implements Runnable {
    private Thread thread;
    private boolean isPlaying;
    private SurfaceHolder holder;
    private Paint paint;

    public SnakeGameView(Context context) {
        super(context);
        holder = getHolder();
        paint = new Paint();
    }

    @Override
    public void run() {
        while (isPlaying) {
            if (holder.getSurface().isValid()) {
                Canvas canvas = holder.lockCanvas();
                canvas.drawColor(Color.BLACK); // Background ng game
                holder.unlockCanvasAndPost(canvas);
            }
        }
    }

    public void resume() {
        isPlaying = true;
        thread = new Thread(this);
        thread.start();
    }

    public void pause() {
        isPlaying = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
