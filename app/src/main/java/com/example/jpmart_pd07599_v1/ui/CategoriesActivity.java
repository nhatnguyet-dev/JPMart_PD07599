package com.example.jpmart_pd07599_v1.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jpmart_pd07599_v1.R;
import com.example.jpmart_pd07599_v1.adapter.CategoryAdapter;
import com.example.jpmart_pd07599_v1.database.DataHelper;
import com.example.jpmart_pd07599_v1.interfaces.CategoryItemListener;
import com.example.jpmart_pd07599_v1.middleware.SpacingItemDecoration;
import com.example.jpmart_pd07599_v1.model.DanhMucModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class CategoriesActivity extends AppCompatActivity {
    protected RecyclerView recyclerViewCate;
    protected FloatingActionButton btnAdd;
    protected Toolbar toolbar;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_quan_ly_danh_muc);

        recyclerViewCate = findViewById(R.id.recyclerViewCategory);
        btnAdd = findViewById(R.id.btnAdd);
        toolbar = findViewById(R.id.toolbar);

        DataHelper db = new DataHelper(this);

        List<DanhMucModel> cateList = db.getAllDanhMuc();

        CategoryAdapter adapter = new CategoryAdapter(this, cateList, new CategoryItemListener(){
            @Override
            public void onEdit(DanhMucModel category) {
                startActivity(new Intent(CategoriesActivity.this, EditCategoryActivity.class));
            }

            @Override
            public void onDelete(DanhMucModel category) {
                // Xóa category khỏi SQLite và refresh RecyclerView
            }
        });
        recyclerViewCate.setAdapter(adapter);
        recyclerViewCate.setLayoutManager(new GridLayoutManager(this, 2));

        int spacingInDp = 10;
        int spacingPx = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                spacingInDp,
                getResources().getDisplayMetrics()
        );

        recyclerViewCate.addItemDecoration(new SpacingItemDecoration(spacingPx));
        btnAdd.setOnClickListener(v->{
            startActivity(new Intent(CategoriesActivity.this, AddCategoryActivity.class));
        });

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Quản lý danh mục");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(v->{
            onBackPressed();
        });

    }
}
