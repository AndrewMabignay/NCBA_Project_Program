package com.example.ncba_project_program;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;


public class AboutUsCareerTeaching extends Fragment {
    public static AboutUsCareerTeaching newInstance() {
        return new AboutUsCareerTeaching();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.about_us_teaching_tab_layout_submenu_subfragment, container, false);
        AddElement(view);
        AddInteraction();
        return view;
    }

    private void AddElement(View view) {

    }

    private void AddInteraction() {

    }
}
