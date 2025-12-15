package com.example.jpmart_pd07599_v1.interfaces;

import com.example.jpmart_pd07599_v1.model.NhanVienModel;
import com.example.jpmart_pd07599_v1.model.ProductModel;

public interface StaffItemListener {
    void onEdit(NhanVienModel staff);
    void onDelete(NhanVienModel staff);
}
