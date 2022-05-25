package com.example.appconsultanutricional.models;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TabelaNutricionalDAO {

    SQLiteDatabase bd;

    public TabelaNutricionalDAO(Context context) {
        bd = context.openOrCreateDatabase("csv_db", context.MODE_PRIVATE, null);

        try {
            abreArquivoSQL(context);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void abreArquivoSQL(Context context) throws IOException {

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(context.getAssets().open("taco_4___edicao.sql"), "UTF-8"));
        String line;
        while ((line = reader.readLine()) != null) {
            String lineSQL = line.toString();
            this.bd.execSQL(lineSQL);
        }
    }

    public ArrayList<Alimento> getAlimentos() {

        ArrayList<Alimento> arraylistadeAlimentos = new ArrayList<Alimento>();

        Cursor cursor;
        cursor = bd.rawQuery("SELECT * FROM taco_4", null,null);
        cursor.moveToFirst();

        while(!cursor.isAfterLast())
        {
            Alimento alimento = new Alimento();
            alimento.setCategoria(cursor.getString(cursor.getColumnIndexOrThrow("Caterogia")));
            alimento.setNome(cursor.getString(cursor.getColumnIndexOrThrow("Alimento")));
            /*alimento.setUmidade(cursor.getString(cursor.getColumnIndexOrThrow("Umidade")));
            alimento.setEnergiakcal(cursor.getString(cursor.getColumnIndexOrThrow("Energiakcal")));
            alimento.setkJ(cursor.getString(cursor.getColumnIndexOrThrow("kJ")));
            alimento.setProteonag(cursor.getString(cursor.getColumnIndexOrThrow("Proteonag")));
            alimento.setLipodeosg(cursor.getString(cursor.getColumnIndexOrThrow("Lipodeosg")));
            alimento.setColesterolmg(cursor.getString(cursor.getColumnIndexOrThrow("Colesterolmg")));
            alimento.setCarboidratosg(cursor.getString(cursor.getColumnIndexOrThrow("Carboidratosg")));
            alimento.setFibraAlimentarg(cursor.getString(cursor.getColumnIndexOrThrow("FibraAlimentarg")));
            alimento.setCinzasg(cursor.getString(cursor.getColumnIndexOrThrow("Cinzasg")));
            alimento.setCalciomg(cursor.getString(cursor.getColumnIndexOrThrow("Calciomg")));
            alimento.setMagnesiomg(cursor.getString(cursor.getColumnIndexOrThrow("Magnesiomg")));
            alimento.setManganesmg(cursor.getString(cursor.getColumnIndexOrThrow("Manganesmg")));
            alimento.setFosforomg(cursor.getString(cursor.getColumnIndexOrThrow("Fósforomg")));
            alimento.setFerromg(cursor.getString(cursor.getColumnIndexOrThrow("Ferromg")));
            alimento.setSodiomg(cursor.getString(cursor.getColumnIndexOrThrow("Sódiomg")));
            alimento.setPotassiomg(cursor.getString(cursor.getColumnIndexOrThrow("Potassiomg")));
            alimento.setCobremg(cursor.getString(cursor.getColumnIndexOrThrow("Cobremg")));
            alimento.setZincomg(cursor.getString(cursor.getColumnIndexOrThrow("Zincomg")));
            alimento.setRetinolmcg(cursor.getString(cursor.getColumnIndexOrThrow("Retinolmcg")));
            alimento.setRemcg(cursor.getString(cursor.getColumnIndexOrThrow("REmcg")));
            alimento.setRaemcg(cursor.getString(cursor.getColumnIndexOrThrow("RAEmcg")));
            alimento.setTiaminamg(cursor.getString(cursor.getColumnIndexOrThrow("Tiaminamg")));
            alimento.setRiboflavinamg(cursor.getString(cursor.getColumnIndexOrThrow("Riboflavinamg")));
            alimento.setPiridoxinamg(cursor.getString(cursor.getColumnIndexOrThrow("Piridoxinamg")));
            alimento.setNiacinamg(cursor.getString(cursor.getColumnIndexOrThrow("Niacinamg")));
            alimento.setVitaminaCmg(cursor.getString(cursor.getColumnIndexOrThrow("VitaminaCmg")));*/

            arraylistadeAlimentos.add(alimento);
            cursor.moveToNext();
        }

        return arraylistadeAlimentos;
    }
}
