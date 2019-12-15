package com.example.myapplication.Screen;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.Model.User;
import com.example.myapplication.R;

public class DetailedFragment extends Fragment {
    private ImageView iamge;
    private TextView name, surname, email;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detailed, container, false);
        name = view.findViewById(R.id.name_detalie);
        surname = view.findViewById(R.id.surname_detalie);
        email = view.findViewById(R.id.email);
        iamge = view.findViewById(R.id.image_large);
        Bundle bundle = getArguments();
        int pos = bundle.getInt("a");
        name.setText(User.name[pos]);
        surname.setText(User.surname[pos]);
        iamge.setImageResource(User.imagepath[pos]);
        email.setText(User.email[pos]);
        return view;
    }
}
