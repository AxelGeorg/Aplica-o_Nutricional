package com.example.appconsultanutricional;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appconsultanutricional.controllers.TabelaNutricionalController;
import com.example.appconsultanutricional.models.Alimento;

public class ExibeAlimento extends AppCompatActivity {

    TabelaNutricionalController tabelaNutricionalController;
    Alimento alimento;

    TextView textViewCategoria;
    TextView textViewAlimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibe_alimento);

        int idAlimento = getIntent().getExtras().getInt("id");

        this.tabelaNutricionalController = new TabelaNutricionalController(getBaseContext());
        this.alimento = tabelaNutricionalController.getAlimentos().get(idAlimento);

        this.textViewCategoria = findViewById(R.id.textViewCategoria);
        this.textViewAlimento = findViewById(R.id.textViewAlimento);

        this.textViewCategoria.setText(this.alimento.getCategoria());
        this.textViewAlimento.setText(this.alimento.getNome());
    }
}

