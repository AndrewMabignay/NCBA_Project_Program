package com.example.ncba_project_program;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {
    private LinearLayout admission, academics, aboutUs, contactUs, webMaster, console;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main_fragment, container, false);
        AddElement(view);
        AddInteraction();

        /* --- RESERVED CODE ---
            if (savedInstanceState == null) {
                 requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.Main_Fragment_Container, new MainFragment())
                    .commit();
            }
        */

        return view;
    }

    private void AddElement(View view) {
        // ================= BUTTONS (LINEAR LAYOUT) =================
        admission = view.findViewById(R.id.Admission);
        academics = view.findViewById(R.id.Academic);
        aboutUs = view.findViewById(R.id.AboutUs);
        contactUs = view.findViewById(R.id.ContactUs);
        webMaster = view.findViewById(R.id.WebMaster);
        console = view.findViewById(R.id.Game);
    }

    private Fragment admissionFragment;
    private void AddInteraction() {
        admission.setOnClickListener(e -> {
            admissionFragment = new AdmissionFragment();
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                    .replace(R.id.Main_Fragment_Container, admissionFragment)
                    .addToBackStack(null)
                    .commit();
        });
    }


}
