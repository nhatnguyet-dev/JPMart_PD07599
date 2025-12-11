package com.example.jpmart_pd07599_v1.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.jpmart_pd07599_v1.R;

public class MainActivity extends AppCompatActivity {

    private LinearLayout btnDoanhThu, btnTopProducts, btnTopCustomers
            , btnProducts, btnCustomers, btnOrders, btnCategories
            , btnStaff, btnChangePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDoanhThu = findViewById(R.id.btndoanhThu);
        btnTopProducts = findViewById(R.id.btnTopProducts);
        btnTopCustomers = findViewById(R.id.btnTopCustomers);
        btnProducts = findViewById(R.id.btnProducts);
        btnCustomers = findViewById(R.id.btnCustomers);
        btnOrders = findViewById(R.id.btnOrders);
        btnCategories = findViewById(R.id.btnCategories);
        btnStaff = findViewById(R.id.btnStaff);
        btnChangePassword = findViewById(R.id.btnChangePasswords);

        btnDoanhThu.setOnClickListener(v->{
            startActivity(new Intent(MainActivity.this, VenueActivity.class));
        });

        btnTopProducts.setOnClickListener(v->{
            startActivity(new Intent(MainActivity.this, TopProductsActivity.class));
        });

        btnTopCustomers.setOnClickListener(v->{
            startActivity(new Intent(MainActivity.this, TopCustomersActivity.class));
        });

        btnProducts.setOnClickListener(v->{
            startActivity(new Intent(MainActivity.this, ProductsActivity.class));
        });

        btnCustomers.setOnClickListener(v->{
            startActivity(new Intent(MainActivity.this, CustomersActivity.class));
        });

        btnOrders.setOnClickListener(v->{
            startActivity(new Intent(MainActivity.this, OrdersActivity.class));
        });

        btnCategories.setOnClickListener(v->{
            startActivity(new Intent(MainActivity.this, CategoriesActivity.class));
        });

        btnStaff.setOnClickListener(v->{
            startActivity(new Intent(MainActivity.this, StaffActivity.class));
        });

        btnChangePassword.setOnClickListener(v->{
            startActivity(new Intent(MainActivity.this, ChangePasswordActivity.class));
        });

    }
}