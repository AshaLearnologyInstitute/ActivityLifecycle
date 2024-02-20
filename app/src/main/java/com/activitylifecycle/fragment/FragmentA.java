package com.activitylifecycle.fragment;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.activitylifecycle.R;
import com.activitylifecycle.model.TextChangedEvent;

import org.greenrobot.eventbus.EventBus;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentA extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_one, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EventBus bus = EventBus.getDefault();

        Button btnPassData = view.findViewById(R.id.btnPassData);
        EditText inData = view.findViewById(R.id.inMessage);
        btnPassData.setOnClickListener(v -> {
            bus.post(new TextChangedEvent(inData.getText().toString().trim()));
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

}