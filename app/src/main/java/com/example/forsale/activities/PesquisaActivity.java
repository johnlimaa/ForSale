package com.example.forsale.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.forsale.R;
import com.example.forsale.access.Produto;
import com.example.forsale.access.ProdutoDAO;

import java.util.List;

public class PesquisaActivity extends AppCompatActivity {

    private ListView listCiew;
    private ProdutoDAO dao;
    private List<Produto> produtos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa);
    }
}
