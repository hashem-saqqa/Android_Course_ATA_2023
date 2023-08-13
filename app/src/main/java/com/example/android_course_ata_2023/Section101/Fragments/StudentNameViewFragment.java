package com.example.android_course_ata_2023.Section101.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android_course_ata_2023.R;
import com.example.android_course_ata_2023.databinding.FragmentStudentNameViewBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StudentNameViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StudentNameViewFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // TODO : return here if u get the data from the api
    // TODO: 13/08/2023 8762348743 fd
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_NAME = "studentName";

    // TODO: Rename and change types of parameters
    private String name;

    public StudentNameViewFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static StudentNameViewFragment newInstance(String n_name) {
        StudentNameViewFragment fragment = new StudentNameViewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, n_name);
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
        // Inflate the layout for this fragment
        FragmentStudentNameViewBinding binding = FragmentStudentNameViewBinding
                .inflate(inflater, container, false);

        if (name != null)
            binding.nameTv.setText(name);

        return binding.getRoot();
    }
}