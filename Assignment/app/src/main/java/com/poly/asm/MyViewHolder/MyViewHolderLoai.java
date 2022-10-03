package com.poly.asm.MyViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.poly.asm.R;

public class MyViewHolderLoai extends RecyclerView.ViewHolder {
    public TextView tv1;
    public ImageView iv1,iv2;

    public MyViewHolderLoai(@NonNull View itemView) {
        super(itemView);
        this.tv1 = (TextView) itemView.findViewById(R.id.tv_l);
        this.iv1 = (ImageView) itemView.findViewById(R.id.iv_l);
        this.iv2 = (ImageView) itemView.findViewById(R.id.iv_l_2);
    }
}
