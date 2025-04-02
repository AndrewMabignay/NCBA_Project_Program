package com.example.ncba_project_program;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

public class AboutUsBriefHistorySubFragment extends Fragment {
    private ImageView imageView;
    private final int[] images = {
            R.drawable.doroteo,
            R.drawable.diangco,
            R.drawable.gloria,
            R.drawable.sarabia,
            R.drawable.torres
    };
    private int currentIndex = 0;
    private Handler handler;
    private Runnable runnable;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.about_us_brief_history_submenu_subfragment, container, false);
        handler = new Handler();
        AddElement(view);
        return view;
    }

    private void AddElement(View view) {
        imageView = view.findViewById(R.id.ImagingSwitcher);
        if (imageView != null) {
            setRoundedImage();

            handler.postDelayed(this::startImageTransition, 1500);

            // Hover effect (Opacity + Scale)
            imageView.setOnTouchListener((v, event) -> {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        imageView.setAlpha(0.7f);
                        imageView.setScaleX(1.1f);
                        imageView.setScaleY(1.1f);
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        imageView.setAlpha(1f);
                        imageView.setScaleX(1f);
                        imageView.setScaleY(1f);
                        break;
                }
                return false;
            });

            // Click event para sa Image Dialog
            imageView.setOnClickListener(v -> showImageDialog());
        }
    }

    private void showImageDialog() {
        if (getContext() == null || getActivity() == null) return;

        handler.removeCallbacks(runnable);

        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.about_us_brief_history_image_dialog_submenu, null);
        builder.setView(dialogView);

        ViewPager2 viewPager = dialogView.findViewById(R.id.imageViewPagerBriefHistory);
        ImagePageAdapter adapter = new ImagePageAdapter(requireContext(), images);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(currentIndex, false);





        AlertDialog dialog = builder.create();
        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(android.graphics.Color.TRANSPARENT));
        }

        dialog.setOnDismissListener(dialogInterface -> {
            handler.post(runnable);
        });

        dialog.show();
    }

    private void startImageTransition() {
        runnable = () -> {
            if (imageView == null) return;

            AlphaAnimation fadeOut = new AlphaAnimation(1.0f, 0.0f);
            fadeOut.setDuration(500);
            fadeOut.setFillAfter(true);
            imageView.startAnimation(fadeOut);

            handler.postDelayed(() -> {
                currentIndex = (currentIndex + 1) % images.length;
                setRoundedImage();

                AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
                fadeIn.setDuration(500);
                fadeIn.setFillAfter(true);
                imageView.startAnimation(fadeIn);

                handler.postDelayed(runnable, 3000);
            }, 500);
        };

        handler.postDelayed(runnable, 1500);
    }

    private void setRoundedImage() {
        if (imageView == null || getContext() == null) return;

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), images[currentIndex]);

        if (bitmap != null) {
            RoundedBitmapDrawable roundedDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
            roundedDrawable.setCornerRadius(30f);
            roundedDrawable.setAntiAlias(true);

            imageView.setImageDrawable(roundedDrawable);

            // Ensure the image fills the ImageView properly
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }


//    private void showImageDialog() {
//        if (getContext() == null || getActivity() == null) return;
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
//        LayoutInflater inflater = getLayoutInflater();
//        View dialogView = inflater.inflate(R.layout.about_us_brief_history_image_dialog_submenu, null);
//        builder.setView(dialogView);
//
//        ImageView dialogImageView = dialogView.findViewById(R.id.dialogImageView);
//        if (dialogImageView != null) {
//            dialogImageView.setImageResource(images[currentIndex]);
//        }
//
//        AlertDialog dialog = builder.create();
//        dialog.show();
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (handler != null && runnable != null) {
            handler.removeCallbacks(runnable);
        }
    }
}
