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
    private LinearLayout mbaDetails;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.academic_graduate_program_submenu_subfragment, container, false);
        AddElement(view);
        AddInteraction();
        return view;
    }

    private void AddElement(View view) {
        mbaDetails = view.findViewById(R.id.MBA);
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
                dialogMBA.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
            }

            TextView closeButton = dialogMBAView.findViewById(R.id.CloseButton);
            closeButton.setOnClickListener(v -> {
                dialogMBA.dismiss();
            });

            // ✅ Prevent dismissing when clicking outside
            dialogMBA.setCancelable(false);
            dialogMBA.setCanceledOnTouchOutside(false);

            dialogMBA.show();
        });
    }
}
