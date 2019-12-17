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
import com.example.myapplication.Model.Singleton;
import com.example.myapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class ChattingFragment extends Fragment {
    private BottomNavigationView bottomNavigationView;
    private EditText editText;
    private Button sendMessage;
    private List<String> messages;
    private List<String> allmessages;
    private ChatAdapter adapter;
    private Singleton singleton;
    private boolean messagesIsNull;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        messages = new ArrayList<>();
        singleton = Singleton.getInstance();
        messagesIsNull = true;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chatting, container, false);
        final RecyclerView recyclerView = view.findViewById(R.id.chat_recyclerView);
        final int pos = getArguments().getInt("position");
        allmessages = singleton.getUsersList().get(pos).getAllmessage();
        if (allmessages != null) {
            adapter = new ChatAdapter(allmessages);
            messagesIsNull = false;
        } else {
            adapter = new ChatAdapter(messages);
        }
        bottomNavigationView = getActivity().findViewById(R.id.nav_view);
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        ((LinearLayoutManager) layoutManager).setStackFromEnd(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        editText = view.findViewById(R.id.editText);
        sendMessage = view.findViewById(R.id.send);


        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!messagesIsNull) {
                    allmessages.add(editText.getText().toString());
                    singleton.getUsersList().get(pos).setAllmessage(allmessages);
                } else {
                    messages.add(editText.getText().toString());
                    singleton.getUsersList().get(pos).setAllmessage(messages);
                }
                adapter.notifyDataSetChanged();
            }
        });
        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        bottomNavigationView.setVisibility(View.VISIBLE);
    }
}
