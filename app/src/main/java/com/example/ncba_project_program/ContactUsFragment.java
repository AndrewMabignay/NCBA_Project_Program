package com.example.ncba_project_program;

import android.app.AlertDialog;
import android.graphics.Outline;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.content.Context;


import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

public class ContactUsFragment extends Fragment {
    private ImageView ncbaCubao, ncbaTaytay, ncbaFairview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contactus_main_fragment, container, false);
        AddElement(view);
        AddInteraction(savedInstanceState);
        return view;
    }

    private WebView webView;
    private WebSettings webSettings;
    private void AddElement(View view) {
        // 1. RADIUS FIELDS
        ncbaCubao = view.findViewById(R.id.ncbaCubao);
        ncbaCubao.setClipToOutline(true);
        ncbaCubao.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                int radius = 28;
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), radius);
            }
        });

        ncbaTaytay = view.findViewById(R.id.ncbaTaytay);
        ncbaTaytay.setClipToOutline(true);
        ncbaTaytay.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                int radius = 28;
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), radius);
            }
        });

        ncbaFairview = view.findViewById(R.id.ncbaFairview);
        ncbaFairview.setClipToOutline(true);
        ncbaFairview.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                int radius = 28;
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), radius);
            }
        });
    }

    private void AddInteraction(Bundle savedInstanceState) {
        ncbaCubao.setOnClickListener(e -> {
            if (getActivity() == null) return; // ✅ Prevents null context issues

            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            LayoutInflater inflater = LayoutInflater.from(getContext()); // ✅ Ensures correct layout inflater
            View dialogBusinessAdView = inflater.inflate(R.layout.contactus_cubao_campus_dialog_submenu_subfragment, null);
            builder.setView(dialogBusinessAdView);

            AlertDialog dialogBusinessAd = builder.create();

            if (dialogBusinessAd.getWindow() != null) {
                dialogBusinessAd.getWindow().setBackgroundDrawableResource(R.drawable.rounded_dialog); // ✅ Apply Rounded Corners
                dialogBusinessAd.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; // (Optional) Animation
            }

            LinearLayout closeButton = dialogBusinessAdView.findViewById(R.id.CloseButton);
            closeButton.setOnClickListener(v -> {
                dialogBusinessAd.dismiss();
            });

            // ✅ Prevent dismissing when clicking outside
            dialogBusinessAd.setCancelable(false);
            dialogBusinessAd.setCanceledOnTouchOutside(false);

            // ✅ Handle Back Button Press
            dialogBusinessAd.setOnKeyListener((dialog, keyCode, event) -> {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
                    dialogBusinessAd.dismiss(); // Isasara ang dialog
                    return true; // Iwasan ang default back button behavior
                }
                return false;
            });

            dialogBusinessAd.show();
        });

        ncbaFairview.setOnClickListener(e -> {
            if (getActivity() == null) return; // ✅ Prevents null context issues

            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            LayoutInflater inflater = LayoutInflater.from(getContext()); // ✅ Ensures correct layout inflater
            View dialogBusinessAdView = inflater.inflate(R.layout.contactus_fairview_campus_dialog_submenu_subfragment, null);
            builder.setView(dialogBusinessAdView);

            AlertDialog dialogBusinessAd = builder.create();

            if (dialogBusinessAd.getWindow() != null) {
                dialogBusinessAd.getWindow().setBackgroundDrawableResource(R.drawable.rounded_dialog); // ✅ Apply Rounded Corners
                dialogBusinessAd.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; // (Optional) Animation
            }

            LinearLayout closeButton = dialogBusinessAdView.findViewById(R.id.CloseButton);
            closeButton.setOnClickListener(v -> {
                dialogBusinessAd.dismiss();
            });

            // ✅ Prevent dismissing when clicking outside
            dialogBusinessAd.setCancelable(false);
            dialogBusinessAd.setCanceledOnTouchOutside(false);

            // ✅ Handle Back Button Press
            dialogBusinessAd.setOnKeyListener((dialog, keyCode, event) -> {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
                    dialogBusinessAd.dismiss(); // Isasara ang dialog
                    return true; // Iwasan ang default back button behavior
                }
                return false;
            });

            dialogBusinessAd.show();
        });

        ncbaTaytay.setOnClickListener(e -> {
            if (getActivity() == null) return; // ✅ Prevents null context issues

            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            LayoutInflater inflater = LayoutInflater.from(getContext()); // ✅ Ensures correct layout inflater
            View dialogBusinessAdView = inflater.inflate(R.layout.contactus_taytay_campus_dialog_submenu_subfragment, null);
            builder.setView(dialogBusinessAdView);

            AlertDialog dialogBusinessAd = builder.create();

            if (dialogBusinessAd.getWindow() != null) {
                dialogBusinessAd.getWindow().setBackgroundDrawableResource(R.drawable.rounded_dialog); // ✅ Apply Rounded Corners
                dialogBusinessAd.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; // (Optional) Animation
            }

            LinearLayout closeButton = dialogBusinessAdView.findViewById(R.id.CloseButton);
            closeButton.setOnClickListener(v -> {
                dialogBusinessAd.dismiss();
            });

            // ✅ Prevent dismissing when clicking outside
            dialogBusinessAd.setCancelable(false);
            dialogBusinessAd.setCanceledOnTouchOutside(false);

            // ✅ Handle Back Button Press
            dialogBusinessAd.setOnKeyListener((dialog, keyCode, event) -> {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
                    dialogBusinessAd.dismiss(); // Isasara ang dialog
                    return true; // Iwasan ang default back button behavior
                }
                return false;
            });

            dialogBusinessAd.show();
        });
    }
}
