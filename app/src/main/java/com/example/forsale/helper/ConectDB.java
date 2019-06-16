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
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
