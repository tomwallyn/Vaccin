package com.example.vaccincovid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Int2;
import android.view.View;
import android.widget.TextView;

import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView alerte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.alerte = (TextView) findViewById(R.id.alerte);

        try {

            Fonction fonc = new Fonction();
            Statement st = fonc.connexionSQLBDD();

            String SQL = "SELECT Quantite FROM stock";

            final ResultSet rs = st.executeQuery(SQL);
            rs.next();

            int ivar = Integer.parseInt(rs.getString(1));

            if (ivar < 20){
                alerte.setText("ALERTE dans le stock. Quantité faible pour le AstraZeneca");
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void goToStock(View view) {
        Intent intent = new Intent(MainActivity.this, Stock.class);
        startActivity(intent);
    }

    public void goToRDV(View view) {
        Intent intent = new Intent(MainActivity.this, RDV.class);
        startActivity(intent);
    }

    public void goToNewRDV(View view) {
        Intent intent = new Intent(MainActivity.this, PrendreRDV.class);
        startActivity(intent);
    }
}