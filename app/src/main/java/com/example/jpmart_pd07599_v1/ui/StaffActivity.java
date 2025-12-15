package com.example.jpmart_pd07599_v1.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jpmart_pd07599_v1.R;
import com.example.jpmart_pd07599_v1.adapter.StaffAdapter;
import com.example.jpmart_pd07599_v1.database.DataHelper;
import com.example.jpmart_pd07599_v1.interfaces.StaffItemListener;
import com.example.jpmart_pd07599_v1.model.NhanVienModel;

import java.util.ArrayList;
import java.util.List;

public class StaffActivity extends AppCompatActivity {
    protected Toolbar toolbar;
    protected RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_quan_ly_nhan_vien);

        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recyclerViewStaff);

        DataHelper db = new DataHelper(this);
        List<NhanVienModel> staffList = db.getAllStaff();

        StaffAdapter adapter = new StaffAdapter(this, staffList, new StaffItemListener() {
            @Override
            public void onEdit(NhanVienModel staff) {
                startActivity(new Intent(StaffActivity.this, EditCustomerActivity.class));
            }

            @Override
            public void onDelete(NhanVienModel staff) {

            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Quản lý nhân viên");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(v->{
            onBackPressed();
        });
        db.close();
    }
}
