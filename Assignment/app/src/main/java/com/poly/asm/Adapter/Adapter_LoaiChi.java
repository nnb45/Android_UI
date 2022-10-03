package com.poly.asm.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.poly.asm.DAO.LoaichiDAO;
import com.poly.asm.Model.LoaiChi;
import com.poly.asm.MyViewHolder.MyViewHolderLoai;
import com.poly.asm.R;

import java.util.ArrayList;

public class Adapter_LoaiChi extends RecyclerView.Adapter<MyViewHolderLoai> {
    ArrayList<LoaiChi> dsLoaiChi;
    Context context;
    LoaichiDAO loaichiDAO;

    public Adapter_LoaiChi(ArrayList<LoaiChi> dsLoaiChi, Context context) {
        this.dsLoaiChi = dsLoaiChi;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolderLoai onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_holder_item_loai, parent,false);
        return new MyViewHolderLoai(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderLoai holder, int position) {
        LoaiChi loaiChi = dsLoaiChi.get(holder.getAdapterPosition());
        loaichiDAO = new LoaichiDAO(context);

        holder.tv1.setText(loaiChi.getTenLoaiChi()+"");

        holder.iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(holder,holder.getAdapterPosition());
            }
        });
        holder.iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogEdit(holder,holder.getAdapterPosition());
            }
        });

    }

    @Override
    public int getItemCount() {
        return dsLoaiChi.size();
    }
    public void showDialog(MyViewHolderLoai holder, int position){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Thông báo!!!");
        builder.setMessage("Bạn có muốn xóa không?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                LoaiChi loaiChi1 = dsLoaiChi.get(holder.getAdapterPosition());
                loaichiDAO.xoaLoaiChi(loaiChi1.getMaLoaiChi());
                dsLoaiChi.remove(holder.getAdapterPosition());
                notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void showDialogEdit(MyViewHolderLoai holder, int position){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewdialog = inflater.inflate(R.layout.dialog_edit_loai, null);
        TextView textView = viewdialog.findViewById(R.id.tv_sua_loai);
        EditText editText = viewdialog.findViewById(R.id.ed_ten_loai);
        int id = dsLoaiChi.get(holder.getAdapterPosition()).getMaLoaiChi();
        String name = dsLoaiChi.get(holder.getAdapterPosition()).getTenLoaiChi();
        textView.setText(id+"");
        editText.setText(name);
        builder.setView(viewdialog);
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                EditText editText = viewdialog.findViewById(R.id.ed_ten_loai);
                String name_edit = editText.getText().toString();
                LoaiChi loaiChi = new LoaiChi(id, name_edit);
                loaichiDAO.suaLoaiChi(loaiChi);
                dsLoaiChi.set(holder.getAdapterPosition(),loaiChi);
                notifyDataSetChanged();

            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
