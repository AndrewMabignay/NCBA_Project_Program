package com.example.ncba_project_program;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class AdmissionCubaoCollegeEnrollmentProcedureSubMenuFragment extends Fragment {
    public static AdmissionCubaoCollegeEnrollmentProcedureSubMenuFragment newInstance() {
        return new AdmissionCubaoCollegeEnrollmentProcedureSubMenuFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.admission_enrollment_procedures_college_dialog_submenu, container, false);
        AddElement(view);
        AddInteraction();
        return view;
    }


    private void AddElement(View view) {

    }

    private void AddInteraction() {

    }
}
