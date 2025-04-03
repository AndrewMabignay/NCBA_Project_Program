package com.example.ncba_project_program;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

public class AboutUsFragment extends Fragment {
    private LinearLayout theInstitution, briefHistory, missionVision, ncbaHymn, recognitions, career, facilities;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.about_us_main_fragment, container, false);
        AddElement(view);
        AddInteraction();
        return view;
    }

    private void AddElement(View view) {
        theInstitution = view.findViewById(R.id.TheInstitution);
        briefHistory = view.findViewById(R.id.BriefHistory);
        missionVision = view.findViewById(R.id.VisionMissionCoreValues);
        ncbaHymn = view.findViewById(R.id.NCBAHymn);
        recognitions = view.findViewById(R.id.Recognition);
        career = view.findViewById(R.id.Career);
        facilities = view.findViewById(R.id.Facilities);
    }

    private Fragment theInstitutionFragment, briefHistoryFragment, missionAndVisionFragment, ncbaHymnFragment, recognitionsFragment, careersFragment, facilitiesFragment;
    private void AddInteraction() {
        // 1. THE INSTITUTION
        theInstitution.setOnClickListener(e -> {
            if (theInstitutionFragment == null) {
                theInstitutionFragment = new AboutUsTheInstitutionSubFragment();
            }

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(
                            R.anim.slide_in_left_to_right,  // Enter animation (Left to Right)
                            R.anim.slide_out_left_to_right, // Exit animation (Left to Right)
                            R.anim.slide_in_right_to_left,  // Pop enter (Backstack)
                            R.anim.slide_out_right_to_left  // Pop exit (Backstack)
                    )
                    .replace(R.id.Main_Fragment_Container, theInstitutionFragment)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
        });

        // 2. BRIEF HISTORY
        briefHistory.setOnClickListener(e -> {
            if (briefHistoryFragment == null) {
                briefHistoryFragment = new AboutUsBriefHistorySubFragment();
            }

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(
                            R.anim.slide_in_left_to_right,  // Enter animation (Left to Right)
                            R.anim.slide_out_left_to_right, // Exit animation (Left to Right)
                            R.anim.slide_in_right_to_left,  // Pop enter (Backstack)
                            R.anim.slide_out_right_to_left  // Pop exit (Backstack)
                    )
                    .replace(R.id.Main_Fragment_Container, briefHistoryFragment)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
        });

        // 3. VISION, MISSION AND CORE VALUES
        missionVision.setOnClickListener(e -> {
            if (missionAndVisionFragment == null) {
                missionAndVisionFragment = new AboutUsMissionVisionSubFragment();
            }

            TransitionFragmentInteraction(missionAndVisionFragment);
        });

        // 4. NCBA HYMN
        ncbaHymn.setOnClickListener(e -> {
            if (ncbaHymnFragment == null) {
                ncbaHymnFragment = new AboutUsNCBAHymnSubFragment();
            }

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(
                            R.anim.slide_in_left_to_right,  // Enter animation (Left to Right)
                            R.anim.slide_out_left_to_right, // Exit animation (Left to Right)
                            R.anim.slide_in_right_to_left,  // Pop enter (Backstack)
                            R.anim.slide_out_right_to_left  // Pop exit (Backstack)
                    )
                    .replace(R.id.Main_Fragment_Container, ncbaHymnFragment)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
        });


        // 5. RECOGNITION
        recognitions.setOnClickListener(e -> {
            if (recognitionsFragment == null) {
                recognitionsFragment = new AboutUsRecognitionsSubFragment();
            }

            TransitionFragmentInteraction(recognitionsFragment);
        });

        // 6. CAREERS
        career.setOnClickListener(e -> {
            if (careersFragment == null) {
                careersFragment = new AboutUsCareersSubFragment();
            }

            TransitionFragmentInteraction(careersFragment);
        });

        // 7. FACILITIES
        facilities.setOnClickListener(e -> {
            if (facilitiesFragment == null) {
                facilitiesFragment = new AboutUsFacilitiesSubFragment();
            }

            TransitionFragmentInteraction(facilitiesFragment);
        });
    }

    private void TransitionFragmentInteraction(Fragment fragment) {
        requireActivity().getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(
                        R.anim.slide_in_left_to_right,  // Enter animation (Left to Right)
                        R.anim.slide_out_left_to_right, // Exit animation (Left to Right)
                        R.anim.slide_in_right_to_left,  // Pop enter (Backstack)
                        R.anim.slide_out_right_to_left  // Pop exit (Backstack)
                )
                .replace(R.id.Main_Fragment_Container, fragment)
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .commit();
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
