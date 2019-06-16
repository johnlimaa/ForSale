package com.example.forsale.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.forsale.R;
import com.example.forsale.access.Usuario;
import com.example.forsale.access.UsuarioDAO;

public class CadastroActivity extends AppCompatActivity {

    private Button btn_cadastro;
    private Button btn_back;

    private EditText nome;
    private EditText mail;
    private EditText senha;
    private EditText cpf;
    private UsuarioDAO dao_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        btn_back = findViewById(R.id.btn_back);

        btn_cadastro = findViewById(R.id.btn_cadastro);
        dao_user = new UsuarioDAO(this);
        nome = findViewById(R.id.editTextNome);
        mail = findViewById(R.id.editTextMail);
        senha = findViewById(R.id.editTextSenha);
        cpf = findViewById(R.id.editTextCpf);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                call_back();
            }
        });
        btn_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario u = new Usuario();
                u.setNome(nome.getText().toString());
                u.setMail(mail.getText().toString());
                u.setSenha(senha.getText().toString());
                u.setCpf(Long.valueOf(cpf.getText().toString()));
                long id = dao_user.insertUser(u);
                Toast.makeText(CadastroActivity.this, "User " + id + " inserido", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void call_back() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
