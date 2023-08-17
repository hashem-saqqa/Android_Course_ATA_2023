package com.example.android_course_ata_2023.Section101.Fragments_Part2;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android_course_ata_2023.R;
import com.example.android_course_ata_2023.databinding.FragmentInsertName2Binding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InsertNameFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InsertNameFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private OnFragmentActionListener listener;

    private String mParam1;
    private String mParam2;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentActionListener)
            listener = (OnFragmentActionListener) context;
    }

    public InsertNameFragment() {
        // Required empty public constructor
    }

    public static InsertNameFragment newInstance(String param1, String param2) {
        InsertNameFragment fragment = new InsertNameFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentInsertName2Binding binding = FragmentInsertName2Binding
                .inflate(inflater, container, false);
//        listener = (OnFragmentActionListener) requireContext();
        binding.insertBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.nameEt.getText().toString();
                listener.onNameInserted(name);
//                getActivity().getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.fragmentsContainer2, ViewNameFragment.newInstance(name)).commit();
            }
        });
        return binding.getRoot();
    }
}