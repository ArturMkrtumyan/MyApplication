package com.example.myapplication.Screen;

import android.os.Bundle;

import com.example.myapplication.OtherClases.BottomNavigationViewBehavior;
import com.example.myapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;


import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    SearchView searchView;
    private Button buttonchat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchView = findViewById(R.id.searchView);
        navView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        buttonchat = findViewById(R.id.chatButton);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new HomeFragment()).commit();
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navView.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationViewBehavior());
    }

    public BottomNavigationView navView;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    buttonchat.setVisibility(View.GONE);
                    searchView.setVisibility(View.VISIBLE);
                    toolbar.setVisibility(View.VISIBLE);
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.navigation_message:
                    buttonchat.setVisibility(View.GONE);
                    searchView.setVisibility(View.VISIBLE);
                    toolbar.setVisibility(View.VISIBLE);
                    selectedFragment = new MessagesFragment();
                    break;
                case R.id.navigation_account:
                    toolbar.setVisibility(View.GONE);
                    navView.setVisibility(View.GONE);
                    selectedFragment = new AccountFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, selectedFragment).addToBackStack(null).commit();
            return true;
        }
    };

}


