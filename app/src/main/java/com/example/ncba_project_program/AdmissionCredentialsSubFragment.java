package com.example.ncba_project_program;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.util.Log; // Import this at the top

import androidx.fragment.app.Fragment;

public class AdmissionCredentialsSubFragment extends Fragment  {
    private TextView torFirstStatement;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.admission_credentials_subfragment, container, false);
        AddElement(view);
        AddInteraction();
        return view;
    }



    private void AddElement(View view) {
        torFirstStatement = view.findViewById(R.id.FirstStatementCredential);
        String[] stepsArray = getResources().getStringArray(R.array.credentialsFirstStatementArray);

        if (stepsArray.length == 0) {
            Log.d("DebugCheck", "String array is empty!");
        }

        StringBuilder formattedText = new StringBuilder();
        for (String step : stepsArray) {
            formattedText.append(step).append("\n\n");
        }

        torFirstStatement.setText(formattedText.toString());
    }


    private void AddInteraction() {

    }
}
