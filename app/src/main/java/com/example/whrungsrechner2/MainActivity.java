package com.example.whrungsrechner2;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //einfache Datentypen
    float pfund;
    float euro;
    float kurs = 0.7564f;

    //komplexe Datentypen
    TextView euroAusgeben;
    EditText pfundEingeben;
    EditText kursEingeben;
    Button umrechnen;

    //Listener
    View.OnClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Java- und xml-Datei verbinden.
        setContentView(R.layout.activity_main);

        //Oberflächenelemente werden den komplexen Datentypen zugewiesen.

        //Casting von View zu EditText.
        pfundEingeben = (EditText) findViewById(R.id.pfund_eingabe);
        kursEingeben = (EditText) findViewById(R.id.kurs_eingabe);

        //Casting von View zu Button.
        umrechnen = (Button) findViewById(R.id.btn_rechnen);

        //Casting von View zu TextView.
        euroAusgeben = (TextView) findViewById(R.id.euro_ausgabe);

        //Programmablauf - gestartet durch den Klick des Buttons.
        listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Eingabe
                String pfundText = pfundEingeben.getText().toString();
                pfund = Float.valueOf(pfundText);

                //verkuezt
                //pfund = Float.valueOf(pfundEingeben.getText().toString());

                String kursText = kursEingeben.getText().toString();
                kurs = Float.valueOf(kursText);

                //Verarbeitung
                euro = pfund / kurs;

                //Auf zwei Nachkommastellen runden.
                euro = ((int) (euro * 100 + 0.5)) / 100f;

                //Ausgabe
                euroAusgeben.setText(String.valueOf(euro) + " €");
            }
        };

        //Button und Listener verbinden.
        umrechnen.setOnClickListener(listener);
    }
}
