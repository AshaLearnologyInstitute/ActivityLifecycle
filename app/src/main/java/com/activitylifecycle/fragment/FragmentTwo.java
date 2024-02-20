package com.activitylifecycle.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.activitylifecycle.MainActivity;
import com.activitylifecycle.R;
import com.activitylifecycle.ViewPagerIndActivity;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentTwo extends Fragment {

    TextView txtData;
    Button nextAct;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_two, container, false);
        return rootView;

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

    public void displayReceivedData(String message){
        txtData.setText("Data received: "+message);
//        Toast.makeText(getContext(),message,Toast.LENGTH_LONG).show();
    }

}