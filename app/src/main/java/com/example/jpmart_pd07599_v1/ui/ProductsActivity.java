package com.example.jpmart_pd07599_v1.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jpmart_pd07599_v1.R;
import com.example.jpmart_pd07599_v1.adapter.ProductAdapter;
import com.example.jpmart_pd07599_v1.database.DataHelper;
import com.example.jpmart_pd07599_v1.interfaces.ProductItemListener;
import com.example.jpmart_pd07599_v1.model.ProductModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class ProductsActivity extends AppCompatActivity {
    protected RecyclerView recyclerViewPro;
    protected FloatingActionButton btnAdd;
    protected Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_san_pham);

        recyclerViewPro = findViewById(R.id.recyclerViewProduct);
        btnAdd = findViewById(R.id.btnAddProduct);
        toolbar = findViewById(R.id.toolbar_sp);

        DataHelper db = new DataHelper(this);
        List<ProductModel> productList = db.getAllProduct();

        ProductAdapter adapter = new ProductAdapter(this, productList, new ProductItemListener() {
            @Override
            public void onEdit(ProductModel product) {
                startActivity(new Intent(ProductsActivity.this, EditProductActivity.class));
            }
            @Override
            public void onDelete(ProductModel product) {

            }
        });
        recyclerViewPro.setAdapter(adapter);
        recyclerViewPro.setLayoutManager(new LinearLayoutManager(this));

        btnAdd.setOnClickListener(v->{
            startActivity(new Intent(ProductsActivity.this, AddProductActivity.class));
        });

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Quản lý sản phẩm");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(v->{
            onBackPressed();
        });
    }
}
