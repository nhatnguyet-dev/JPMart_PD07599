package com.example.jpmart_pd07599_v1.ui;

import static com.example.jpmart_pd07599_v1.middleware.DatePickerFormat.getDateFromPicker;

import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jpmart_pd07599_v1.R;
import com.example.jpmart_pd07599_v1.adapter.TopProductAdapter;
import com.example.jpmart_pd07599_v1.database.DataHelper;
import com.example.jpmart_pd07599_v1.dto.TopProductDTO;

import java.util.List;

public class TopProductsActivity extends AppCompatActivity {
    protected Toolbar toolbar;
    protected Button btnCalculate;
    protected DatePicker edtStartDateTopSp, edtEndDateTopSp;
    protected RecyclerView recyclerViewTopSp;
    protected EditText edtQuantityTopSp;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke_top_sp);
        DataHelper db = new DataHelper(this);

        toolbar = findViewById(R.id.toolbar);
        btnCalculate = findViewById(R.id.btnCaculateSp);
        edtStartDateTopSp = findViewById(R.id.edtStartDateTopSp);
        edtEndDateTopSp = findViewById(R.id.edtEndDateTopSp);
        edtQuantityTopSp = findViewById(R.id.edtQuantityTopSp);
        recyclerViewTopSp = findViewById(R.id.recyclerViewTopSp);

        btnCalculate.setOnClickListener(v->{
            String fromDate = getDateFromPicker(edtStartDateTopSp);
            String toDate = getDateFromPicker(edtEndDateTopSp);
            String quantityStr = edtQuantityTopSp.getText().toString().trim();

            int limit;
            if (quantityStr.isEmpty()) {
                limit = 3; // mặc định TOP 10
            } else {
                limit = Integer.parseInt(quantityStr);
            }
            List<TopProductDTO> data =
                    db.getTopProduct(fromDate, toDate, limit);

            recyclerViewTopSp.setLayoutManager(
                    new LinearLayoutManager(this));
            recyclerViewTopSp.setAdapter(
                    new TopProductAdapter(data));
        });

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Thống kê top sản phẩm");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(v->{
            onBackPressed();
        });
    }
}
