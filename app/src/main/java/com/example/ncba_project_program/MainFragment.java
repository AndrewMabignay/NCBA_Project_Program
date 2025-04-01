package com.example.ncba_project_program;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Scroller;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import android.view.animation.Interpolator;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {
    private LinearLayout admission, academics, aboutUs, contactUs, webMaster, entertainment;

    private ViewPager2 viewPager2;
    private EventPagerAdapter adapter;
    private Handler handler;
    private Runnable autoScrollRunnable;
    private int currentPage = 0;


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
        eventList.add(new Event("Life Saving Blood Donation", "Community Outreach Program, Events, Fairview", R.drawable.blood_donation_event_one));
        eventList.add(new Event("Bringing Care to the Community!", "COP, Cubao, Events.", R.drawable.care_community_event_two));
        eventList.add(new Event("NCBA Taytay Open House: A Glimpse Inside", "58th Foundation Day, Events, Taytay", R.drawable.glimpse_inside_event_three));
        eventList.add(new Event("NCBA Taytay Rocks: Battle of the Bands 2025", "58th Foundation Day, Events, Taytay", R.drawable.battle_of_the_bands_event_four));
        eventList.add(new Event("NCBA COP Launched a Adopted Community Program", "COP, Events, Taytay", R.drawable.adopted_community_event_five));
        eventList.add(new Event("BSHM Second Year Students (Bread and Pastry)", "BSHM, College, Events", R.drawable.bread_pastry_event_six));
        eventList.add(new Event("NCBA Job Fair 2024", "College, Cubao, Fairview, Taytay, Upcoming Events", R.drawable.ncba_job_fair_event_seven));
        eventList.add(new Event("The Rise of Digitalization", "BSBA, College, Events\n", R.drawable.rise_digitalization_event_eight));
        eventList.add(new Event("Ethical Hacking Seminar", "BSCS, College, Taytay\n", R.drawable.ethical_hacking_event_nine));
        eventList.add(new Event("Filipino Food Month", "BSHM, College, Events\n", R.drawable.filipino_food_month_event_ten));
        eventList.add(new Event("SSS and PAG-IBIG Seminar", "BSBA, College, Events, Taytay\n", R.drawable.sss_pagibig_event_eleven));
        eventList.add(new Event("SSS eWheels on Campus", "Events, Fairview, General\n", R.drawable.sss_ewheel_event_twelve));
        eventList.add(new Event("Gifted Children Awareness Film Showing", "College, Cubao, Events", R.drawable.children_awareness_event_thirteen));
        eventList.add(new Event("PACUCOA Accreditors Visit NCBA Cubao", "College, Cubao, Events", R.drawable.pacucoa_event_fourteen));
        eventList.add(new Event("COP’s Livelihood Training: Make Dishwashing and Hand Soap", "Events", R.drawable.soup_event_fifteen));

        adapter = new EventPagerAdapter(requireActivity(), eventList);
        viewPager2.setAdapter(adapter);

        viewPager2.setPageTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                page.setAlpha(1 - Math.abs(position)); // Fade effect
                page.setTranslationX(-position * page.getWidth() * 0.2f); // Horizontal slide
            }
        });

        // Start auto-scroll functionality without using Handler
        viewPager2.postDelayed(new Runnable() {
            @Override
            public void run() {
                int itemCount = viewPager2.getAdapter().getItemCount();
                if (currentPage >= itemCount) {
                    currentPage = 0; // Loop back to the first item when reaching the last
                }

                viewPager2.setCurrentItem(currentPage++, true); // Smooth transition to next page
                viewPager2.postDelayed(this, 4000); // Delay of 4 seconds for smooth transition
            }
        }, 2000);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (handler != null) {
            handler.removeCallbacks(autoScrollRunnable);
        }
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




class CustomScroller extends Scroller {
    private int mDuration;

    public CustomScroller(Context context, Interpolator interpolator) {
        super(context, interpolator);
    }

    @Override
    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        super.startScroll(startX, startY, dx, dy, mDuration);
    }

    public void setScrollDuration(int duration) {
        this.mDuration = duration;
    }
}