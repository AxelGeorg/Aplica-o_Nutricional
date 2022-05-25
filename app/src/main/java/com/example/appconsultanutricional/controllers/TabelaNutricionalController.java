package com.example.appconsultanutricional.controllers;

import android.content.Context;

import com.example.appconsultanutricional.models.Alimento;
import com.example.appconsultanutricional.models.TabelaNutricionalDAO;

import java.util.ArrayList;
import java.util.List;

public class TabelaNutricionalController {

    TabelaNutricionalDAO tabelaNutricionalDao;
    Context mContext;

    public TabelaNutricionalController(Context context) {
        this.mContext = context;
        this.tabelaNutricionalDao = new TabelaNutricionalDAO(mContext);
    }

    public ArrayList<String> getNomeAlimentos() {
        ArrayList<String> nomesAlimentos = new ArrayList<String>();
        for (Alimento alimento : this.tabelaNutricionalDao.getAlimentos()) {
            nomesAlimentos.add(alimento.getNome());
        }
        return nomesAlimentos;
    }

    public ArrayList<Alimento> getAlimentos() {
        return this.tabelaNutricionalDao.getAlimentos();
    }
}
