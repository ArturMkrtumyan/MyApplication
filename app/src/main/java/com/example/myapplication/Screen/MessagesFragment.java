package com.example.myapplication.Screen;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.Adapters.MessagesAdapter;
import com.example.myapplication.Model.UserMessage;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class MessagesFragment extends Fragment {
    List<UserMessage> userMessages;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userMessages = new ArrayList<>();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_messages, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.message_recyclerVie);
        MessagesAdapter adapter = new MessagesAdapter(getActivity(), userMessages);
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        //  userMessages.add(new UserMessage(User.name[pos],User.imagepath[pos]));
        return view;
    }

}
