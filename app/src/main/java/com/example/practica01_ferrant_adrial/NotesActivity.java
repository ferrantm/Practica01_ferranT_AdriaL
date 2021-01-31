package com.example.practica01_ferrant_adrial;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class NotesActivity extends AppCompatActivity {
    ListView ListView;
    String mtitol[] = {"Dilluns", "Dimarts", "Dimecres", "Dijous", "Divendres","Dissabte","Diumenge"};
    String mnota[] = {"Anar al dentista a les 13:40, Anar reunió pares escola, apuntar a Alex a l'autoescola ", "Anar gimnas a les 11", "Fer la compra, Aldi, Consum, Mercadona", "Apuntar a la Jordina a les classes de Judo", "Portar el gos al veterinari 17:20","Portar el Alex a partit de futbol a les 9:00","Anar al Cine amb la Laia"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        ListView = findViewById(R.id.ListView);

        NotesActivity.MyAdapter adapter = new MyAdapter(this,mtitol,mnota);
        ListView.setAdapter(adapter);



        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Toast.makeText(NotesActivity.this, "Hola bon dia!", Toast.LENGTH_SHORT);
                }
                if (position == 1) {
                    Toast.makeText(NotesActivity.this, "Ens veiem demà", Toast.LENGTH_SHORT);
                }
                if (position == 2) {
                    Toast.makeText(NotesActivity.this, "Com portes els deures?", Toast.LENGTH_SHORT);
                }
                if (position == 3) {
                    Toast.makeText(NotesActivity.this, "Hola", Toast.LENGTH_SHORT);
                }
                if (position == 4) {
                    Toast.makeText(NotesActivity.this, "Al final acceptes el contracte?", Toast.LENGTH_SHORT);
                }
            }
        });
    }

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String rtitol[];
        String rnota[];

        MyAdapter(Context c, String titol[], String nota[]) {
            super(c, R.layout.rownota, R.id.texttitol, titol);
            this.context = c;
            this.rtitol = titol;
            this.rnota = nota;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rownota = layoutInflater.inflate(R.layout.rownota, parent, false);
            TextView myTitol = rownota.findViewById(R.id.texttitol);
            TextView myNota = rownota.findViewById(R.id.textnota);

            myTitol.setText(rtitol[position]);
            myNota.setText(rnota[position]);

            return rownota;
        }

    }
}
