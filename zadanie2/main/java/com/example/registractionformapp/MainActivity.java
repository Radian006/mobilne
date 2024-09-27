package com.example.registractionformapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{

    private EditText editTextName;
    private EditText editTextEmail;
    private Button buttonSubmit;
    private EditText password;
    private EditText checkpassword;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.password);
        checkpassword = findViewById(R.id.checkpassword);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String name = editTextName.getText().toString().trim();
               String email = editTextEmail.getText().toString().trim();
               String password = editTextEmail.getText().toString().trim();
               String checkpassword = editTextEmail.getText().toString().trim();

               if (name.isEmpty()) {
                   Toast.makeText(MainActivity.this, "Proszę wprowadzić imę", Toast.LENGTH_SHORT).show();
               } else if (email.isEmpty()) {
                   Toast.makeText(MainActivity.this, "Proszę wprowadzić adres e-mail", Toast.LENGTH_SHORT).show();
               } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                   Toast.makeText(MainActivity.this, "Niepoprawny adres e-mail", Toast.LENGTH_SHORT).show();
               } else if (password.isEmpty()) {
                   Toast.makeText(MainActivity.this, "Proszę wprowadzić Hasło", Toast.LENGTH_SHORT).show();
               } else if (checkpassword.equals(password)) {
                   Toast.makeText(MainActivity.this, "Proszę wprowadzić poprawne hasło", Toast.LENGTH_SHORT).show();
               } else {
                   Toast.makeText(MainActivity.this, "Formularz przesłany poprawnie", Toast.LENGTH_SHORT).show();
               }
           }
        });
    }
}