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

public class FirstSubscriberFragment extends Fragment {

    TextView firstTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_subscriber_fragment,container,false);
        EventBus.getDefault().register(this);
        firstTextView = view.findViewById(R.id.firstTextView);
        return view;
    }

    @Subscribe
    public void onEvent(MessageEvent event){
        firstTextView.setText(event.getMessage());
    }
}
