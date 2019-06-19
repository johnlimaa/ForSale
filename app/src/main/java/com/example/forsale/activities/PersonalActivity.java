package com.example.forsale.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.forsale.R;
import com.example.forsale.access.Usuario;
import com.example.forsale.access.UsuarioDAO;

import java.util.ArrayList;

public class PersonalActivity extends AppCompatActivity {

    private TextView nome;
    private TextView mail;
    private TextView cpf;

    private UsuarioDAO dao;
    private ArrayList<Usuario> user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);

        dao = new UsuarioDAO(this);

        nome =  findViewById(R.id.textViewPersonalName);
        mail = findViewById(R.id.textViewPersonalMail);
        cpf = findViewById(R.id.textViewPersonalCpf);

        Intent ints = getIntent();

        try {
            user = dao.obetAlguns(ints.getStringExtra("mail"), ints.getStringExtra("senha"));

            nome.setText(user.get(0).getNome());
            mail.setText(user.get(0).getMail());
            cpf.setText(String.valueOf(user.get(0).getCpf()));

        } catch (Exception e) {
            Toast.makeText(PersonalActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}
