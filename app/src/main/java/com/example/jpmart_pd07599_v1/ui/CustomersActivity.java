package com.example.jpmart_pd07599_v1.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jpmart_pd07599_v1.R;
import com.example.jpmart_pd07599_v1.adapter.CustomerAdapter;
import com.example.jpmart_pd07599_v1.database.DataHelper;
import com.example.jpmart_pd07599_v1.interfaces.CustomerItemListener;
import com.example.jpmart_pd07599_v1.model.CustomerModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class CustomersActivity extends AppCompatActivity {
    protected Toolbar toolbar;
    protected RecyclerView recyclerView;
    protected FloatingActionButton btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_khach_hang);

        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recyclerViewCustomer);
        btnAdd = findViewById(R.id.btnAddCustomer);

        DataHelper db = new DataHelper(this);
        List<CustomerModel> customerList = db.getAllCustomer();

        CustomerAdapter adapter = new CustomerAdapter(this, customerList, new CustomerItemListener() {
            @Override
            public void onEdit(CustomerModel customer) {
                startActivity(new Intent(CustomersActivity.this, EditCustomerActivity.class));
            }

            @Override
            public void onDelete(CustomerModel customer) {

            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        btnAdd.setOnClickListener(v->{
            startActivity(new Intent(CustomersActivity.this, AddCustomerActivity.class));
        });

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Quản lý khách hàng");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(v->{
            onBackPressed();
        });
        db.close();
    }
}
