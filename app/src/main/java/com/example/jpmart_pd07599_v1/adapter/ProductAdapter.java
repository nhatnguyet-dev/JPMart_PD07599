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
import com.example.jpmart_pd07599_v1.interfaces.OnProductClickListener;
import com.example.jpmart_pd07599_v1.interfaces.ProductItemListener;
import com.example.jpmart_pd07599_v1.model.ProductModel;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private final Context context;
    private final List<ProductModel> ProductList;
    private final ProductItemListener listener;
    private final OnProductClickListener detailListener;
    public ProductAdapter(Context context, List<ProductModel> productList, ProductItemListener listener, OnProductClickListener detailListener){
        this.context = context;
        this.ProductList = productList;
        this.listener = listener;
        this.detailListener = detailListener;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        ProductModel product = ProductList.get(position);

        holder.itemView.setOnClickListener(v->{
            detailListener.onClick(product);
        });
        holder.txtName.setText(product.getTenSanPham());
        holder.txtPrice.setText(String.valueOf(product.getDonGia()));
        holder.btnEdit.setOnClickListener(v->{listener.onEdit(product);});
        holder.btnDelete.setOnClickListener(v->{listener.onDelete(product);});
    }

    @Override
    public int getItemCount() {
        return ProductList.size();
    }
    public static class ProductViewHolder extends RecyclerView.ViewHolder{
        TextView txtName, txtPrice;
        ImageButton btnEdit, btnDelete;
        public ProductViewHolder(@NonNull View itemView){
            super(itemView);
            txtName = itemView.findViewById(R.id.txtNameProduct);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            btnDelete = itemView.findViewById(R.id.btnDeletePro);
            btnEdit = itemView.findViewById(R.id.btnEditPro);
        }
    }
    public void updateData(List<ProductModel> newList) {
        this.ProductList.clear();
        this.ProductList.addAll(newList);
        notifyDataSetChanged();
    }
}
