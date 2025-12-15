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
import com.example.jpmart_pd07599_v1.interfaces.StaffItemListener;
import com.example.jpmart_pd07599_v1.model.NhanVienModel;

import java.util.List;

public class StaffAdapter extends RecyclerView.Adapter<StaffAdapter.StaffViewHolder>{
    private final Context context;
    private final List<NhanVienModel> staffList;
    private final StaffItemListener listener;
    public StaffAdapter(Context context, List<NhanVienModel> staffList, StaffItemListener listener){
        this.context = context;
        this.staffList = staffList;
        this.listener = listener;
    }
    @NonNull
    @Override
    public StaffViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v = LayoutInflater.from(context).inflate(R.layout.item_staff, parent, false);
        return new StaffViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull StaffAdapter.StaffViewHolder holder, int position){
        NhanVienModel staff = staffList.get(position);

        holder.txtName.setText(staff.getTenNhanVien());
        holder.txtPosition.setText(String.valueOf(staff.getChucVu()));
    }
    @Override
    public int getItemCount(){return staffList.size();}
    public static class StaffViewHolder extends RecyclerView.ViewHolder{
        TextView txtName, txtPosition;
        ImageButton btnEdit, btnDelete;
        public StaffViewHolder(@NonNull View itemView){
            super(itemView);

            txtName = itemView.findViewById(R.id.txtNameStaff);
            txtPosition = itemView.findViewById(R.id.txtPositionStaff);
        }
    }
}
