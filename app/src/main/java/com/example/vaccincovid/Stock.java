package com.example.vaccincovid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.sql.ResultSet;
import java.sql.Statement;

public class Stock extends AppCompatActivity {

    private TextView astrazeneca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock2);
        this.astrazeneca = (TextView) findViewById(R.id.astrazeneca);

        try {

            Fonction fonc = new Fonction();
            Statement st = fonc.connexionSQLBDD();

            String SQL = "SELECT Quantite FROM stock WHERE Nom='Astrazeneca'";

            final ResultSet rs = st.executeQuery(SQL);
            rs.next();

            astrazeneca.setText(rs.getString(1));

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}