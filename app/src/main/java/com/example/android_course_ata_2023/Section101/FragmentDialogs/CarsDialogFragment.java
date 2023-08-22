package com.example.android_course_ata_2023.Section101.FragmentDialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.android_course_ata_2023.R;
import com.example.android_course_ata_2023.databinding.FragmentCarsDialogBinding;

public class CarsDialogFragment extends DialogFragment {

    private static final String ARG_DIALOG_TYPE = "dialogType";
    private static final String ARG_CAR_NAME = "carName";
    private static final String ARG_CAR_COLOR = "carColor";
    private static final String ARG_CAR_YEAR = "carYear";
    private static final String ARG_DELETE_MSG = "deleteMsg";


    private boolean dialogType;
    private String carName;
    private String carColor;
    private String carYear;
    private String deleteMsg;

    public CarsDialogFragment() {
        // Required empty public constructor
    }


    public static CarsDialogFragment newInstance(boolean dialogType, String carName, String carColor, String carYear) {
        CarsDialogFragment fragment = new CarsDialogFragment();
        Bundle args = new Bundle();
        args.putBoolean(ARG_DIALOG_TYPE, dialogType);
        args.putString(ARG_CAR_NAME, carName);
        args.putString(ARG_CAR_COLOR, carColor);
        args.putString(ARG_CAR_YEAR, carYear);
        fragment.setArguments(args);
        return fragment;
    }
    public static CarsDialogFragment newInstance(boolean dialogType,  String deleteMsg) {
        CarsDialogFragment fragment = new CarsDialogFragment();
        Bundle args = new Bundle();
        args.putBoolean(ARG_DIALOG_TYPE, dialogType);
        args.putString(ARG_DELETE_MSG, deleteMsg);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            dialogType = getArguments().getBoolean(ARG_DIALOG_TYPE);
            carName = getArguments().getString(ARG_CAR_NAME);
            carColor = getArguments().getString(ARG_CAR_COLOR);
            carYear = getArguments().getString(ARG_CAR_YEAR);
            deleteMsg = getArguments().getString(ARG_DELETE_MSG);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentCarsDialogBinding binding = FragmentCarsDialogBinding
                .inflate(inflater, container, false);
        binding.carNameEt.setText(carName);
        binding.carColorEt.setText(carColor);
        binding.carYearEt.setText(carYear);
        return binding.getRoot();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        if (!dialogType) {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(requireContext());
            alertDialog.setTitle("Delete Dialog");
            alertDialog.setMessage(deleteMsg);
            alertDialog.setIcon(R.drawable.cancel_icon);
            alertDialog.setPositiveButton("Yes", (dialogInterface, i) -> {

            });
            alertDialog.setNegativeButton("No", (dialogInterface, i) -> {

            });
//        alertDialog.show();
            return alertDialog.create();
        }

        return super.onCreateDialog(savedInstanceState);

    }

    @Override
    public void onStart() {
        super.onStart();
        getDialog().getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
    }
}