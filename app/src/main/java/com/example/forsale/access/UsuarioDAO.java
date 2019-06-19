package com.example.forsale.access;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.forsale.helper.ConectDB;

import java.util.ArrayList;

public class UsuarioDAO {

    private ConectDB conexao;
    private SQLiteDatabase banco;

    public UsuarioDAO(Context context) {
        conexao = new ConectDB(context);
        banco = conexao.getWritableDatabase();
    }

    public long insertUser(Usuario user) {
        ContentValues values = new ContentValues();
        values.put("nome", user.getNome());
        values.put("mail", user.getMail());
        values.put("senha", user.getSenha());
        values.put("cpf", user.getCpf());

        return banco.insert("usuario", null, values);
    }

    public String possoLogar(String luser, String lsenha) {
        Cursor cursor = banco.rawQuery("select * from usuario where mail=? and senha=?", new String[]{luser, lsenha});

        if (cursor.getCount() > 0) {
            return "OK";
        }
        return "ERRO";
    }

    public ArrayList<Usuario> obetAlguns(String mail, String senha) {
        ArrayList<Usuario> users = new ArrayList<Usuario>();
        Cursor cursor = banco.rawQuery("select * from usuario where mail=? and senha=?", new String[]{mail, senha});
        while(cursor.moveToNext()) {
            Usuario u = new Usuario();
            u.setNome(cursor.getString(1));
            u.setMail(cursor.getString(2));
            u.setCpf(cursor.getLong(4));
            users.add(u);
        }
        return users;
    }

}
