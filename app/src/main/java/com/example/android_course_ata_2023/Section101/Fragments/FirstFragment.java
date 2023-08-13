package com.example.android_course_ata_2023.Section101.Fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android_course_ata_2023.R;
import com.example.android_course_ata_2023.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    String name;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = getArguments();
        if (b != null)
            name = b.getString("studentName");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        FragmentFirstBinding binding = FragmentFirstBinding
                .inflate(inflater, container, false);
        if (name != null)
            binding.nameTv.setText(name);
        return binding.getRoot();

    }
}