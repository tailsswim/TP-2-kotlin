
package com.example.tp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class FragmentA extends Fragment {

    private SharedViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        return inflater.inflate(
                R.layout.fragment_a,
                container,
                false
        );
    }

    @Override
    public void onViewCreated(
            @NonNull View view,
            @Nullable Bundle savedInstanceState) {

        EditText editMessage =
                view.findViewById(R.id.edit_message);

        Button button =
                view.findViewById(R.id.btn_send);

        viewModel = new ViewModelProvider(
                requireActivity()
        ).get(SharedViewModel.class);

        button.setOnClickListener(v -> {
            String text = editMessage.getText().toString().trim();

            if (text.isEmpty()) {
                Toast.makeText(
                        requireContext(),
                        "Entrez un message",
                        Toast.LENGTH_SHORT
                ).show();
            } else {
                viewModel.setMessage(text);
                editMessage.setText("");
            }
        });
    }
}
