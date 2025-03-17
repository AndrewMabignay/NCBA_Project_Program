package com.example.ncba_project_program;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class AcademicGraduateSubFragment extends Fragment {
    private TextView mbaDetails, mpaDetails;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.academic_graduate_program_submenu_subfragment, container, false);
        AddElement(view);
        AddInteraction();
        return view;
    }

    private void AddElement(View view) {
        mbaDetails = view.findViewById(R.id.MBA);
        mpaDetails = view.findViewById(R.id.MPA);
    }
    private void AddInteraction() {
        mbaDetails.setOnClickListener(e -> {
            if (getActivity() == null) return; // ✅ Prevents null context issues

            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            LayoutInflater inflater = LayoutInflater.from(getContext()); // ✅ Ensures correct layout inflater
            View dialogMBAView = inflater.inflate(R.layout.academic_graduate_program_dialog_mba_submenu, null);
            builder.setView(dialogMBAView);

            AlertDialog dialogMBA = builder.create();

            if (dialogMBA.getWindow() != null) {
                dialogMBA.getWindow().setBackgroundDrawableResource(R.drawable.rounded_dialog); // ✅ Apply Rounded Corners
                dialogMBA.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; // (Optional) Animation
            }

            LinearLayout closeButton = dialogMBAView.findViewById(R.id.CloseButton);
            closeButton.setOnClickListener(v -> {
                dialogMBA.dismiss();
            });

            // ✅ Prevent dismissing when clicking outside
            dialogMBA.setCancelable(false);
            dialogMBA.setCanceledOnTouchOutside(false);

            dialogMBA.show();
        });

        mpaDetails.setOnClickListener(e -> {
            if (getActivity() == null) return; // ✅ Prevents null context issues

            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            LayoutInflater inflater = LayoutInflater.from(getContext()); // ✅ Ensures correct layout inflater
            View dialogMPAView = inflater.inflate(R.layout.academic_graduate_program_dialog_mpa_submenu, null);
            builder.setView(dialogMPAView);

            AlertDialog dialogMPA = builder.create();

            if (dialogMPA.getWindow() != null) {
                dialogMPA.getWindow().setBackgroundDrawableResource(R.drawable.rounded_dialog); // ✅ Apply Rounded Corners
                dialogMPA.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; // (Optional) Animation
            }

            LinearLayout closeButton = dialogMPAView.findViewById(R.id.CloseButton);
            closeButton.setOnClickListener(v -> {
                dialogMPA.dismiss();
            });

            // ✅ Prevent dismissing when clicking outside
            dialogMPA.setCancelable(false);
            dialogMPA.setCanceledOnTouchOutside(false);

            dialogMPA.show();
        });
    }
}
