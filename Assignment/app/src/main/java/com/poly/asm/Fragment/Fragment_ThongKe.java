package com.poly.asm.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.poly.asm.DAO.KhoanchiDao;
import com.poly.asm.DAO.KhoanthuDAO;
import com.poly.asm.DAO.LoaiThuDAO;
import com.poly.asm.DAO.LoaichiDAO;
import com.poly.asm.R;

import java.util.ArrayList;
import java.util.Collections;

public class Fragment_ThongKe extends Fragment implements OnChartValueSelectedListener {
    KhoanchiDao khoanchiDao;
    KhoanthuDAO khoanthuDAO;
    LoaichiDAO loaichiDAO;
    LoaiThuDAO loaiThuDAO;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thongke, container, false);

        khoanchiDao = new KhoanchiDao(getContext());
        khoanthuDAO = new KhoanthuDAO(getContext());
        loaichiDAO = new LoaichiDAO(getContext());
        loaiThuDAO = new LoaiThuDAO(getContext());

        PieChart mChart = view.findViewById(R.id.piechart);
        mChart.setRotationEnabled(true);
        mChart.setDescription(new Description());
        mChart.setHoleRadius(35f);
        mChart.setTransparentCircleAlpha(0);
        mChart.setCenterText("Thống kê");
        mChart.setCenterTextSize(10);
        mChart.setDrawEntryLabels(true);
//        addDataSet(mChart);
        mChart.setOnChartValueSelectedListener(this);
        return view;

    }

//    private void addDataSet(PieChart mChart) {
//    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }
//    private void addDataSet(PieChart pieChart) {
//        ArrayList<PieEntry> entrys = new ArrayList<>();
//        float[] yData = khoanchiDao.getThongTinThuChi();
////        float[] yData = khoanthuDAO.getThongTinThuChi();
//        String[] xData = {"Khoản thu", "Khoản chi"};
//        for (int i = 0; i < yData.length; i++) {
//            entrys.add(new PieEntry(yData[i], xData[i]));
//        }
//
//        PieDataSet pieDataSet = new PieDataSet(entrys, " ");
//        pieDataSet.setSliceSpace(2);
//        pieDataSet.setValueTextSize(12);
//        ArrayList<Integer> colors = new ArrayList<>();
//        colors.add(Color.BLUE);
//        colors.add(Color.RED);
//        pieDataSet.setColors(colors);
//        Legend legend = pieChart.getLegend();
//        legend.setForm(Legend.LegendForm.CIRCLE);
//        PieData pieData = new PieData(pieDataSet);
//        pieChart.setData(pieData);
//        pieChart.invalidate();
//    }
    }
