package com.example.ncba_project_program;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

public class MainFragment extends Fragment {
    private LinearLayout admission, academics, aboutUs, contactUs, webMaster, entertainment;

    private ViewPager2 viewPager2;
    private EventPagerAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main_fragment, container, false);
        AddElement(view);
        AddInteraction();
        return view;
    }

    private void AddElement(View view) {
        // ================= BUTTONS (LINEAR LAYOUT) =================
        admission = view.findViewById(R.id.AdmissionMain);
        academics = view.findViewById(R.id.AcademicsMain);
        aboutUs = view.findViewById(R.id.AboutUsMain);
        contactUs = view.findViewById(R.id.ContactUsMain);
        webMaster = view.findViewById(R.id.WebMasterMain);
        entertainment = view.findViewById(R.id.EntertainmentMain);


        viewPager2 = view.findViewById(R.id.viewPager);
        adapter = new EventPagerAdapter(requireActivity());
        viewPager2.setAdapter(adapter);
    }

    private Fragment admissionFragment, academicFragment, aboutUsFragment, contactUsFragment;
    private void AddInteraction() {
        // 1. ADMISSION FRAGMENT
        admission.setOnClickListener(e -> {
            if (admissionFragment == null) {
                admissionFragment = new AdmissionFragment();
            }

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(
                            R.anim.slide_in_left_to_right,  // Enter animation (Left to Right)
                            R.anim.slide_out_left_to_right, // Exit animation (Left to Right)
                            R.anim.slide_in_right_to_left,  // Pop enter (Backstack)
                            R.anim.slide_out_right_to_left  // Pop exit (Backstack)
                    )
                    .replace(R.id.Main_Fragment_Container, admissionFragment)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
        });

        // 2. ACADEMIC FRAGMENT
        academics.setOnClickListener(e -> {
            if (academicFragment == null) {
                academicFragment = new AcademicFragment();
            }

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(
                            R.anim.slide_in_left_to_right,  // Enter animation (Left to Right)
                            R.anim.slide_out_left_to_right, // Exit animation (Left to Right)
                            R.anim.slide_in_right_to_left,  // Pop enter (Backstack)
                            R.anim.slide_out_right_to_left  // Pop exit (Backstack)
                    )
                    .replace(R.id.Main_Fragment_Container, academicFragment)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
        });

        // 3. ABOUT US
        aboutUs.setOnClickListener(e -> {
            if (aboutUsFragment == null) {
                aboutUsFragment = new AboutUsFragment();
            }

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(
                            R.anim.slide_in_left_to_right,  // Enter animation (Left to Right)
                            R.anim.slide_out_left_to_right, // Exit animation (Left to Right)
                            R.anim.slide_in_right_to_left,  // Pop enter (Backstack)
                            R.anim.slide_out_right_to_left  // Pop exit (Backstack)
                    )
                    .replace(R.id.Main_Fragment_Container, aboutUsFragment)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
        });

        // 4. CONTACT US
        contactUs.setOnClickListener(e -> {
            if (contactUsFragment == null) {
                contactUsFragment = new ContactUsFragment();
            }

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(
                            R.anim.slide_in_left_to_right,  // Enter animation (Left to Right)
                            R.anim.slide_out_left_to_right, // Exit animation (Left to Right)
                            R.anim.slide_in_right_to_left,  // Pop enter (Backstack)
                            R.anim.slide_out_right_to_left  // Pop exit (Backstack)
                    )
                    .replace(R.id.Main_Fragment_Container, contactUsFragment)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
        });

        entertainment.setOnClickListener(e -> {
            Intent intent = new Intent(getActivity(), MainSnakeGame.class);
            startActivity(intent);
        });
    }
}