package com.example.jpmart_pd07599_v1.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.jpmart_pd07599_v1.R;

public class AddCustomerActivity extends AppCompatActivity {
    protected Toolbar toolbar;
    public void onCreate(Bundle savedInstanceStated){
        super.onCreate(savedInstanceStated);
        setContentView(R.layout.activity_them_khach_hang);
        toolbar = findViewById(R.id.toolbarCus);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Thêm khách hàng");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(v->{
            onBackPressed();
        });
    }
}
