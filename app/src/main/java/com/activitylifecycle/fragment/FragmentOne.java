package com.activitylifecycle.fragment;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.activitylifecycle.R;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentOne extends Fragment {

    SendMessage sendMessage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_one, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sendMessage= (SendMessage) getActivity();
        Button btnPassData = view.findViewById(R.id.btnPassData);
        EditText inData = view.findViewById(R.id.inMessage);
        btnPassData.setOnClickListener(v -> {
            sendMessage.sendData(inData.getText().toString().trim());
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    public interface SendMessage {
        void sendData(String message);
    }
}