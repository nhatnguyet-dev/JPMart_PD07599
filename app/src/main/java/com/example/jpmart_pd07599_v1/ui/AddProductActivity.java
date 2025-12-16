package com.example.jpmart_pd07599_v1.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.jpmart_pd07599_v1.R;
import com.example.jpmart_pd07599_v1.database.DataHelper;
import com.example.jpmart_pd07599_v1.model.ProductModel;

public class AddProductActivity extends AppCompatActivity {
    protected Toolbar toolbar;
    protected EditText edtIdCategory, edtNameProduct, edtPrice,
            edtQuantity, edtDonViTinh, edtMoTa, edtMaProduct;
    protected Button btnHuy, btnLuu;
    protected DataHelper db;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_them_san_pham);
        toolbar = findViewById(R.id.toolbar);
        edtIdCategory = findViewById(R.id.edtIdCategory);
        edtNameProduct = findViewById(R.id.edtNameProduct);
        edtPrice = findViewById(R.id.edtPrice);
        edtQuantity = findViewById(R.id.edtQuantity);
        edtDonViTinh = findViewById(R.id.edtDonViTinh);
        edtMoTa = findViewById(R.id.edtMoTa);
        edtMaProduct = findViewById(R.id.edtMaProduct);

        btnHuy = findViewById(R.id.btn_huy);
        btnLuu = findViewById(R.id.btn_luu);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Thêm sản phẩm");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(v->{
            onBackPressed();
        });
        db = new DataHelper(this);

        // Hủy
        btnHuy.setOnClickListener(v -> finish());

        // Lưu
        btnLuu.setOnClickListener(v -> insertProduct());
    }
    private void insertProduct() {
        try {
            String maDanhMuc = edtIdCategory.getText().toString().trim();
            String tenSanPham = edtNameProduct.getText().toString().trim();
            int donGia = Integer.parseInt(edtPrice.getText().toString().trim());
            int soLuong = Integer.parseInt(edtQuantity.getText().toString().trim());
            String donViTinh = edtDonViTinh.getText().toString().trim();
            String moTa = edtMoTa.getText().toString().trim();
            String maSanPham = edtMaProduct.getText().toString().trim();

            if (maDanhMuc.isEmpty() || tenSanPham.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }

            ProductModel product = new ProductModel();
            product.setMaDanhMuc(maDanhMuc);
            product.setMaSanPham(maSanPham);
            product.setTenSanPham(tenSanPham);
            product.setDonGia(donGia);
            product.setSoLuong(soLuong);
            product.setDonViTinh(donViTinh);
            product.setMoTa(moTa);

            boolean success = db.createProduct(product);

            if (success) {
                Toast.makeText(this, "Thêm sản phẩm thành công", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Thêm sản phẩm thất bại", Toast.LENGTH_SHORT).show();
            }

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Giá và số lượng phải là số", Toast.LENGTH_SHORT).show();
        }
    }
}
