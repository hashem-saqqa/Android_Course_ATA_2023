package com.example.android_course_ata_2023.Section101.Fragments_Part2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android_course_ata_2023.databinding.FragmentViewName2Binding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ViewNameFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewNameFragment extends Fragment {

    private static final String ARG_NAME = "name";

    private String name;

    public ViewNameFragment() {
        // Required empty public constructor
    }

    public static ViewNameFragment newInstance(String name) {
        ViewNameFragment fragment = new ViewNameFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(ARG_NAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentViewName2Binding binding = FragmentViewName2Binding
                .inflate(inflater,container,false);
        if (name != null){
            binding.nameTv.setText(name);
        }
        return binding.getRoot();
    }
}