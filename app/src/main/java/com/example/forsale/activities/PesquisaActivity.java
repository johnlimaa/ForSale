package com.example.forsale.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.forsale.R;
import com.example.forsale.access.Produto;
import com.example.forsale.access.ProdutoDAO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PesquisaActivity extends AppCompatActivity {

    private ListView list;
    private List<Produto> produtos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa);

        list = findViewById(R.id.listaDeBusca);
        Bundle busca_intent = getIntent().getExtras();

        if(busca_intent != null) {
            produtos = (List) busca_intent.getSerializable("produtos");
            ArrayAdapter<Produto> adaptador = new ArrayAdapter<Produto>(this, android.R.layout.simple_list_item_1, produtos);
            list.setAdapter(adaptador);
        }

        list.setOnClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(position == 0) {
                    Toast.makeText(this, "Item Lenovo Clicked", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
