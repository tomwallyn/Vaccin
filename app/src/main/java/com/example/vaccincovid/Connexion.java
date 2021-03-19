package com.example.vaccincovid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connexion extends AppCompatActivity {

    private static Button btn_send;
    private static EditText pseudo, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        pseudo = (EditText) findViewById(R.id.pseudo);
        pass = (EditText) findViewById(R.id.pass);

        btn_send = (Button) findViewById(R.id.btn_send);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connexion();
            }
        });

        if (android.os.Build.VERSION.SDK_INT > 9){
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
    }

    private void connexion(){
        try {

            Fonction fonc = new Fonction();
            Statement st = fonc.connexionSQLBDD();

            String SQL = "SELECT Password FROM utilisateur WHERE Username='"+pseudo.getText().toString()+"'";

            final ResultSet rs = st.executeQuery(SQL);
            rs.next();

            if (rs.getString(1).equals(pass.getText().toString())){
                NexActivity();
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void NexActivity() {
        Intent intent = new Intent(Connexion.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}