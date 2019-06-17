package com.example.forsale.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConectDB extends SQLiteOpenHelper {

    private static final String name = "banco.db";
    private static final int version = 1;

    public ConectDB(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase banco) {
        banco.execSQL("create table usuario(id integer primary key autoincrement, " +
                        "nome varchar(80) not null, mail varchar(60) not null, senha varchar(20) not null, cpf bigint unique not null)");

        banco.execSQL("create table produto(id integer primary key autoincrement, " +
                        "nome varchar(60) not null, descricao varchar(240), tipo varchar(20) not null, valor float not null)");

        // Inserindo dados na tabela de produtos
        banco.execSQL("insert into produto (nome, descricao, tipo, valor) values ('Lenovo ThinkPad', 'core i5 7440, 4GB 1600 Mhz e 500 GB de Hard Disk','notebook', 1890.90)");
        banco.execSQL("insert into produto (nome, descricao, tipo, valor) values ('Samsung Essential', 'core i3 8400, 8GB 1333 Mhz e 1 TB de Hard Disk','notebook', 1350.90)");
        banco.execSQL("insert into produto (nome, descricao, tipo, valor) values ('Dell G3', 'core i7 8400, 16GB 1600 Mhz, 1 TB de Hard Disk e GTX 1030 de 2 GB','notebook', 4400.90)");
        banco.execSQL("insert into produto (nome, descricao, tipo, valor) values ('Sony Vaio', 'core i5 6400, 4GB 1600 Mhz e 240 GB de Solid State Disk','notebook', 3290.90)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
