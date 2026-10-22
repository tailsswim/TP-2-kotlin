
package com.example.tp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class FragmentB extends Fragment {

    private SharedViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        return inflater.inflate(
                R.layout.fragment_b,
                container,
                false
        );
    }

    @Override
    public void onViewCreated(
            @NonNull View view,
            @Nullable Bundle savedInstanceState) {

        TextView textReceived =
                view.findViewById(R.id.text_received);

        viewModel = new ViewModelProvider(
                requireActivity()
        ).get(SharedViewModel.class);

        viewModel.getMessage().observe(
                getViewLifecycleOwner(),
                message -> textReceived.setText(message)
        );
    }
}
