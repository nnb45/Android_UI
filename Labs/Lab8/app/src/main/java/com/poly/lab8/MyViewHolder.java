package com.poly.lab8;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    public ImageView iv;

    public TextView tv;

    public MyViewHolder(View view)

    {

        super(view);

        this.iv=(ImageView)view.findViewById(R.id.imageView);

        this.tv=(TextView)view.findViewById(R.id.textView);

    }
}
