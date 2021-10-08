package com.example.clase1octubre;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Basededatos extends SQLiteOpenHelper {
    private static final String Nombre_DB = "bdproyecto.bd";
    private static final int Version_DB =1;
    private static final String Tabla_Estudiantes= "create table estudiantes(codigo int primary key," +
            "nombre text, carrera text)";

    public Basededatos(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Tabla_Estudiantes);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF exists" +Tabla_Estudiantes);
        sqLiteDatabase.execSQL(Tabla_Estudiantes);

    }

    public void agregarEstudiante(int codigo, String nombre, String carrera){
        SQLiteDatabase bd=getReadableDatabase();
        if(bd!=null){
            bd.execSQL("INSERT INTO estudiantes values('"+codigo+"','"+nombre+"','"+carrera+"')");
            bd.close();
        }
    }
}
