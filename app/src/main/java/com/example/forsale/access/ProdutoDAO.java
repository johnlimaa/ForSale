package com.example.forsale.access;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.forsale.helper.ConectDB;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private ConectDB conexao;
    private SQLiteDatabase banco;

    public ProdutoDAO (Context context) {
        conexao = new ConectDB(context);
        banco = conexao.getWritableDatabase();
    }

    public List<Produto> obterTodos(String where) {
        List<Produto> produtos = new ArrayList<>();
        Cursor cursor = banco.query("produtos", new String[]{"nome", "descricao", "valor"}, "tipo = " + where, null, null, null, null);
        while(cursor.moveToNext()) {
            Produto p = new Produto();
            p.setNome(cursor.getString(0));
            p.setDescricao(cursor.getString(1));
            p.setValor(cursor.getFloat(2));
            produtos.add(p);
        }

        return produtos;
    }
}
