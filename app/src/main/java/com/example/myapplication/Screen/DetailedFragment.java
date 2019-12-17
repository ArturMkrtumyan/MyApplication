package com.example.myapplication.Screen;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.Model.Singleton;
import com.example.myapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DetailedFragment extends Fragment {
    private ImageView iamge;
    private TextView name, surname, email;
    private Button openchat;
    private BottomNavigationView navView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detailed, container, false);
        name = view.findViewById(R.id.name_detalie);
        surname = view.findViewById(R.id.surname_detalie);
        email = view.findViewById(R.id.email);
        iamge = view.findViewById(R.id.image_large);
        openchat = getActivity().findViewById(R.id.chatButton);
        navView = getActivity().findViewById(R.id.nav_view);
        Bundle bundle = getArguments();
        final int pos = bundle.getInt("a");
        openchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("position", pos);
                ChattingFragment chattingFragment = new ChattingFragment();
                chattingFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_container, chattingFragment).addToBackStack(null).commit();
                navView.setVisibility(View.GONE);
            }
        });
        Singleton singleton = Singleton.getInstance();
        name.setText(singleton.getUsersList().get(pos).getName());
        surname.setText(singleton.getUsersList().get(pos).getSurname());
        iamge.setImageResource(singleton.getUsersList().get(pos).getImagePath());
        return view;
    }

}
