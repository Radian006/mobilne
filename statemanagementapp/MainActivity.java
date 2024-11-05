package com.example.statemanagementapp;

import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.util.Log;
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
    private static final String KEY_TEXT = "awdbhiahwduawghdiahwudh";
    private static final String KEY_BOX = "abudabi";

    private CountViewModel countViewModel;
    private TextView TextViewCount;
    private CheckBox box;
    private Switch zmiana;
    private TextView napis;
    private TextView main;
    private EditText edittext;
    private boolean kolor = false;
    private boolean klik = false;
    private Button buttonIncrement;
    private View Layout;

    private TextView textViewCount;
    private String placeholder_edittext = "";
    private String checkBox;
    private int count =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewCount = findViewById(R.id.textViewCount);
        buttonIncrement = findViewById(R.id.buttonIncrement);
        napis = findViewById(R.id.napis);
        edittext = findViewById(R.id.edittext);
        zmiana = findViewById(R.id.Swigga);
        Layout = findViewById(R.id.main);
        box = findViewById(R.id.box);

        box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                klik=!klik;
                updateCheckboxNapis();
            }
        });


        zmiana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kolor = !kolor;
                colorChange(kolor);
            }
        });

        if(savedInstanceState != null){
            count = savedInstanceState.getInt(KEY_COUNT);
            kolor = savedInstanceState.getBoolean(klucz_kolor);
            klik = savedInstanceState.getBoolean(KEY_BOX);
            placeholder_edittext = savedInstanceState.getString(KEY_TEXT);
        }

        updateCountText();
        colorChange(kolor);
        updateCheckboxNapis();
//        getText();


        countViewModel = new ViewModelProvider(this).get(com.example.statemanagementapp.CountViewModel.class);

        Log.i("info", placeholder_edittext);
        buttonIncrement.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                placeholder_edittext = edittext.getText().toString();
                CountViewModel.incrementCount();
                updateCountText();
            }
        });
    }


    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString(KEY_TEXT, placeholder_edittext);
        outState.putBoolean(KEY_BOX, klik);
        outState.putBoolean(klucz_kolor, kolor);
        outState.putInt(KEY_COUNT, count);
    }
    private void colorChange(Boolean kolor) {

        if(kolor){
            Layout.setBackgroundResource(R.color.black);
            box.setTextColor(getColor(R.color.white));
            napis.setTextColor(getColor(R.color.white));
            textViewCount.setTextColor(getColor(R.color.white));
            edittext.setTextColor(getColor(R.color.white));
            zmiana.setText("Light mode");
            zmiana.setTextColor(getColor(R.color.white));
        }
        if(!kolor){
            Layout.setBackgroundResource(R.color.white);
            textViewCount.setTextColor(getColor(R.color.black));
            napis.setTextColor(getColor(R.color.black));
            box.setTextColor(getColor(R.color.black));
            edittext.setTextColor(getColor(R.color.black));
            zmiana.setText("Dark mode");
            zmiana.setTextColor(getColor(R.color.black));
        }
    }
    private void updateCheckboxNapis(){
        if(klik){
            napis.setText("Opcja zaznaczona");
        }
        if(!klik){
            napis.setText(" ");
        }
    }

    private void updateCountText(){
        textViewCount.setText("Licznik: "+ CountViewModel.getCount());


    }

}