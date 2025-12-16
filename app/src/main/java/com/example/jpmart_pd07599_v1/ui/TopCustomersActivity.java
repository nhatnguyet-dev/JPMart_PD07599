package com.example.jpmart_pd07599_v1.ui;

import static com.example.jpmart_pd07599_v1.middleware.DatePickerFormat.getDateFromPicker;

import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jpmart_pd07599_v1.R;
import com.example.jpmart_pd07599_v1.adapter.TopCustomerAdapter;
import com.example.jpmart_pd07599_v1.database.DataHelper;
import com.example.jpmart_pd07599_v1.dto.TopCustomerDTO;

import java.util.List;

public class TopCustomersActivity extends AppCompatActivity {
    protected Toolbar toolbar;
    protected Button btnCalculate;
    protected DatePicker edtStartDate, edtEndDate;
    protected TextView edtQuantity;
    protected RecyclerView recyclerViewTop;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke_top_khach_hang);
        DataHelper db = new DataHelper(this);

        toolbar = findViewById(R.id.toolbar);
        btnCalculate = findViewById(R.id.btnCaculateCus);
        edtStartDate = findViewById(R.id.edtStartDateCus);
        edtEndDate = findViewById(R.id.edtEndDateCus);
        edtQuantity = findViewById(R.id.edtQuantityCus);
        recyclerViewTop = findViewById(R.id.recyclerViewCustomerTop);

        btnCalculate.setOnClickListener(v -> {

            String fromDate = getDateFromPicker(edtStartDate);
            String toDate = getDateFromPicker(edtEndDate);

            String qtyStr = edtQuantity.getText().toString().trim();
            int limit = qtyStr.isEmpty() ? 10 : Integer.parseInt(qtyStr);

            List<TopCustomerDTO> data =
                    db.getTopCustomer(fromDate, toDate, limit);

            recyclerViewTop.setLayoutManager(
                    new LinearLayoutManager(this));
            recyclerViewTop.setAdapter(
                    new TopCustomerAdapter(data));
        });

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Thống kê top khách hàng");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(v->{
            onBackPressed();
        });
    }
}
