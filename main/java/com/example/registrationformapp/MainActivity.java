package com.example.registrationformapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.registrationformapp.R;

public class MainActivity extends AppCompatActivity{

    private EditText editTextName;
    private EditText editTextEmail;
    private Button buttonSubmit;
    private EditText passwordd;
    private EditText checkpasswordd;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        passwordd = findViewById(R.id.password);
        checkpasswordd = findViewById(R.id.checkpassword);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String name = editTextName.getText().toString().trim();
               String email = editTextEmail.getText().toString().trim();
               String password = passwordd.getText().toString().trim();
               String checkpassword = checkpasswordd.getText().toString().trim();

               if (name.isEmpty()) {
                   Toast.makeText(MainActivity.this, "Proszę wprowadzić imę", Toast.LENGTH_SHORT).show();
               } else if (email.isEmpty()) {
                   Toast.makeText(MainActivity.this, "Proszę wprowadzić adres e-mail", Toast.LENGTH_SHORT).show();
               } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                   Toast.makeText(MainActivity.this, "Niepoprawny adres e-mail", Toast.LENGTH_SHORT).show();
               } else if (password.isEmpty()) {
                   Toast.makeText(MainActivity.this, "Proszę wprowadzić Hasło", Toast.LENGTH_SHORT).show();
               } else if (password.length() <6) {
                   Toast.makeText(MainActivity.this, "Proszę wprowadzić dłuuuuugie hasło", Toast.LENGTH_SHORT).show();
               } else if (!checkpassword.equals(password)) {
                   Toast.makeText(MainActivity.this, "Proszę wprowadzić poprawne hasło", Toast.LENGTH_SHORT).show();
               } else {
                   Toast.makeText(MainActivity.this, "Formularz przesłany poprawnie", Toast.LENGTH_SHORT).show();
               }
           }
        });
    }
}