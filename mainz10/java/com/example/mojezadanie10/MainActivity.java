package com.example.mojezadanie10;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    SeekBar suwakWiek;
    TextView napisWiek;
    int iloscWSuwaku;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        napisWiek = findViewById(R.id.napisWiek);
        suwakWiek = findViewById(R.id.suwakWiek);

        iloscWSuwaku = -1;

        TimePicker zegar = findViewById(R.id.wybierzGodzine);
        zegar.setIs24HourView(true);
        zegar.setHour(16);
        zegar.setMinute(0);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.listaSpinnera,
                android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        suwakWiek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar suwakWiek, int i, boolean b) {
                if(b && iloscWSuwaku!=-1){
                    napisWiek.setText("Lat: " + i);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if(iloscWSuwaku!=-1){
                    napisWiek.setText("Lat: "+String.valueOf(suwakWiek.getProgress()));
                }
            }
        });
    }
}