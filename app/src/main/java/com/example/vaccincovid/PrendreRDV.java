package com.example.vaccincovid;

import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.sql.Statement;
import java.text.SimpleDateFormat;

public class PrendreRDV extends AppCompatActivity {

    private static Button btn_astrazeneca, btn_pfizer, btn_moderna;
    private static EditText nom, prenom;
    private DatePicker daterdv;
    private TimePicker heurerdv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prendre_r_d_v);
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

        nom = (EditText) findViewById(R.id.nom);
        prenom = (EditText) findViewById(R.id.prenom);
        this.daterdv = (DatePicker) findViewById(R.id.daterdv);
        this.heurerdv = (TimePicker) findViewById(R.id.heurerdv);

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

            int heurerdvForm = heurerdv.getHour();
            int minuterdvForm = heurerdv.getMinute();

            String dateFormated = daterdv.getYear()+"-0"+daterdv.getMonth()+"-"+daterdv.getDayOfMonth();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dateStr = formatter.parse(dateFormated);
            java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());

            String SQL = "INSERT INTO reservation (Nom, Prenom, IdVaccin, Date) VALUES ('"+nom.getText().toString()+"', '"+prenom.getText().toString()+"', 1, '"+dateDB+" "+heurerdvForm+":"+minuterdvForm+":00.0')";

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

            int heurerdvForm = heurerdv.getHour();
            int minuterdvForm = heurerdv.getMinute();

            String dateFormated = daterdv.getYear()+"-0"+daterdv.getMonth()+"-"+daterdv.getDayOfMonth();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dateStr = formatter.parse(dateFormated);
            java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());

            String SQL = "INSERT INTO reservation (Nom, Prenom, IdVaccin, Date) VALUES ('"+nom.getText().toString()+"', '"+prenom.getText().toString()+"', 2, '"+dateDB+" "+heurerdvForm+":"+minuterdvForm+":00.0')";

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

            int heurerdvForm = heurerdv.getHour();
            int minuterdvForm = heurerdv.getMinute();

            String dateFormated = daterdv.getYear()+"-0"+daterdv.getMonth()+"-"+daterdv.getDayOfMonth();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dateStr = formatter.parse(dateFormated);
            java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());

            String SQL = "INSERT INTO reservation (Nom, Prenom, IdVaccin, Date) VALUES ('"+nom.getText().toString()+"', '"+prenom.getText().toString()+"', 3, '"+dateDB+" "+heurerdvForm+":"+minuterdvForm+":00.0')";

            final int rs = st.executeUpdate(SQL);

            String SQL2 = "UPDATE Stock SET Quantite = Quantite - 1 WHERE Id = 3";

            final int rs2 = st.executeUpdate(SQL2);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}