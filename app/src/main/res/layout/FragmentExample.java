
package com.example.tp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentExample extends Fragment {

    // Interface for sending a message to the Activity
    public interface MessageListener {
        void onMessageReceived(String message);
    }

    private MessageListener listener;

    // Receive data from the Activity using a Bundle
    public static FragmentExample newInstance(String message) {
        FragmentExample fragment = new FragmentExample();

        Bundle bundle = new Bundle();
        bundle.putString("msg", message);

        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {

        return inflater.inflate(
                R.layout.fragment_example,
                container,
                false
        );
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof MessageListener) {
            listener = (MessageListener) context;
        }
    }

    @Override
    public void onViewCreated(
            @NonNull View view,
            @Nullable Bundle savedInstanceState) {

        TextView textView = view.findViewById(R.id.text_message);
        Button button = view.findViewById(R.id.btn_send);

        Bundle bundle = getArguments();

        if (bundle != null) {
            textView.setText(bundle.getString("msg"));
        }

        button.setOnClickListener(v -> {
            if (listener != null) {
                listener.onMessageReceived("Bonjour Activity !");
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
