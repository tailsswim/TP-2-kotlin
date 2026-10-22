
package com.example.tp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String[] animaux = {
            "Chat",
            "Chien",
            "Lion",
            "Éléphant",
            "Lapin",
            "Tigre",
            "Dauphin",
            "Girafe"
    };

    String[] descriptions = {
            "Le chat est un animal domestique indépendant.",
            "Le chien est un animal fidèle et affectueux.",
            "Le lion est un grand félin vivant principalement en Afrique.",
            "L'éléphant est un grand mammifère doté d'une trompe.",
            "Le lapin est un petit mammifère aux longues oreilles.",
            "Le tigre est un grand félin reconnaissable à ses rayures.",
            "Le dauphin est un mammifère marin intelligent.",
            "La girafe est un mammifère doté d'un long cou."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listViewAnimals);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                animaux
        );

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(
                            AdapterView<?> parent,
                            View view,
                            int position,
                            long id) {

                        String animal = animaux[position];
                        String description = descriptions[position];

                        Toast.makeText(
                                MainActivity.this,
                                animal + " : " + description,
                                Toast.LENGTH_LONG
                        ).show();
                    }
                }
        );
    }
}
