package com.example.ncba_project_program;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {
    private LinearLayout admission, academics, aboutUs, contactUs, webMaster, entertainment;

    private ViewPager2 viewPager2;
    private EventPagerAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main_fragment, container, false);
        AddElement(view);
        AddInteraction();
        return view;
    }

    private void AddElement(View view) {
        // ================= BUTTONS (LINEAR LAYOUT) =================
        admission = view.findViewById(R.id.AdmissionMain);
        academics = view.findViewById(R.id.AcademicsMain);
        aboutUs = view.findViewById(R.id.AboutUsMain);
        contactUs = view.findViewById(R.id.ContactUsMain);
        webMaster = view.findViewById(R.id.WebMasterMain);
        entertainment = view.findViewById(R.id.EntertainmentMain);



        viewPager2 = view.findViewById(R.id.viewPagerHome);
        List<Event> eventList = new ArrayList<>();
        eventList.add(new Event("Open House 2024", "A chance to explore our campus!", R.drawable.blood_donation_event_one));
        eventList.add(new Event("IT Seminar", "Learn the latest trends in technology.", R.drawable.blood_donation_event_one));
        eventList.add(new Event("Sports Fest", "Showcase your skills in various sports!", R.drawable.blood_donation_event_one));

        // SET ADAPTER
        adapter = new EventPagerAdapter(requireActivity(), eventList);
        viewPager2.setAdapter(adapter);

    }

    private Fragment admissionFragment, academicFragment, aboutUsFragment, webMasterFragment, contactUsFragment;
    private void AddInteraction() {
        // 1. ADMISSION FRAGMENT
        admission.setOnClickListener(e -> {
            if (admissionFragment == null) {
                admissionFragment = new AdmissionFragment();
            }

            TransitionFragmentInteraction(admissionFragment);
        });

        // 2. ACADEMIC FRAGMENT
        academics.setOnClickListener(e -> {
            if (academicFragment == null) {
                academicFragment = new AcademicFragment();
            }

            TransitionFragmentInteraction(academicFragment);
        });

        // 3. ABOUT US
        aboutUs.setOnClickListener(e -> {
            if (aboutUsFragment == null) {
                aboutUsFragment = new AboutUsFragment();
            }

            TransitionFragmentInteraction(aboutUsFragment);
        });

        // 4. CONTACT US
        contactUs.setOnClickListener(e -> {
            if (contactUsFragment == null) {
                contactUsFragment = new ContactUsFragment();
            }

            TransitionFragmentInteraction(contactUsFragment);
        });

        webMaster.setOnClickListener(e -> {
            if (webMasterFragment == null) {
                webMasterFragment = new WebMasterFragment();
            }

            TransitionFragmentInteraction(webMasterFragment);
        });

        entertainment.setOnClickListener(e -> {
            Intent intent = new Intent(getActivity(), MainSnakeGame.class);
            startActivity(intent);
        });
    }

    private void TransitionFragmentInteraction(Fragment fragment) {
        requireActivity().getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(
                        R.anim.slide_in_left_to_right,  // Enter animation (Left to Right)
                        R.anim.slide_out_left_to_right, // Exit animation (Left to Right)
                        R.anim.slide_in_right_to_left,  // Pop enter (Backstack)
                        R.anim.slide_out_right_to_left  // Pop exit (Backstack)
                )
                .replace(R.id.Main_Fragment_Container, fragment)
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .commit();
    }
}

class EventPagerAdapter extends FragmentStateAdapter {
    private final List<Event> eventList;

    public EventPagerAdapter(@NonNull FragmentActivity fragmentActivity, List<Event> eventList) {
        super(fragmentActivity);
        this.eventList = eventList;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return EventItemFragment.newInstance(eventList.get(position));
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }
}




class Event {
    private String title;
    private String description;
    private int imageResId; // Resource ID ng event image

    public Event(String title, String description, int imageResId) {
        this.title = title;
        this.description = description;
        this.imageResId = imageResId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResId() {
        return imageResId;
    }
}

