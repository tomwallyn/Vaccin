package com.example.vaccincovid;

import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;

public class RDV extends AppCompatActivity {

    private TextView listrdv;
    private static Button btn_send;
    private static EditText numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_d_v);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        this.listrdv = (TextView) findViewById(R.id.listrdv);

        try {

            String txt = "";

            Fonction fonc = new Fonction();
            Statement st = fonc.connexionSQLBDD();

            String SQL = "SELECT reservation.Id, reservation.Nom, reservation.Prenom, stock.Nom, reservation.Date FROM reservation, stock WHERE reservation.IdVaccin = stock.Id";

            final ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                System.out.println(rs.getString(1));
                txt += String.valueOf("Numéro de reservation : " + rs.getString(1) + " Nom : " + rs.getString(2) + " Prenom : " + rs.getString(3) + " Vaccin : " +  rs.getString(4) + " Date : " + rs.getString(5) +"\n");
            }

            listrdv.setText(txt);


        } catch (Exception e){
            e.printStackTrace();
        }

        numero = (EditText) findViewById(R.id.numero);

        btn_send = (Button) findViewById(R.id.btn_supprimer);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                supprimer();
            }
        });
    }

    private void supprimer(){
        try {

            Fonction fonc = new Fonction();
            Statement st = fonc.connexionSQLBDD();

            String SQL = "DELETE FROM reservation WHERE Id='"+numero.getText().toString()+"'";

            final int rs = st.executeUpdate(SQL);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}