package com.example.ncba_project_program;

import android.app.AlertDialog;
import android.graphics.Outline;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

public class AcademicProgramOfferingsSubFragment extends Fragment {
    private LinearLayout graduateProgram, collegiateProgram, associateProgram;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.academic_program_offerings_submenu_subfragment, container, false);
        AddElement(view);
        AddInteraction();
        return view;
    }

    private void AddElement(View view) {
        graduateProgram = view.findViewById(R.id.GraduateProgram);
        graduateProgram.setClipToOutline(true);
        graduateProgram.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
            int radius = 28;
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), radius);
            }
        });

        collegiateProgram = view.findViewById(R.id.CollegiateProgram);
        collegiateProgram.setClipToOutline(true);
        collegiateProgram.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                int radius = 28;
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), radius);
            }
        });

        associateProgram = view.findViewById(R.id.AssociateProgram);
        associateProgram.setClipToOutline(true);
        associateProgram.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                int radius = 28;
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), radius);
            }
        });
    }
    private void AddInteraction() {
        graduateProgram.setOnClickListener(e -> {
            if (getActivity() == null) return; // ✅ Prevents null context issues

            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            LayoutInflater inflater = LayoutInflater.from(getContext()); // ✅ Ensures correct layout inflater
            View dialogCollegeProgramView = inflater.inflate(R.layout.academic_program_offerings_dialog_graduate_program_submenu, null);
            builder.setView(dialogCollegeProgramView);

            AlertDialog dialogCollegeProgram = builder.create();

            if (dialogCollegeProgram.getWindow() != null) {
                dialogCollegeProgram.getWindow().setBackgroundDrawableResource(R.drawable.rounded_dialog); // ✅ Apply Rounded Corners
                dialogCollegeProgram.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; // (Optional) Animation
            }

            LinearLayout closeButton = dialogCollegeProgramView.findViewById(R.id.CloseButton);
            closeButton.setOnClickListener(v -> {
                dialogCollegeProgram.dismiss();
            });

            // ✅ Prevent dismissing when clicking outside
            dialogCollegeProgram.setCancelable(false);
            dialogCollegeProgram.setCanceledOnTouchOutside(false);

            // ✅ Handle Back Button Press
            dialogCollegeProgram.setOnKeyListener((dialog, keyCode, event) -> {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
                    dialogCollegeProgram.dismiss(); // Isasara ang dialog
                    return true; // Iwasan ang default back button behavior
                }
                return false;
            });

            dialogCollegeProgram.show();
        });

        collegiateProgram.setOnClickListener(e -> {
            if (getActivity() == null) return; // ✅ Prevents null context issues

            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            LayoutInflater inflater = LayoutInflater.from(getContext()); // ✅ Ensures correct layout inflater
            View dialogCollegiateProgramView = inflater.inflate(R.layout.academic_program_offerings_dialog_collegiate_program_submenu, null);
            builder.setView(dialogCollegiateProgramView);

            AlertDialog dialogCollegiateProgramViewProgram = builder.create();

            if (dialogCollegiateProgramViewProgram.getWindow() != null) {
                dialogCollegiateProgramViewProgram.getWindow().setBackgroundDrawableResource(R.drawable.rounded_dialog); // ✅ Apply Rounded Corners
                dialogCollegiateProgramViewProgram.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; // (Optional) Animation
            }

            LinearLayout closeButton = dialogCollegiateProgramView.findViewById(R.id.CloseButton);
            closeButton.setOnClickListener(v -> {
                dialogCollegiateProgramViewProgram.dismiss();
            });

            // ✅ Prevent dismissing when clicking outside
            dialogCollegiateProgramViewProgram.setCancelable(false);
            dialogCollegiateProgramViewProgram.setCanceledOnTouchOutside(false);

            // ✅ Handle Back Button Press
            dialogCollegiateProgramViewProgram.setOnKeyListener((dialog, keyCode, event) -> {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
                    dialogCollegiateProgramViewProgram.dismiss(); // Isasara ang dialog
                    return true; // Iwasan ang default back button behavior
                }
                return false;
            });

            dialogCollegiateProgramViewProgram.show();
        });

        associateProgram.setOnClickListener(e -> {
            if (getActivity() == null) return; // ✅ Prevents null context issues

            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            LayoutInflater inflater = LayoutInflater.from(getContext()); // ✅ Ensures correct layout inflater
            View dialogAssociateProgramView = inflater.inflate(R.layout.academic_program_offerings_dialog_associate_program_submenu, null);
            builder.setView(dialogAssociateProgramView);

            AlertDialog dialogAssociateProgramViewProgram = builder.create();

            if (dialogAssociateProgramViewProgram.getWindow() != null) {
                dialogAssociateProgramViewProgram.getWindow().setBackgroundDrawableResource(R.drawable.rounded_dialog); // ✅ Apply Rounded Corners
                dialogAssociateProgramViewProgram.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; // (Optional) Animation
            }

            LinearLayout closeButton = dialogAssociateProgramView.findViewById(R.id.CloseButton);
            closeButton.setOnClickListener(v -> {
                dialogAssociateProgramViewProgram.dismiss();
            });

            // ✅ Prevent dismissing when clicking outside
            dialogAssociateProgramViewProgram.setCancelable(false);
            dialogAssociateProgramViewProgram.setCanceledOnTouchOutside(false);

            // ✅ Handle Back Button Press
            dialogAssociateProgramViewProgram.setOnKeyListener((dialog, keyCode, event) -> {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
                    dialogAssociateProgramViewProgram.dismiss(); // Isasara ang dialog
                    return true; // Iwasan ang default back button behavior
                }
                return false;
            });

            dialogAssociateProgramViewProgram.show();
        });

    }
}
