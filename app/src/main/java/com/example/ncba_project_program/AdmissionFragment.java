package com.example.ncba_project_program;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

public class AdmissionFragment extends Fragment {
    LinearLayout scholarshipDiscount, credentials;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.admission_main_fragment, container, false);
        AddElement(view);
        AddInteraction();
        return view;
    }

    private void AddElement(View view) {
        scholarshipDiscount = view.findViewById(R.id.ScholarshipDiscount);
        credentials = view.findViewById(R.id.Credentials);
    }

    private Fragment admissionScholarshipDiscount, admissionCredentials;
    private void AddInteraction() {
        scholarshipDiscount.setOnClickListener(e -> {
            if (admissionScholarshipDiscount == null) {
                admissionScholarshipDiscount = new AdmissionScholarshipDiscountSubFragment();
            }

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(
                            R.anim.slide_in_left_to_right,  // Enter animation (Left to Right)
                            R.anim.slide_out_left_to_right, // Exit animation (Left to Right)
                            R.anim.slide_in_right_to_left,  // Pop enter (Backstack)
                            R.anim.slide_out_right_to_left  // Pop exit (Backstack)
                    )
                    .replace(R.id.Main_Fragment_Container, admissionScholarshipDiscount)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
        });

        credentials.setOnClickListener(e -> {
            if (admissionCredentials == null) {
                admissionCredentials = new AdmissionScholarshipDiscountSubFragment();
            }

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(
                            R.anim.slide_in_left_to_right,  // Enter animation (Left to Right)
                            R.anim.slide_out_left_to_right, // Exit animation (Left to Right)
                            R.anim.slide_in_right_to_left,  // Pop enter (Backstack)
                            R.anim.slide_out_right_to_left  // Pop exit (Backstack)
                    )
                    .replace(R.id.Main_Fragment_Container, admissionCredentials)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
        });
    }
}
