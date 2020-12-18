package com.example.eventbusexample.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.eventbusexample.Events.MessageEvent;
import com.example.eventbusexample.R;

import org.greenrobot.eventbus.EventBus;
import org.w3c.dom.Text;

public class SenderFragment extends Fragment {

    public EditText editText;
    Button button;
    String message;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sender_fragment_layout,container,false);
        editText = view.findViewById(R.id.editText);
        button = view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message = editText.getText().toString();
                MessageEvent event = new MessageEvent();
                event.setMessage(message);
                EventBus.getDefault().post(event);
            }
        });
        return view;
    }



}
