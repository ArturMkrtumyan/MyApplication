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
import com.example.myapplication.Model.Singleton;
import com.example.myapplication.Model.User;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class MessagesFragment extends Fragment {
    private Singleton singleton;
    private List<User> users;
    private ArrayList<Integer> usersID;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        singleton = Singleton.getInstance();
        users = new ArrayList<>();
        usersID = new ArrayList<>();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_messages, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.message_recyclerVie);
        MessagesAdapter adapter = new MessagesAdapter(users);
        for (int i = 0; i < singleton.getUsersList().size(); i++) {
            if (singleton.getUsersList().get(i).getAllmessage() != null) {
                User user = singleton.getUsersList().get(i);
                users.add(user);
                usersID.add(user.getId());
            }

        }
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        adapter.setOnItemClickListener(new MessagesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Bundle bundle = new Bundle();
                int id = usersID.get(position);
                bundle.putInt("position", id);
                ChattingFragment chatFragment = new ChattingFragment();
                chatFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_container, chatFragment).commit();
            }
        });
        return view;
    }
}
