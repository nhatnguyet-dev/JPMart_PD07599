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

public class EditProductActivity extends AppCompatActivity {
    protected Toolbar toolbar;
    protected EditText edtIdCategory, edtIdProduct, edtNameProduct,
            edtPrice, edtQuantity, edtDonViTinh, edtMoTa;
    protected Button btnHuy, btnLuu;

    protected DataHelper db;
    protected int productId;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_sua_san_pham);

        toolbar = findViewById(R.id.toolbar);
        edtIdCategory = findViewById(R.id.edtIdCategory);
        edtIdProduct = findViewById(R.id.edtIdProduct);
        edtNameProduct = findViewById(R.id.edtNameProduct);
        edtPrice = findViewById(R.id.edtPrice);
        edtQuantity = findViewById(R.id.edtQuantity);
        edtDonViTinh = findViewById(R.id.edtDonViTinh);
        edtMoTa = findViewById(R.id.edtMoTa);

        btnHuy = findViewById(R.id.btn_huy);
        btnLuu = findViewById(R.id.btn_luu);

        db = new DataHelper(this);

        productId = getIntent().getIntExtra("PRODUCT_ID", -1);
        if (productId == -1) {
            finish();
            return;
        }
        ProductModel product = db.getProductById(productId);
        if (product != null) {
            bindData(product);
        }

        btnHuy.setOnClickListener(v -> finish());
        btnLuu.setOnClickListener(v -> updateProduct());
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Sửa sản phẩm");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(v->{
            onBackPressed();
        });
    }
    private void bindData(ProductModel p) {
        edtIdCategory.setText(p.getMaDanhMuc());
        edtIdProduct.setText(p.getMaSanPham());
        edtNameProduct.setText(p.getTenSanPham());
        edtPrice.setText(String.valueOf(p.getDonGia()));
        edtQuantity.setText(String.valueOf(p.getSoLuong()));
        edtDonViTinh.setText(p.getDonViTinh());
        edtMoTa.setText(p.getMoTa());
    }
    private void updateProduct() {
        try {
            String maDanhMuc = edtIdCategory.getText().toString().trim();
            String maSanPham = edtIdProduct.getText().toString().trim();
            String tenSanPham = edtNameProduct.getText().toString().trim();
            int donGia = Integer.parseInt(edtPrice.getText().toString().trim());
            int soLuong = Integer.parseInt(edtQuantity.getText().toString().trim());
            String donViTinh = edtDonViTinh.getText().toString().trim();
            String moTa = edtMoTa.getText().toString().trim();

            ProductModel product = new ProductModel();
            product.setId(productId);
            product.setMaDanhMuc(maDanhMuc);
            product.setMaSanPham(maSanPham);
            product.setTenSanPham(tenSanPham);
            product.setDonGia(donGia);
            product.setSoLuong(soLuong);
            product.setDonViTinh(donViTinh);
            product.setMoTa(moTa);

            boolean success = db.updateProduct(product);

            if (success) {
                Toast.makeText(this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Cập nhật thất bại", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Dữ liệu không hợp lệ", Toast.LENGTH_SHORT).show();
        }
    }
}
