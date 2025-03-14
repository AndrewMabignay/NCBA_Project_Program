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
    private LinearLayout admission, academics, aboutUs, contactUs, webMaster, console;


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
        AddInteraction();
    }

    private void AddElement() {
        drawerLayout = findViewById(R.id.drawer_layout);
    }

    private void AddInteraction() {
        findViewById(R.id.openDrawer).setOnClickListener(view -> drawerLayout.openDrawer(findViewById(R.id.manual_drawer)));
        findViewById(R.id.closeDrawer).setOnClickListener(view -> drawerLayout.closeDrawer(findViewById(R.id.manual_drawer)));
    }
}
