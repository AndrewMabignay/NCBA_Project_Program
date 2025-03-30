package com.example.ncba_project_program;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class EventItemFragment extends Fragment {
    private static final String ARG_TITLE = "title";
    private static final String ARG_DESCRIPTION = "description";
    private static final String ARG_IMAGE_RES_ID = "imageResId";

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

        if (getArguments() != null) {
            titleText.setText(getArguments().getString(ARG_TITLE, "No Title"));
            descriptionText.setText(getArguments().getString(ARG_DESCRIPTION, "No Description"));
            eventImage.setImageResource(getArguments().getInt(ARG_IMAGE_RES_ID, R.drawable.bg_dialog));
        }
    }
}
