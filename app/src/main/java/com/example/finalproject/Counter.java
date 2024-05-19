package com.example.finalproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Counter extends Fragment {

    int angka = 0;
    TextView angkaCounter;

    public Counter() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_counter, container, false);
    }


//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_counter);
//        angkaCounter = findViewById(R.id.tv_counter);
//    }
//
//
//    public void CountClick(View view) {
//        angka=angka+1;
//        angkaCounter.setText(Integer.toString(angka));
//    }
//
//    public void CountClick(View view) {
//        angka=angka-1;
//        angkaCounter.setText(Integer.toString(angka));
//    }

}