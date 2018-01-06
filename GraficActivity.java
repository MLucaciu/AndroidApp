package com.example.mircea.aplicatiemobila;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mircea.aplicatiemobila.entity.Orase;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.Random;

public class GraficActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafic);
    }

    protected void onStart(){
        super.onStart();

        PieChart pieChart = (PieChart) findViewById(R.id.chart);

        ArrayList<PieEntry> yEntrys = new ArrayList<>();
        ArrayList<String> xEntrys = new ArrayList<>();
        ArrayList<Integer> colors = new ArrayList<>();

        for(int i = 0; i < Orase.ITEMS.size(); i++){
            yEntrys.add(new PieEntry(Orase.ITEMS.get(i).populatie , Orase.ITEMS.get(i).content));
            xEntrys.add(Orase.ITEMS.get(i).tara);
            Random rnd = new Random();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            colors.add(color);
        }

        //create the data set
        PieDataSet pieDataSet = new PieDataSet(yEntrys, "Friend Color");
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueTextSize(12);

        //add colors to dataset

        pieDataSet.setColors(colors);

        Legend legend = pieChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART);

        //create pie data object
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();
    }
}
