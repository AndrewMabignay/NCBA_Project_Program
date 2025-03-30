package com.example.ncba_project_program;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

public class AcademicAcademicSubFragment extends Fragment {
    private ImageView academicImages;
    private int[] academicImageList = {
            R.drawable.computer_lab_one, R.drawable.computer_lab_two,
            R.drawable.library_lab_one, R.drawable.gym_second_image,
            R.drawable.computer_lab_three, R.drawable.library_two,
            R.drawable.pusa_ni_river, R.drawable.redhorse
    };
    private int currentIndex = 0;
    private Handler handler;
    private Runnable runnable;
    private float x1, x2;
    private static final int MIN_DISTANCE = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.academic_academic_program_submenu_subfragment, container, false);
        handler = new Handler();

        AddElement(view);
        AddInteraction();

        return view;
    }

    private void AddElement(View view) {
        academicImages = view.findViewById(R.id.AcademicPictures);
        academicImages.setClickable(true);
        academicImages.setFocusable(true);

        academicImages.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x1 = event.getX();
                        return false;
                    case MotionEvent.ACTION_UP:
                        x2 = event.getX();
                        float deltaX = x2 - x1;

                        if (Math.abs(deltaX) > MIN_DISTANCE) {
                            if (deltaX > 0) {
                                showPreviousImage();
                            } else {
                                showNextImage();
                            }
                            return true;
                        }
                }
                return false;
            }
        });

        academicImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImageDialog();
            }
        });
    }

    private void showImageDialog() {
        if (getContext() == null || getActivity() == null) return;

        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(getContext());
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.about_us_brief_history_image_dialog_submenu, null);
        builder.setView(dialogView);

        ImageView dialogImageView = dialogView.findViewById(R.id.dialogImageView);
        if (dialogImageView != null) {
            dialogImageView.setImageResource(academicImageList[currentIndex]);
        }

        AlertDialog dialog = builder.create();

        dialog.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(android.graphics.Color.TRANSPARENT));

        // Enable dismissal when clicking outside
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
    }

    private void AddInteraction() {
        startImageTransition();
    }

    private void startImageTransition() {
        runnable = new Runnable() {
            @Override
            public void run() {
                Animation slideOut = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.slide_out);
                academicImages.startAnimation(slideOut);

                slideOut.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {}

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        currentIndex = (currentIndex + 1) % academicImageList.length;
                        academicImages.setImageResource(academicImageList[currentIndex]);

                        Animation slideIn = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.slide_in);
                        academicImages.startAnimation(slideIn);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {}
                });
                handler.postDelayed(this, 5000);
            }
        };
        handler.post(runnable);
    }

    private void showNextImage() {
        currentIndex = (currentIndex + 1) % academicImageList.length;
        academicImages.setImageResource(academicImageList[currentIndex]);
        Animation slideIn = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.slide_in);
        academicImages.startAnimation(slideIn);
    }

    private void showPreviousImage() {
        currentIndex = (currentIndex - 1 + academicImageList.length) % academicImageList.length;
        academicImages.setImageResource(academicImageList[currentIndex]);
        Animation slideIn = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.slide_in);
        academicImages.startAnimation(slideIn);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (handler != null && runnable != null) {
            handler.removeCallbacks(runnable);
        }
    }
}
