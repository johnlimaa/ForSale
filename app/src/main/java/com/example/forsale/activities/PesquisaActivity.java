package com.example.forsale.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.forsale.R;
import com.example.forsale.access.Produto;
import com.example.forsale.access.ProdutoDAO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PesquisaActivity extends AppCompatActivity {

    private ListView listView;
    private List<Produto> produtos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa);

        listView = findViewById(R.id.listaDeBusca);
        Bundle busca_intent = getIntent().getExtras();

        if(busca_intent != null) {
            produtos = (List) busca_intent.getSerializable("produtos");
            ArrayAdapter<Produto> adaptador = new ArrayAdapter<Produto>(this, android.R.layout.simple_list_item_1, produtos);
            listView.setAdapter(adaptador);
        }
    }
}
