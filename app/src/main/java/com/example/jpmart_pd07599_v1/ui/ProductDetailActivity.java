package com.example.jpmart_pd07599_v1.ui;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.jpmart_pd07599_v1.R;
import com.example.jpmart_pd07599_v1.database.DataHelper;
import com.example.jpmart_pd07599_v1.model.ProductModel;

public class ProductDetailActivity extends AppCompatActivity {
    protected Toolbar toolbar;
    protected EditText edtIdCategory, edtIdProduct, edtNameProduct, edtPrice,
            edtQuantity, edtDonViTinh, edtMoTa;
    protected DataHelper db;
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_san_pham_chi_tiet);

        toolbar = findViewById(R.id.toolbar);
        edtIdCategory = findViewById(R.id.edtIdCategory);
        edtIdProduct = findViewById(R.id.edtIdProduct);
        edtNameProduct = findViewById(R.id.edtNameProduct);
        edtPrice = findViewById(R.id.edtPrice);
        edtQuantity = findViewById(R.id.edtQuantity);
        edtDonViTinh = findViewById(R.id.edtDonViTinh);
        edtMoTa = findViewById(R.id.edtMoTa);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Sản phẩm chi tiết");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(v->{
            onBackPressed();
        });
        int productId = getIntent().getIntExtra("PRODUCT_ID", -1);
        if (productId == -1) {
            finish(); // lỗi → thoát
            return;
        }

        db = new DataHelper(this);
        ProductModel product = db.getProductById(productId);

        if (product != null) {
            bindData(product);
        }
    }
    private void bindData(ProductModel p) {
        edtIdCategory.setText(p.getMaDanhMuc());
        edtIdProduct.setText(p.getMaSanPham());
        edtNameProduct.setText(p.getTenSanPham());
        edtPrice.setText(formatMoney(p.getDonGia()));
        edtQuantity.setText(String.valueOf(p.getSoLuong()));
        edtDonViTinh.setText(p.getDonViTinh());
        edtMoTa.setText(p.getMoTa());
    }

    private String formatMoney(int money) {
        return String.format("%,d đ", money).replace(',', '.');
    }
}
