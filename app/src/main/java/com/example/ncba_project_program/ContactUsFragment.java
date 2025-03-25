package com.example.ncba_project_program;

import android.graphics.Outline;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.content.Context;


import android.os.Bundle;
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

    }
}
