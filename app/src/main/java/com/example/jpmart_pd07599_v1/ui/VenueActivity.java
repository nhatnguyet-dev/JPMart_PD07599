package com.example.jpmart_pd07599_v1.ui;

import static com.example.jpmart_pd07599_v1.middleware.DatePickerFormat.getDateFromPicker;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.jpmart_pd07599_v1.R;
import com.example.jpmart_pd07599_v1.database.DataHelper;

import java.text.NumberFormat;
import java.util.Locale;

public class VenueActivity extends AppCompatActivity {
    protected Toolbar toolbar;
    protected DatePicker startDate, endDate;
    protected TextView txtTotalVenue;
    protected Button btnCaculate;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke_doanh_thu);
        DataHelper db = new DataHelper(this);

        toolbar = findViewById(R.id.toolbar);
        startDate = findViewById(R.id.edtStartDate);
        endDate = findViewById(R.id.edtEndDate);
        txtTotalVenue = findViewById(R.id.txtTotalVenue);
        btnCaculate = findViewById(R.id.btnCaculate);

        btnCaculate.setOnClickListener(v->{
            String fromDate = getDateFromPicker(startDate);
            String toDate = getDateFromPicker(endDate);
            if (fromDate.compareTo(toDate) > 0) {
                Toast.makeText(this, "Ngày bắt đầu phải ≤ ngày kết thúc", Toast.LENGTH_SHORT).show();
                return;
            }
            int total = db.getRevenueBetweenDates(fromDate, toDate);
            NumberFormat formatter = NumberFormat.getInstance(new Locale("vi", "VN"));
            String formatted = formatter.format(total);
            txtTotalVenue.setText(formatted + " VND");
        });

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Thống kê doanh thu");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(v->{
            onBackPressed();
        });
    }

}
