package com.example.android_course_ata_2023.Section0.RoomDataBase;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ProductViewModel extends AndroidViewModel {
    ProductsRepository repository;
    public ProductViewModel(@NonNull Application application) {
        super(application);
        repository = new ProductsRepository(application);
    }

    void insertProduct(Product product){
        repository.insertProduct(product);

    }


    void updateProduct(Product product){
        repository.updateProduct(product);
    }


    void deleteProduct(Product product){
        repository.deleteProduct(product);
    }


    LiveData<List<Product>> getAllProducts(){
        return repository.getAllProducts();
    }
}
