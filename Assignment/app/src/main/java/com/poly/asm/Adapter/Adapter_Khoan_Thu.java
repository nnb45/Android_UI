package com.poly.asm.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.poly.asm.DAO.KhoanchiDao;
import com.poly.asm.DAO.KhoanthuDAO;
import com.poly.asm.DAO.LoaiThuDAO;
import com.poly.asm.DAO.LoaichiDAO;
import com.poly.asm.Model.KhoanChi;
import com.poly.asm.Model.KhoanThu;
import com.poly.asm.Model.LoaiChi;
import com.poly.asm.Model.LoaiThu;
import com.poly.asm.MyViewHolder.MyViewHolderKhoan;
import com.poly.asm.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Adapter_Khoan_Thu extends RecyclerView.Adapter<MyViewHolderKhoan> {
    ArrayList<KhoanThu> dsKhoanThu;
    ArrayList<LoaiThu> dsLoaiThu;
    Context context;
    KhoanthuDAO khoanthuDAO;
    LoaiThuDAO loaiThuDAO;
    public Adapter_Khoan_Thu(ArrayList<KhoanThu> dsKhoanThu, Context context) {
        this.dsKhoanThu = dsKhoanThu;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolderKhoan onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_holder_item_khoan, parent, false);
        return new MyViewHolderKhoan(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderKhoan holder, int position) {
        KhoanThu khoanThu = dsKhoanThu.get(holder.getAdapterPosition());
        khoanthuDAO = new KhoanthuDAO(context);
        loaiThuDAO = new LoaiThuDAO(context);
        dsLoaiThu = loaiThuDAO.xemLoaiThu();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        String dateString;
        try {
            date = khoanThu.getNgayThu();
            dateString = simpleDateFormat.format(date);
        } catch (Exception e) {
            dateString = "null";
        }

        String tenLoai = null;
        for (int i = 0; i < dsLoaiThu.size(); i++) {
            if (dsLoaiThu.get(i).getMaLoaiThu() == khoanThu.getMaKhoanThu()) {
                tenLoai = dsLoaiThu.get(i).getTenLoaiThu();
            }
        }

        holder.tv1.setText(khoanThu.getTenKhoanThu());
        holder.tv2.setText(dateString);
        holder.tv3.setText(khoanThu.getSoTienThu() + "");
        holder.tv4.setText(khoanThu.getMoTa());
        holder.tv5.setText(tenLoai);

        holder.iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {showDialog(holder, holder.getAdapterPosition());
            }
        });

        holder.iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogEdit(holder, holder.getAdapterPosition());
            }
        });
    }

    public void showDialog(MyViewHolderKhoan holder, int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Thông báo!!!");
        builder.setMessage("Bạn có muốn xóa không?");

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                KhoanThu khoanThu = dsKhoanThu.get(holder.getAdapterPosition());
                khoanthuDAO.xoaKhoanThu(khoanThu.getMaKhoanThu());
                dsKhoanThu.remove(holder.getAdapterPosition());
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

    public void showDialogEdit(MyViewHolderKhoan holder, int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewdialog = inflater.inflate(R.layout.dialog_edit_khoan, null);

        TextView textViewIDKhoan = viewdialog.findViewById(R.id.tv_sua_khoan);
        Spinner spinner = viewdialog.findViewById(R.id.spinner_sua_khoan);
        EditText editTextTenKhoan = viewdialog.findViewById(R.id.ed_sua_ten_khoan);
        EditText editTextNgay = viewdialog.findViewById(R.id.ed_sua_ngay_khoan);
        EditText editTextSoTien = viewdialog.findViewById(R.id.ed_sua_tien_khoan);
        EditText editTextMoTa = viewdialog.findViewById(R.id.ed_sua_mota_khoan);

        KhoanThu khoanThu = dsKhoanThu.get(position);
        textViewIDKhoan.setText(khoanThu.getMaKhoanThu() + "");
        editTextTenKhoan.setText(khoanThu.getTenKhoanThu());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        String dateString;
        try {
            date = khoanThu.getNgayThu();
            dateString = simpleDateFormat.format(date);
        } catch (Exception e) {
            dateString = "null";
        }

        editTextNgay.setText(dateString);
        editTextSoTien.setText(String.valueOf(khoanThu.getSoTienThu()));
        editTextMoTa.setText(khoanThu.getMoTa());

        LoaiThuDAO loaiThuDAO = new LoaiThuDAO(context);
        dsLoaiThu = loaiThuDAO.xemLoaiThu();
        ArrayList<String> dsTenLoai = new ArrayList<String>();
        for (int i = 0; i < dsLoaiThu.size(); i++) {
            dsTenLoai.add(dsLoaiThu.get(i).getTenLoaiThu());
        }

        ArrayAdapter arrayAdapter = new ArrayAdapter((Activity) context, android.R.layout.simple_spinner_item, dsTenLoai);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        int index = -1;
        for (int i = 0; i < dsLoaiThu.size(); i++) {
            if (dsLoaiThu.get(i).getMaLoaiThu() == khoanThu.getMaLoaiThu()) {
                index = i;
            }
        }

        spinner.setSelection(index);
        builder.setView(viewdialog);
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                int idKhoan = khoanThu.getMaKhoanThu();
                int index = spinner.getSelectedItemPosition();
                int idLoai = dsLoaiThu.get(index).getMaLoaiThu();
                String ten_khoan = editTextTenKhoan.getText().toString();
                Date ngay_khoan = null;
                try {
                    ngay_khoan = simpleDateFormat.parse(editTextNgay.getText().toString());
                }catch (Exception e){
                    ngay_khoan = null;
                }
                double sotien_khoan = Double.parseDouble(editTextSoTien.getText().toString());
                String mota_khoan = editTextMoTa.getText().toString();
                KhoanThu khoanThu = new KhoanThu(idKhoan,ten_khoan, ngay_khoan, sotien_khoan, mota_khoan,idLoai);
                khoanthuDAO.suaKhoanThu(khoanThu);
                dsKhoanThu.set(holder.getAdapterPosition(), khoanThu);
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
    @Override
    public int getItemCount() {
        return dsKhoanThu.size();
    }
}
