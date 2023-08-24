package com.example.android_course_ata_2023.Section101.BottomNavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.android_course_ata_2023.R;
import com.example.android_course_ata_2023.databinding.ActivityBottomNavigationBinding;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class BottomNavigationActivity extends AppCompatActivity {
    ActivityBottomNavigationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBottomNavigationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(BottomNavigationFragment.newInstance("Home"));
        fragments.add(BottomNavigationFragment.newInstance("Search"));
        fragments.add(BottomNavigationFragment.newInstance("Profile"));

        binding.viewPager.setAdapter(new MyViewPagerAdapter(this,fragments));


//        getSupportFragmentManager().beginTransaction().add(R.id.fragmentsContainer,
//                BottomNavigationFragment.newInstance("Home")).commit();



        binding.bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.homeItem){
                  binding.viewPager.setCurrentItem(0);
                } else if (item.getItemId() == R.id.searchItem) {
                    binding.viewPager.setCurrentItem(1);
                } else if (item.getItemId() == R.id.profileItem) {
                   binding.viewPager.setCurrentItem(2);
                }
                return true;
            }
        });
        binding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    binding.bottomNavigationView.setSelectedItemId(R.id.homeItem);
                } else if (position == 1) {
                    binding.bottomNavigationView.setSelectedItemId(R.id.searchItem);
                } else if (position == 2) {
                    binding.bottomNavigationView.setSelectedItemId(R.id.profileItem);
                }
                super.onPageSelected(position);
            }
        });
//        binding.bottomNavigationView.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
//            @Override
//            public void onNavigationItemReselected(@NonNull MenuItem item) {
//
//            }
//        });
    }
}