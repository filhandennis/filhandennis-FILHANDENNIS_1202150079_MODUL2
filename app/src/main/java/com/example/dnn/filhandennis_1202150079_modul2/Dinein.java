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

    //Attribut Komponen View
    private Spinner noMeja;
    private TextView nama;
    private String lblNoMeja;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinein);

        //Inisialisasi Komponen View
        nama = (TextView)findViewById(R.id.txtNamaDineIn);
        //Set Text untuk Komponen Nama
        nama.setText("Dennis");
        //Inisialisasi Komponen View Spinner
        noMeja = (Spinner)findViewById(R.id.txtNoMeja);
        //Mengisi data dengan method yang mendaftarkan data
        ArrayList<String> list = isiDataMeja();
        //ArrayAdapter untuk mengubah list data menjadi item view pada Spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        //AmbilReferensi Spinner
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Set Adapter pada Spinner
        noMeja.setAdapter(dataAdapter);
    }

    public ArrayList<String> isiDataMeja(){
        int maks = 20;
        ArrayList<String> data = new ArrayList<>();
        for(int i=1; i<=maks;i++){data.add("Meja "+i);}
        return data;
    }


    //Method yang dijalankan saat tombol diklik
    //Digunakan untuk berpindah ke acitivy DaftarMenu
    public void selectMenu2(View view){
        //property yang akan digunakan
        String nomejax, namax;
        //mengambil nilai yang dipilih dari Spinner
        nomejax = String.valueOf(noMeja.getSelectedItem());
        //mengambil nilai komponen view
        namax = nama.getText().toString();
        //membuat toast
        Toast.makeText(this, nomejax+" atas Nama "+namax+" Dipilih", Toast.LENGTH_SHORT).show();
        //pindah ke activity DaftarMenu
        startActivity(new Intent(this, DaftarMenu.class));
    }

}
