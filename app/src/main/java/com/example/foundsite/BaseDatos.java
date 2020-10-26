package com.example.foundsite;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BaseDatos extends SQLiteOpenHelper {
        static String nombre = "mapa";
        static int versions = 1;

    public BaseDatos(Context context) {
        super(context, nombre , null, versions);
    }


    @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            String markador  = "create table marcador(titulo text primary key , latitud decimal(11,9) , longitud decimal(11,9))";
            sqLiteDatabase.execSQL(markador);

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }


