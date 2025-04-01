package com.example.ncba_project_program;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class AdmissionCubaoGraduateStudiesEnrollmentProcedureSubMenuFragment extends Fragment {
    public static AdmissionCubaoGraduateStudiesEnrollmentProcedureSubMenuFragment newInstance() {
        return new AdmissionCubaoGraduateStudiesEnrollmentProcedureSubMenuFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.admission_enrollment_procedures_graduate_studies_dialog_submenu, container, false);
        AddElement(view);
        AddInteraction();
        return view;
    }


    private void AddElement(View view) {

    }

    private void AddInteraction() {

    }
}
