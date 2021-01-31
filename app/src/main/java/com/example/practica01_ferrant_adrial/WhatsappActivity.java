package com.example.practica01_ferrant_adrial;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
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

public class WhatsappActivity extends AppCompatActivity {
    ListView ListView;
    String mUsuari[]={"Joan","Carla","Júlia","Pere","Jaume"};
    String mMissatge[]={"Hola bon dia!","Ens veiem demà","Com portes els deures?","Hola","Al final acceptes el contracte?"};
    String mHora[]={"11:24","17:32","19:12","20:30","21:03"};
    int images []={R.drawable.image01,R.drawable.image02,R.drawable.image03,R.drawable.image04,R.drawable.image05};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whatsapp);

        ListView = findViewById(R.id.ListView);

        MyAdapter adapter= new MyAdapter( this, mUsuari,mMissatge,images,mHora);
        ListView.setAdapter(adapter);

        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Intent intent;
                final Intent intent2;
                switch (position){
                    case 0:
                        intent = new Intent(WhatsappActivity.this,Joan.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent2 = new Intent(WhatsappActivity.this,Carla.class);
                        startActivity(intent2);
                        break;
                    case 2:
                        intent = new Intent(WhatsappActivity.this,julia.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent2 = new Intent(WhatsappActivity.this,Pere.class);
                        startActivity(intent2);
                        break;
                    case 4:
                        intent2 = new Intent(WhatsappActivity.this,Jaume.class);
                        startActivity(intent2);
                        break;
                }
            }
        });
    }

    class MyAdapter extends ArrayAdapter <String>{
        Context context;
        String rUsuari[];
        String rMissatge[];
        int rImatge[];
        String rHora[];

        MyAdapter(Context c, String Usuari[], String Missatge[],int Imatge[],String Hora[]){
            super(c,R.layout.row,R.id.textUsuari,Usuari);
            this.context=c;
            this.rUsuari=Usuari;
            this.rMissatge=Missatge;
            this.rImatge=Imatge;
            this.rHora=Hora;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater= (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row=layoutInflater.inflate(R.layout.row,parent,false);
            ImageView images=row.findViewById(R.id.image);
            TextView myUsuari=row.findViewById(R.id.textUsuari);
            TextView myMissatge=row.findViewById(R.id.textMissatge);
            TextView myHora=row.findViewById(R.id.textHora);

            images.setImageResource(rImatge[position]);
            myUsuari.setText(rUsuari[position]);
            myMissatge.setText(rMissatge[position]);
            myHora.setText(rHora[position]);

            return row;
        }
    }
}