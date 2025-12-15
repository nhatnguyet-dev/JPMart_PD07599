package com.example.jpmart_pd07599_v1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jpmart_pd07599_v1.R;
import com.example.jpmart_pd07599_v1.dto.TopProductDTO;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class TopProductAdapter  extends RecyclerView.Adapter<TopProductAdapter.ViewHolder> {

    private List<TopProductDTO> list;

    public TopProductAdapter(List<TopProductDTO> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_top_product, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        TopProductDTO p = list.get(i);
        h.txtName.setText(p.getTenSanPham());
        h.txtQuantity.setText("SL: " + p.getTongSoLuong());
        h.txtRevenue.setText(
                NumberFormat.getInstance(new Locale("vi","VN"))
                        .format(p.getTongDoanhThu()) + " đ"
        );
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtQuantity, txtRevenue;
        ViewHolder(View v) {
            super(v);
            txtName = v.findViewById(R.id.txtName);
            txtQuantity = v.findViewById(R.id.txtQuantity);
            txtRevenue = v.findViewById(R.id.txtRevenue);
        }
    }
}
