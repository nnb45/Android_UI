package com.poly.asm.Fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.poly.asm.Adapter.Adapter_Khoan_Chi;
import com.poly.asm.Adapter.Adapter_Khoan_Thu;
import com.poly.asm.DAO.KhoanchiDao;
import com.poly.asm.DAO.KhoanthuDAO;
import com.poly.asm.DAO.LoaiThuDAO;
import com.poly.asm.DAO.LoaichiDAO;
import com.poly.asm.Model.KhoanChi;
import com.poly.asm.Model.KhoanThu;
import com.poly.asm.Model.LoaiChi;
import com.poly.asm.Model.LoaiThu;
import com.poly.asm.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Fragment_KhoanThu extends Fragment {
    RecyclerView recyclerView;
    ArrayList<KhoanThu> dsKhoanThu = new ArrayList<KhoanThu>();
    KhoanthuDAO khoanthuDAO;
    FloatingActionButton floatingActionButton;
    Adapter_Khoan_Thu adapter_khoan_thu;
    LoaiThuDAO loaiThuDAO;
    ArrayList<LoaiThu> dsLoaiThu = new ArrayList<LoaiThu>();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_khoanthu, container, false);
        recyclerView = view.findViewById(R.id.recV_itemkthu);
        floatingActionButton = view.findViewById(R.id.btn_them_kt);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        khoanthuDAO = new KhoanthuDAO(getContext());
        dsKhoanThu = khoanthuDAO.xemKhoanThu();
        adapter_khoan_thu = new Adapter_Khoan_Thu(dsKhoanThu, getContext());
        recyclerView.setAdapter(adapter_khoan_thu);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {@Override
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
        }
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                if(dy > 0   && floatingActionButton.isShown()){
                    floatingActionButton.hide();
                }else{
                    floatingActionButton.show();
                }
            }
        });
        floatingActionButton.setOnClickListener(new View.OnClickListener() {@Override
        public void onClick(View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
            LayoutInflater inflater = getLayoutInflater();
            View viewdialog = inflater.inflate(R.layout.dialog_insert_khoan, null);
            Spinner spinner = viewdialog.findViewById(R.id.spinner_khoan);
            EditText editTextTenKhoan = viewdialog.findViewById(R.id.ed_ten_khoan);
            EditText editTextNgay = viewdialog.findViewById(R.id.ed_ngay_khoan);
            EditText editTextSoTien = viewdialog.findViewById(R.id.ed_tien_khoan);
            EditText editTextTenMoTa = viewdialog.findViewById(R.id.ed_mota_khoan);
            loaiThuDAO = new LoaiThuDAO(getContext());
            dsLoaiThu = loaiThuDAO.xemLoaiThu();
            ArrayList<String> dsTenLoai = new ArrayList<String>();
            for(int i=0;i<dsLoaiThu.size();i++){
                dsTenLoai.add(dsLoaiThu.get(i).getTenLoaiThu());
            }
            ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, dsTenLoai);
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(arrayAdapter);
            builder.setView(viewdialog);
            builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
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
                    String mota_khoan = editTextTenMoTa.getText().toString();
                    KhoanThu khoanThu = new KhoanThu(ten_khoan, ngay_khoan, sotien_khoan, mota_khoan,idLoai);
                    KhoanthuDAO khoanthuDAO = new KhoanthuDAO(getContext());
                    khoanthuDAO.themKhoanThu(khoanThu);
                    dsKhoanThu = khoanthuDAO.xemKhoanThu();
                    adapter_khoan_thu = new Adapter_Khoan_Thu(dsKhoanThu, getContext());
                    recyclerView.setAdapter(adapter_khoan_thu);
                }
            });
            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {dialogInterface.cancel();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
        });
        return view;
    }
}

