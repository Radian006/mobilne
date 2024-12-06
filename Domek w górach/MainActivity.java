package com.example.domek_w_gorach;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button przycisk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        przycisk=findViewById(R.id.polubienie);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        przycisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    private void zwieksz(){
        przycisk.setText("Polubienia: "+ Counter.getCount());
    }
}