package com.example.forsale.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.example.forsale.R;
import com.example.forsale.access.Produto;
import com.example.forsale.access.ProdutoDAO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btn_login;
    private Button btn_cadastrar;
    private Button btn_buscar;

    private EditText area_pesquisa;

    private ProdutoDAO dao;
    private List<Produto> produtos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_login = findViewById(R.id.btn_login);
        btn_cadastrar = findViewById(R.id.btn_cadastrar);
        btn_buscar = findViewById(R.id.btn_buscar);

        area_pesquisa = findViewById(R.id.area_pesquisa);

        dao = new ProdutoDAO(this);

        btn_buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String busca = area_pesquisa.getText().toString();
                call_busca(busca);
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                call_login();
            }
        });
        btn_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                call_cadastro();
            }
        });
    }

    public void call_busca(String where) {
        Intent intent = new Intent(this, PesquisaActivity.class);
        Bundle bundle = new Bundle();
        produtos = dao.obterTodos(where);
        //intent.putStringArrayListExtra("produtos", (ArrayList) produtos);
        bundle.putSerializable("produtos", (Serializable) produtos);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void call_login() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void call_cadastro() {
        Intent intent = new Intent(this, CadastroActivity.class);
        startActivity(intent);
    }
}
