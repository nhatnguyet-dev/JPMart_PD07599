package com.example.jpmart_pd07599_v1.interfaces;

import com.example.jpmart_pd07599_v1.model.ProductModel;

public interface ProductItemListener {
    void onEdit(ProductModel product);
    void onDelete(ProductModel product);
}
