package com.example.ncba_project_program;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;


public class MainActivity extends AppCompatActivity {


    private DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        drawerLayout = findViewById(R.id.drawer_layout);


        findViewById(R.id.openDrawer).setOnClickListener(view -> drawerLayout.openDrawer(findViewById(R.id.manual_drawer)));


        findViewById(R.id.closeDrawer).setOnClickListener(view -> drawerLayout.closeDrawer(findViewById(R.id.manual_drawer)));
    }
}
