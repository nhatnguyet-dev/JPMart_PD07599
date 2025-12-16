package com.example.jpmart_pd07599_v1.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.jpmart_pd07599_v1.R;

public class MainStaffActivity extends AppCompatActivity {
    private LinearLayout btnProducts, btnCustomers, btnOrders, btnCategories
            , btnStaff, btnChangePassword;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_nhanvien);

        btnProducts = findViewById(R.id.btnProducts);
        btnCustomers = findViewById(R.id.btnCustomers);
        btnOrders = findViewById(R.id.btnOrders);
        btnCategories = findViewById(R.id.btnCategories);
        btnStaff = findViewById(R.id.btnStaff);
        btnChangePassword = findViewById(R.id.btnChangePasswords);
        toolbar = findViewById(R.id.toolbar);

        btnProducts.setOnClickListener(v->{
            startActivity(new Intent(MainStaffActivity.this, ProductsActivity.class));
        });

        btnCustomers.setOnClickListener(v->{
            startActivity(new Intent(MainStaffActivity.this, CustomersActivity.class));
        });

        btnOrders.setOnClickListener(v->{
            startActivity(new Intent(MainStaffActivity.this, OrdersActivity.class));
        });

        btnCategories.setOnClickListener(v->{
            startActivity(new Intent(MainStaffActivity.this, CategoriesActivity.class));
        });

        btnStaff.setOnClickListener(v->{
            startActivity(new Intent(MainStaffActivity.this, StaffActivity.class));
        });

        btnChangePassword.setOnClickListener(v->{
            startActivity(new Intent(MainStaffActivity.this, ChangePasswordActivity.class));
        });

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Home");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(v->{
            onBackPressed();
        });
    }
}
