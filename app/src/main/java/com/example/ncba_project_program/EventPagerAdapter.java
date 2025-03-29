package com.example.ncba_project_program;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class EventPagerAdapter extends FragmentStateAdapter {
    public EventPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new EventItemFragment(); // Return the event item fragment
    }

    @Override
    public int getItemCount() {
        return 3; // Number of event items to display (adjust as needed)
    }
}
