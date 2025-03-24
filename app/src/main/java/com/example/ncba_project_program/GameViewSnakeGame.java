package com.example.ncba_project_program;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameViewSnakeGame extends SurfaceView implements Runnable {
    private Thread gameThread;
    private boolean isRunning;
    private SurfaceHolder holder;
    private Paint paint;

    public GameViewSnakeGame(Context context, SurfaceView surfaceView) {
        super(context);
        this.holder = surfaceView.getHolder();
        paint = new Paint();
    }

    @Override
    public void run() {
        while (isRunning) {
            if (!holder.getSurface().isValid()) continue;

            Canvas canvas = holder.lockCanvas();
            if (canvas != null) {
                canvas.drawColor(Color.BLACK);

                paint.setColor(Color.BLUE);
                paint.setTextSize(50);
                canvas.drawText("Hello Snake Game!", 100, 200, paint);

                holder.unlockCanvasAndPost(canvas);
            }
        }
    }

    public void startGame() {
        isRunning = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void pause() {
        isRunning = false;
        try {
            if (gameThread != null) {
                gameThread.join();  // Hintayin matapos ang thread bago mag-exit
                gameThread = null;  // Reset thread para puwedeng mag-resume
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void resume() {
        if (gameThread == null) {
            isRunning = true;
            gameThread = new Thread(this);
            gameThread.start();
        }
    }
}
