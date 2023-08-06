package com.example.android_course_ata_2023.Section0.RoomDataBase;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public class ProductsRepository {
    private ProductDao productDao;

    public ProductsRepository(Application application) {
        ProductsDatabase database = ProductsDatabase.getDatabase(application);
        productDao = database.productDao();
    }

    void insertProduct(Product product){
        ProductsDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                productDao.insertProduct(product);
            }
        });

    }


    void updateProduct(Product product){
        ProductsDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                productDao.updateProduct(product);
            }
        });
    }


    void deleteProduct(Product product){
        ProductsDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                productDao.deleteProduct(product);
            }
        });
    }


    LiveData<List<Product>> getAllProducts(){
       return productDao.getAllProducts();
    }
}
