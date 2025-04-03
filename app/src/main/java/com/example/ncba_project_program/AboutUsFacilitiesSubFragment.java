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

    private LinearLayout lobbyFacilities;

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
    }

    private void AddInteraction() {
        lobbyFacilities.setOnClickListener(e -> {
//            Log.d("Hello", "Facilities");
            showImageDialog();
        });
    }

    private void showImageDialog() {
        if (getContext() == null || getActivity() == null) return;

        handler.removeCallbacks(runnable);

        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.about_us_facilities_image_dialog_submenu, null);
        builder.setView(dialogView);

        ViewPager2 viewPager = dialogView.findViewById(R.id.imageViewPager);
        ImagePageAdapter adapter = new ImagePageAdapter(requireContext(), lobbyImages);
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