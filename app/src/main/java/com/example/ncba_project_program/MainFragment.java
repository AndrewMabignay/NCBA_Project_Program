package com.example.ncba_project_program;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainFragment extends Fragment {
    private LinearLayout admission, academics, aboutUs, contactUs, webMaster, entertainment;

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
    }

    private Fragment admissionFragment, academicFragment, aboutUsFragment, contactUsFragment;
    private void AddInteraction() {
        // 1. ADMISSION FRAGMENT
        admission.setOnClickListener(e -> {
            if (admissionFragment == null) {
                admissionFragment = new AdmissionFragment();
            }

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(
                            R.anim.slide_in_left_to_right,  // Enter animation (Left to Right)
                            R.anim.slide_out_left_to_right, // Exit animation (Left to Right)
                            R.anim.slide_in_right_to_left,  // Pop enter (Backstack)
                            R.anim.slide_out_right_to_left  // Pop exit (Backstack)
                    )
                    .replace(R.id.Main_Fragment_Container, admissionFragment)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
        });

        // 2. ACADEMIC FRAGMENT
        academics.setOnClickListener(e -> {
            if (academicFragment == null) {
                academicFragment = new AcademicFragment();
            }

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(
                            R.anim.slide_in_left_to_right,  // Enter animation (Left to Right)
                            R.anim.slide_out_left_to_right, // Exit animation (Left to Right)
                            R.anim.slide_in_right_to_left,  // Pop enter (Backstack)
                            R.anim.slide_out_right_to_left  // Pop exit (Backstack)
                    )
                    .replace(R.id.Main_Fragment_Container, academicFragment)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
        });

        // 3. ABOUT US
        aboutUs.setOnClickListener(e -> {
            if (aboutUsFragment == null) {
                aboutUsFragment = new AboutUsFragment();
            }

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(
                            R.anim.slide_in_left_to_right,  // Enter animation (Left to Right)
                            R.anim.slide_out_left_to_right, // Exit animation (Left to Right)
                            R.anim.slide_in_right_to_left,  // Pop enter (Backstack)
                            R.anim.slide_out_right_to_left  // Pop exit (Backstack)
                    )
                    .replace(R.id.Main_Fragment_Container, aboutUsFragment)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
        });

        // 4. CONTACT US
        contactUs.setOnClickListener(e -> {
            if (contactUsFragment == null) {
                contactUsFragment = new ContactUsFragment();
            }

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(
                            R.anim.slide_in_left_to_right,  // Enter animation (Left to Right)
                            R.anim.slide_out_left_to_right, // Exit animation (Left to Right)
                            R.anim.slide_in_right_to_left,  // Pop enter (Backstack)
                            R.anim.slide_out_right_to_left  // Pop exit (Backstack)
                    )
                    .replace(R.id.Main_Fragment_Container, contactUsFragment)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
        });

        entertainment.setOnClickListener(e -> {
            Intent intent = new Intent(getActivity(), MainSnakeGame.class);
            startActivity(intent);
        });
    }


}

class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {
    private Context context;
    private List<Integer> eventImages; // Listahan ng event images

    public EventAdapter(Context context, List<Integer> eventImages) {
        this.context = context;
        this.eventImages = eventImages;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_main_event_item_sub_fragment, parent, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        holder.eventImage.setImageResource(eventImages.get(position));
    }

    @Override
    public int getItemCount() {
        return eventImages.size();
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder {
        ImageView eventImage;

        public EventViewHolder(@NonNull View itemView) {
            super(itemView);
            eventImage = itemView.findViewById(R.id.ImagingEventSwitcher);
        }
    }
}
