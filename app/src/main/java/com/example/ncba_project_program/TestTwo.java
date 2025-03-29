package com.example.ncba_project_program;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;


public class TestTwo extends Fragment {
    public static TestOne newInstance() {
        return new TestOne();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.about_us_the_institution_submenu_subfragment, container, false);
        AddElement(view);
        AddInteraction();
        return view;
    }


    private void AddElement(View view) {

    }

    private void AddInteraction() {

    }
}
