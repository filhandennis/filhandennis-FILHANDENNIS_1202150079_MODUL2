package com.example.dnn.filhandennis_1202150079_modul2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Dinein extends AppCompatActivity {

    private Spinner noMeja;
    private TextView nama;
    private String lblNoMeja;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinein);

        nama = (TextView)findViewById(R.id.txtNamaDineIn);
        nama.setText("Dennis");
        noMeja = (Spinner)findViewById(R.id.txtNoMeja);
        ArrayList<String> list = isiDataMeja();
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        noMeja.setAdapter(dataAdapter);
    }

    public ArrayList<String> isiDataMeja(){
        int maks = 20;
        ArrayList<String> data = new ArrayList<>();
        for(int i=1; i<=maks;i++){data.add("Meja "+i);}
        return data;
    }

    public void selectMenu2(View view){
        String nomejax, namax;
        nomejax = String.valueOf(noMeja.getSelectedItem());
        namax = nama.getText().toString();
        Toast.makeText(this, nomejax+" atas Nama "+namax+" Dipilih", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, DaftarMenu.class));
    }

}
