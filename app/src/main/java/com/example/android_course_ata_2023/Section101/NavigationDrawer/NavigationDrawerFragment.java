package com.example.android_course_ata_2023.Section101.NavigationDrawer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.android_course_ata_2023.databinding.FragmentBottomNavigationBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NavigationDrawerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NavigationDrawerFragment extends Fragment {


    private static final String ARG_FRAGMENT_NAME = "fragmentName";

    private String fragmentName;

    public NavigationDrawerFragment() {
        // Required empty public constructor
    }

    public static NavigationDrawerFragment newInstance(String ss) {
        NavigationDrawerFragment fragment = new NavigationDrawerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_FRAGMENT_NAME, ss);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            fragmentName = getArguments().getString(ARG_FRAGMENT_NAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentBottomNavigationBinding binding = FragmentBottomNavigationBinding.inflate(inflater);
        if (fragmentName != null) binding.fragmentNameTv.setText(fragmentName);

        return binding.getRoot();
    }
}