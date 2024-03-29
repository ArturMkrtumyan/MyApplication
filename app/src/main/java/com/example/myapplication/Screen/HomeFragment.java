package com.example.myapplication.Screen;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.Adapters.HomeAdapter;
import com.example.myapplication.Model.Singleton;
import com.example.myapplication.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    public HomeAdapter adapter;
    RecyclerView recyclerView;
    Singleton singleton;
    ArrayList users;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.home_recyclerVie);
        singleton = Singleton.getInstance();
        users = singleton.getUsersList();
        adapter = new HomeAdapter(users);
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        setHasOptionsMenu(true);
        adapter.setOnItemClickListener(new HomeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                DetailedFragment detailedFragment = new DetailedFragment();
                getFragmentManager().beginTransaction().replace(R.id.frame_container, detailedFragment).addToBackStack(null).commit();
                Bundle bundle = new Bundle();
                bundle.putInt("a", position);
                detailedFragment.setArguments(bundle);
                getActivity().findViewById(R.id.chatButton).setVisibility(View.VISIBLE);
                getActivity().findViewById(R.id.searchView).setVisibility(View.GONE);
            }
        });
        return view;
    }

}
