package com.example.statemanagementapp;

import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.RelativeLayout;


public class MainActivity extends AppCompatActivity {

    private static final String KEY_COUNT = "count";
    private static final String klucz_kolor = "kolor";

    private CountViewModel countViewModel;
    private TextView TextViewCount;
    private CheckBox box;
    private Switch zmiana;
    private TextView napis;
    private TextView main;
    private EditText edittext;
    private static boolean kolor = false;
    private boolean klik = false;

    private TextView textViewCount;
    private int count =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewCount = findViewById(R.id.textViewCount);
        Button buttonIncrement = findViewById(R.id.buttonIncrement);
        TextView napis = findViewById(R.id.napis);
        EditText edittext = findViewById(R.id.edittext);
        Switch zmiana = findViewById(R.id.Swigga);
        View RelativeLayout = findViewById(R.id.main);
        box = findViewById(R.id.box);

        box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                klik=!klik;
                if(klik){
                    napis.setText("Opcja zaznaczona");
                }
                if(!klik){
                    napis.setText(" ");
                }
            }
        });


        zmiana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kolor=!kolor;
                if(kolor){
                RelativeLayout.setBackgroundResource(R.color.black);
                box.setTextColor(getColor(R.color.white));
                napis.setTextColor(getColor(R.color.white));
                textViewCount.setTextColor(getColor(R.color.white));
                edittext.setTextColor(getColor(R.color.white));
                zmiana.setText("Light mode");
                zmiana.setTextColor(getColor(R.color.white));
                }
                if(!kolor){
                RelativeLayout.setBackgroundResource(R.color.white);
                textViewCount.setTextColor(getColor(R.color.black));
                napis.setTextColor(getColor(R.color.black));
                box.setTextColor(getColor(R.color.black));
                edittext.setTextColor(getColor(R.color.black));
                zmiana.setText("Dark mode");
                zmiana.setTextColor(getColor(R.color.black));
                }
            }
        });

        if(savedInstanceState != null){
            count = savedInstanceState.getInt(KEY_COUNT);
        }
        updateCountText();

        countViewModel = new ViewModelProvider(this).get(com.example.statemanagementapp.CountViewModel.class);
        updateCountText();

        buttonIncrement.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                CountViewModel.incrementCount();
                updateCountText();
            }
        });
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putBoolean(klucz_kolor, kolor);
        outState.putBoolean(String.valueOf(klik), true);
        outState.putString(String.valueOf(napis),"Opcja zaznaczona");
        outState.putInt(KEY_COUNT, count);
    }
    private void updateCountText(){
        textViewCount.setText("Licznik: "+ CountViewModel.getCount());
    }
    
}