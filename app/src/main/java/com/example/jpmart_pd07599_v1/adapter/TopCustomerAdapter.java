package com.example.jpmart_pd07599_v1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jpmart_pd07599_v1.R;
import com.example.jpmart_pd07599_v1.dto.TopCustomerDTO;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class TopCustomerAdapter extends RecyclerView.Adapter<TopCustomerAdapter.ViewHolder> {

    private List<TopCustomerDTO> list;
    public TopCustomerAdapter(List<TopCustomerDTO> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_top_customer, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        TopCustomerDTO c = list.get(i);

        h.txtCustomerName.setText(c.getTenKhachHang());
        h.txtOrderCount.setText("ĐH: " + c.getSoDonHang());
        h.txtTotalSpent.setText(
                NumberFormat.getInstance(new Locale("vi","VN"))
                        .format(c.getTongChiTieu()) + " đ"
        );
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtCustomerName, txtOrderCount, txtTotalSpent;
        ViewHolder(View v) {
            super(v);
            txtCustomerName = v.findViewById(R.id.txtCustomerName);
            txtOrderCount = v.findViewById(R.id.txtOrderCount);
            txtTotalSpent = v.findViewById(R.id.txtTotalSpent);
        }
    }
}
