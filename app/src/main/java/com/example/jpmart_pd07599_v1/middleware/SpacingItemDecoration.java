package com.example.jpmart_pd07599_v1.middleware;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class SpacingItemDecoration extends RecyclerView.ItemDecoration {

    private final int spacing;

    public SpacingItemDecoration(int spacing) {
        this.spacing = spacing;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent,
                               RecyclerView.State state) {

        int position = parent.getChildAdapterPosition(view);
        int column = position % 2; // 0 = cột trái, 1 = cột phải

        if (column == 0) {
            // Cột trái: spacing bên phải
            outRect.right = spacing / 2;
            outRect.left = spacing;
        } else {
            // Cột phải: spacing bên trái
            outRect.left = spacing / 2;
            outRect.right = spacing;
        }

        // spacing giữa các hàng
        outRect.top = spacing;
        outRect.bottom = spacing;
    }
}
