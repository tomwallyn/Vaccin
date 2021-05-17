package com.example.vaccincovid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import java.sql.ResultSet;
import java.sql.Statement;

public class Stock extends AppCompatActivity {

    private TextView stockPfizer;
    private TextView stockModerna;
    private TextView stockAstra;
    private TextView exit;
    private TextView modStock;

    private EditText PfizerEdit;
    private EditText AstraEdit;
    private EditText ModernaEdit;
    private TextView PfizerButton;
    private TextView AstraButton;
    private TextView ModernaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock2);
        this.stockPfizer = (TextView) findViewById(R.id.stockPfizer);
        this.stockAstra = (TextView) findViewById(R.id.stockAstra);
        this.stockModerna = (TextView) findViewById(R.id.stockModerna);
        this.exit = (TextView) findViewById(R.id.exit);

        this.PfizerEdit = (EditText) findViewById(R.id.PfizerEdit);
        this.PfizerButton = (TextView) findViewById(R.id.PfizerButton);
        this.AstraEdit = (EditText) findViewById(R.id.AstraEdit);
        this.AstraButton = (TextView) findViewById(R.id.AstraButton);
        this.ModernaEdit = (EditText) findViewById(R.id.ModernaEdit);
        this.ModernaButton = (TextView) findViewById(R.id.ModernaButton);

        try {
            Fonction fonc = new Fonction();
            Statement st = fonc.connexionSQLBDD();

            String SQL = "SELECT Quantite from stock WHERE id = 2";
            ResultSet rs = st.executeQuery(SQL);

            rs.next();
            int result = rs.getInt(1);
            stockPfizer.setText("Quantite : "+result);


        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            Fonction fonc = new Fonction();
            Statement st = fonc.connexionSQLBDD();

            String SQL = "SELECT Quantite from stock WHERE id = 1";

            ResultSet rs = st.executeQuery(SQL);
            rs.next();
            stockAstra.setText("Quantite : " + rs.getInt(1));


        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            Fonction fonc = new Fonction();
            Statement st = fonc.connexionSQLBDD();

            String SQL = "SELECT Quantite from stock WHERE id = 3";

            ResultSet rs = st.executeQuery(SQL);
            rs.next();
            stockModerna.setText("Quantite : "+rs.getInt(1));


        }catch (Exception e){
            e.printStackTrace();
        }

        PfizerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = PfizerEdit.getText().toString();
                int num = Integer.parseInt(number);
                setInBDD(2,num);
            }
        });
        AstraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = AstraEdit.getText().toString();
                int num = Integer.parseInt(number);
                setInBDD(1,num);
            }
        });
        ModernaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = ModernaEdit.getText().toString();
                int num = Integer.parseInt(number);
                setInBDD(3,num);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });
    }

    private void setInBDD(int id,int num) {
        try {
            Fonction fonc = new Fonction();
            Statement st = fonc.connexionSQLBDD();

            String SQL3 = "UPDATE `stock` SET `quantite` = "+num+" WHERE `id` = "+id+";";
            st.executeUpdate(SQL3);

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}