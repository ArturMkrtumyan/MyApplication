package com.example.myapplication.Screen;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.Adapters.ChatAdapter;
import com.example.myapplication.Model.ChatMessage;
import com.example.myapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class ChattingFragment extends Fragment {
    private BottomNavigationView bottomNavigationView;
    private EditText message;
    private Button sendMessage;
    private List<ChatMessage> messages;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        messages = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chatting, container, false);
        final RecyclerView recyclerView = view.findViewById(R.id.chat_recyclerView);
        ChatAdapter adapter = new ChatAdapter(getActivity(), messages);
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        ((LinearLayoutManager) layoutManager).setStackFromEnd(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        message = view.findViewById(R.id.editText);
        sendMessage = view.findViewById(R.id.send);


        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (messages != null) {
                    String massage = message.getText().toString();
                    messages.add(new ChatMessage(massage));
                }
            }
        });
        bottomNavigationView = getActivity().findViewById(R.id.nav_view);
        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        bottomNavigationView.setVisibility(View.VISIBLE);
    }
}
