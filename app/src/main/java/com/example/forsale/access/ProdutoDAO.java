package com.example.forsale.access;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.forsale.helper.ConectDB;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private ConectDB conexao;
    private SQLiteDatabase banco;

    public ProdutoDAO (Context context) {
        conexao = new ConectDB(context);
        banco = conexao.getWritableDatabase();
    }

    public ArrayList<Produto> obterTodos(String where) {
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        Cursor cursor = banco.query("produto", new String[]{"nome", "tipo", "descricao", "valor"}, "tipo=?" , new String[]{where} , null, null, null);
        while(cursor.moveToNext()) {
            Produto p = new Produto();
            p.setNome(cursor.getString(0));
            p.setTipo(cursor.getString(1));
            p.setDescricao(cursor.getString(2));
            p.setValor(cursor.getFloat(3));
            produtos.add(p);
        }
        return produtos;
    }
}
