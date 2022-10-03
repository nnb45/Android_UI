package com.poly.asm.MyViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.poly.asm.R;

public class MyViewHolderKhoan extends RecyclerView.ViewHolder {
    public TextView tv1, tv2, tv3, tv4, tv5;
    public ImageView iv1,iv2;

    public MyViewHolderKhoan(@NonNull View itemView) {
        super(itemView);
        this.tv1 = (TextView) itemView.findViewById(R.id.tv_k);
        this.tv2 = (TextView) itemView.findViewById(R.id.tv_ngay);
        this.tv3 = (TextView) itemView.findViewById(R.id.tv_tien);
        this.tv4 = (TextView) itemView.findViewById(R.id.tv_mota);
        this.tv5 = (TextView) itemView.findViewById(R.id.tv_loai);
        this.iv1 = (ImageView) itemView.findViewById(R.id.iv_l);
        this.iv2 = (ImageView) itemView.findViewById(R.id.iv_l_2);
    }
}
