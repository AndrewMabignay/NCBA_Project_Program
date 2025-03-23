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
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class AcademicCollegiateSubFragment extends Fragment {
    private LinearLayout accountancy, businessAd, computerSystem, hospitalityManagement, educ, englishLanguage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.academic_collegiate_program_submenu_subfragment, container, false);
        AddElement(view);
        AddInteraction();
        return view;
    }

    private void AddElement(View view) {
        /* ------------- 1. ACCOUNTANCY ------------- */
        accountancy = view.findViewById(R.id.Accountancy);
        accountancy.setClipToOutline(true);
        accountancy.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                int radius = 28;
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), radius);
            }
        });

        /* ------------- 2. BUSINESS AD ------------- */
        businessAd = view.findViewById(R.id.BusinessAdministration);
        businessAd.setClipToOutline(true);
        businessAd.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                int radius = 28;
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), radius);
            }
        });

        /* ------------- 3. COMPUTER SYSTEM ------------- */
        computerSystem = view.findViewById(R.id.ComputerSystem);
        computerSystem.setClipToOutline(true);
        computerSystem.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                int radius = 28;
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), radius);
            }
        });

        /* ------------- 4. HOSPITALITY MANAGEMENT ------------- */
        hospitalityManagement = view.findViewById(R.id.HospitalityManagement);
        hospitalityManagement.setClipToOutline(true);
        hospitalityManagement.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                int radius = 28;
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), radius);
            }
        });

        /* ------------- 5. EDUCATION ------------- */
        educ = view.findViewById(R.id.TeacherEducation);
        educ.setClipToOutline(true);
        educ.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                int radius = 28;
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), radius);
            }
        });

        /* ------------- 6. ENGLISH LANGUAGE ------------- */
        englishLanguage = view.findViewById(R.id.EnglishLanguage);
        englishLanguage.setClipToOutline(true);
        englishLanguage.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                int radius = 28;
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), radius);
            }
        });


    }
    private void AddInteraction() {
        // 1. ACCOUNTING
        accountancy.setOnClickListener(e -> {
            if (getActivity() == null) return; // ✅ Prevents null context issues

            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            LayoutInflater inflater = LayoutInflater.from(getContext()); // ✅ Ensures correct layout inflater
            View dialogAccountingView = inflater.inflate(R.layout.academic_collegiate_program_dialog_bsa_bsma_submenu, null);
            builder.setView(dialogAccountingView);

            AlertDialog dialogAccounting = builder.create();

            if (dialogAccounting.getWindow() != null) {
                dialogAccounting.getWindow().setBackgroundDrawableResource(R.drawable.rounded_dialog); // ✅ Apply Rounded Corners
                dialogAccounting.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; // (Optional) Animation
            }

            LinearLayout closeButton = dialogAccountingView.findViewById(R.id.CloseButton);
            closeButton.setOnClickListener(v -> {
                dialogAccounting.dismiss();
            });

            // ✅ Prevent dismissing when clicking outside
            dialogAccounting.setCancelable(false);
            dialogAccounting.setCanceledOnTouchOutside(false);

            // ✅ Handle Back Button Press
            dialogAccounting.setOnKeyListener((dialog, keyCode, event) -> {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
                    dialogAccounting.dismiss(); // Isasara ang dialog
                    return true; // Iwasan ang default back button behavior
                }
                return false;
            });

            dialogAccounting.show();
        });

        // 2. BUSINESS AD
        businessAd.setOnClickListener(e -> {
            if (getActivity() == null) return; // ✅ Prevents null context issues

            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            LayoutInflater inflater = LayoutInflater.from(getContext()); // ✅ Ensures correct layout inflater
            View dialogBusinessAdView = inflater.inflate(R.layout.academic_collegiate_program_dialog_bsba_submenu, null);
            builder.setView(dialogBusinessAdView);

            AlertDialog dialogBusinessAd = builder.create();

            if (dialogBusinessAd.getWindow() != null) {
                dialogBusinessAd.getWindow().setBackgroundDrawableResource(R.drawable.rounded_dialog); // ✅ Apply Rounded Corners
                dialogBusinessAd.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; // (Optional) Animation
            }

            LinearLayout closeButton = dialogBusinessAdView.findViewById(R.id.CloseButton);
            closeButton.setOnClickListener(v -> {
                dialogBusinessAd.dismiss();
            });

            // ✅ Prevent dismissing when clicking outside
            dialogBusinessAd.setCancelable(false);
            dialogBusinessAd.setCanceledOnTouchOutside(false);

            // ✅ Handle Back Button Press
            dialogBusinessAd.setOnKeyListener((dialog, keyCode, event) -> {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
                    dialogBusinessAd.dismiss(); // Isasara ang dialog
                    return true; // Iwasan ang default back button behavior
                }
                return false;
            });

            dialogBusinessAd.show();
        });

        // 3. COMPUTER SCIENCE
        computerSystem.setOnClickListener(e -> {
            if (getActivity() == null) return; // ✅ Prevents null context issues

            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            LayoutInflater inflater = LayoutInflater.from(getContext()); // ✅ Ensures correct layout inflater
            View dialogComputerSystemView = inflater.inflate(R.layout.academic_collegiate_program_dialog_bsis_bscs_submenu, null);
            builder.setView(dialogComputerSystemView);

            AlertDialog dialogComputerSystem = builder.create();

            if (dialogComputerSystem.getWindow() != null) {
                dialogComputerSystem.getWindow().setBackgroundDrawableResource(R.drawable.rounded_dialog); // ✅ Apply Rounded Corners
                dialogComputerSystem.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; // (Optional) Animation
            }

            LinearLayout closeButton = dialogComputerSystemView.findViewById(R.id.CloseButton);
            closeButton.setOnClickListener(v -> {
                dialogComputerSystem.dismiss();
            });

            // ✅ Prevent dismissing when clicking outside
            dialogComputerSystem.setCancelable(false);
            dialogComputerSystem.setCanceledOnTouchOutside(false);

            // ✅ Handle Back Button Press
            dialogComputerSystem.setOnKeyListener((dialog, keyCode, event) -> {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
                    dialogComputerSystem.dismiss(); // Isasara ang dialog
                    return true; // Iwasan ang default back button behavior
                }
                return false;
            });

            dialogComputerSystem.show();
        });

        // 4. HOSPITALITY MANAGEMENT
        hospitalityManagement.setOnClickListener(e -> {
            if (getActivity() == null) return; // ✅ Prevents null context issues

            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            LayoutInflater inflater = LayoutInflater.from(getContext()); // ✅ Ensures correct layout inflater
            View dialogHospitalityManagementView = inflater.inflate(R.layout.academic_collegiate_program_dialog_bshm_submenu, null);
            builder.setView(dialogHospitalityManagementView);

            AlertDialog dialogHospitalityManagement = builder.create();

            if (dialogHospitalityManagement.getWindow() != null) {
                dialogHospitalityManagement.getWindow().setBackgroundDrawableResource(R.drawable.rounded_dialog); // ✅ Apply Rounded Corners
                dialogHospitalityManagement.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; // (Optional) Animation
            }

            LinearLayout closeButton = dialogHospitalityManagementView.findViewById(R.id.CloseButton);
            closeButton.setOnClickListener(v -> {
                dialogHospitalityManagement.dismiss();
            });

            // ✅ Prevent dismissing when clicking outside
            dialogHospitalityManagement.setCancelable(false);
            dialogHospitalityManagement.setCanceledOnTouchOutside(false);

            // ✅ Handle Back Button Press
            dialogHospitalityManagement.setOnKeyListener((dialog, keyCode, event) -> {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
                    dialogHospitalityManagement.dismiss(); // Isasara ang dialog
                    return true; // Iwasan ang default back button behavior
                }
                return false;
            });

            dialogHospitalityManagement.show();
        });

        // 5. ELEMENTARY EDUCATION
        educ.setOnClickListener(e -> {
            if (getActivity() == null) return; // ✅ Prevents null context issues

            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            LayoutInflater inflater = LayoutInflater.from(getContext()); // ✅ Ensures correct layout inflater
            View dialogEducView = inflater.inflate(R.layout.academic_collegiate_program_dialog_beed_submenu, null);
            builder.setView(dialogEducView);

            AlertDialog dialogEduc = builder.create();

            if (dialogEduc.getWindow() != null) {
                dialogEduc.getWindow().setBackgroundDrawableResource(R.drawable.rounded_dialog); // ✅ Apply Rounded Corners
                dialogEduc.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; // (Optional) Animation
            }

            LinearLayout closeButton = dialogEducView.findViewById(R.id.CloseButton);
            closeButton.setOnClickListener(v -> {
                dialogEduc.dismiss();
            });

            // ✅ Prevent dismissing when clicking outside
            dialogEduc.setCancelable(false);
            dialogEduc.setCanceledOnTouchOutside(false);

            // ✅ Handle Back Button Press
            dialogEduc.setOnKeyListener((dialog, keyCode, event) -> {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
                    dialogEduc.dismiss(); // Isasara ang dialog
                    return true; // Iwasan ang default back button behavior
                }
                return false;
            });

            dialogEduc.show();
        });

        // 6. ENGLISH LANGUAGE
        englishLanguage.setOnClickListener(e -> {
            if (getActivity() == null) return; // ✅ Prevents null context issues

            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            LayoutInflater inflater = LayoutInflater.from(getContext()); // ✅ Ensures correct layout inflater
            View dialogEnglishLanguageView = inflater.inflate(R.layout.academic_collegiate_program_dialog_ab_submenu, null);
            builder.setView(dialogEnglishLanguageView);

            AlertDialog dialogEnglishLanguage = builder.create();

            if (dialogEnglishLanguage.getWindow() != null) {
                dialogEnglishLanguage.getWindow().setBackgroundDrawableResource(R.drawable.rounded_dialog); // ✅ Apply Rounded Corners
                dialogEnglishLanguage.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; // (Optional) Animation
            }

            LinearLayout closeButton = dialogEnglishLanguageView.findViewById(R.id.CloseButton);
            closeButton.setOnClickListener(v -> {
                dialogEnglishLanguage.dismiss();
            });

            // ✅ Prevent dismissing when clicking outside
            dialogEnglishLanguage.setCancelable(false);
            dialogEnglishLanguage.setCanceledOnTouchOutside(false);

            // ✅ Handle Back Button Press
            dialogEnglishLanguage.setOnKeyListener((dialog, keyCode, event) -> {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
                    dialogEnglishLanguage.dismiss(); // Isasara ang dialog
                    return true; // Iwasan ang default back button behavior
                }
                return false;
            });

            dialogEnglishLanguage.show();
        });
    }
}
