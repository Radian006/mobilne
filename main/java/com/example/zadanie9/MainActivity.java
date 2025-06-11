package com.example.zadanie9;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView wiek, result;
    private EditText imieNazwisko, cel;
    private SeekBar sb;
    private RadioButton pies, kot, swinkaMorska;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TimePicker tp = findViewById(R.id.time);
        tp.setIs24HourView(true);
        tp.setHour(16);
        tp.setMinute(0);

        wiek = findViewById(R.id.wiek);
        sb = findViewById(R.id.seekBar);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                wiek.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        pies = findViewById(R.id.pies);
        kot = findViewById(R.id.kot);
        swinkaMorska = findViewById(R.id.swinkaMorska);

        pies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb.setMax(18);
                kot.setChecked(false);
                swinkaMorska.setChecked(false);
            }
        });
        kot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb.setMax(20);
                pies.setChecked(false);
                swinkaMorska.setChecked(false);
            }
        });
        swinkaMorska.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb.setMax(9);
                pies.setChecked(false);
                kot.setChecked(false);
            }
        });

        result = findViewById(R.id.result);
        imieNazwisko = findViewById(R.id.imie_nazwisko);
        cel = findViewById(R.id.cel);
        findViewById(R.id.ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String zwierze;
                if(pies.isChecked()){
                    zwierze = "pies";
                }else if(kot.isChecked()){
                    zwierze = "kot";
                }else{
                    zwierze = "wydra";
                }
                result.setText(imieNazwisko.getText() + " z " + zwierze + " lat: " + wiek.getText() +" o godzinie: "+ tp.getHour() + ":"+tp.getMinute() + " w celu: " + cel.getText());
            }
        });
    }
}