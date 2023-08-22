package com.example.android_course_ata_2023.Section101.FragmentDialogs;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import com.example.android_course_ata_2023.R;
import com.example.android_course_ata_2023.databinding.ActivityAllCarsBinding;

import java.util.ArrayList;

public class AllCarsActivity extends AppCompatActivity implements OnCarItemListener {
    ActivityAllCarsBinding binding;
    ArrayList<Car> cars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAllCarsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        cars = new ArrayList<>();
        cars.add(new Car(1, "BMW", "White", "2020"));
        cars.add(new Car(2, "Mercedes", "Black", "2022"));
        cars.add(new Car(3, "S-class", "yellow", "2021"));

        AllCarsAdapter adapter = new AllCarsAdapter(cars, this);
        binding.allCarsRV.setAdapter(adapter);
        binding.allCarsRV.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onEdit(int pos) {
        Car c = cars.get(pos);
        CarsDialogFragment customDialog =  CarsDialogFragment
                .newInstance(true,c.getName(),c.getColor(),c.getYear());
        customDialog.show(getSupportFragmentManager(),"dialog");
    }

    @Override
    public void onDelete(int pos) {
        CarsDialogFragment customDialog = CarsDialogFragment
                .newInstance(false,"r u sure u wanna delete this car?");
        customDialog.show(getSupportFragmentManager(),"dialog");
    }
}