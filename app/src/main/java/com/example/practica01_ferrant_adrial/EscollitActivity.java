package com.example.practica01_ferrant_adrial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class EscollitActivity extends AppCompatActivity {
Spinner _sphome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escollit);
        _sphome = (Spinner) findViewById(R.id.spHome);
        _sphome.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                final Intent intent;
                final Intent intent2;
                switch (position){
                    case 1:
                        intent = new Intent(EscollitActivity.this,NotesActivity.class);
                    startActivity(intent);
                    break;
                    case 2:
                        intent2 = new Intent(EscollitActivity.this,WhatsappActivity.class);
                        startActivity(intent2);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}