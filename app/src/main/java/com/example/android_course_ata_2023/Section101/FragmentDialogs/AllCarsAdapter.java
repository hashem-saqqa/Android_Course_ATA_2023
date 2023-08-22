package com.example.android_course_ata_2023.Section101.FragmentDialogs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_course_ata_2023.databinding.ItemMyCarBinding;

import java.util.ArrayList;

public class AllCarsAdapter extends RecyclerView.Adapter<AllCarsAdapter.AllCarsViewHolder> {
    ArrayList<Car> cars;
    OnCarItemListener listener;

    public AllCarsAdapter(ArrayList<Car> cars, OnCarItemListener listener) {
        this.cars = cars;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AllCarsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMyCarBinding b = ItemMyCarBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);

        return new AllCarsViewHolder(b);
    }

    @Override
    public void onBindViewHolder(@NonNull AllCarsViewHolder holder, int position) {
        int i = position;
        Car c = cars.get(i);
        holder.carName.setText(c.getName());
        holder.carColor.setText(c.getColor());
        holder.carYear.setText(c.getYear());
        holder.editIcon.setOnClickListener(view -> {
            listener.onEdit(i);
        });
        holder.deleteIcon.setOnClickListener(view -> {
            listener.onDelete(i);
        });

    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    class AllCarsViewHolder extends RecyclerView.ViewHolder {
        TextView carName, carColor, carYear;
        ImageView editIcon, deleteIcon;
        public AllCarsViewHolder(ItemMyCarBinding binding) {
            super(binding.getRoot());
            carName = binding.carNameTv;
            carColor = binding.carColorTv;
            carYear = binding.carYearTv;
            editIcon = binding.editIcon;
            deleteIcon = binding.deleteIcon;

        }
    }
}
