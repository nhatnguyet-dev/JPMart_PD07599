package com.example.jpmart_pd07599_v1.interfaces;


import com.example.jpmart_pd07599_v1.model.CustomerModel;

public interface CustomerItemListener {
    void onEdit(CustomerModel customer);
    void onDelete(CustomerModel customer);
}
