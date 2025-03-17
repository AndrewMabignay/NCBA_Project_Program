package com.example.ncba_project_program;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

public class AcademicFragment extends Fragment {
    private LinearLayout academicProgram, graduateProgram, collegiateProgram, programOfferings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.academic_main_fragment, container, false);
        AddElement(view);
        AddInteraction();
        return view;
    }

    private void AddElement(View view) {
        graduateProgram = view.findViewById(R.id.GraduateProgram);
        collegiateProgram = view.findViewById(R.id.CollegiateProgram);
    }

    Fragment graduateFragment, collegiateFragment;

    private void AddInteraction() {
        graduateProgram.setOnClickListener(e -> {
            if (graduateFragment == null) {
                graduateFragment = new AcademicGraduateSubFragment();
            }

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(
                            R.anim.slide_in_left_to_right,  // Enter animation (Left to Right)
                            R.anim.slide_out_left_to_right, // Exit animation (Left to Right)
                            R.anim.slide_in_right_to_left,  // Pop enter (Backstack)
                            R.anim.slide_out_right_to_left  // Pop exit (Backstack)
                    )
                    .replace(R.id.Main_Fragment_Container, graduateFragment)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
        });

        collegiateProgram.setOnClickListener(e -> {
            if (collegiateFragment == null) {
                collegiateFragment = new AcademicCollegiateSubFragment();
            }

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(
                            R.anim.slide_in_left_to_right,  // Enter animation (Left to Right)
                            R.anim.slide_out_left_to_right, // Exit animation (Left to Right)
                            R.anim.slide_in_right_to_left,  // Pop enter (Backstack)
                            R.anim.slide_out_right_to_left  // Pop exit (Backstack)
                    )
                    .replace(R.id.Main_Fragment_Container, collegiateFragment)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
        });
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
