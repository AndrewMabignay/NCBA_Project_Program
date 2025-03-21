package com.example.ncba_project_program;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;


public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private LinearLayout homeNav, admissionNav, academicsNav, aboutUsNav, contactUsNav, webMasterNav, entertainmentNav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.Main_Fragment_Container, new MainFragment()) // Default fragment
                    .commit();
        }

        AddElement();
        AddInteraction(savedInstanceState);
    }

    private void AddElement() {
        drawerLayout = findViewById(R.id.drawer_layout);

        homeNav = findViewById(R.id.HomeNav);
        admissionNav = findViewById(R.id.AdmissionNav);
        academicsNav = findViewById(R.id.AcademicNav);
        aboutUsNav = findViewById(R.id.AboutUsNav);
        contactUsNav = findViewById(R.id.ContactUsNav);
        webMasterNav = findViewById(R.id.WebMasterNav);
        entertainmentNav = findViewById(R.id.EntertainmentNav);
    }

    private void AddInteraction(Bundle savedInstanceState) {
        findViewById(R.id.openDrawer).setOnClickListener(view -> drawerLayout.openDrawer(findViewById(R.id.manual_drawer)));
//        findViewById(R.id.closeDrawer).setOnClickListener(view -> drawerLayout.closeDrawer(findViewById(R.id.manual_drawer)));

        homeNav.setOnClickListener(e -> {
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.Main_Fragment_Container, new MainFragment()) // Default fragment
                        .commit();
            }

            AddElement();
            AddInteraction(savedInstanceState);

            drawerLayout.closeDrawer(findViewById(R.id.manual_drawer));
        });

        admissionNav.setOnClickListener(e -> {
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.Main_Fragment_Container, new AdmissionFragment()) // Default fragment
                        .commit();
            }

            AddElement();
            AddInteraction(savedInstanceState);

            drawerLayout.closeDrawer(findViewById(R.id.manual_drawer));
        });

        academicsNav.setOnClickListener(e -> {
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.Main_Fragment_Container, new AcademicFragment()) // Academic Fragment
                        .commit();
            }

            AddElement();
            AddInteraction(savedInstanceState);

            drawerLayout.closeDrawer(findViewById(R.id.manual_drawer));
        });

        aboutUsNav.setOnClickListener(e -> {
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.Main_Fragment_Container, new AboutUsFragment()) // About Us Fragment
                        .commit();
            }

            AddElement();
            AddInteraction(savedInstanceState);

            drawerLayout.closeDrawer(findViewById(R.id.manual_drawer));
        });

        academicsNav.setOnClickListener(e -> {
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.Main_Fragment_Container, new AcademicFragment()) // Academic Fragment
                        .commit();
            }

            AddElement();
            AddInteraction(savedInstanceState);

            drawerLayout.closeDrawer(findViewById(R.id.manual_drawer));
        });
    }
}
