package com.example.jpmart_pd07599_v1.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jpmart_pd07599_v1.R;
import com.example.jpmart_pd07599_v1.adapter.OrderAdapter;
import com.example.jpmart_pd07599_v1.database.DataHelper;
import com.example.jpmart_pd07599_v1.dto.OrderDTO;

import java.util.List;

public class OrdersActivity extends AppCompatActivity {
    protected Toolbar toolbar;
    protected RecyclerView recyclerViewOrder;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_quan_ly_hoa_don);

        toolbar = findViewById(R.id.toolbar);
        recyclerViewOrder = findViewById(R.id.recyclerViewOrder);

        DataHelper db = new DataHelper(this);
        List<OrderDTO> orderList = db.getAllOrderDisplay();

        OrderAdapter adapter = new OrderAdapter(this, orderList);
        recyclerViewOrder.setAdapter(adapter);
        recyclerViewOrder.setLayoutManager(new LinearLayoutManager(this));

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Quản lý hóa đơn");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(v->{
            onBackPressed();
        });
        db.close();
    }
}
