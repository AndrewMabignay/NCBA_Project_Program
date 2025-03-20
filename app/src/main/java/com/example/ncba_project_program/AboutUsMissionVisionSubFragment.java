package com.example.ncba_project_program;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class AboutUsMissionVisionSubFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.about_us_mission_vision_values_submenu_subfragment, container, false);
        AddElement(view);
        return view;
    }

    private void AddElement(View view) {

    }

    private void startImageTransition() {

    }
}
