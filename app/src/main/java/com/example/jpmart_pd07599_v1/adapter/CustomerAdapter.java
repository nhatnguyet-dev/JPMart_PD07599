package com.example.jpmart_pd07599_v1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jpmart_pd07599_v1.R;
import com.example.jpmart_pd07599_v1.interfaces.CustomerItemListener;
import com.example.jpmart_pd07599_v1.model.CustomerModel;

import java.util.List;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder>{
    private final Context context;
    private final List<CustomerModel> CustomerList;
    private final CustomerItemListener listener;
    public CustomerAdapter(Context context, List<CustomerModel> customerList, CustomerItemListener listener){
        this.context = context;
        this.CustomerList = customerList;
        this.listener = listener;
    }
    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v = LayoutInflater.from(context).inflate(R.layout.item_customer,parent,false);
        return new CustomerViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull CustomerViewHolder holder, int position){
        CustomerModel customer = CustomerList.get(position);

        holder.txtName.setText(customer.getTenKhachHang());
        holder.txtAddress.setText(customer.getDiaChi());
        holder.btnEdit.setOnClickListener(v->{listener.onEdit(customer);});
        holder.btnDelete.setOnClickListener(v->{listener.onDelete(customer);});
    }
    @Override
    public int getItemCount(){return CustomerList.size();}
    public static class CustomerViewHolder extends RecyclerView.ViewHolder{
        TextView txtName, txtAddress;
        ImageButton btnEdit, btnDelete;
        public CustomerViewHolder(@NonNull View itemView){
            super(itemView);
            txtName = itemView.findViewById(R.id.txtNameCustomer);
            txtAddress = itemView.findViewById(R.id.txtAddressCustomer);
            btnDelete = itemView.findViewById(R.id.btnDeleteCus);
            btnEdit = itemView.findViewById(R.id.btnEditCus);

        }
    }
}
