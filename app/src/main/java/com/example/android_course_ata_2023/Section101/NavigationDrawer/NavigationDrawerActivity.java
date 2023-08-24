package com.example.android_course_ata_2023.Section101.NavigationDrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.android_course_ata_2023.R;
import com.example.android_course_ata_2023.databinding.ActivityNavigationDrawerBinding;
import com.google.android.material.navigation.NavigationView;

public class NavigationDrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ActivityNavigationDrawerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNavigationDrawerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolBar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this
                , binding.drawerLayout, binding.toolBar, R.string.open_drawer_text, R.string.close_drawer_text);

        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportFragmentManager().beginTransaction().add(R.id.fragmentsContainer,
                NavigationDrawerFragment.newInstance("Home")).commit();


        binding.navigationView.setCheckedItem(R.id.homeItem);

        binding.navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.homeItem) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentsContainer,
                    NavigationDrawerFragment.newInstance("Home")).commit();
            binding.navigationView.setCheckedItem(R.id.homeItem);
            binding.drawerLayout.closeDrawer(GravityCompat.START);

        } else if (item.getItemId() == R.id.settingsItem) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentsContainer,
                    NavigationDrawerFragment.newInstance("Settings")).commit();
            binding.navigationView.setCheckedItem(R.id.settingsItem);
            binding.drawerLayout.closeDrawer(GravityCompat.START);


        } else if (item.getItemId() == R.id.aboutUsItem) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentsContainer,
                    NavigationDrawerFragment.newInstance("About us")).commit();
            binding.navigationView.setCheckedItem(R.id.aboutUsItem);
            binding.drawerLayout.closeDrawer(GravityCompat.START);

        } else if (item.getItemId() == R.id.logoutItem) {
            Toast.makeText(this, "Logout successfully", Toast.LENGTH_SHORT).show();
            binding.drawerLayout.closeDrawer(GravityCompat.START);

        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}