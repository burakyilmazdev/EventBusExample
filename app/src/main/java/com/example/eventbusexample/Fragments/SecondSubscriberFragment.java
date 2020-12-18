package com.example.eventbusexample.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.eventbusexample.Events.MessageEvent;
import com.example.eventbusexample.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class SecondSubscriberFragment extends Fragment {

    TextView secondTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_subscriber_fragment,container,false);
        secondTextView = view.findViewById(R.id.secondTextView);
        EventBus.getDefault().register(this);
        return view;
    }

    @Subscribe
    public void onEvent(MessageEvent event){
        secondTextView.setText(event.getMessage());
    }
}
