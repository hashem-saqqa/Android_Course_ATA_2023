package com.example.android_course_ata_2023.Section101.TabLayoutWithViewPager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android_course_ata_2023.R;
import com.example.android_course_ata_2023.databinding.FragmentCategoryBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CategoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CategoryFragment extends Fragment {

    private static final String ARG_CAT_NAME = "catName";


    private String catName;

    public CategoryFragment() {
        // Required empty public constructor
    }


    public static CategoryFragment newInstance(String catName) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CAT_NAME, catName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            catName = getArguments().getString(ARG_CAT_NAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentCategoryBinding binding = FragmentCategoryBinding
                .inflate(inflater, container, false);

        if (catName != null)
            binding.catNameTv.setText(catName);

        return binding.getRoot();
    }
}