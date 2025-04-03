package com.example.ncba_project_program;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class AdmissionEnrollmentProcedureSubFragment extends Fragment  {
    private LinearLayout cubaoCampusEnrollment, taytayCampusEnrollment, fairviewCampusEnrollment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.admission_enrollment_procedures_subfragment, container, false);
        AddElement(view);
        AddInteraction();
        return view;
    }

    private void AddElement(View view) {
        cubaoCampusEnrollment = view.findViewById(R.id.CubaoCampusEnrollment);
        taytayCampusEnrollment = view.findViewById(R.id.TaytayCampusEnrollment);
        fairviewCampusEnrollment = view.findViewById(R.id.FairviewCampusEnrollment);
    }


    private void AddInteraction() {
        cubaoCampusEnrollment.setOnClickListener(e -> {
            if (getActivity() == null) return; // ✅ Prevents null context issues

            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            LayoutInflater inflater = LayoutInflater.from(getContext()); // ✅ Ensures correct layout inflater
            View dialogCubaoCampusEnrollmentView = inflater.inflate(R.layout.admission_enrollment_procedures_cubao_campus_dialog_submenu, null);
            builder.setView(dialogCubaoCampusEnrollmentView);

            AlertDialog dialogCubaoCampusEnrollmentViewProgram = builder.create();

            if (dialogCubaoCampusEnrollmentViewProgram.getWindow() != null) {
                dialogCubaoCampusEnrollmentViewProgram.getWindow().setBackgroundDrawableResource(R.drawable.rounded_dialog); // ✅ Apply Rounded Corners
                dialogCubaoCampusEnrollmentViewProgram.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; // (Optional) Animation
            }

            LinearLayout closeButton = dialogCubaoCampusEnrollmentView.findViewById(R.id.CloseButton);
            closeButton.setOnClickListener(v -> {
                dialogCubaoCampusEnrollmentViewProgram.dismiss();
            });

            // ✅ Prevent dismissing when clicking outside
            dialogCubaoCampusEnrollmentViewProgram.setCancelable(false);
            dialogCubaoCampusEnrollmentViewProgram.setCanceledOnTouchOutside(false);

            // ✅ Handle Back Button Press
            dialogCubaoCampusEnrollmentViewProgram.setOnKeyListener((dialog, keyCode, event) -> {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
                    dialogCubaoCampusEnrollmentViewProgram.dismiss(); // Isasara ang dialog
                    return true; // Iwasan ang default back button behavior
                }
                return false;
            });

            dialogCubaoCampusEnrollmentViewProgram.show();
        });

        taytayCampusEnrollment.setOnClickListener(e -> {
            if (getActivity() == null) return; // ✅ Prevents null context issues

            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            LayoutInflater inflater = LayoutInflater.from(getContext()); // ✅ Ensures correct layout inflater
            View dialogCubaoCampusEnrollmentView = inflater.inflate(R.layout.admission_enrollment_procedures_cubao_campus_dialog_submenu, null);
            builder.setView(dialogCubaoCampusEnrollmentView);

            AlertDialog dialogCubaoCampusEnrollmentViewProgram = builder.create();

            if (dialogCubaoCampusEnrollmentViewProgram.getWindow() != null) {
                dialogCubaoCampusEnrollmentViewProgram.getWindow().setBackgroundDrawableResource(R.drawable.rounded_dialog); // ✅ Apply Rounded Corners
                dialogCubaoCampusEnrollmentViewProgram.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; // (Optional) Animation
            }

            LinearLayout closeButton = dialogCubaoCampusEnrollmentView.findViewById(R.id.CloseButton);
            closeButton.setOnClickListener(v -> {
                dialogCubaoCampusEnrollmentViewProgram.dismiss();
            });

            // ✅ Prevent dismissing when clicking outside
            dialogCubaoCampusEnrollmentViewProgram.setCancelable(false);
            dialogCubaoCampusEnrollmentViewProgram.setCanceledOnTouchOutside(false);

            // ✅ Handle Back Button Press
            dialogCubaoCampusEnrollmentViewProgram.setOnKeyListener((dialog, keyCode, event) -> {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
                    dialogCubaoCampusEnrollmentViewProgram.dismiss(); // Isasara ang dialog
                    return true; // Iwasan ang default back button behavior
                }
                return false;
            });

            dialogCubaoCampusEnrollmentViewProgram.show();
        });

        fairviewCampusEnrollment.setOnClickListener(e -> {
            if (getActivity() == null) return; // ✅ Prevents null context issues

            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            LayoutInflater inflater = LayoutInflater.from(getContext()); // ✅ Ensures correct layout inflater
            View dialogCubaoCampusEnrollmentView = inflater.inflate(R.layout.admission_enrollment_procedures_cubao_campus_dialog_submenu, null);
            builder.setView(dialogCubaoCampusEnrollmentView);

            AlertDialog dialogCubaoCampusEnrollmentViewProgram = builder.create();

            if (dialogCubaoCampusEnrollmentViewProgram.getWindow() != null) {
                dialogCubaoCampusEnrollmentViewProgram.getWindow().setBackgroundDrawableResource(R.drawable.rounded_dialog); // ✅ Apply Rounded Corners
                dialogCubaoCampusEnrollmentViewProgram.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; // (Optional) Animation
            }

            LinearLayout closeButton = dialogCubaoCampusEnrollmentView.findViewById(R.id.CloseButton);
            closeButton.setOnClickListener(v -> {
                dialogCubaoCampusEnrollmentViewProgram.dismiss();
            });

            // ✅ Prevent dismissing when clicking outside
            dialogCubaoCampusEnrollmentViewProgram.setCancelable(false);
            dialogCubaoCampusEnrollmentViewProgram.setCanceledOnTouchOutside(false);

            // ✅ Handle Back Button Press
            dialogCubaoCampusEnrollmentViewProgram.setOnKeyListener((dialog, keyCode, event) -> {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
                    dialogCubaoCampusEnrollmentViewProgram.dismiss(); // Isasara ang dialog
                    return true; // Iwasan ang default back button behavior
                }
                return false;
            });

            dialogCubaoCampusEnrollmentViewProgram.show();
        });
    }

    class VPAdaptering extends FragmentStateAdapter {
        private final ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
        private final ArrayList<String> fragmentTitle = new ArrayList<>();

        public VPAdaptering(@NonNull FragmentManager fm, @NonNull Lifecycle lifecycle) {
            super(fm, lifecycle);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return fragmentArrayList.get(position);
        }

        @Override
        public int getItemCount() {
            return fragmentArrayList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            fragmentArrayList.add(fragment);
            fragmentTitle.add(title);
        }

        @Nullable
        public CharSequence getPageTitle(int position) {
            return fragmentTitle.get(position);
        }
    }

}
