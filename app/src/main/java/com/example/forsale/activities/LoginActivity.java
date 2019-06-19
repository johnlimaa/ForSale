package com.example.forsale.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.forsale.R;
import com.example.forsale.access.UsuarioDAO;

public class LoginActivity extends AppCompatActivity {

    private EditText user;
    private EditText senha;

    private Button logar;
    private Button voltar;

    private UsuarioDAO dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dao = new UsuarioDAO(this);

        user = findViewById(R.id.editTextUserLogin);
        senha = findViewById(R.id.editTextSenhaLogin);
        logar = findViewById(R.id.buttonLogar);
        voltar = findViewById(R.id.buttonLoginBack);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String temp = dao.possoLogar(user.getText().toString(), senha.getText().toString());

                    if (temp == "OK") {
                        Intent intent = new Intent(LoginActivity.this, PersonalActivity.class);
                        intent.putExtra("mail", user.getText().toString());
                        intent.putExtra("senha", senha.getText().toString());
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this, "Senha ou e-mail incorretos.", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
