package com.example.jpmart_pd07599_v1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jpmart_pd07599_v1.R;
import com.example.jpmart_pd07599_v1.interfaces.CategoryItemListener;
import com.example.jpmart_pd07599_v1.model.DanhMucModel;

import org.w3c.dom.Text;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private final Context context;
    private final List<DanhMucModel> DanhMucList;
    private final CategoryItemListener listener;
    public CategoryAdapter(Context context, List<DanhMucModel> DanhMucList, CategoryItemListener listener){
        this.context = context;
        this.DanhMucList = DanhMucList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.item_category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        DanhMucModel category = DanhMucList.get(position);

        holder.txtName.setText(category.getTenDanhMuc());
        holder.txtId.setText(category.getMaDanhMuc());

        holder.btnEdit.setOnClickListener(v -> {
            listener.onEdit(category);
        });

        holder.btnDelete.setOnClickListener(v -> {
            listener.onDelete(category);
        });
    }

    @Override
    public int getItemCount() {
        return DanhMucList.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        ImageButton btnEdit;
        ImageButton btnDelete;
        TextView txtName;
        TextView txtId;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtNameCategory);
            txtId = itemView.findViewById(R.id.txtIdCategory);
            btnDelete = itemView.findViewById(R.id.btnDelete);
            btnEdit = itemView.findViewById(R.id.btnEdit);
        }
    }
}
