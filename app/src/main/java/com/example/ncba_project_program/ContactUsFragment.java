package com.example.ncba_project_program;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

public class ContactUsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contactus_main_fragment, container, false);
        AddElement(view);
        AddInteraction();
        return view;
    }

    private void AddElement(View view) {

    }

    private void AddInteraction() {

    }
}

/*
* package com.example.ncba_project_program;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

public class AcademicFragment extends Fragment {
    private ImageView academicImages;
    private int[] academicImageList = {R.drawable.avr_first_image, R.drawable.gym_second_image};
    private int currentIndex = 0;
    private Handler handler = new Handler();
    private Runnable runnable;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.academic_main_fragment, container, false);
        AddElement(view);
        AddInteraction();
        return view;
    }

    private void AddElement(View view) {
        academicImages = view.findViewById(R.id.AcademicPictures);
    }

    private void AddInteraction() {
        startImageTransition();
    }

    private void startImageTransition() {
        runnable = new Runnable() {
            @Override
            public void run() {
                // Slide out animation (current image)
                Animation slideOut = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.slide_out);
                academicImages.startAnimation(slideOut);

                // Palitan ang image pagkatapos ng animation
                slideOut.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {}

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        // Change to the next image
                        currentIndex = (currentIndex + 1) % academicImageList.length;
                        academicImages.setImageResource(academicImageList[currentIndex]);

                        // Apply slide-in animation for the new image
                        Animation slideIn = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.slide_in);
                        academicImages.startAnimation(slideIn);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {}
                });

                // Loop every 3 seconds
                handler.postDelayed(this, 3000);
            }
        };
        handler.post(runnable);
    }
}

* */
