package com.example.kostki;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final int MAX_W_WIERSZU = 5;
    private static final int MIN_KOSTEK = 1;
    private static final int MAX_KOSTEK = 100;

    private EditText editTextLiczbaKostek;
    private GridLayout gridKostki;
    private TextView textViewWyniki;

    
    private final ArrayList<Integer> wyniki = new ArrayList<>();
    private final Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextLiczbaKostek = findViewById(R.id.editTextLiczbaKostek);
        gridKostki = findViewById(R.id.gridKostki);
        textViewWyniki = findViewById(R.id.textViewWyniki);
        Button buttonLosuj = findViewById(R.id.buttonLosuj);
        Button buttonRosnaco = findViewById(R.id.buttonRosnaco);
        Button buttonMalejaco = findViewById(R.id.buttonMalejaco);

        
        gridKostki.setColumnCount(MAX_W_WIERSZU);

        buttonLosuj.setOnClickListener(v -> losuj());

        buttonRosnaco.setOnClickListener(v -> {
            if (!czySaWyniki()) return;
            sortujRosnaco(wyniki);
            odswiezWidok();
        });

        buttonMalejaco.setOnClickListener(v -> {
            if (!czySaWyniki()) return;
            sortujMalejaco(wyniki);
            odswiezWidok();
        });
    }

    

    private void losuj() {
        String tekst = editTextLiczbaKostek.getText().toString().trim();

        if (tekst.isEmpty()) {
            pokazKomunikat("Wpisz liczbę kostek.");
            return;
        }

        int liczba;
        try {
            liczba = Integer.parseInt(tekst);
        } catch (NumberFormatException e) {
            pokazKomunikat("Wpisana wartość nie jest poprawną liczbą.");
            return;
        }

        if (liczba < MIN_KOSTEK) {
            pokazKomunikat("Liczba kostek musi być większa od zera.");
            return;
        }
        if (liczba > MAX_KOSTEK) {
            pokazKomunikat("Liczba kostek nie może być większa niż " + MAX_KOSTEK + ".");
            return;
        }

        
        wyniki.clear();
        for (int i = 0; i < liczba; i++) {
            wyniki.add(random.nextInt(6) + 1); // 1..6
        }
        odswiezWidok();
    }

    private boolean czySaWyniki() {
        if (wyniki.isEmpty()) {
            pokazKomunikat("Najpierw wylosuj kostki.");
            return false;
        }
        return true;
    }

    
    private void sortujRosnaco(ArrayList<Integer> lista) {
        int n = lista.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (lista.get(j) > lista.get(j + 1)) {
                    zamien(lista, j, j + 1);
                }
            }
        }
    }

    
    private void sortujMalejaco(ArrayList<Integer> lista) {
        int n = lista.size();
        for (int i = 0; i < n - 1; i++) {
            int indeksNajwiekszego = i;
            for (int j = i + 1; j < n; j++) {
                if (lista.get(j) > lista.get(indeksNajwiekszego)) {
                    indeksNajwiekszego = j;
                }
            }
            if (indeksNajwiekszego != i) {
                zamien(lista, i, indeksNajwiekszego);
            }
        }
    }

    private void zamien(ArrayList<Integer> lista, int a, int b) {
        int pomocnicza = lista.get(a);
        lista.set(a, lista.get(b));
        lista.set(b, pomocnicza);
    }

    

    private void odswiezWidok() {
        // lista wyników oddzielona przecinkami
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < wyniki.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(wyniki.get(i));
        }
        textViewWyniki.setText(sb.toString());

        // kostki w siatce
        gridKostki.removeAllViews();
        int rozmiar = dpNaPx(48);
        int margines = dpNaPx(4);

        for (int wartosc : wyniki) {
            TextView kostka = new TextView(this);
            kostka.setText(String.valueOf(wartosc));
            kostka.setTextSize(22);
            kostka.setTextColor(Color.BLACK);
            kostka.setGravity(Gravity.CENTER);

            GradientDrawable tlo = new GradientDrawable();
            tlo.setColor(Color.WHITE);
            tlo.setCornerRadius(dpNaPx(8));
            tlo.setStroke(dpNaPx(2), Color.DKGRAY);
            kostka.setBackground(tlo);

            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = rozmiar;
            params.height = rozmiar;
            params.setMargins(margines, margines, margines, margines);
            kostka.setLayoutParams(params);

            gridKostki.addView(kostka);
        }
    }

    private void pokazKomunikat(String tekst) {
        Toast.makeText(this, tekst, Toast.LENGTH_SHORT).show();
    }

    private int dpNaPx(int dp) {
        return Math.round(dp * getResources().getDisplayMetrics().density);
    }
}
