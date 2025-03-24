package com.example.ncba_project_program;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.fragment.app.Fragment;

public class AboutUsBriefHistorySubFragment extends Fragment {
    private ImageView imageView;
    private int[] images = {
            R.drawable.doroteo,
            R.drawable.diangco,
            R.drawable.gloria,
            R.drawable.sarabia,
            R.drawable.torres
    };
    private int currentIndex = 0;
    private Handler handler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.about_us_brief_history_submenu_subfragment, container, false);
        handler = new Handler();
        AddElement(view);
        return view;
    }

    private void AddElement(View view) {
        imageView = view.findViewById(R.id.ImagingSwitcher);
        setRoundedImage();

        handler.postDelayed(this::startImageTransition, 1500);

        // Hover effect (Opacity + Scale)
        imageView.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    imageView.setAlpha(0.7f);
                    imageView.setScaleX(1.1f);
                    imageView.setScaleY(1.1f);
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    imageView.setAlpha(1f);
                    imageView.setScaleX(1f);
                    imageView.setScaleY(1f);
                    break;
            }
            return false;
        });

        // Click event para sa Image Dialog
        imageView.setOnClickListener(v -> showImageDialog());
    }

    private void startImageTransition() {
        AlphaAnimation fadeOut = new AlphaAnimation(1.0f, 0.0f);
        fadeOut.setDuration(500);
        fadeOut.setFillAfter(true);
        imageView.startAnimation(fadeOut);

        handler.postDelayed(() -> {
            currentIndex = (currentIndex + 1) % images.length;
            setRoundedImage();

            AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
            fadeIn.setDuration(500);
            fadeIn.setFillAfter(true);
            imageView.startAnimation(fadeIn);

            handler.postDelayed(this::startImageTransition, 3000);
        }, 500);
    }

    private void setRoundedImage() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), images[currentIndex]);
        RoundedBitmapDrawable roundedDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        roundedDrawable.setCornerRadius(30f);
        roundedDrawable.setAntiAlias(true);

        imageView.setBackgroundResource(R.drawable.rounded_shadow);
        imageView.setImageDrawable(roundedDrawable);
    }

    private void showImageDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.about_us_brief_history_image_dialog_submenu, null);
        builder.setView(dialogView);

        ImageView dialogImageView = dialogView.findViewById(R.id.dialogImageView);
        dialogImageView.setImageResource(images[currentIndex]);

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
