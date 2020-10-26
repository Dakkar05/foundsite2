package com.example.foundsite;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;
import java.util.ArrayList;

public class MarcarPosicion {
    private String titulo;
    private double latitud , longitud;

    public MarcarPosicion(String titulo, double latitud, double longitud) {
        this.titulo = titulo;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public MarcarPosicion() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }


    public String toString(){
        return  titulo;
    }

    public SQLiteDatabase lectura(Context context){
        BaseDatos bd = new BaseDatos(context);
        return  bd.getReadableDatabase();
    }
    public SQLiteDatabase escritura(Context context){
        BaseDatos bd = new BaseDatos(context);
        return  bd.getWritableDatabase();
    }


    public ArrayAdapter<Object> obtenerMarcadores (Context context){
        try {
            ArrayAdapter<Object> adapter = new ArrayAdapter<>(context , android.R.layout.simple_list_item_1);
            ArrayList<Object> arrayList = new ArrayList<>();
            Cursor c = lectura(context).rawQuery(" SELECT * from marcador " , null);

            while (c.moveToFirst()){
                arrayList.add(new MarcarPosicion(c.getString(0) , c.getDouble(1) , c.getDouble(2)));
            }
            adapter.addAll(arrayList);
            return adapter;
        }catch (Exception e){
            return new ArrayAdapter<Object>(context,android.R.layout.simple_list_item_1);
        }
    }

    public long ingresar (Context context){
        ContentValues content = new ContentValues();
//        content.put("titulo" , titulo);
//        content.put("latitud" , latitud);
//        content.get("longitud" , longitud);
        content.get(String.valueOf(longitud));
        content.get(String.valueOf(latitud));
        content.get(String.valueOf(titulo));
        return escritura(context).insert("marcador" , null , content);
    }

}
