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

        webView = view.findViewById(R.id.webView);
        webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);

//        // Check internet connection
//        if (isInternetAvailable()) {
//            webView.setVisibility(View.VISIBLE); // Show WebView if internet is available
//            webView.loadData(
//                    "<iframe src='https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3860.4841975731683!2d121.06796262756052!3d14.628434175438064!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3397b78fe2ccb011%3A0x7375abf629d6685a!2sNational%20College%20of%20Business%20and%20Arts%20(NCBA)!5e0!3m2!1sen!2sph!4v1742610948433!5m2!1sen!2sph' width='100%' height='100%' style='border:0;' allowfullscreen='' loading='lazy'></iframe>",
//                    "text/html",
//                    "UTF-8"
//            );
//        } else {
//            webView.setVisibility(View.GONE); // Hide WebView if no internet
//        }






    }
//
//    // Method to check internet connection
//    private boolean isInternetAvailable() {
//        ConnectivityManager cm = (ConnectivityManager) requireContext().getSystemService(Context.CONNECTIVITY_SERVICE);
//        if (cm != null) {
//            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
//            return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
//        }
//        return false;
//    }






    private void AddInteraction(Bundle savedInstanceState) {

    }
}
