package com.example.ncba_project_program;

import android.app.AlertDialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class EventItemFragment extends Fragment {
    private static final String ARG_TITLE = "title";
    private static final String ARG_DESCRIPTION = "description";
    private static final String ARG_IMAGE_RES_ID = "imageResId";
    private LinearLayout readMore;

    public static EventItemFragment newInstance(Event event) {
        EventItemFragment fragment = new EventItemFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, event.getTitle());
        args.putString(ARG_DESCRIPTION, event.getDescription());
        args.putInt(ARG_IMAGE_RES_ID, event.getImageResId());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_main_event_item_sub_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView titleText = view.findViewById(R.id.textTitle);
        TextView descriptionText = view.findViewById(R.id.textDescription);
        ImageView eventImage = view.findViewById(R.id.imageView);
        readMore = view.findViewById(R.id.ReadMore);


        if (getArguments() != null) {
            titleText.setText(getArguments().getString(ARG_TITLE, "No Title"));
            descriptionText.setText(getArguments().getString(ARG_DESCRIPTION, "No Description"));
            eventImage.setImageResource(getArguments().getInt(ARG_IMAGE_RES_ID, R.drawable.bg_dialog));

            readMore.setOnClickListener(e -> {
                String eventTitle = titleText.getText().toString();
                showEventDialog(eventTitle);
            });
        }
    }

    private void showEventDialog(String eventTitle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.activity_main_event_item_sub_fragment_dialog, null);

        builder.setView(dialogView);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawableResource(R.drawable.rounded_dialog); // ✅ Apply Rounded Corners
            alertDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; // (Optional) Animation
        }

        TextView titleViewDialog = dialogView.findViewById(R.id.textTitle);
        TextView dateViewDialog = dialogView.findViewById(R.id.textDate);
        TextView descriptionViewDialog = dialogView.findViewById(R.id.textDescription);
        ImageView imageViewDialog = dialogView.findViewById(R.id.imageViewArticle);
        TextView textArticle = dialogView.findViewById(R.id.textArticleDescription);

        String date;
        String description;
        int imageResId;
        String article;

        SpannableString spannableArticle;
        int start;

        switch (eventTitle) {
            //  EVENT 1
            case "Life Saving Blood Donation":
                date = "March 10, 2025";
                description = "Community Outreach Program, Events, Fairview";
                imageResId = R.drawable.blood_donation_event_one;
                article = getString(R.string.article_text_event_one);

                spannableArticle = new SpannableString(article);

                applyHashtagColor(spannableArticle, "#BloodDonation", R.color.colorBlue);
                applyHashtagColor(spannableArticle, "#SaveLives", R.color.colorBlue);

                textArticle.setText(spannableArticle);
                break;

            //  EVENT 2
            case "Bringing Care to the Community!":
                date = "March 10, 2025";
                description = "Community Outreach Program, Events, Fairview";
                imageResId = R.drawable.care_community_event_two;
                article = getString(R.string.article_text_event_two);

                spannableArticle = new SpannableString(article);

                applyHashtagColor(spannableArticle, "#NCBA58YearsStrong", R.color.colorBlue);
                applyHashtagColor(spannableArticle, "#DriveForChange", R.color.colorBlue);
                applyHashtagColor(spannableArticle, "#NCBACares", R.color.colorBlue);
                applyHashtagColor(spannableArticle, "#JCIQuezonCityCapitol", R.color.colorBlue);
                applyHashtagColor(spannableArticle, "#MedicalMission2025", R.color.colorBlue);

                textArticle.setText(spannableArticle);
                break;

            //  EVENT 3
            case "NCBA Taytay Open House: A Glimpse Inside":
                date = "March 5, 2025";
                description = "58th Foundation Day, Events, Taytay";
                imageResId = R.drawable.glimpse_inside_event_three;
                article = getString(R.string.article_text_event_three);
                textArticle.setText(article);
                break;

            //  EVENT 4
            case "NCBA Taytay Rocks: Battle of the Bands 2025":
                date = "March 5, 2025";
                description = "58th Foundation Day, Events, Taytay";
                imageResId = R.drawable.battle_of_the_bands_event_four;
                article = getString(R.string.article_text_event_four);
                textArticle.setText(article);
                break;

            //  EVENT 5
            case "NCBA COP Launched a Adopted Community Program":
                date = "October 18, 2024";
                description = "Community Outreach Program, Events, Taytay";
                imageResId = R.drawable.adopted_community_event_five;
                article = getString(R.string.article_text_event_five);
                textArticle.setText(article);
                break;

            //  EVENT 6
            case "BSHM Second Year Students (Bread and Pastry)":
                date = "October 14, 2024";
                description = "BSHM, College, Events";
                imageResId = R.drawable.bread_pastry_event_six;
                article = getString(R.string.article_text_event_six);
                textArticle.setText(article);
                break;

            //  EVENT 7
            case "NCBA Job Fair 2024":
                date = "May 8, 2024";
                description = "College, Cubao, Fairview, Taytay, Upcoming Events";
                imageResId = R.drawable.ncba_job_fair_event_seven;
                article = getString(R.string.article_text_event_seven);

                spannableArticle = new SpannableString(article);
                applyBoldText(spannableArticle, "Heads Up, NCBA College Seniors!");
                applyBoldText(spannableArticle, "May 10, 2024 (Friday)");
                applyBoldText(spannableArticle, "9:00 am – 4:00 pm");
                applyBoldText(spannableArticle, "Founders Hall, NCBA Fairview");

                textArticle.setText(spannableArticle);
                break;

            //  EVENT 8
            case "The Rise of Digitalization":
                date = "May 7, 2024";
                description = "BSBA, College, Events";
                imageResId = R.drawable.rise_digitalization_event_eight;
                article = getString(R.string.article_text_event_eight);

                spannableArticle = new SpannableString(article);
                applyBoldText(spannableArticle, "The Rise of Digitalization: Impact of Digital Services in the Financial Sector");

                textArticle.setText(spannableArticle);
                break;

            //  EVENT 9
            case "Ethical Hacking Seminar":
                date = "April 22, 2024";
                description = "BSCS, College, Taytay";
                imageResId = R.drawable.ethical_hacking_event_nine;
                article = getString(R.string.article_text_event_nine);
                textArticle.setText(article);
                break;

            //  EVENT 10
            case "Filipino Food Month":
                date = "April 22, 2024";
                description = "BSHM, College, Events";
                imageResId = R.drawable.filipino_food_month_event_ten;
                article = getString(R.string.article_text_event_ten);

                spannableArticle = new SpannableString(article);

                applyHashtagColor(spannableArticle, "#NCBA", R.color.colorBlue);
                applyHashtagColor(spannableArticle, "#wildcats", R.color.colorBlue);
                applyHashtagColor(spannableArticle, "#HMDepartment", R.color.colorBlue);

                textArticle.setText(spannableArticle);
                break;

            //  EVENT 11
            case "SSS and PAG-IBIG Seminar":
                date = "April 15, 2024";
                description = "BSBA, College, Events, Taytay";
                imageResId = R.drawable.sss_pagibig_event_eleven;
                article = getString(R.string.article_text_event_eleven);

                textArticle.setText(article);
                break;

            //  EVENT 12
            case "SSS eWheels on Campus":
                date = "March 24, 2024";
                description = "Events, Fairview, General";
                imageResId = R.drawable.sss_ewheel_event_twelve;
                article = getString(R.string.article_text_event_twelve);

                spannableArticle = new SpannableString(article);
                applyBoldText(spannableArticle, "March 25, 9:00–5:00pm");
                applyBoldText(spannableArticle, "EXCLUSIVE for NCBA Fairview students only!");

                textArticle.setText(spannableArticle);
                break;

            //  EVENT 13
            case "Gifted Children Awareness Film Showing":
                date = "March 13, 2024";
                description = "College, Cubao, Events";
                imageResId = R.drawable.children_awareness_event_thirteen;
                article = getString(R.string.article_text_event_thirteen);

                textArticle.setText(article);
                break;

            //  EVENT 14
            case "PACUCOA Accreditors Visit NCBA Cubao":
                date = "Feb 29, 2024";
                description = "College, Cubao, Events";
                imageResId = R.drawable.pacucoa_event_fourteen;
                article = getString(R.string.article_text_event_fourteen);

                textArticle.setText(article);
                break;

            //  EVENT 15
            case "COP’s Livelihood Training: Make Dishwashing and Hand Soap":
                date = "November 28, 2022";
                description = "Events";
                imageResId = R.drawable.soup_event_fifteen;
                article = getString(R.string.article_text_event_fifteen);

                textArticle.setText(article);
                break;

            default:
                date = "Unknown Date";
                description = "No description available.";
                imageResId = R.drawable.redhorse; // Use a default image in case
                article = "No article available.";
                break;
        }

        titleViewDialog.setText(eventTitle);
        dateViewDialog.setText(date);
        descriptionViewDialog.setText(description);
        imageViewDialog.setImageResource(imageResId);





        LinearLayout closeButton = dialogView.findViewById(R.id.CloseButton);
        closeButton.setOnClickListener(v -> {
            alertDialog.dismiss();
        });

        // ✅ Prevent dismissing when clicking outside
        alertDialog.setCancelable(false);
        alertDialog.setCanceledOnTouchOutside(false);

        // ✅ Handle Back Button Press
        alertDialog.setOnKeyListener((dialog, keyCode, event) -> {
            if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
                alertDialog.dismiss(); // Isasara ang dialog
                return true; // Iwasan ang default back button behavior
            }
            return false;
        });

        alertDialog.show();
    }

    private void applyHashtagColor(SpannableString spannable, String hashtag, int colorResId) {
        int start = spannable.toString().indexOf(hashtag);
        if (start != -1) {
            int end = start + hashtag.length();
            spannable.setSpan(new ForegroundColorSpan(ContextCompat.getColor(requireContext(), colorResId)),
                    start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }

    private void applyBoldText(SpannableString spannable, String targetText) {
        int start = spannable.toString().indexOf(targetText);
        if (start != -1) {
            int end = start + targetText.length();
            spannable.setSpan(new StyleSpan(Typeface.BOLD), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }

}
