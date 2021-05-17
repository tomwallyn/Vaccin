package com.example.vaccincovid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.sql.ResultSet;
import java.sql.Statement;

public class NewRDV extends AppCompatActivity {

    private static Button btn_astrazeneca, btn_pfizer, btn_moderna;
    private static EditText nom, prenom, date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_r_d_v);

        nom = (EditText) findViewById(R.id.nom);
        prenom = (EditText) findViewById(R.id.prenom);
        date = (EditText) findViewById(R.id.date);

        btn_astrazeneca= (Button) findViewById(R.id.btn_astrazeneca);
        btn_pfizer= (Button) findViewById(R.id.btn_pfizer);
        btn_moderna= (Button) findViewById(R.id.btn_moderna);

        btn_astrazeneca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                astrazeneca();
            }
        });

        btn_pfizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pfizer();
            }
        });

        btn_moderna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moderna();
            }
        });
    }

    private void astrazeneca(){
        try {

            Fonction fonc = new Fonction();
            Statement st = fonc.connexionSQLBDD();

            String SQL = "INSERT INTO reservation (Nom, Prenom, IdVaccin, Date) VALUES ('"+nom.getText().toString()+"', '"+prenom.getText().toString()+"', 1, '"+date.getText().toString()+"')";

            final int rs = st.executeUpdate(SQL);

            String SQL2 = "UPDATE Stock SET Quantite = Quantite - 1 WHERE Id = 1";

            final int rs2 = st.executeUpdate(SQL2);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void pfizer(){
        try {

            Fonction fonc = new Fonction();
            Statement st = fonc.connexionSQLBDD();

            String SQL = "INSERT INTO reservation (Nom, Prenom, IdVaccin, Date) VALUES ('"+nom.getText().toString()+"', '"+prenom.getText().toString()+"', 2, '"+date.getText().toString()+"')";

            final int rs = st.executeUpdate(SQL);

            String SQL2 = "UPDATE Stock SET Quantite = Quantite - 1 WHERE Id = 2";

            final int rs2 = st.executeUpdate(SQL2);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void moderna(){
        try {

            Fonction fonc = new Fonction();
            Statement st = fonc.connexionSQLBDD();

            String SQL = "INSERT INTO reservation (Nom, Prenom, IdVaccin, Date) VALUES ('"+nom.getText().toString()+"', '"+prenom.getText().toString()+"', 3, '"+date.getText().toString()+"')";

            final int rs = st.executeUpdate(SQL);

            String SQL2 = "UPDATE Stock SET Quantite = Quantite - 1 WHERE Id = 3";

            final int rs2 = st.executeUpdate(SQL2);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}