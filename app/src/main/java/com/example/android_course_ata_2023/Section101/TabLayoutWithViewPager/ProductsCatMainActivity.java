package com.example.android_course_ata_2023.Section101.TabLayoutWithViewPager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.android_course_ata_2023.R;
import com.example.android_course_ata_2023.databinding.ActivityProductsCatMainBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class ProductsCatMainActivity extends AppCompatActivity {
    ActivityProductsCatMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductsCatMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<String> categories = new ArrayList<>();
        categories.add("home tools");
        categories.add("electronics");
        categories.add("Clothes");
        categories.add("Testing");

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(CategoryFragment.newInstance("home tools"));
        fragments.add(CategoryFragment.newInstance("electronics"));
        fragments.add(CategoryFragment.newInstance("Clothes"));


        binding.categoriesVp.setAdapter(new
                CategoryAdapter(this,fragments));

       new TabLayoutMediator(binding.categoriesTl, binding.categoriesVp,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        tab.setText(categories.get(position));
                    }
                }).attach();

        binding.categoriesVp.setCurrentItem(2);
    }
}