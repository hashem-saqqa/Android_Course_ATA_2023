package com.example.android_course_ata_2023.Section0.RoomDataBase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.android_course_ata_2023.R;
import com.example.android_course_ata_2023.databinding.ActivityProductsViewRoomBinding;

public class ProductsViewRoomActivity extends AppCompatActivity {
ActivityProductsViewRoomBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductsViewRoomBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ProductViewModel viewModel = new ViewModelProvider(this).get(ProductViewModel.class);


        binding.addBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.insertProduct(new Product("Car",50));
            }
        });
    }
}