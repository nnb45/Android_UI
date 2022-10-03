package com.poly.asm.Fragment;


import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.EditText;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.poly.asm.Adapter.Adapter_LoaiChi;
import com.poly.asm.DAO.LoaichiDAO;
import com.poly.asm.Model.LoaiChi;
import com.poly.asm.R;
import java.util.ArrayList;

public class Fragment_LoaiChi extends Fragment {
    RecyclerView recyclerView;
    ArrayList<LoaiChi> dsLoaiChi = new ArrayList<LoaiChi>();
    LoaichiDAO loaiChiDAO;
    FloatingActionButton floatingActionButton;
    Adapter_LoaiChi adapter_loaiChi;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_loaichi, container, false);
        recyclerView = view.findViewById(R.id.recV_itemchi);
        floatingActionButton = view.findViewById(R.id.btn_them_c);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        loaiChiDAO = new LoaichiDAO(getContext());
        dsLoaiChi = loaiChiDAO.xemLoaiChi();
        adapter_loaiChi = new Adapter_LoaiChi(dsLoaiChi, getContext());
        recyclerView.setAdapter(adapter_loaiChi);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
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

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                LayoutInflater inflater = getLayoutInflater();
                View viewdialog = inflater.inflate(R.layout.dialog_insert_loai, null);
                builder.setView(viewdialog);
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText inputname = viewdialog.findViewById(R.id.name_ten);
                        String name= inputname.getText().toString();
                        LoaichiDAO loaiChiDAO = new LoaichiDAO(getContext());
                        loaiChiDAO.themLoaiChi(new LoaiChi(name));
                        dsLoaiChi = loaiChiDAO.xemLoaiChi();
                        Adapter_LoaiChi adapter_loaiChi = new Adapter_LoaiChi(dsLoaiChi,getContext());
                        recyclerView.setAdapter(adapter_loaiChi);
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
        });
        return view;
    }
}