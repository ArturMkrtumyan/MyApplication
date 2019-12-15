package com.example.myapplication.Screen;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class AccountFragment extends Fragment {
    BottomNavigationView bottomNavigationView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        bottomNavigationView = getActivity().findViewById(R.id.nav_view);
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        bottomNavigationView.setVisibility(View.VISIBLE);

    }
}
