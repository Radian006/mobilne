package com.example.rejestracja;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText emailInput;
    private EditText hasloInput;
    private Button przyciskZatwierdz;
    private TextView komunikatWyjsciowy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        emailInput = findViewById(R.id.email);
        hasloInput = findViewById(R.id.haslo);
        przyciskZatwierdz = findViewById(R.id.zatwierdz);
        komunikatWyjsciowy = findViewById(R.id.blad);

        przyciskZatwierdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailInput.getText().toString().trim();
                String haslo = hasloInput.getText().toString();


                if (email.isEmpty() || haslo.isEmpty()) {
                    komunikatWyjsciowy.setText("Proszę wypełnić wszystkie pola");
                    return;
                }


                if (!email.contains("@")) {
                    komunikatWyjsciowy.setText("Produkt e-mail musi zawierać znak @");
                    return;
                }


                String bladHasla = sprawdzHaslo(haslo);
                if (bladHasla != null) {
                    komunikatWyjsciowy.setText(bladHasla);
                } else {
                    komunikatWyjsciowy.setText("Zarejestrowano pomyślnie!");
                }
            }
        });
    }

    private String sprawdzHaslo(String haslo) {
        if (haslo.length() < 16){
            return "Hasło musi mieć co najmniej 16 znaków";
        }
        if (!haslo.matches(".*[a-z].*")){
            return "Hasło musi mieć małą literę";
        }
        if (!haslo.matches(".*[A-Z].*")){
            return "Hasło musi mieć wielką literę";
        }
        if (!haslo.matches(".*\\d.*")){
            return "Hasło musi mieć cyfrę";
        }
        if (!haslo.matches(".*[!@#$%].*")){
            return "Hasło musi mieć znak specjalny (!@#$%)";
        }

        return null;
    }
}