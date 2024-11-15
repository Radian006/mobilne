package com.example.grawkosci;

import java.util.Random;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button przycisk;
    Button reset;
    TextView liczba1;
    TextView liczba2;
    TextView liczba3;
    TextView liczba4;
    TextView liczba5;
    TextView ileRazy;


    int[] tablica = new int[5];
    int wynikGry;
    int wynikLosowania;
    int IloscRzutow=0;
    TextView wynikNapis;
    TextView wynikLosowaniaNapis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        przycisk=findViewById(R.id.rzutKośćmi);
        reset=findViewById(R.id.reset);
        liczba1=findViewById(R.id.liczba1);
        liczba2=findViewById(R.id.liczba2);
        liczba3=findViewById(R.id.liczba3);
        liczba4=findViewById(R.id.liczba4);
        liczba5=findViewById(R.id.liczba5);
        ileRazy=findViewById(R.id.ileRazy);
        wynikNapis=findViewById(R.id.wynikGry);
        wynikLosowaniaNapis=findViewById(R.id.wynikLosowania);

        wynikGry=0;
        wynikLosowania=0;


        przycisk.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                przypisanie();
                punkty();
                IleRazyRzucono();
                wynikNapis.setText("Wynik Gry: " + wynikGry);
                wynikLosowaniaNapis.setText("Wynik tego Losowania: "+ wynikLosowania);
                ileRazy.setText("Ile Razy: "+IloscRzutow);
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                reset();

                wynikNapis.setText("Wynik Gry: " + wynikGry);
                wynikLosowaniaNapis.setText("Wynik tego Losowania: "+ wynikLosowania);
                ileRazy.setText("Ile Razy: "+IloscRzutow);
            }
        });

    }
    private int[] losowaLiczba(int[] tablica){
        Random losowy = new Random();
        for(int i=0;i<tablica.length;i++){
            tablica[i] = losowy.nextInt(6)+1;
        }
        return tablica;
    }
    private void przypisanie(){
        tablica = losowaLiczba(tablica);
        liczba1.setText(String.valueOf(tablica[0]));
        liczba2.setText(String.valueOf(tablica[1]));
        liczba3.setText(String.valueOf(tablica[2]));
        liczba4.setText(String.valueOf(tablica[3]));
        liczba5.setText(String.valueOf(tablica[4]));
    }
    private void reset(){
        liczba1.setText("?");
        liczba2.setText("?");
        liczba3.setText("?");
        liczba4.setText("?");
        liczba5.setText("?");

        wynikLosowania=0;
        wynikGry=0;
        IloscRzutow=0;

    }
    private void punkty(){
        wynikLosowania=0;
        for(int i=0; i<tablica.length; i++) {
            int ileRazy = 1;
            for (int j = 0; j < tablica.length; j++) {
                if (i == j) {
                    continue;
                }
                if (tablica[i] == tablica[j]) {
                    ileRazy++;
                    break;
                }
            }
            if (ileRazy > 1) {
                wynikLosowania += tablica[i];
                wynikGry += tablica[i];
            }
        }
    }
    private void IleRazyRzucono(){
        IloscRzutow++;
    }
}