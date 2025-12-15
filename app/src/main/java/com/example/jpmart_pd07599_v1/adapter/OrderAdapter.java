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
import com.example.jpmart_pd07599_v1.dto.OrderDTO;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder>{
    private final Context context;
    private final List<OrderDTO> OrderList;
    public OrderAdapter(Context context, List<OrderDTO> orderList){
        this.context = context;
        this.OrderList = orderList;
    }
    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v = LayoutInflater.from(context).inflate(R.layout.item_order, parent,false);
        return new OrderViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position){
        OrderDTO order = OrderList.get(position);
        holder.txtIdOrder.setText(order.getMaHoaDon());
        holder.txtNameCustomer.setText(order.getTenKhachHang()); // ✅
        holder.txtNameStaff.setText(order.getTenNhanVien());
        holder.txtTotal.setText(String.valueOf(order.getTongTien()));
    }
    @Override
    public int getItemCount(){return OrderList.size();}
    public static class OrderViewHolder extends RecyclerView.ViewHolder{
        TextView txtIdOrder, txtNameStaff, txtNameCustomer, txtTotal;
        ImageButton btnDeleteOrder;
        public OrderViewHolder(@NonNull View itemView){
            super(itemView);
            txtIdOrder = itemView.findViewById(R.id.txtIdOrder);
            txtNameStaff = itemView.findViewById(R.id.txtNameStaff);
            txtNameCustomer = itemView.findViewById(R.id.txtNameCustomer);
            txtTotal = itemView.findViewById(R.id.txtTotal);
        }
    }
}
