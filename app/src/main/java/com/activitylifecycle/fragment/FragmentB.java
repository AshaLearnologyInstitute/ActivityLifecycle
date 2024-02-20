package com.activitylifecycle.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.activitylifecycle.R;
import com.activitylifecycle.ViewPagerIndActivity;
import com.activitylifecycle.model.TextChangedEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentB extends Fragment {

    TextView txtData;
    Button nextAct;
    EventBus bus;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_two, container, false);

        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bus = EventBus.getDefault();
        //Register to EventBus
        bus.register(this);
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txtData = view.findViewById(R.id.txtData);
        nextAct= view.findViewById(R.id.nextAct);
        nextAct.setOnClickListener(view1 -> {
            Intent nextAct=new Intent(getActivity(), ViewPagerIndActivity.class);
            startActivity(nextAct);
        });
    }

    @Subscribe
    public void onEvent(TextChangedEvent event) {
        txtData.setText(event.newText);
    }

}