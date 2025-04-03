package com.example.ncba_project_program;

import android.graphics.Outline;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.LinearLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

public class AboutUsFacilitiesSubFragment extends Fragment {
    private int[] lobbyImages = {
            R.drawable.facilities_lobby_one, R.drawable.facilities_lobby_two
    };

    private int[] computerImages = {
            R.drawable.facilities_computer_two, R.drawable.facilities_computer_three,
            R.drawable.facilities_computer_four, R.drawable.facilities_computer_five,
            R.drawable.facilities_computer_six, R.drawable.facilities_computer_seven,
            R.drawable.facilities_computer_eight, R.drawable.facilities_computer_nine,
            R.drawable.facilities_computer_ten, R.drawable.facilities_computer_eleven,
            R.drawable.facilities_computer_twelve
    };

    private int[] gymnasium = {
            R.drawable.facilities_gymnasium_one, R.drawable.facilities_gymnasium_two,
            R.drawable.facilities_gymnasium_three, R.drawable.facilities_gymnasium_four,
            R.drawable.facilities_gymnasium_five, R.drawable.facilities_gymnasium_six
    };

    private int[] canteen = {
            R.drawable.facilities_canteen_one, R.drawable.facilities_canteen_two,
            R.drawable.facilities_canteen_three, R.drawable.facilities_canteen_four
    };

    private int[] library = {
            R.drawable.facilities_library_one, R.drawable.facilities_library_two,
            R.drawable.facilities_library_three, R.drawable.facilities_library_four,
            R.drawable.facilities_library_five, R.drawable.facilities_library_six,
            R.drawable.facilities_library_seven
    };

    private int[] classroom = {
            R.drawable.facilities_classrooms_one
    };

    private int[] church = {
            R.drawable.facilities_church_one, R.drawable.facilities_church_two,
            R.drawable.facilities_church_three, R.drawable.facilities_church_four
    };

    private int[] miniTheater = {

    };

    private LinearLayout lobbyFacilities, computerLaboratoriesFacilities, gymnasiumFacilities, canteenFacilities,
            libraryFacilities, classRoomFacilities, churchFacilites, miniTheaterFacilities, clinicFacilities;

    private int currentIndex = 0;
    private Handler handler;
    private Runnable runnable;
    private float x1, x2;
    private static final int MIN_DISTANCE = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.about_us_facilities_submenu_subfragment, container, false);
        handler = new Handler();
        AddElement(view);
        AddInteraction();
        return view;
    }

    private void AddElement(View view) {
        lobbyFacilities = view.findViewById(R.id.LobbyFacilities);
        lobbyFacilities.setClipToOutline(true);
        lobbyFacilities.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                int radius = 28;
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), radius);
            }
        });

        computerLaboratoriesFacilities = view.findViewById(R.id.ComputerLaboratoriesFacilities);
        computerLaboratoriesFacilities.setClipToOutline(true);
        computerLaboratoriesFacilities.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                int radius = 28;
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), radius);
            }
        });

        gymnasiumFacilities = view.findViewById(R.id.GymnasiumFacilities);
        gymnasiumFacilities.setClipToOutline(true);
        gymnasiumFacilities.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                int radius = 28;
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), radius);
            }
        });

        canteenFacilities = view.findViewById(R.id.CanteenFacilities);
        canteenFacilities.setClipToOutline(true);
        canteenFacilities.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                int radius = 28;
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), radius);
            }
        });

        libraryFacilities = view.findViewById(R.id.LibraryFacilities);
        libraryFacilities.setClipToOutline(true);
        libraryFacilities.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                int radius = 28;
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), radius);
            }
        });

        classRoomFacilities = view.findViewById(R.id.ClassroomFacilities);
        classRoomFacilities.setClipToOutline(true);
        classRoomFacilities.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                int radius = 28;
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), radius);
            }
        });

        churchFacilites = view.findViewById(R.id.ChurchFacilities);
        churchFacilites.setClipToOutline(true);
        churchFacilites.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                int radius = 28;
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), radius);
            }
        });
    }

    private void AddInteraction() {
        lobbyFacilities.setOnClickListener(e -> {
            showImageDialog(lobbyImages);
        });

        computerLaboratoriesFacilities.setOnClickListener(e -> {
            showImageDialog(computerImages);
        });

        gymnasiumFacilities.setOnClickListener(e -> {
            showImageDialog(gymnasium);
        });

        canteenFacilities.setOnClickListener(e -> {
            showImageDialog(canteen);
        });

        libraryFacilities.setOnClickListener(e -> {
            showImageDialog(library);
        });

        classRoomFacilities.setOnClickListener(e -> {
            showImageDialog(classroom);
        });

        churchFacilites.setOnClickListener(e -> {
            showImageDialog(church);
        });
    }

    private void showImageDialog(int[] images) {
        if (getContext() == null || getActivity() == null) return;

        handler.removeCallbacks(runnable);

        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.about_us_facilities_image_dialog_submenu, null);
        builder.setView(dialogView);

        ViewPager2 viewPager = dialogView.findViewById(R.id.imageViewPager);
        ImagePageAdapter adapter = new ImagePageAdapter(requireContext(), images);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(currentIndex, false);

        viewPager.setOrientation(ViewPager2.ORIENTATION_VERTICAL);

        AlertDialog dialog = builder.create();
        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(android.graphics.Color.TRANSPARENT));
        }

        dialog.setOnDismissListener(dialogInterface -> {
            handler.post(runnable);
        });

        dialog.show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (handler != null && runnable != null) {
            handler.removeCallbacks(runnable);
        }
    }
}